/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin10_1;

import javax.swing.JOptionPane;

/**
 *
 * @author Pablo Alonso Vazquez <pav.vigo@gmail.com>
 */
public class Boletin10_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer numeroAdivinar, numIntentos, numero, contIntentos = 0;
        String textoAMostrar = "Introduzca un numero";

        numeroAdivinar = Peticiones.pedirNumIntFiltrado("Jugador 1, Introduzca un numero entre el 0 y el 50", 1, 50, true);
        Boolean gano = false;
        numIntentos = Peticiones.pedirNumeroInteger("Jugador 1, Introduzca el numero de intentos", true);

        do {
            numero = Peticiones.pedirNumIntFiltrado(textoAMostrar, 1, 50, true);
            System.out.println("numero " + numero + " adivinar " + numeroAdivinar);
            contIntentos++;
            if (numero < numeroAdivinar) {
                textoAMostrar = "El numero que buscas es mayor que " + numero;
            } else {
                if (numero > numeroAdivinar) {
                    textoAMostrar = "El numero que buscas es menor que " + numero;
                } else {
                    gano = true;
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
