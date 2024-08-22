
package Agenda;

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
        String lugar = "Laboratorio Salud y Vida";
        String fecha = "30/07/2024";
        String hora = "14:00";
        
        //sentencia 
        String sql = "INSERT INTO Agenda (lugar, fecha, hora ('"+lugar+"','"+fecha+"','"+hora+"')";
        
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
            rs = sm.executeQuery("SELECT * FROM Agenda");
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
