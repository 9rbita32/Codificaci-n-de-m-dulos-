/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Carrito_de_compras;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class agregar {
     public static void main(String[] args) {
        conexion con = new conexion();
        Connection cc;
        Statement sm;
        ResultSet rs;
        
        // Datos agg
        String nombre_test = "Tipo de Sangre";
        String unit_precio = "45.000";
        String cantidad_total = "2";
        String total = "90.000";
       
        //sentencia 
        String sql = "INSERT INTO Carrito_de_compras(nombre_test, unit_precio, cantidad_total, total)values ('"+nombre_test+"','"+unit_precio+"','"+cantidad_total+"','"+total+"')";
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
                
         }
        catch(ClassNotFoundException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try {
            cc = con.getConection();
            sm = cc.createStatement();
            sm.executeUpdate(sql);
            rs = sm.executeQuery("SELECT * FROM Carrito_de_compras");
            rs.next();
            
            do{
                System.out.println(rs.getInt("id")+":"+ rs.getString("codigo"));
            }
            while(rs.next());
        }
        catch(SQLException ex){
            Logger.getLogger(agregar.class.getName()).log(Level.SEVERE,null, ex);
        }
              
          
    }
    
}
