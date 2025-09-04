//clase para manejar la conexion a la base de datos
package com.mycompany.learnonline;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    
    // Variables de conexión
    static String url = "jdbc:mysql://localhost:3307/learn_online";
    static String user = "root";
    static String pass = "";

    // Metodo para abrir la conexión con MySQL
    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion a la base de datos exitosa.");
        } catch (SQLException ex) {
            System.out.println("Error en la conexion: " + ex.getMessage());
        }
        return con;
    }

    public static void main(String[] args) {
        // se prueba conexion
        Connection test = conectar();
        if (test != null) {
            System.out.println("LearnOnline esta listo.");
        }
   }
}