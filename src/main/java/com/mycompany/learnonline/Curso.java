package com.mycompany.learnonline;

public class Curso {
    //atributos 
    private String titulo;
    private int duracion; //en horas
    
    //metodo para mostrar info del curso
    public void mostrarCurso() {
        System.out.println("Titulo " + titulo);
        System.out.println("Duracion " + duracion);
    }
}
