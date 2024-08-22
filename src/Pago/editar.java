
package Pago;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class editar {
     public static void main(String[] args){
        
        conexion con = new conexion();
        Connection cc;
        Statement sm;
        ResultSet rs;
        
        // Datos agg
        int idE = 2;
        String metodo_pagoEdit = "Efectivo";
        
        //sentencia 
        String sql = "UPDATE Pago set idE='"+metodo_pagoEdit+"'";
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
                
         }
        catch(ClassNotFoundException ex){
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try {
            cc = con.getConection();
            sm = cc.createStatement();
            sm.executeUpdate(sql);
            rs = sm.executeQuery("SELECT * FROM Pago");
            rs.next();
            
            do{
                System.out.println(rs.getInt("id")+":"+ rs.getString("codigo"));
            }
            while(rs.next());
        }
        catch(SQLException ex){
            Logger.getLogger(editar.class.getName()).log(Level.SEVERE,null, ex);
        }
    
    
    
    
    }
    
}
