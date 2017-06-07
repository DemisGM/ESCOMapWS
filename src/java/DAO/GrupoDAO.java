/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Grupo;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Demis
 */
public class GrupoDAO {
    static String message;
    
    public static boolean insert(Grupo g){
        String query = "insert into grupo "
                + "values("
                + g.getId()+","
                + "'"+g.getNombre()+"',"
                + g.getId_salon()
                + ")";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean delete(int id){
        String query = "delete from grupo where id = "+id;
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean update(int id, Grupo g){
        String query = "update grupo "
                + "set id = "+g.getId()+", "
                + "nombre = '"+g.getNombre()+"', "
                + "id_salon = "+g.getId_salon()+" "
                + "where id = "+id;
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static Grupo[] getAll(){
        ArrayList<Grupo> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from grupo");
            if(rs !=null){
                while(rs.next())
                    a.add(new Grupo(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                rs.close();
                return a.toArray(new Grupo[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static Grupo[] get(int id){
        ArrayList<Grupo> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from grupo where id = "+id);
            if(rs !=null){
                if(rs.next())
                    a.add(new Grupo(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                rs.close();
                return a.toArray(new Grupo[0]);
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
