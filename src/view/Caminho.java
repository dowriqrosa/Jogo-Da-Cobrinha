/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author dowriq
 */
public class Caminho {
    //private JButton cobra;
    
    public ArrayList arrayCaminhos() {
        Botao peca;
        ArrayList<JButton> caminho = new ArrayList<>();
        for(int i=0;i<=400;i+=20){
            for(int j=0;j<=400;j+=20){
                peca = new Botao();
                peca.setLocation(new Point(i,j));
                peca.setEnabled(false);
                caminho.add(peca);  
            }
        }
        
        return caminho;
    }
        
    
}
