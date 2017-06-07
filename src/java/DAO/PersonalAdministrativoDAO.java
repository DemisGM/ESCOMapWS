/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.PersonalAdministrativo;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Demis
 */
public class PersonalAdministrativoDAO {
    static String message;
    
    public static boolean insert(PersonalAdministrativo pa){
        String query = "insert into personal_administrativo "
                + "values("
                + "'"+pa.getNombres()+"',"
                + "'"+pa.getApellidos()+"',"
                + "'"+pa.getEmail_usuario()+"'"
                + ")";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean delete(String email_usuario){
        String query = "delete from personal_administrativo where email_usuario = '"+email_usuario+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean update(String email_usuario, PersonalAdministrativo pa){
        String query = "update personal_administrativo "
                + "set nombres = '"+pa.getNombres()+"', "
                + "apellidos = '"+pa.getApellidos()+"',"
                + "email_usuario = '"+pa.getEmail_usuario()+"' "
                + "where email_usuario = '"+email_usuario+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static PersonalAdministrativo[] getAll(){
        ArrayList<PersonalAdministrativo> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from personal_administrativo");
            if(rs !=null){
                while(rs.next())
                    a.add(new PersonalAdministrativo(rs.getString(1), rs.getString(2), rs.getString(3)));
                rs.close();
                return a.toArray(new PersonalAdministrativo[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static PersonalAdministrativo[] get(String email_usuario){
        ArrayList<PersonalAdministrativo> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from personal_administrativo where email_usuario = '"+email_usuario+"'");
            if(rs !=null){
                if(rs.next())
                    a.add(new PersonalAdministrativo(rs.getString(1), rs.getString(2), rs.getString(3)));
                rs.close();
                return a.toArray(new PersonalAdministrativo[0]);
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
