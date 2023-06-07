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
public class Casco extends ParteDeArmadura{

    public Casco() {
        consumo = 1000;
        danhado = false;
        destruido = false;
    }

    public Casco(Integer consumo, boolean danhado, boolean destruido) {
        super(consumo, danhado, destruido);
    }
    
    
}
