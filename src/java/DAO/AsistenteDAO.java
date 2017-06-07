/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Asistente;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Demis
 */
public class AsistenteDAO {
     static String message;
    
    public static boolean insert(Asistente a){
        String query = "insert into asistente "
                + "values("
                + "'"+a.getNombres()+"',"
                + "'"+a.getApellidos()+"',"
                + "'"+a.getGenero()+"',"
                + a.getEdad()+","
                + "'"+a.getEmail_usuario()+"'"
                + ")";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean delete(String email){
        String query = "delete from asistente where email_usuario = '"+email+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean update(String email_usuario, Asistente a){
        String query = "update asistente "
                + "set nombres = '"+a.getNombres()+"', "
                + "apellidos = '"+a.getApellidos()+"', "
                + "genero = '"+a.getGenero()+"',"
                + "edad = "+a.getEdad()+" "
                + "where email_usuario = '"+email_usuario+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static Asistente[] getAll(){
        ArrayList<Asistente> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from asistente");
            if(rs !=null){
                while(rs.next())
                    a.add(new Asistente(rs.getString(1), rs.getString(2), rs.getString(3).charAt(0), rs.getInt(4), rs.getString(5)));
                rs.close();
                return a.toArray(new Asistente[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static Asistente[] get(String email_usuario){
        ArrayList<Asistente> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from asistente where email_usuario = '"+email_usuario+"'");
            if(rs !=null){
                if(rs.next())
                    a.add(new Asistente(rs.getString(1), rs.getString(2), rs.getString(3).charAt(0), rs.getInt(4), rs.getString(5)));
                rs.close();
                return a.toArray(new Asistente[0]);
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
