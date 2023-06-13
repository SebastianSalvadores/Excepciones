/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Servicios.ArmaduraServicio;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Sebastian
 */
public class JARVIS {
    private static ArmaduraServicio armServ = new ArmaduraServicio();
    
    public void mostrarEstado(Armadura armadura){
        float energia = armadura.getEnergia();
        float porcentaje = energia * 100 / Armadura.max_energia;
        float amperiosHora = energia * 100000 / Armadura.max_energia;
        float coulomb = amperiosHora * 3600;
        if(porcentaje > 0){
                System.out.println("Porcentaje: %"+porcentaje);
                System.out.println("Energia: "+energia);
                System.out.println("amperios-hora: " + amperiosHora + "Ah");
                System.out.println("coulombs: " + coulomb + "C");
            }else{
                System.out.println("Se agotó la batería.");
        }
        
    }
    
    public void reparar(ParteDeArmadura dispositivo){
        Double probabilidadReparar;
        Double probabilidadDestruir;
        do{
            probabilidadReparar = Math.random() * 100;
            if(probabilidadReparar <= 40){
                dispositivo.setDanhado(false);
                System.out.println("El dispositivo fue reparado exitosamente.");
            }else{
                System.out.println("Intento de reparacion fallido.");
                probabilidadDestruir = Math.random() * 100;
                if(probabilidadDestruir <= 30){
                    dispositivo.setDestruido(true);
                    System.out.println("El dispositivo fue destruido.");
                }
            }
        }while(dispositivo.isDestruido() == false && dispositivo.isDanhado() == true);
    }
    
    public void radar(Armadura armadura){
        
        ArrayList<Objetivo> enemigos = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Objetivo objetivo = new Objetivo();
            System.out.println("Objetivo " + (i+1));
            System.out.println(objetivo.toString());
            if(objetivo.isHostil()){
                enemigos.add(objetivo);
            }
        }
        
        System.out.println("Se han encontrado " + enemigos.size() + " enemigos!");
        double distancia;
        int i = 0;
        
        for (Iterator<Objetivo> iterator = enemigos.iterator(); iterator.hasNext();) {
            Objetivo enemigo = iterator.next();
            distancia = calcularDistancia(enemigo);
            System.out.print("El enemigo " + (i + 1) + " se encuentra a " + distancia + " metros");
            if(distancia > 3000){
                System.out.print(". Enemigo fuera de rango!");
                iterator.remove();
            }else{
                enemigo.setDistancia(distancia);
            }
            System.out.println("");
            i++;
        }
        Comparator<Objetivo> compararDistancias = (Objetivo o1, Objetivo o2) -> o1.getDistancia().compareTo(o2.getDistancia());
        enemigos.sort(compararDistancias);
        for (Objetivo enemigo : enemigos) {
            System.out.println(enemigo.toString());
        }
        
        if(armadura.getGuantes().get(0).isDestruido() == false || armadura.getGuantes().get(1).isDestruido() == false){
            for (Iterator<Objetivo> iterator = enemigos.iterator(); iterator.hasNext();) {
                Objetivo enemigo = iterator.next();
                while(enemigo.getResistencia() > 0){
                    atacar(armadura, enemigo);
                    if(armadura.getGuantes().get(0).isDestruido() && armadura.getGuantes().get(1).isDestruido()){
                        break;
                    }
                }
                if(armadura.getGuantes().get(0).isDestruido() && armadura.getGuantes().get(1).isDestruido()){
                        break;
                }
                if(enemigo.getResistencia() <= 0){
                    iterator.remove();
                }
            }
        }
        System.out.println(armadura.toString());
        for (Guante guante : armadura.getGuantes()) {
            System.out.println(guante.toString());
        }
        //mostrarEstado(armadura);
        if(armadura.getGuantes().get(0).isDestruido() && armadura.getGuantes().get(1).isDestruido()){
            evadir(armadura, enemigos.get(0));
        }
        
    }
    
    public double calcularDistancia(Objetivo objetivo){
        return Math.sqrt(Math.pow(objetivo.getCoordenadaX(), 2) + Math.pow(objetivo.getCoordenadaY(), 2) + Math.pow(objetivo.getCoordenadaZ(), 2));
    }
    
    public void atacar(Armadura armadura, Objetivo objetivo){
        
        System.out.println("Atacando enemigo! Resistencia: " + objetivo.getResistencia() + ".");
        double factor = objetivo.getDistancia() / 5000;
        int potenciaDisparo = (int) (80 * (1 - factor));
        ArrayList<Guante> guantes = armadura.getGuantes();
        int cont = 0;
        for (Guante guante : guantes) {
            if(guante.isDanhado() == false){
                cont++;
            }
        }
        
        if(cont == 2){
            potenciaDisparo *= 1.2;
        }
        
        armServ.disparar(armadura, (int)(objetivo.getDistancia() * 0.2));
        
        if(guantes.get(0).isDestruido() == false || guantes.get(1).isDestruido() == false){
            System.out.println("Potencia de disparo: " + potenciaDisparo);
            int resistenciaEnemigo = objetivo.getResistencia();

            resistenciaEnemigo -= potenciaDisparo;
            if(resistenciaEnemigo > 0){
                System.out.println("le quedan " + resistenciaEnemigo + " puntos de salud.");
            }
            objetivo.setResistencia(resistenciaEnemigo);
            if(resistenciaEnemigo <= 0){
                System.out.println("Enemigo destruido!");
            }
        }else{
            System.out.println("No es posible atacar al enemigo. Guantes destruidos.");
        }
        
    }
    
    public void evadir(Armadura armadura, Objetivo objetivo){
        double distancia = objetivo.getDistancia();
        do{
            armServ.correr(armadura, 100);
            distancia += 100;
            System.out.println("Escapando... distancia: " + distancia);
            if(armadura.getBotas().get(0).isDestruido() || armadura.getBotas().get(1).isDestruido()){
                System.out.println("Ya no es posible escapar! Bota destruida.");
                break;
            }
        }while(distancia < 3000);
        
        if(distancia >= 3000){
            System.out.println("Lograste escapar!");
        }
        
    }
}
