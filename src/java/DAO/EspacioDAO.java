/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Espacio;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Demis
 */
public class EspacioDAO {
    static String message;
    
    public static boolean insert(Espacio e){
        String query = "insert into espacio "
                + "values("
                + e.getId()+","
                + "'"+e.getNombre()+"',"
                + e.getLat()+","
                + e.getLon()
                + ")";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean delete(int id){
        String query = "delete from espacio where id = "+id;
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean update(int id, Espacio e){
        String query = "update espacio "
                + "set id = "+e.getId()+", "
                + "nombre = '"+e.getNombre()+"', "
                + "lat = "+e.getLat()+","
                + "lon = "+e.getLon() + " "
                + "where id = "+id;
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static Espacio[] getAll(){
        ArrayList<Espacio> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from espacio");
            if(rs !=null){
                while(rs.next())
                    a.add(new Espacio(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
                rs.close();
                return a.toArray(new Espacio[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static Espacio[] get(int id){
        ArrayList<Espacio> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from espacio where id = "+id);
            if(rs !=null){
                if(rs.next())
                    a.add(new Espacio(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
                rs.close();
                return a.toArray(new Espacio[0]);
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
