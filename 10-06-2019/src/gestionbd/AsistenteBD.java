/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RLCR
 */
public class AsistenteBD {
    
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultado = null; 
    String driver = "org.sqlite.JDBC";
    String nombreBD = "empresa.sqlite";
    String url = "jdbc:sqlite:"+nombreBD;
    
    
    public void crearBD(){
        
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        System.out.println("DB Creada con exito!");
    }
    
    public void crearTabla(){
     
        try{
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            
            //sentencia =  conexion.createStatement();
            sentencia = conexion.createStatement(); 
            String sql = "CREATE TABLE CLIENTE" +
                        "(id int primary key not null,"+
                        "Nombre tezt not null,"+
                        "apellido text not null,"+
                        "edad int)";
                    
            sentencia.execute(sql);
            sentencia.close();
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        System.out.println("Tabla creada con exito!");
    }
    
        
    public void insertarDato(){
     
        try{
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement(); 
            sentencia.executeUpdate("INSERT INTO CLIENTE " + "VALUES (2, 'Orlando', 'Guajardo', 27)");        
            sentencia.close();
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        System.out.println("Insertado con exito!");
    }
    
    
    public void actualizarDato(){
     
        try{
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement(); 
            sentencia.executeUpdate("update CLIENTE " + "set Apellido = 'Gatica' where id = 1");        
            sentencia.close();
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        System.out.println("Actualizado con exito!");
    }
    
    public void eliminarDato(){
     
        try{
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement(); 
            sentencia.executeUpdate("delete from CLIENTE " + " where id = 1");        
            sentencia.close();
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        System.out.println("Eliminado todo los datos con exito!");
    }
    
    public void mostrarDato(){
     
        try{
            
            Class.forName(driver);
            conexion = DriverManager.getConnection(url);
            sentencia = conexion.createStatement(); 
            String sql = "select * from cliente";
            resultado = sentencia.executeQuery(sql);
                   
            while(resultado.next()){
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                int edad = resultado.getInt("edad");
                
                System.out.println("\nID: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nEdad: " + edad);
            }
            
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error: "+e.getLocalizedMessage());
        }
        System.out.println("Mostrado con exito!");
    }
}
