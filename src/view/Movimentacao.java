/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;

/**
 *
 * @author dowriq
 */
public class Movimentacao {
    
    public static void right(){
        ArrayList<Integer> cobra = new ArrayList<>();
        for(int i = 0; i < Cobra.getCobra().size()-1; i++){
            int var = (int) Cobra.getCobra().get(i);
            if(i == 0){  
                var = var+21; 
                cobra.add(var);
            }
            cobra.add((int) Cobra.getCobra().get(i));    
        }
        Cobra.setCobra(cobra);
    }
    
    public static void left(){
        ArrayList<Integer> cobra = new ArrayList<>();
        for(int i = 0; i < Cobra.getCobra().size()-1; i++){
            int var = (int) Cobra.getCobra().get(i);
            if(i == 0){  
                var = var-21; 
                cobra.add(var);
            }
            cobra.add((int) Cobra.getCobra().get(i));
            
        }
        Cobra.setCobra(cobra);
    }
    
    public static void up(){
        ArrayList<Integer> cobra = new ArrayList<>();
       // cobra = Cobra.getCobra();  
        for(int i = 0; i < Cobra.getCobra().size()-1; i++){
            int var = (int) Cobra.getCobra().get(i);
            if(i == 0){  
                var = var-1; 
                cobra.add(var);
            }
            cobra.add((int) Cobra.getCobra().get(i));
            
        }
        Cobra.setCobra(cobra);
    }
    
    public static void down(){
        ArrayList<Integer> cobra = new ArrayList<>();
        for(int i = 0; i < Cobra.getCobra().size()-1; i++){
            int var = (int) Cobra.getCobra().get(i);
            if(i == 0){  
                var = var+1; 
                cobra.add(var);
            }
            cobra.add((int) Cobra.getCobra().get(i));
        }
        Cobra.setCobra(cobra);
    }
    
    
}
