/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastian
 */
public class JARVIS {
    public void mostrarEstado(Armadura armadura){
        float energia = armadura.getEnergia();
        float porcentaje = energia * 100 / Armadura.max_energia;
        if(porcentaje > 0){
                System.out.println("Porcentaje: %"+porcentaje);
                System.out.println("Energia: "+energia);
            }else{
                System.out.println("Se agotó la batería.");
        }
    }
}
