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
public class Bota extends ParteDeArmadura{

    public Bota() {
        consumo = 1000;
        danhado = false;
        destruido = false;
    }

    public Bota(Integer consumo, boolean danhado, boolean destruido) {
        super(consumo, danhado, destruido);
    }
    
}
