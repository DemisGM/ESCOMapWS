/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Demis
 */
public class BDHandler {

    Connection con;
    private static final String dbname = "public", user = "root", password = "root";
    static String message = "";

    private static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection ("jdbc:mysql://localhost/"+dbname,user, password);
            return con;
        } catch (Exception e) {
            message = e.getMessage();
            return null;
        }
    }
    
    public static ResultSet query(String inst){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            if(con !=null){
                stmt = con.createStatement();
                rs = stmt.executeQuery(inst);
                return rs;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            message = ex.getMessage();
            return null;
        }
    }
    
    public static boolean execute(String inst){
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            stmt.execute(inst);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            message = ex.getMessage();
            return false;
        }
        
    }

    public static String getMessage() {
        return message;
    }
}
