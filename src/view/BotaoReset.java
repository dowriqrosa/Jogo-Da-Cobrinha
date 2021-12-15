/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Point;
import javax.swing.JButton;

/**
 *
 * @author dowriq
 */
public class BotaoReset extends JButton {
    
   public BotaoReset(){
        this.setSize(120,40);
        this.setText("Reset");
        this.setLocation(new Point(450,250));   
    }
    
}
