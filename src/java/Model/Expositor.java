package Model;

/**
 *
 * @author Demis
 */
public class Expositor {
    private String descripcion;
    private String email_usuario;

    private String nombre;

    public Expositor(String nombre, String descripcion, String email_usuario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.email_usuario = email_usuario;
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

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }
    
}
