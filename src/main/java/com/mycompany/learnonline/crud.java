package com.mycompany.learnonline;
import java.sql.*; //proceso de insercion de datos sql

public class crud {
    
    public void insertarDato(int edad, String nombre, String email) 
    {
        String query = "INSERT INTO usuarios (nombre, email, edad, fecha_registro) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
        try 
        {
            Connection con = dbConnection.conectar(); //usar el metodo conectar() de dbConnection
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setInt(3, edad);
            
            ps.executeUpdate();
            System.out.println("Dato insertado correctamente.");
        }
        catch (SQLException ex) 
        {
            System.out.println("Error al insertar: " + ex.getMessage());
        }
   }  
    
    // aqui es el metodo de prueba para la INSERCION
    public static void main(String[] args) {
        crud c = new crud();
        c.insertarDato(0, "nombre", "abc@mail.com");
    }
    //LECTURA
    public void lectura()
    {
        String query = "SELECT id, nombre, email, edad, fecha_registro FROM usuarios";

        try {
            
            Connection con = dbConnection.conectar(); //usar el metodo conectar() de dbConnection
             PreparedStatement ps = con.prepareStatement(query);
             
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
                int id=rs.getInt("id");
                String nombre=rs.getString("nombre");
                String email=rs.getString("email");
                int edad=rs.getInt("edad");
                String fecha=rs.getString("fecha_registro");
                System.out.println(id + " | " + nombre + " | " + email + " | " + edad + " | " + fecha);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al leer dato: " + ex.getMessage());
        }    
    }
  // metodo para ACTUALIZAR un usuario por id
   public void actualizarDato(int id, String nombre, String email, int edad) {
        String query = "UPDATE usuarios SET nombre = ?, email = ?, edad = ? WHERE id = ?";
        try {
            Connection con = Main.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, email);
            ps.setInt(3, edad);
            ps.setInt(4, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontro el usuario con id " + id);
            }
        } catch (SQLException ex) {
            System.out.println("Error al actualizar: " + ex.getMessage());
        }
    }
   

        // eliminar usuarios por id
   
    public void eliminarDato(int id) {
        String query = "DELETE FROM usuarios WHERE id = ?";
        try {
            Connection con = Main.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Usuario eliminado.");
            } else {
                System.out.println("No se encontrp el usuario con id "+ id);
            }
        } catch (SQLException ex) {
            System.out.println("Error al eliminar: "+ ex.getMessage());
        }
    }
}    
