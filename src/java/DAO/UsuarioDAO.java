/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Usuario;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Demis
 */
public class UsuarioDAO {
    static String message;
    
    public static boolean insert(Usuario u){
        String query = "insert into usuario "
                + "values("
                + "'"+u.getEmail()+"',"
                + "'"+u.getPassword()+"',"
                + u.getTipo()
                + ")";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean delete(String email){
        String query = "delete from usuario where email = '"+email+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean update(String email, Usuario u){
        String query = "update usuario "
                + "set email = '"+u.getEmail()+"', "
                + "password = '"+u.getPassword()+"', "
                + "tipo = "+u.getTipo()+" "
                + "where email = '"+email+"'";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static Usuario[] getAll(){
        ArrayList<Usuario> u = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from usuario");
            if(rs !=null){
                while(rs.next())
                    u.add(new Usuario(rs.getString(1), rs.getString(2), rs.getInt(3)));
                rs.close();
                return u.toArray(new Usuario[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static Usuario[] get(String email){
        ArrayList<Usuario> u = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from usuario where email = '"+email+"'");
            if(rs !=null){
                if(rs.next())
                    u.add(new Usuario(rs.getString(1), rs.getString(2), rs.getInt(3)));
                rs.close();
                return u.toArray(new Usuario[0]);
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
