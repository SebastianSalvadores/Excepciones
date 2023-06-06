/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Sebastian
 */
public class Armadura {
    private Integer resistencia;
    private Integer salud;
    private Float energia;
    private ArrayList<Bota> botas;
    private ArrayList<Guante> guantes;
    private Casco casco;
    public static Float max_energia = 999999999.0f;
    
    public Armadura() {
        botas = new ArrayList();
        guantes = new ArrayList();
        resistencia = 100;
        salud = 100;
        energia = max_energia;
        for (int i = 0; i < 2; i++) {
            Bota bota = new Bota();
            botas.add(bota);
        }
        for (int i = 0; i < 2; i++) {
            Guante guante = new Guante();
            guantes.add(guante);
        }
        casco = new Casco();
    }

    public Armadura(Integer resistencia) {
        this.resistencia = resistencia;
        botas = new ArrayList();
        guantes = new ArrayList();
        salud = 100;
        energia = max_energia;
        for (int i = 0; i < 2; i++) {
            Bota bota = new Bota();
            botas.add(bota);
        }
        for (int i = 0; i < 2; i++) {
            Guante guante = new Guante();
            guantes.add(guante);
        }
        casco = new Casco();
    }

    public Integer getResistencia() {
        return resistencia;
    }

    public void setResistencia(Integer resistencia) {
        this.resistencia = resistencia;
    }

    public Integer getSalud() {
        return salud;
    }

    public void setSalud(Integer salud) {
        this.salud = salud;
    }

    public Float getEnergia() {
        return energia;
    }

    public void setEnergia(Float energia) {
        this.energia = energia;
    }

    public ArrayList<Bota> getBotas() {
        return botas;
    }

    public void setBotas(ArrayList<Bota> botas) {
        this.botas = botas;
    }

    public ArrayList<Guante> getGuantes() {
        return guantes;
    }

    public void setGuantes(ArrayList<Guante> guantes) {
        this.guantes = guantes;
    }

    public Casco getCasco() {
        return casco;
    }

    public void setCasco(Casco casco) {
        this.casco = casco;
    }

    

    
}
