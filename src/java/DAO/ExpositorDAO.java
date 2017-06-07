/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Expositor;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Demis
 */
public class ExpositorDAO {
    static String message;
    
    public static boolean insert(Expositor e){
        String query = "insert into expositor "
                + "values("
                + "'"+e.getNombre()+"',"
                + "'"+e.getDescripcion()+"',"
                + "'"+e.getEmail_usuario()+"'"
                + ")";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean delete(String email_usuario){
        String query = "delete from expositor where email_usuario = '"+email_usuario+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean update(String email_usuario, Expositor e){
        String query = "update expositor "
                + "set nombre = '"+e.getNombre()+"', "
                + "descripcion = '"+e.getDescripcion()+"',"
                + "email_usuario = '"+e.getEmail_usuario()+"' "
                + "where email_usuario = '"+email_usuario+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static Expositor[] getAll(){
        ArrayList<Expositor> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from expositor");
            if(rs !=null){
                while(rs.next())
                    a.add(new Expositor(rs.getString(1), rs.getString(2), rs.getString(3)));
                rs.close();
                return a.toArray(new Expositor[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static Expositor[] get(String email_usuario){
        ArrayList<Expositor> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from expositor where email_usuario = '"+email_usuario+"'");
            if(rs !=null){
                if(rs.next())
                    a.add(new Expositor(rs.getString(1), rs.getString(2), rs.getString(3)));
                rs.close();
                return a.toArray(new Expositor[0]);
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
