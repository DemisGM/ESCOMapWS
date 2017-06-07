/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Demis
 */
public class Evento {
    private int id;
    private String nombre, descripcion;
    private int cupo, aprobado;
    private String tiempo_inicio, tiempo_fin;
    private int id_espacio;
    private String id_expositor;

    public Evento(int id, String nombre, String descripcion, int cupo, int aprobado, String tiempo_inicio, String tiempo_fin, int id_espacio, String id_expositor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cupo = cupo;
        this.aprobado = aprobado;
        this.tiempo_inicio = tiempo_inicio;
        this.tiempo_fin = tiempo_fin;
        this.id_espacio = id_espacio;
        this.id_expositor = id_expositor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    public int getAprobado() {
        return aprobado;
    }

    public void setAprobado(int aprobado) {
        this.aprobado = aprobado;
    }

    public String getTiempo_inicio() {
        return tiempo_inicio;
    }

    public void setTiempo_inicio(String tiempo_inicio) {
        this.tiempo_inicio = tiempo_inicio;
    }

    public String getTiempo_fin() {
        return tiempo_fin;
    }

    public void setTiempo_fin(String tiempo_fin) {
        this.tiempo_fin = tiempo_fin;
    }

    public int getId_espacio() {
        return id_espacio;
    }

    public void setId_espacio(int id_espacio) {
        this.id_espacio = id_espacio;
    }

    public String getId_expositor() {
        return id_expositor;
    }

    public void setId_expositor(String id_expositor) {
        this.id_expositor = id_expositor;
    }
    
    
}
