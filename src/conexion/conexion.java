
package conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class conexion {
    Connection con;
    public conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/microlab","root","192837");
        }
        catch(ClassNotFoundException | SQLException e ){
            System.out.println("no se pudo conenctar");
        }
    
    }
    public Connection getConection(){
        return con;
    
    }
}
