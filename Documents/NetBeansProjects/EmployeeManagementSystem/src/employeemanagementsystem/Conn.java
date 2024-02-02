
package employeemanagementsystem;

import java.sql.*;

public class Conn {
    public Connection c;
    public Statement s;
    
   public Conn(){
        try {
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root","root");
            s=c.createStatement();
            System.out.println("Connection Established");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
