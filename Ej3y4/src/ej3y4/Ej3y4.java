/*
Defina una clase llamada DivisionNumero. En el método main utilice un Scanner para leer dos
números en forma de cadena. A continuación, utilice el método parseInt() de la clase Integer,
para convertir las cadenas al tipo int y guardarlas en dos variables de tipo int. Por ultimo realizar
una división con los dos numeros y mostrar el resultado.

Todas estas operaciones puede tirar excepciones a manejar, el ingreso por teclado puede
causar una excepción de tipo InputMismatchException, el método Integer.parseInt() si la cadena
no puede convertirse a entero, arroja una NumberFormatException y además, al dividir un
número por cero surge una ArithmeticException. Manipule todas las posibles excepciones
utilizando bloques try/catch para las distintas excepciones
 */
package ej3y4;

import Entidad.DivisionNumero;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class Ej3y4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        String num1 = "";
        String num2 = "";
        
        try {
            System.out.println("Ingrese un numero:");
            num1 = leer.next();
            System.out.println("Ingrese otro numero: ");
            num2 = leer.next();
        } catch (InputMismatchException e) {
            System.out.println("Error: El tipo de dato ingresado es incorrecto.");
        } 
        
        try{
            double div = DivisionNumero.dividir(num1, num2);
            System.out.println("La division " + num1 + "/" + num2 + " = " + div);
        }catch(ArithmeticException a){
            System.out.println("Error: Division por 0");
        }catch(NumberFormatException n){
            System.out.println("Error: No se ingreso un numero entero");
        }
    }
    
}
