/*
Inicializar un objeto de la clase Persona ejercicio 7 de la guía POO, a null y tratar de invocar el
método esMayorDeEdad() a través de ese objeto. Luego, englobe el código con una cláusula
try-catch para probar la nueva excepción que debe ser controlada.
 */
package ej1;

import Entidad.Persona;
import Servicio.PersonaServicio;

/**
 *
 * @author Sebastian
 */
public class Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaServicio ps = new PersonaServicio();
        boolean mayorEdad = false;

        Persona p1 = null;
//        System.out.println(p1.toString());
        try {
            mayorEdad = ps.esMayorDeEdad(p1);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println(mayorEdad);
    }

}
