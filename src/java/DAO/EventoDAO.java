/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Evento;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Demis
 */
public class EventoDAO {
    static String message;
    
    public static boolean insert(Evento e){
        String query = "insert into evento "
                + "values("
                + e.getId()+","
                + "'"+e.getNombre()+"',"
                + "'"+e.getDescripcion()+"', "
                + e.getCupo()+", "
                + e.getAprobado()+", "
                + "'"+e.getTiempo_inicio()+"', "
                + "'"+e.getTiempo_fin()+"', "
                + e.getId_espacio()+", "
                + "'" + e.getId_expositor() + "'"
                + ")";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean delete(int id){
        String query = "delete from evento where id = "+id;
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean update(int id, Evento e){
        String query = "update evento "
                + "set id = "+e.getId()+", "
                + "nombre = '"+e.getNombre()+"', "
                + "descripcion = '"+e.getDescripcion()+"', "
                + "cupo = " + e.getCupo()+", "
                + "aprobado = " + e.getAprobado()+", "
                + "tiempo_inicio = '"+e.getTiempo_inicio()+"', "
                + "tiempo_fin = '"+e.getTiempo_fin()+"', "
                + "id_espacio = "+e.getId_espacio()+", "
                + "id_expositor = '"+e.getId_expositor()+"' "
                + "where id = "+id;
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static Evento[] getAll(){
        ArrayList<Evento> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from evento");
            if(rs !=null){
                while(rs.next())
                    a.add(new Evento(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)));
                rs.close();
                return a.toArray(new Evento[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static Evento[] get(int id){
        ArrayList<Evento> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from evento where id = "+id);
            if(rs !=null){
                if(rs.next())
                    a.add(new Evento(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9)));                
                rs.close();
                return a.toArray(new Evento[0]);
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
