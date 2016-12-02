/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.ulima.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juancarlos
 */
public class DBConexion {
       // Paso 1: Definir una URL de conexion   
    private static String url = "jdbc:mysql://localhost/sistema_venta?user=root&password=";
     /*
       String ip = "localhost";
       String port = "3306";
       String bd = "bd_alumnos";
       String user = "root";
       String password = "root";
       String url2 = "jdbc:mysql://"+ ip + ":" + port + "/" + bd;   
    */
   public static Connection getConnection() {
           Connection con = null;
           try {
               // Paso 2: Cargar el driver
               // puede lanzar la excepcion ClassNotFoundException
               Class.forName("com.mysql.jdbc.Driver");
               // Paso 3: Obtener una conexion a la BD
               // OJO que puede lanzar un SQLException
               con = DriverManager.getConnection(url);
       
           } catch (ClassNotFoundException ex) {
               System.out.println("Verifica tu driver en el classpath");
           } catch (SQLException ex) {
               System.out.println("Verifica tus parametros de conexion");
           }
       
           return con;
   }
}
