/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Asistencia;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Demis
 */
public class AsistenciaDAO {
    static String message;
    
    public static boolean insert(Asistencia a){
        String query = "insert into asistencia "
                + "values("
                + "'"+a.getId_usuario()+"',"
                + a.getId_evento()
                + ")";
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static boolean delete(String id_usuario, int id_evento){
        String query = "delete from asistencia where id_usuario = '"+id_usuario+"' and id_evento = "+id_evento;
        boolean success = BDHandler.execute(query);
        if(!success)
            message = BDHandler.getMessage();
        return success;
    }
    
    public static Asistencia[] getAll(){
        ArrayList<Asistencia> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from asistencia");
            if(rs !=null){
                while(rs.next())
                    a.add(new Asistencia(rs.getString(1), rs.getInt(2)));
                rs.close();
                return a.toArray(new Asistencia[0]);
            }else{
                message = BDHandler.getMessage();
                return null;
            }
        }catch(Exception e){
            message = e.getMessage();
            return null;
        }
    }
    
    public static Asistencia[] get(String id_usuario, int id_evento){
        ArrayList<Asistencia> a = new ArrayList<>();
        try{
            ResultSet rs = BDHandler.query("select * from asistencia where id_usuario = '"+id_usuario+"' and id_evento = "+id_evento);
            if(rs !=null){
                if(rs.next())
                    a.add(new Asistencia(rs.getString(1), rs.getInt(2)));
                rs.close();
                return a.toArray(new Asistencia[0]);
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
