/*
Escribir un programa en Java que juegue con el usuario a adivinar un número. La computadora
debe generar un número aleatorio entre 1 y 500, y el usuario tiene que intentar adivinarlo. Para
ello, cada vez que el usuario introduce un valor, la computadora debe decirle al usuario si el
número que tiene que adivinar es mayor o menor que el que ha introducido el usuario. Cuando
consiga adivinarlo, debe indicárselo e imprimir en pantalla el número de veces que el usuario
ha intentado adivinar el número. Si el usuario introduce algo que no es un número, se debe
controlar esa excepción e indicarlo por pantalla. En este último caso también se debe contar el
carácter fallido como un intento.
 */
package Entidades;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class Juego {
    public void nuevoJuego(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Bienvenido al juego. Adivine el numero secreto!");
        Computadora com = new Computadora();
        Jugador jugador = new Jugador();
        int num = 0;
        int intentos = 0;
        do {
            try{
                System.out.println("Ingrese un numero:");
                num = leer.nextInt();
                if(num > com.getNumSecreto()){
                    intentos++;
                    System.out.println("El numero ingresado es mayor al numero secreto.");
                }else if(num < com.getNumSecreto()){
                    System.out.println("El numero ingresado es menor al numero secreto.");
                    intentos++;
                }
            }catch(InputMismatchException e){
                System.out.println("Error: No ingresaste un numero entero. (-1 intento)");
                intentos++;
                leer.next(); // limpia el buffer del scanner
            }finally{
                jugador.setIntentos(intentos);
            }
        } while (num != com.getNumSecreto());
        System.out.println("¡GANASTE! El numero secreto era: " + com.getNumSecreto());
        System.out.println("Total de intentos: " + jugador.getIntentos());
    }
}
