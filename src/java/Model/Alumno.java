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
public class Alumno {
    private String boleta;
    private String email_asistente;

    public Alumno(String boleta, String email_asistente) {
        this.boleta = boleta;
        this.email_asistente = email_asistente;
    }

    public String getEmail_asistente() {
        return email_asistente;
    }

    public void setEmail_asistente(String email_asistente) {
        this.email_asistente = email_asistente;
    }

    public String getBoleta() {
        return boleta;
    }

    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }
    
    
}
