/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Alumno;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Demis
 */
public class AlumnoDAO {
    static String message;
    
    public static boolean insert(Alumno a){
        String query = "insert into alumno "
                + "values("
                + "'"+a.getBoleta()+"',"
                + "'"+a.getEmail_asistente()+"'"
                + ")";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean delete(String email_asistente){
        String query = "delete from alumno where email_asistente = '"+email_asistente+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean update(String email_asistente, Alumno a){
        String query = "update alumno "
                + "set boleta = '"+a.getBoleta()+"', "
                + "email_asistente = '"+a.getEmail_asistente()+"' "
                + "where email_asistente = '"+email_asistente+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static Alumno[] getAll(){
        ArrayList<Alumno> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from alumno");
            if(rs !=null){
                while(rs.next())
                    a.add(new Alumno(rs.getString(1), rs.getString(2)));
                rs.close();
                return a.toArray(new Alumno[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static Alumno[] get(String email_asistente){
        ArrayList<Alumno> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from alumno where email_asistente = '"+email_asistente+"'");
            if(rs !=null){
                if(rs.next())
                    a.add(new Alumno(rs.getString(1), rs.getString(2)));
                rs.close();
                return a.toArray(new Alumno[0]);
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
