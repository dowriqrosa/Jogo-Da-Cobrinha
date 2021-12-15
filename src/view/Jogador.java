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
public class Jogador {
    private static String jogador;
    private static int pontos;

    public static String getJogador() {
        return jogador;
    }

    public static void setJogador(String jogador) {
        Jogador.jogador = jogador;
    }

    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        Jogador.pontos = pontos;
    }
    
    
}
