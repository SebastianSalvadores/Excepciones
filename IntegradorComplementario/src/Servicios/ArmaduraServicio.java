/*
En esta primera etapa con una armadura podremos: caminar, correr, propulsar, volar, escribir y
leer.

    • Al caminar la armadura hará un uso básico de las botas y se consumirá la energía
    establecida como consumo en la bota por el tiempo en el que se camine.

    • Al correr la armadura hará un uso normal de las botas y se consumirá el doble de la
    energía establecida como consumo en la bota por el tiempo en el que se corra.
    
    • Al propulsarse la armadura hará un uso intensivo de las botas utilizando el triple de la
    energía por el tiempo que dure la propulsión.

    • Al volar la armadura hará un uso intensivo de las botas y de los guantes un uso normal
    consumiendo el triple de la energía establecida para las botas y el doble para los guantes.

    • Al utilizar los guantes como armas el consumo se triplica durante el tiempo del disparo.

    • Al utilizar las botas para caminar o correr el consumo es normal durante el tiempo que se
    camina o se corra.

    • Cada vez que se escribe en la consola o se habla a través del sintetizador se consume lo
    establecido en estos dispositivos. Solo se usa en nivel básico.

    • Cada vez que se efectúa una acción se llama a los métodos usar del dispositivo se le pasa
    el nivel de intensidad y el tiempo. El dispositivo debe retornar la energía consumida y la
    armadura deberá informar al generador se ha consumido esa cantidad de energía.
 */
package Servicios;

import Entidades.Armadura;
import Entidades.Bota;
import Entidades.Casco;
import Entidades.Guante;
import Entidades.ParteDeArmadura;
import java.util.ArrayList;


/**
 *
 * @author Sebastian
 */
public class ArmaduraServicio {
    
    public void caminar(Armadura armadura, int tiempo){
        ArrayList<Bota> botas = armadura.getBotas();
        if(botas.get(0).isDanhado() == false && botas.get(1).isDanhado() == false){
            int consumo = botas.get(0).getCosumo();
            float energia = armadura.getEnergia();
            energia -= (consumo * tiempo);
            armadura.setEnergia(energia);
            for (Bota bota : botas) {
                usarDispositivo(bota);
            }
        }else{
            if(botas.get(0).isDanhado() && botas.get(0).isDestruido() == false){
                //reparar bota 0
                botas.get(0).setDanhado(true);
            }else if(botas.get(1).isDanhado() && botas.get(1).isDestruido() == false){
                //reparar bota 1
                botas.get(1).setDanhado(true);
            }else if(botas.get(0).isDestruido() && botas.get(1).isDestruido()){
                System.out.println("No es posible caminar. Bota destruida.");
            }
        }
    }
    
    public void correr(Armadura armadura, int tiempo){
        ArrayList<Bota> botas = armadura.getBotas();
        int consumo = botas.get(0).getCosumo() * 2;
        float energia = armadura.getEnergia();
        energia -= (consumo * tiempo);
        armadura.setEnergia(energia);
    }
    
    public void propulsar(Armadura armadura, int tiempo){
        ArrayList<Bota> botas = armadura.getBotas();
        int consumo = botas.get(0).getCosumo() * 3;
        float energia = armadura.getEnergia();
        energia -= (consumo * tiempo);
        armadura.setEnergia(energia);
    }
    
    public void volar(Armadura armadura, int tiempo){
        ArrayList<Bota> botas = armadura.getBotas();
        ArrayList<Guante> guantes = armadura.getGuantes();
        int consumoBotas = botas.get(0).getCosumo() * 3;
        int consumoGuantes = guantes.get(0).getCosumo() * 2;
        float energia = armadura.getEnergia();
        energia -= ((consumoBotas + consumoGuantes) * tiempo);
        armadura.setEnergia(energia);
    }
    
    public void disparar(Armadura armadura, int tiempo){
        ArrayList<Guante> guantes = armadura.getGuantes();
        int consumo = guantes.get(0).getCosumo() * 3;
        float energia = armadura.getEnergia();
        energia -= (consumo * tiempo);
        armadura.setEnergia(energia);
    }
    
    public void consola(Armadura armadura, int tiempo){
        Casco casco = armadura.getCasco();
        int consumo = casco.getCosumo();
        float energia = armadura.getEnergia();
        energia -= (consumo * tiempo);
        armadura.setEnergia(energia);
    }
    
    public void usarDispositivo(ParteDeArmadura dispositivo){
        double azar = Math.random() * 100;
        if(azar >= 70){
            dispositivo.setDanhado(true);
        }
    }
    
}
