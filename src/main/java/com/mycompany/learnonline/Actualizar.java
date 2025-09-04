package com.mycompany.learnonline;

public class Actualizar {

    public static void main(String[] args) {
        System.out.println("prueba de actualizacion");

        crud c = new crud();

        // Actualizar usuario con id 1
        c.actualizarDato(1, "Henry Actualizado", "henry.actualizado@gmail.com", 25);

        // Leer todos los usuarios para verificar
        System.out.println("Usuarios después de la actualización");
        c.lectura();
    }
}
