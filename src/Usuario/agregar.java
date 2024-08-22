/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

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
        String nombre_usuario = "Katherinne";
        String correo = "Fuentes";
        String telefono = "0000";
        String dirección = "Salitre";
        String contraseña = "contraseña";
        String rol = "admin";
        
        //sentencia 
        String sql = "INSERT INTO Usuario (nombre_usuario, correo, telefono, dirección, contraseña, rol)values ('"+nombre_usuario+"','"+correo+"','"+telefono+"','"+dirección+"','"+contraseña+"','"+rol+"',)";
        
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
            rs = sm.executeQuery("SELECT * FROM Usuario");
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
