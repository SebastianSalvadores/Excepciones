/*
Definir una Clase que contenga algún tipo de dato de tipo array y agregue el código para
generar y capturar una excepción ArrayIndexOutOfBoundsException (índice de arreglo fuera
de rango).
 */
package ej2;

import Entidad.Alumno;

/**
 *
 * @author Sebastian
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] cursos = {"Matematica", "Lengua", "Geografia", "Historia"};
        Alumno alumno = new Alumno("Seba", "Salvadores", 28, cursos);
        System.out.println(alumno.toString() + "\nCursos:");
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println(alumno.getCursos()[i]);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("El alumno solo tiene 4 cursos.");
        }
    }
    
}
