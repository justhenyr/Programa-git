package com.mycompany.learnonline;

public class Eliminar {

    public static void main(String[] args) {
        System.out.println("=== Prueba de eliminación ===");

        crud c = new crud();
        c.eliminarDato(1);

        System.out.println("\n=== Usuarios después de la eliminación ===");
        c.lectura();
    }
}
