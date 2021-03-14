package Practica2.Practica2;

import java.io.*;

public class Leer {

    /**
     * el .pediCadena no hara falta hacer un Scanner teclado= new
     * Scanner(Sysmten.in) ya que ya te piede una cadena ó int
     */
    static public String pedirCadena() {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        String dato = "";
        boolean error = true;
        while (error) {
            try {
                dato = dataIn.readLine();
                error = false;
            } catch (IOException e) {
                System.out.println("Vuelve a introducir el dato, por favor: ");
                error = true;
            }
        }
        return dato;

    }

    /**
     * el .pediCadena no hara falta hacer un Scanner teclado= new
     * Scanner(Sysmten.in) ya que ya te piede una cadena ó int
     */
    static public int pedirEnteroValidar() {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        int dato = 0;
        boolean error = true;
        while (error) {
            try {
                dato = Integer.parseInt(dataIn.readLine());
                error = false;
            } catch (IOException e) {
                System.out.println("No es un numero entero, introduzca el valor valido");
                error = true;
            } catch (NumberFormatException e) {
                System.out.println("El dato introducido no es entero");
                System.out.println("Vuelve a introducir el dato, por favor: ");
                error = true;
            }
        }
        return dato;

    }

    /**
     * el .pediCadena no hara falta hacer un Scanner teclado= new
     * Scanner(Sysmten.in) ya que ya te piede una cadena ó int
     */
    static public double pedirDecimal() {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        double dato = 0;
        boolean error = true;
        while (error) {
            try {
                dato = Double.parseDouble(dataIn.readLine());
                error = false;
            } catch (IOException e) {
                System.out.println("Vuelve a introducir el dato, por favor: ");
                error = true;
            } catch (NumberFormatException e) {
                System.out.println("El dato introducido no es entero");
                System.out.println("Vuelve a introducir el dato, por favor: ");
                error = true;
            }
        }
        return dato;

    }

    /**
     * el .pediCadena no hara falta hacer un Scanner teclado= new
     * Scanner(Sysmten.in) ya que ya te piede una cadena ó int
     */
    static public float pedirFloat() {
        BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
        float dato = 0;
        boolean error = true;
        while (error) {
            try {
                dato = Float.parseFloat(dataIn.readLine());
                error = false;
            } catch (IOException e) {
                System.out.println("Vuelve a introducir el dato, por favor: ");
                error = true;
            } catch (NumberFormatException e) {
                System.out.println("El dato introducido no es entero");
                System.out.println("Vuelve a introducir el dato, por favor: ");
                error = true;
            }
        }
        return dato;

    }
}