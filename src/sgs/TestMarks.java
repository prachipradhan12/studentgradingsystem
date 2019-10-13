/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author HP
 */
public class TestMarks {
 
    static Connection conn;
    static String url ="jdbc:postgresql://localhost:5432/sgs";
    static String user ="postgres";
    static String passwd_c ="root";
    
    public static void initConn() {
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
    
    public static void main(String[] args) {
        conn = new MyConnection().returnConnection();
       
        ResultSet rs;
        try {
            if(conn == null) {
                System.out.println("Connection NULL");
            } else {
                
            Statement stmt= conn.createStatement();
            rs=stmt.executeQuery("Select * from student_result()");
            while(rs.next()) {
                System.out.println("RollID = " + rs.getInt("rollid"));
            }
            }
        } catch (Exception ex) {
            Logger.getLogger(marks.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    }
    
}
