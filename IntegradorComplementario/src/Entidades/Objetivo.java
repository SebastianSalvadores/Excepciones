/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Comparator;

/**
 *
 * @author Sebastian
 */
public class Objetivo {
    private Integer coordenadaX;
    private Integer coordenadaY;
    private Integer coordenadaZ;
    private boolean hostil;
    private Integer resistencia;

    public Objetivo() {
        coordenadaX = (int) (Math.random() * 3000);
        coordenadaY = (int) (Math.random() * 3000);
        coordenadaZ = (int) (Math.random() * 3000);
        hostil = Math.random() < 0.5;
        resistencia = (int) (Math.random() * 100);
    }
    
    public Objetivo(Integer coordenadaX, Integer coordenadaY, Integer coordenadaZ, boolean hostil, Integer resistencia) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.coordenadaZ = coordenadaZ;
        this.hostil = hostil;
        this.resistencia = resistencia;
    }

    public Integer getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Integer coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Integer getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Integer coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Integer getCoordenadaZ() {
        return coordenadaZ;
    }

    public void setCoordenadaZ(Integer coordenadaZ) {
        this.coordenadaZ = coordenadaZ;
    }

    public boolean isHostil() {
        return hostil;
    }

    public void setHostil(boolean hostil) {
        this.hostil = hostil;
    }

    public Integer getResistencia() {
        return resistencia;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    @Override
    public String toString() {
        return "Objetivo{" + "coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", coordenadaZ=" + coordenadaZ + ", hostil=" + hostil + ", resistencia=" + resistencia + '}';
    }
    
    
}
