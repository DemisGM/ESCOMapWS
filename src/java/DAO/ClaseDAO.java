/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Clase;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Demis
 */
public class ClaseDAO {
    static String message;
    
    public static boolean insert(Clase c){
        String query = "insert into clase "
                + "values("
                + c.getId()+","
                + "'"+c.getNombre()+"',"
                + c.getId_grupo()
                + ")";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean delete(int id){
        String query = "delete from clase where id = "+id;
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean update(int id, Clase c){
        String query = "update clase "
                + "set id = "+c.getId()+", "
                + "nombre = '"+c.getNombre()+"', "
                + "id_grupo = "+c.getId_grupo()+" "
                + "where id = "+id;
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static Clase[] getAll(){
        ArrayList<Clase> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from clase");
            if(rs !=null){
                while(rs.next())
                    a.add(new Clase(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                rs.close();
                return a.toArray(new Clase[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static Clase[] get(int id){
        ArrayList<Clase> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from clase where id = "+id);
            if(rs !=null){
                if(rs.next())
                    a.add(new Clase(rs.getInt(1), rs.getString(2), rs.getInt(3)));
                rs.close();
                return a.toArray(new Clase[0]);
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
