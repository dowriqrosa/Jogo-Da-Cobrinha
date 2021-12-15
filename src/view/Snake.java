/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author dowriq
 */
public class Snake extends JFrame{
    
    private javax.swing.JPanel principal;
    private static BotaoStart start;
    private BotaoReset reset;
    private BotaoVoltar voltar;
    private static int cabeca;
    private static boolean perdeu;
    private static ArrayList<JButton> localizacaoCaminho;
    private static int rabo;
    private static int key=0;
    private static Thread movimentacaoThread;
    private static Thread colisaoCobraComCobraThread;
   public Snake(){
     //Define o título da janela
     super("Snake");
     start = new BotaoStart(); 
     reset = new BotaoReset(); 
     voltar = new BotaoVoltar(); 
     movimentacaoThread = new Thread(movimentacao);
     this.montaJanela();
   } 
 
   private void montaJanela(){
       this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
       this.setResizable(false);
       this.setLayout(null);
       this.setSize(600,600);
       this.setVisible(true);
       adicionarPecas();
       movimentacaoThread.start();
       //this.invalidate();
    }
   
   
    private void adicionarPecas(){
        Caminho caminho = new Caminho();
        localizacaoCaminho = new ArrayList<>();
        localizacaoCaminho = caminho.arrayCaminhos();  
        for (int i = 0; i < localizacaoCaminho.size(); i++){
            this.add(localizacaoCaminho.get(i));
            localizacaoCaminho.get(i).setBackground(java.awt.Color.gray);
        }
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key=0;
            }
        });
        start.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                teclaPrecionada(evt);
            }
        });
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTreseActionPerformed(evt);
            }
        });
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTvoltarActionPerformed(evt);
            }
        });
        this.add(start);
        this.add(reset);
        this.add(voltar);
        inicioCobra();
    }
     
    private void inicioCobra(){
        cabeca = 0;
        perdeu = false;
        ArrayList<Integer> cobra = new ArrayList<>();
        cobra.add(0);
        cobra.add(1);
        Cobra.setCobra(cobra);
        for(int i = 0; i < Cobra.getCobra().size(); i++){
             localizacaoCaminho.get(cobra.get(i)).setBackground(java.awt.Color.green);
        }
       
        Comida.gerarLocolizacaoComidaDinamica(localizacaoCaminho, cobra);
        localizacaoCaminho.get(Comida.getLocalizacaoComida()).setBackground(java.awt.Color.RED); 
        Jogador.setPontos(100);
    }
    
    private void teclaPrecionada(java.awt.event.KeyEvent evt) {                                  
        /* CAPTURA AS SETAS DO TECLADO PARA FAZER A MOVIMENTAÇÃO */
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if(key != 2 && perdeu != true)
                key=1;
                break;
            case KeyEvent.VK_RIGHT:
                if(key != 1 && perdeu != true)
                key=2;
                break;
            case KeyEvent.VK_UP:
                if(key != 4 && perdeu != true)
                key=3;
                break;
            case KeyEvent.VK_DOWN:
                if(key != 3 && perdeu != true)
                key=4;
                break;
            default:
                break;
        }
    }
    
    public static Runnable movimentacao = new Runnable() {
        @Override
        public void run() {
            while (key!= 5) {
                switch (key) {
                    case 1:
                        removerCobra();
                        Movimentacao.left();
                        comer();
                        pintarCobra();
                        colisao();
                        break;
                    case 2:
                        removerCobra();
                        Movimentacao.right();
                        comer();
                        pintarCobra();
                        colisao();
                        break;
                    case 3:
                        cabeca = (int) Cobra.getCobra().get(0);
                        if(verificarSaidaCobra()){
                            vocePerdeu();
                        }else{
                            removerCobra();
                            Movimentacao.up();
                            comer();
                            pintarCobra();
                            colisao();
                        }
                        break;
                    case 4:
                        cabeca = (int) Cobra.getCobra().get(0);
                        if(verificarSaidaCobra()){
                            vocePerdeu();
                        }else{
                            removerCobra();
                            Movimentacao.down();
                            comer();
                            pintarCobra();
                            colisao();
                        }
                        break;
                    default:
                        break;
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    //Logger.getLogger(this.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    };
    
    public static void colisao(){
        new Thread(){
            @Override
        public void run() {
                int c = cabeca;
                for(int i= 1; i < Cobra.getCobra().size();i++){
                    if(c == (int) Cobra.getCobra().get(i)){
                        vocePerdeu();
                    }
                }
                //System.out.println();
            }
        }.start();
    }
    
    public static boolean verificarSaidaCobra(){
        boolean vf = false;
        if(key == 3){
            for(int i = 21; i <= 63; i = i+21){
                if(cabeca == i){
                    if(cabeca-1 == i-1){
                        vf = true;
                    }
                    i= 64;
                }
            }
        }else{
            for(int i = 20; i <= 72; i = i+21){
                if(cabeca == i){
                    if(cabeca+1 == i+1){
                        vf = true;
                    }
                    i= 73;
                }
            }
        }
        return vf;
    }
    
    public static void pintarCobra(){
        cabeca = (int) Cobra.getCobra().get(0);
        Cobra.getCobra().forEach((i) -> {
            if((int) i >= localizacaoCaminho.size() || (int) i < 0){
                vocePerdeu();
            }else{
                localizacaoCaminho.get((int) i).setBackground(Color.green);
            }
        });
        
    }
    
    public static void removerCobra(){
        cabeca = (int) Cobra.getCobra().get(0);
        Cobra.getCobra().forEach((i) -> {
            if((int) i >= localizacaoCaminho.size() || (int) i < 0){
                vocePerdeu();
            }else{
                localizacaoCaminho.get((int) i).setBackground(Color.gray);
                rabo = (int) i;
            }
        });
    }
    public static void addRabo(){
        ArrayList<Integer> var = new ArrayList<>();
        var = Cobra.getCobra();
        var.add(rabo);
        Cobra.setCobra(var);
        pintarCobra();
        Jogador.setPontos(Jogador.getPontos()+100);
        System.out.println(Jogador.getPontos());
    }
    
    public static void vocePerdeu(){
        System.out.println("Você perdeu");
        movimentacaoThread.interrupt();
        key = 0;
        perdeu = true;
        JOptionPane.showMessageDialog(null, "Você perdeu!");
        start.setEnabled(false);
    }
    
    public static void comer(){
        if((int) Cobra.getCobra().get(0) == Comida.getLocalizacaoComida()){
            addRabo();
            Comida.gerarLocolizacaoComidaDinamica(localizacaoCaminho, Cobra.getCobra());
            if(Comida.getLocalizacaoComida() == 999){
                System.out.println("final");
            }else{
                localizacaoCaminho.get(Comida.getLocalizacaoComida()).setBackground(Color.RED); 
            }
        }
    } 
     
    private void BTreseActionPerformed(java.awt.event.ActionEvent evt) {                                       
        /* RESETA A POSIÇÃO DA COBRINHA E DA COMIDA*/
        localizacaoCaminho.get(Comida.getLocalizacaoComida()).setBackground(Color.GREEN);
        removerCobra();
        inicioCobra();
        start.setEnabled(true);
    }
    private void BTvoltarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        /* RESETA A POSIÇÃO DA COBRINHA E DA COMIDA*/
        this.dispose();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCobrinha().setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        // TODO code application logic here
       Snake janela = new Snake();
       janela.setVisible(true);
    }    
}
