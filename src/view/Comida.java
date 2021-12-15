/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author dowriq
 */
public class Comida {
    private static int localizacaoComida;
    public static void gerarLocolizacaoComidaDinamica(ArrayList<JButton> caminho, ArrayList<Integer> cobra){
        Random random = new Random();
        int cont = 0;
        while(cont<cobra.size()){
            localizacaoComida = random.nextInt(caminho.size());
            if(localizacaoCobra(cobra,localizacaoComida)){
              cont++;
            }else{
                cont=cobra.size();
            }
        } 
    }
    
    private static boolean localizacaoCobra(ArrayList<Integer> cobra,int localizacaoComida){
        for(int locCobra :cobra){
            if(locCobra == localizacaoComida){
                return true;
            }
        }
        return false;  
    }

    public static int getLocalizacaoComida() {
        return localizacaoComida;
    } 
    
}
