/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin10_2;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Pablo Alonso Vazquez <pav.vigo@gmail.com>
 */
public class Boletin10_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random aleatorio = new Random(System.currentTimeMillis());

        Integer numeroAdivinar = aleatorio.nextInt(50) + 1, numIntentos, numero, contIntentos = 0, diferencia;
        String textoAMostrar = "Introduzca un numero";
        Boolean gano = false;
        numIntentos = 5;

        do {
            numero = Peticiones.pedirNumIntFiltrado(textoAMostrar, 0, 50, true);
            System.out.println("numero " + numero + " adivinar " + numeroAdivinar);
            contIntentos++;
            diferencia = Math.abs(numero - numeroAdivinar);
            if (diferencia > 20) {
                textoAMostrar = "Moy lonxe";
            } else {
                if (diferencia > 10) {
                    textoAMostrar = "Lonxe";
                } else {
                    if (diferencia > 5) {
                        textoAMostrar = " Preto";
                    } else {
                        if (diferencia > 0) {
                            textoAMostrar = "Moi Preto";
                        }else{gano = true;}
                    }
                }
            }

        } while (!(gano || contIntentos > numIntentos));

        if (gano) {

            textoAMostrar = "Felicidades, has acertado";
        } else {
            textoAMostrar = "Te has quedado sin intentos, el numero era " + numeroAdivinar;
        }
        
        JOptionPane.showConfirmDialog(null, textoAMostrar, "titulo", JOptionPane.OK_OPTION);
    }

}
