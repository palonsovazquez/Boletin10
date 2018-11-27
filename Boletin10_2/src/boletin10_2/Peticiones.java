/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. V 0.1
 */
package boletin10_2;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author: Pablo Alonso Vazquez
 * @version: 0.6 Controla las entradas de numeros por teclado añado
 * joptionpanels
 *
 */
public class Peticiones {

    private static Scanner sca = new Scanner(System.in);
    /**
     * Filtro que acepta numeros positivos, negativos y el cero.
     */
    public static final int NEGATIVO_CERO_POSITIVO = 111;
    /**
     * Filtro que acepta numeros positivos y el cero.
     */
    public static final int CERO_POSITIVO = 011;
    /**
     * Filtro que acepta numeros negativos y el cero.
     */
    public static final int NEGATIVO_CERO = 110;
    /**
     * Filtro que acepta numeros positivos.
     */
    public static final int POSITIVO = 001;

    /**
     * filtro que acepta numeros negativos.
     */
    public static final int NEGATIVO = 100;

    public static Double pedirNumeroDouble(String nombreDato, boolean modoGrafico) {
        Double res = null;

        do {
            if (modoGrafico) {

                res = comprobarNumDouble(JOptionPane.showInputDialog(null,  nombreDato));
            } else {
                System.out.print( nombreDato );
                res = comprobarNumDouble(sca.nextLine());
                System.out.println();
            }
        } while (res == null);
        // pedira el dato hasta que e introduzca un numero valido.

        return res;
    }

    public static Double pedirNumeroDouble(String nombreDato) {
        Double res;
        res = pedirNumeroDouble(nombreDato, false);
        return res;

    }

    public static Double comprobarNumDouble(String numero) {
        Double x;
        try {   // lo parseo y si no es un numero valido asigna a x el valor de nulo.
            x = Double.parseDouble(numero);
        } catch (Exception ex) {
            x = null;

        }

        return x;

    }

    public static Short pedirNumeroShort(String nombreDato) {
        Short res;
        res = pedirNumeroShort(nombreDato, false);
        return res;

    }

    public static Short pedirNumeroShort(String nombreDato, boolean modoGrafico) {
        Short res = null;

        do {
            if (modoGrafico) {

                res = comprobarNumShort(JOptionPane.showInputDialog(null, nombreDato));
            } else {
                System.out.print( nombreDato );
                res = comprobarNumShort(sca.nextLine());
                System.out.println();
            }
        } while (res == null);
        // pedira el dato hasta que e introduzca un numero valido.

        return res;
    }

    public static Short comprobarNumShort(String numero) {
        Short x;
        try {   // lo parseo y si no es un numero valido asigna a x el valor de nulo.
            x = Short.parseShort(numero);
        } catch (Exception ex) {
            x = null;

        }

        return x;

    }

    public static Integer pedirNumeroInteger(String nombreDato) {
        Integer res;
        res = pedirNumeroInteger(nombreDato, false);
        return res;

    }

    public static Integer pedirNumeroInteger(String nombreDato, boolean modoGrafico) {
        Integer res = null;

        do {
            if (modoGrafico) {

                res = comprobarNumInteger(JOptionPane.showInputDialog(null,   nombreDato));
            } else {
                System.out.print(  nombreDato  );
                res = comprobarNumInteger(sca.nextLine());
                System.out.println();
            }
        } while (res == null);
        // pedira el dato hasta que e introduzca un numero valido.

        return res;
    }

    public static Integer comprobarNumInteger(String numero) {
        Integer x;
        try {   // lo parseo y si no es un numero valido asigna a x el valor de nulo.
            x = Integer.parseInt(numero);
        } catch (Exception ex) {
            x = null;

        }

        return x;

    }

    public static Integer pedirNumIntFiltrado(String nombreDato, Integer filtro) {
        return pedirNumIntFiltrado(nombreDato, filtro, false);
    }

    public static Integer pedirNumIntFiltrado(String nombreDato, Integer filtro, boolean modoGrafico) {
        Integer dev = null, temp;
        temp = pedirNumeroInteger(nombreDato, modoGrafico);

        switch (filtro) {
            case NEGATIVO:
                if (temp < 0) {
                    dev = temp;
                }
                break;
            case POSITIVO:
                if (temp > 0) {
                    dev = temp;
                }
                break;
            case NEGATIVO_CERO:
                if (temp <= 0) {
                    dev = temp;
                }
                break;

            case CERO_POSITIVO:
                if (temp >= 0) {
                    dev = temp;
                }
                break;
            case NEGATIVO_CERO_POSITIVO: {
                dev = temp;

                break;
            }
        }

        return dev;

    }
 public static Integer pedirNumIntFiltrado(String nombreDato, Integer numInicial,Integer numFinal, boolean modoGrafico) {
        Integer dev = null, temp,aux;
        if(numInicial > numFinal){ // comprobando si el numero inicial es realmente el inicial y si no lo es corregirlo
        aux = numInicial;
        numInicial= numFinal;
        numFinal = aux;
               
        }
        
        
        do{
        temp = pedirNumeroInteger(nombreDato, modoGrafico);
        }while(numInicial < temp && temp > numFinal);
        dev = temp;

        return dev;

    }
    public static Double pedirNumDoubleFiltrado(String nombreDato, Integer filtro) {
        return pedirNumDoubleFiltrado(nombreDato, filtro, false);
    }

    public static Double pedirNumDoubleFiltrado(String nombreDato, Integer filtro, boolean modoGrafico) {
        Double dev = null, temp;
        do {
            temp = pedirNumeroDouble(nombreDato, false);

            switch (filtro) {
                case NEGATIVO:
                    if (temp < 0) {
                        dev = temp;
                    }
                    break;
                case POSITIVO:
                    if (temp > 0) {
                        dev = temp;
                    }
                    break;
                case NEGATIVO_CERO:
                    if (temp <= 0) {
                        dev = temp;
                    }
                    break;

                case CERO_POSITIVO:
                    if (temp >= 0) {
                        dev = temp;
                    }
                    break;
                case NEGATIVO_CERO_POSITIVO: {
                    dev = temp;

                    break;
                }
            }
        } while (dev == null);

        return dev;

    }

    public static String DevolverSuperIndice(Integer supInd) {
        String res = "", aux = "";
        String supIndStr = supInd.toString();
        for (int i = 0; i < supIndStr.length(); i++) {
            switch (Integer.parseInt(supIndStr.charAt(i) + "")) {
                case 0:
                    aux = "\u2070";
                    break;
                case 1:
                    aux = "\u00B9";
                    break;
                case 2:
                    aux = "\u00B2";
                    break;
                case 3:
                    aux = "\u00B3";
                    break;
                case 4:
                    aux = "\u2074";
                    break;
                case 5:
                    aux = "\u2075";
                    break;
                case 6:
                    aux = "\u2076";
                    break;
                case 7:
                    aux = "\u2077";
                    break;
                case 8:
                    aux = "\u2078";
                    break;
                case 9:
                    aux = "\u2079";
                    break;

            }
            res = res.concat(aux);
        }

        return res;
    }
}
