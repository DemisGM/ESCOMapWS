/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Profesor;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Demis
 */
public class ProfesorDAO {
    static String message;
    
    public static boolean insert(Profesor p){
        String query = "insert into profesor "
                + "values("
                + "'"+p.getNombres()+"',"
                + "'"+p.getApellidos()+"',"
                + "'"+p.getEmail_usuario()+"'"
                + ")";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean delete(String email_usuario){
        String query = "delete from profesor where email_usuario = '"+email_usuario+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean update(String email_usuario, Profesor p){
        String query = "update profesor "
                + "set nombres = '"+p.getNombres()+"', "
                + "apellidos = '"+p.getApellidos()+"',"
                + "email_usuario = '"+p.getEmail_usuario()+"' "
                + "where email_usuario = '"+email_usuario+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static Profesor[] getAll(){
        ArrayList<Profesor> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from profesor");
            if(rs !=null){
                while(rs.next())
                    a.add(new Profesor(rs.getString(1), rs.getString(2), rs.getString(3)));
                rs.close();
                return a.toArray(new Profesor[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static Profesor[] get(String email_usuario){
        ArrayList<Profesor> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from profesor where email_usuario = '"+email_usuario+"'");
            if(rs !=null){
                if(rs.next())
                    a.add(new Profesor(rs.getString(1), rs.getString(2), rs.getString(3)));
                rs.close();
                return a.toArray(new Profesor[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static String getMessage(){
        return message;
    }
}
