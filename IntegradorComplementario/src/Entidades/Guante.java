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
public class Guante extends ParteDeArmadura{

    public Guante() {
        consumo = 1;
        danhado = false;
        destruido = false;
    }

    public Guante(Integer consumo, boolean danhado, boolean destruido) {
        super(consumo, danhado, destruido);
    }
   
}
