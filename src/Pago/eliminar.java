
package Pago;

import conexion.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class eliminar {
    public static void main(String[] args){
        
        conexion con = new conexion();
        Connection cc;
        Statement sm;
        ResultSet rs;
        
        // Datos agg
        int idElim = 3;
     
        
        //sentencia 
        String sql = "DELETE FROM cliete WHERE id="+idElim;
        
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
                
         }
        catch(ClassNotFoundException ex){
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE,null,ex);
        }
        
        try {
            cc = con.getConection();
            sm = cc.createStatement();
            sm.executeUpdate(sql);
            rs = sm.executeQuery("SELECT * FROM cliente");
            rs.next();
            
            do{
                System.out.println(rs.getInt("id")+":"+ rs.getString("codigo"));
            }
            while(rs.next());
        }
        catch(SQLException ex){
            Logger.getLogger(eliminar.class.getName()).log(Level.SEVERE,null, ex);
        }
        
        
    }
    
}
