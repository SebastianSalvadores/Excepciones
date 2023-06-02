/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicio;

import Entidad.Persona;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class PersonaServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Persona crearPersona() {
        Persona pers = new Persona();
        System.out.println("Ingrese nombre: ");
        pers.setNombre(leer.next());
        System.out.println("Ingrese edad: ");
        pers.setEdad(leer.nextInt());
        String sexo;
        do {
            System.out.println("Ingrese sexo ('H' hombre, 'M' mujer, 'O' otro): ");
            sexo = leer.next();
            if (!sexo.equalsIgnoreCase("H") && !sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("O")) {
                System.out.println("Sexo incorrecto.");
            }
        } while (!sexo.equalsIgnoreCase("H") && !sexo.equalsIgnoreCase("M") && !sexo.equalsIgnoreCase("O"));
        pers.setSexo(sexo);
        System.out.println("Ingrese peso: ");
        pers.setPeso(leer.nextDouble());
        System.out.println("Ingrese altura: ");
        pers.setAltura(leer.nextDouble());
        return pers;
    }

    public int calcularIMC(Persona pers) {

        double formula;
        double peso = pers.getPeso();
        double altura = pers.getAltura();
        formula = peso / (Math.pow(altura, 2));
        if (formula < 20) {
            return -1;
        } else if (formula >= 20 && formula <= 25) {
            return 0;
        } else {
            return 1;
        }

    }

    public boolean esMayorDeEdad(Persona pers) throws NullPointerException {
        try{
            if(pers == null){
                throw new NullPointerException("El objeto es nulo.");
            }
            int edad = pers.getEdad();
            if (edad >= 18) {
                return true;
            } else {
                return false;
            }
        }catch(NullPointerException e){
            throw e;
        }
    }

}
