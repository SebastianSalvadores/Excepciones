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
package Entidad;

/**
 *
 * @author Sebastian
 */
public class DivisionNumero {
    public static double dividir(String n1, String n2) throws NumberFormatException, ArithmeticException{
        
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        
        return num1 / num2;
    }
}
