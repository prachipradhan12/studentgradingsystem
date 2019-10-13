/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
class MyConnection {
    Connection conn=null;
  
    String url ="jdbc:postgresql://localhost:5432/sgs";
    String user ="postgres";
    String passwd_c ="root";
    public MyConnection(){
    
        try{
        Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
                e.getMessage();
        }
                
        try {
            conn = DriverManager.getConnection(url, user, passwd_c);
            JOptionPane.showMessageDialog(null,"Connected");
        } catch (SQLException ex) {
                Logger.getLogger(Sgs.class.getName()).log(Level.SEVERE, null, ex);
                   JOptionPane.showMessageDialog(null,"Failed Connection");
        }
        
    }
        public Connection returnConnection()
        {
            if(conn != null) {
                return conn;
            } else {
                try{
                    Class.forName("org.postgresql.Driver");
                    }catch(ClassNotFoundException e){
                            e.getMessage();
                    }

                    try {
                        conn = DriverManager.getConnection(url, user, passwd_c);
                        JOptionPane.showMessageDialog(null,"Connected");
                    } catch (SQLException ex) {
                            Logger.getLogger(Sgs.class.getName()).log(Level.SEVERE, null, ex);
                               JOptionPane.showMessageDialog(null,"Failed Connection");
                    }
                    return conn;
            }
        }
    }


