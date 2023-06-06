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
public abstract class ParteDeArmadura {
    protected Integer consumo;
    protected boolean danhado;
    protected boolean destruido;

    public ParteDeArmadura() {
    }

    public ParteDeArmadura(Integer consumo, boolean danhado, boolean destruido) {
        this.consumo = consumo;
        this.danhado = danhado;
        this.destruido = destruido;
    }
    
    public Integer getCosumo() {
        return consumo;
    }

    public void setCosumo(Integer consumo) {
        this.consumo = consumo;
    }

    public boolean isDanhado() {
        return danhado;
    }

    public void setDanhado(boolean danhado) {
        this.danhado = danhado;
    }

    public boolean isDestruido() {
        return destruido;
    }

    public void setDestruido(boolean destruido) {
        this.destruido = destruido;
    }
    
}
