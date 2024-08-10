
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
        int idE = 3;
        String correoEdit = "Kathe";
        
        //sentencia 
        String sql = "UPDATE Usuario set idE='"+correoEdit+"'";
        
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
            rs = sm.executeQuery("SELECT * FROM Usuario");
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
