/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author dowriq
 */
public class ImgLabel extends JLabel{
    
    public ImgLabel(){
       //this.setText("Voltar");
       this.setIcon(new ImageIcon(getClass().getResource("/icons/indice.png")));
       this.setLocation(new Point(450,100));
    }
    
}
