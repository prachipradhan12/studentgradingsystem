
package sgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Sgs {
    Connection conn;
    String url ="jdbc:postgresql://localhost:5432/sgs";
    String user ="postgres";
    String password ="postgres";
    public Connection dbconnection()
    {
        try{
        Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
                e.getMessage();
        }
                
        try {
            DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null,"Connected");
        } catch (SQLException ex) {
                Logger.getLogger(Sgs.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null,"Failed Connection");
        }
        return conn;
    }

    public static void main(String[] args) 
    {
       
    }
    
}
