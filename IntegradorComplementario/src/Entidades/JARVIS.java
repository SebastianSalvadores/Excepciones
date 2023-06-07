/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sebastian
 */
public class JARVIS {
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
    
    public void radar(){
        ArrayList<Objetivo> enemigos = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Objetivo objetivo = new Objetivo();
            System.out.println("Objetivo " + (i+1));
            System.out.println(objetivo.toString());
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
            }
            System.out.println("");
            i++;
        }
        
        for (Objetivo enemigo : enemigos) {
            System.out.println(enemigo.toString());
        }
    }
    
    public double calcularDistancia(Objetivo objetivo){
        return Math.sqrt(Math.pow(objetivo.getCoordenadaX(), 2) + Math.pow(objetivo.getCoordenadaY(), 2) + Math.pow(objetivo.getCoordenadaZ(), 2));
    }
}
