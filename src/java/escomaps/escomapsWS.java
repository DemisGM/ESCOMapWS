package escomaps;

import Model.*;
import DAO.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Demis
 */
@WebService(serviceName = "escomapsWS")
public class escomapsWS {

    /****************************
     *    OPERACIONES USUARIO   *
     * *************************/
    @WebMethod(operationName = "usuario_insert")
    public String usuario_insert(@WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "tipo") int tipo) {
        Usuario u = new Usuario(email, password, tipo);
        String ret = "";
        if(UsuarioDAO.insert(u))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+UsuarioDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "usuario_delete")
    public String usuario_delete(@WebParam(name = "email") String email) {
        String ret = "";
        if(UsuarioDAO.delete(email))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+UsuarioDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "usuario_update")
    public String usuario_update(@WebParam(name = "email") String email, @WebParam(name = "password") String password, @WebParam(name = "tipo") int tipo) {
        Usuario u = new Usuario(email, password, tipo);
        String ret = "";
        if(UsuarioDAO.update(email, u))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+UsuarioDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "usuario_getAll")
    public String usuario_getAll() {
        String ret = "";
        Usuario users[] = UsuarioDAO.getAll();
        if(users!=null){
            ret+="<usuarios>";
            for(Usuario u : users){
                ret+= "<usuario>"
                        + "<email>"+u.getEmail()+"</email>"
                        + "<password>"+u.getPassword()+"</password>"
                        + "<tipo>"+u.getTipo()+"</tipo>"
                        + "</usuario>";
            }
            ret+="</usuarios>";
        }
        else
            ret +=  "<error>"+UsuarioDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "usuario_get")
    public String usuario_get(@WebParam(name = "email") String email) {
        String ret = "";
        Usuario users[] = UsuarioDAO.get(email);
        if(users!=null){
            if(users.length > 0){
                ret+="<usuarios>";
                Usuario u = users[0];
                ret+= "<usuario>"
                        + "<email>"+u.getEmail()+"</email>"
                        + "<password>"+u.getPassword()+"</password>"
                        + "<tipo>"+u.getTipo()+"</tipo>"
                        + "</usuario>";
            }
            ret+="</usuarios>";
        }
        else
            ret +=  "<error>"+UsuarioDAO.getMessage()+"</error>";
        return ret;
    }

    /****************************
     *    OPERACIONES ASISTENTE   *
     * *************************/
    @WebMethod(operationName = "asistente_insert")
    public String asistente_insert(@WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "genero") String genero, @WebParam(name = "edad") int edad, @WebParam(name = "email_usuario") String email_usuario) {
        Asistente a = new Asistente(nombres, apellidos, genero.charAt(0), edad, email_usuario);
        String ret = "";
        if(AsistenteDAO.insert(a))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+AsistenteDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "asistente_delete")
    public String asistente_delete(@WebParam(name = "email_usuario") String email_usuario) {
        String ret = "";
        if(AsistenteDAO.delete(email_usuario))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+AsistenteDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "asistente_update")
    public String asistente_update(@WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "genero") String genero, @WebParam(name = "edad") int edad, @WebParam(name = "email_usuario") String email_usuario) {
        Asistente a = new Asistente(nombres, apellidos, genero.charAt(0), edad, email_usuario);
        String ret = "";
        if(AsistenteDAO.update(email_usuario, a))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+AsistenteDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "asistente_getAll")
    public String asistente_getAll() {
        String ret = "";
        Asistente assist[] = AsistenteDAO.getAll();
        if(assist!=null){
            ret+="<asistentes>";
            for(Asistente a : assist){
                ret+= "<asistente>"
                        + "<nombres>"+a.getNombres()+"</nombres>"
                        + "<apellidos>"+a.getApellidos()+"</apellidos>"
                        + "<genero>"+a.getGenero()+"</genero>"
                        + "<edad>"+a.getEdad()+"</edad>"
                        + "<email>"+a.getEmail_usuario()+"</email>"
                        + "</asistente>";
            }
            ret+="</asistentes>";
        }
        else
            ret +=  "<error>"+AsistenteDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "asistente_get")
    public String asistente_get(@WebParam(name = "email_usuario") String email_usuario) {
        String ret = "";
        Asistente assist[] = AsistenteDAO.get(email_usuario);
        if(assist!=null){
            ret+="<asistentes>";
            if(assist.length > 0){
                Asistente a = assist[0];
                ret+= "<asistente>"
                            + "<nombres>"+a.getNombres()+"</nombres>"
                            + "<apellidos>"+a.getApellidos()+"</apellidos>"
                            + "<genero>"+a.getGenero()+"</genero>"
                            + "<edad>"+a.getEdad()+"</edad>"
                            + "<email>"+a.getEmail_usuario()+"</email>"
                            + "</asistente>";
            }
            ret+="</asistentes>";
        }
        else
            ret +=  "<error>"+AsistenteDAO.getMessage()+"</error>";
        return ret;
    }

    /****************************
     *    OPERACIONES ALUMNO   **
     * *************************/
    @WebMethod(operationName = "alumno_insert")
    public String alumno_insert(@WebParam(name = "boleta") String boleta, @WebParam(name = "email_asistente") String email_asistente) {
        Alumno a = new Alumno(boleta, email_asistente);
        String ret = "";
        if(AlumnoDAO.insert(a))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+AlumnoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "alumno_delete")
    public String alumno_delete(@WebParam(name = "email_asistente") String email_asistente) {
        String ret = "";
        if(AlumnoDAO.delete(email_asistente))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+AlumnoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "alumno_update")
    public String alumno_update(@WebParam(name = "boleta") String boleta, @WebParam(name = "email_asistente") String email_asistente) {
        Alumno a = new Alumno(boleta, email_asistente);
        String ret = "";
        if(AlumnoDAO.update(email_asistente, a))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+AlumnoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "alumno_getAll")
    public String alumno_getAll() {
        String ret = "";
        Alumno alumn[] = AlumnoDAO.getAll();
        if(alumn!=null){
            ret+="<alumnos>";
            for(Alumno a : alumn){
                ret+= "<alumno>"
                        + "<boleta>"+a.getBoleta()+"</boleta>"
                        + "<email>"+a.getEmail_asistente()+"</email>"
                        + "</alumno>";
            }
            ret+="</alumnos>";
        }
        else
            ret +=  "<error>"+AlumnoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "alumno_get")
    public String alumno_get(@WebParam(name = "email_asistente") String email_asistente) {
        String ret = "";
        Alumno alumn[] = AlumnoDAO.get(email_asistente);
        if(alumn!=null){
            ret+="<alumnos>";
            if(alumn.length > 0){
                Alumno a = alumn[0];
                ret+= "<alumno>"
                        + "<boleta>"+a.getBoleta()+"</boleta>"
                        + "<email>"+a.getEmail_asistente()+"</email>"
                        + "</alumno>";
            }
            ret+="</alumnos>";
        }
        else
            ret +=  "<error>"+AlumnoDAO.getMessage()+"</error>";
        return ret;
    }

    /****************************
     **  OPERACIONES PERSONAL  **
     * *************************/
    @WebMethod(operationName = "personal_insert")
    public String personal_insert(@WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "email_usuario") String email_usuario) {
        PersonalAdministrativo a = new PersonalAdministrativo(nombres, apellidos, email_usuario);
        String ret = "";
        if(PersonalAdministrativoDAO.insert(a))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+PersonalAdministrativoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "personal_delete")
    public String personal_delete(@WebParam(name = "email_usuario") String email_usuario) {
        String ret = "";
        if(PersonalAdministrativoDAO.delete(email_usuario))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+PersonalAdministrativoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "personal_update")
    public String personal_update(@WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "email_usuario") String email_usuario) {
        PersonalAdministrativo a = new PersonalAdministrativo(nombres, apellidos, email_usuario);
        String ret = "";
        if(PersonalAdministrativoDAO.update(email_usuario, a))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+PersonalAdministrativoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "personal_getAll")
    public String personal_getAll() {
        String ret = "";
        PersonalAdministrativo adm[] = PersonalAdministrativoDAO.getAll();
        if(adm!=null){
            ret+="<administrativos>";
            for(PersonalAdministrativo a : adm){
                ret+= "<administrativo>"
                        + "<nombres>"+a.getNombres()+"</nombres>"
                        + "<apellidos>"+a.getApellidos()+"</apellidos>"
                        + "<email>"+a.getEmail_usuario()+"</email>"
                        + "</administrativo>";
            }
            ret+="</administrativos>";
        }
        else
            ret +=  "<error>"+PersonalAdministrativoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "personal_get")
    public String personal_get(@WebParam(name = "email_usuario") String email_usuario) {
        String ret = "";
        PersonalAdministrativo adm[] = PersonalAdministrativoDAO.get(email_usuario);
        if(adm!=null){
            ret+="<administrativos>";
            if(adm.length > 0){
                PersonalAdministrativo a = adm[0];
                ret+= "<administrativo>"
                        + "<nombres>"+a.getNombres()+"</nombres>"
                        + "<apellidos>"+a.getApellidos()+"</apellidos>"
                        + "<email>"+a.getEmail_usuario()+"</email>"
                        + "</administrativo>";
            }
            ret+="</administrativos>";
        }
        else
            ret +=  "<error>"+PersonalAdministrativoDAO.getMessage()+"</error>";
        return ret;
    }

    /****************************
     **  OPERACIONES PROFESOR  **
     * *************************/
    @WebMethod(operationName = "profesor_insert")
    public String profesor_insert(@WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "email_usuario") String email_usuario) {
        Profesor p = new Profesor(nombres, apellidos, email_usuario);
        String ret = "";
        if(ProfesorDAO.insert(p))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+ProfesorDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "profesor_delete")
    public String profesor_delete(@WebParam(name = "email_usuario") String email_usuario) {
        String ret = "";
        if(ProfesorDAO.delete(email_usuario))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+ProfesorDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "profesor_update")
    public String profesor_update(@WebParam(name = "nombres") String nombres, @WebParam(name = "apellidos") String apellidos, @WebParam(name = "email_usuario") String email_usuario) {
        Profesor p = new Profesor(nombres, apellidos, email_usuario);
        String ret = "";
        if(ProfesorDAO.update(email_usuario, p))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+ProfesorDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "profesor_getAll")
    public String profesor_getAll() {
        String ret = "";
        Profesor profs[] = ProfesorDAO.getAll();
        if(profs!=null){
            ret+="<profesores>";
            for(Profesor p : profs){
                ret+= "<profesor>"
                        + "<nombres>"+p.getNombres()+"</nombres>"
                        + "<apellidos>"+p.getApellidos()+"</apellidos>"
                        + "<email>"+p.getEmail_usuario()+"</email>"
                        + "</profesor>";
            }
            ret+="</profesores>";
        }
        else
            ret +=  "<error>"+ProfesorDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "profesor_get")
    public String profesor_get(@WebParam(name = "email_usuario") String email_usuario) {
        String ret = "";
        Profesor profs[] = ProfesorDAO.get(email_usuario);
        if(profs!=null){
            ret+="<profesores>";
            if(profs.length > 0){
                Profesor p = profs[0];
                ret+= "<profesor>"
                        + "<nombres>"+p.getNombres()+"</nombres>"
                        + "<apellidos>"+p.getApellidos()+"</apellidos>"
                        + "<email>"+p.getEmail_usuario()+"</email>"
                        + "</profesor>";
            }
            ret+="</profesores>";
        }
        else
            ret +=  "<error>"+ProfesorDAO.getMessage()+"</error>";
        return ret;
    }
    
    /****************************
     ** OPERACIONES EXPOSITOR **
     * *************************/
    @WebMethod(operationName = "expositor_insert")
    public String expositor_insert(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "email_usuario") String email_usuario) {
        Expositor e = new Expositor(nombre, descripcion, email_usuario);
        String ret = "";
        if(ExpositorDAO.insert(e))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+ExpositorDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "expositor_delete")
    public String expositor_delete(@WebParam(name = "email_usuario") String email_usuario) {
        String ret = "";
        if(ExpositorDAO.delete(email_usuario))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+ExpositorDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "expositor_update")
    public String expositor_update(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "email_usuario") String email_usuario) {
        Expositor e = new Expositor(nombre, descripcion, email_usuario);
        String ret = "";
        if(ExpositorDAO.update(email_usuario, e))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+ExpositorDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "expositor_getAll")
    public String expositor_getAll() {
        String ret = "";
        Expositor exp[] = ExpositorDAO.getAll();
        if(exp!=null){
            ret+="<expositores>";
            for(Expositor e : exp){
                ret+= "<expositor>"
                        + "<nombre>"+e.getNombre()+"</nombre>"
                        + "<descripcion>"+e.getDescripcion()+"</descripcion>"
                        + "<email>"+e.getEmail_usuario()+"</email>"
                        + "</expositor>";
            }
            ret+="</expositores>";
        }
        else
            ret +=  "<error>"+ExpositorDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "expositor_get")
    public String expositor_get(@WebParam(name = "email_usuario") String email_usuario) {
        String ret = "";
        Expositor exp[] = ExpositorDAO.get(email_usuario);
        if(exp!=null){
            ret+="<expositores>";
            if(exp.length > 0){
                Expositor e = exp[0];
                ret+= "<expositor>"
                        + "<nombre>"+e.getNombre()+"</nombre>"
                        + "<descripcion>"+e.getDescripcion()+"</descripcion>"
                        + "<email>"+e.getEmail_usuario()+"</email>"
                        + "</expositor>";
            }
            ret+="</expositores>";
        }
        else
            ret +=  "<error>"+ExpositorDAO.getMessage()+"</error>";
        return ret;
    }

    /****************************
     **  OPERACIONES ESPACIO  **
     * *************************/
    @WebMethod(operationName = "espacio_insert")
    public String espacio_insert(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "lat") double lat, @WebParam(name = "lon") double lon) {
        Espacio e = new Espacio(id, nombre, lat, lon);
        String ret = "";
        if(EspacioDAO.insert(e))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+EspacioDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "espacio_delete")
    public String espacio_delete(@WebParam(name = "id") int id) {
        String ret = "";
        if(EspacioDAO.delete(id))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+EspacioDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "espacio_update")
    public String espacio_update(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "lat") double lat, @WebParam(name = "lon") double lon) {
        Espacio e = new Espacio(id, nombre, lat, lon);
        String ret = "";
        if(EspacioDAO.update(id, e))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+EspacioDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "espacio_getAll")
    public String espacio_getAll() {
        String ret = "";
        Espacio esp[] = EspacioDAO.getAll();
        if(esp!=null){
            ret+="<espacios>";
            for(Espacio e : esp){
                ret+= "<espacio>"
                        + "<id>"+e.getId()+"</id>"
                        + "<nombre>"+e.getNombre()+"</nombre>"
                        + "<lat>"+e.getLat()+"</lat>"
                        + "<lon>"+e.getLon()+"</lon>"
                        + "</espacio>";
            }
            ret+="</espacios>";
        }
        else
            ret +=  "<error>"+EspacioDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "espacio_get")
    public String espacio_get(@WebParam(name = "id") int id) {
        String ret = "";
        Espacio esp[] = EspacioDAO.get(id);
        if(esp!=null){
            ret+="<espacios>";
            if(esp.length > 0){
                Espacio e = esp[0];
                ret+= "<espacio>"
                        + "<id>"+e.getId()+"</id>"
                        + "<nombre>"+e.getNombre()+"</nombre>"
                        + "<lat>"+e.getLat()+"</lat>"
                        + "<lon>"+e.getLon()+"</lon>"
                        + "</espacio>";;
            }
            ret+="</espacios>";
        }
        else
            ret +=  "<error>"+EspacioDAO.getMessage()+"</error>";
        return ret;
    }

    /****************************
     **  OPERACIONES EVENTO  **
     * *************************/
    @WebMethod(operationName = "evento_insert")
    public String evento_insert(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "cupo") int cupo, @WebParam(name = "aprobado") int aprobado, @WebParam(name = "tiempo_inicio") String tiempo_inicio, @WebParam(name = "tiempo_fin") String tiempo_fin, @WebParam(name = "id_espacio") int id_espacio, @WebParam(name = "id_expositor") String id_expositor) {
        Evento e = new Evento(id, nombre, descripcion, cupo, aprobado, tiempo_inicio, tiempo_fin, id_espacio, id_expositor);
        String ret = "";
        if(EventoDAO.insert(e))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+EventoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "evento_delete")
    public String evento_delete(@WebParam(name = "id") int id) {
        String ret = "";
        if(EventoDAO.delete(id))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+EventoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "evento_update")
    public String evento_update(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "cupo") int cupo, @WebParam(name = "aprobado") int aprobado, @WebParam(name = "tiempo_inicio") String tiempo_inicio, @WebParam(name = "tiempo_fin") String tiempo_fin, @WebParam(name = "id_espacio") int id_espacio, @WebParam(name = "id_expositor") String id_expositor) {
        Evento e = new Evento(id, nombre, descripcion, cupo, aprobado, tiempo_inicio, tiempo_fin, id_espacio, id_expositor);
        String ret = "";
        if(EventoDAO.update(id, e))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+EventoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "evento_getAll")
    public String evento_getAll() {
        String ret = "";
        Evento eve[] = EventoDAO.getAll();
        if(eve!=null){
            ret+="<eventos>";
            for(Evento e : eve){
                ret+= "<evento>"
                        + "<id>"+e.getId()+"</id>"
                        + "<nombre>"+e.getNombre()+"</nombre>"
                        + "<descripcion>"+e.getDescripcion()+"</descripcion>"
                        + "<cupo>"+e.getCupo()+"</cupo>"
                        + "<aprobado>"+e.getAprobado()+"</aprobado>"
                        + "<tinicio>"+e.getTiempo_inicio()+"</tinicio>"
                        + "<tfin>"+e.getTiempo_fin()+"</tfin>"
                        + "<espacio>"+e.getId_espacio()+"</espacio>"
                        + "<expositor>"+e.getId_expositor()+"</expositor>"
                        + "</evento>";
            }
            ret+="</eventos>";
        }
        else
            ret +=  "<error>"+EventoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "evento_get")
    public String evento_get(@WebParam(name = "id") int id) {
        String ret = "";
        Evento eve[] = EventoDAO.get(id);
        if(eve!=null){
            ret+="<eventos>";
            if(eve.length > 0){
                Evento e = eve[0];
                ret+= "<evento>"
                        + "<id>"+e.getId()+"</id>"
                        + "<nombre>"+e.getNombre()+"</nombre>"
                        + "<descripcion>"+e.getDescripcion()+"</descripcion>"
                        + "<cupo>"+e.getCupo()+"</cupo>"
                        + "<aprobado>"+e.getAprobado()+"</aprobado>"
                        + "<tinicio>"+e.getTiempo_inicio()+"</tinicio>"
                        + "<tfin>"+e.getTiempo_fin()+"</tfin>"
                        + "<espacio>"+e.getId_espacio()+"</espacio>"
                        + "<expositor>"+e.getId_expositor()+"</expositor>"
                        + "</evento>";
            }
            ret+="</eventos>";
        }
        else
            ret +=  "<error>"+EventoDAO.getMessage()+"</error>";
        return ret;
    }

    /****************************
     **  OPERACIONES ASISTENCIA  **
     * *************************/
    @WebMethod(operationName = "asistencia_insert")
    public String asistencia_insert(@WebParam(name = "id_usuario") String id_usuario, @WebParam(name = "id_evento") int id_evento) {
        Asistencia a = new Asistencia(id_usuario, id_evento);
        String ret = "";
        if(AsistenciaDAO.insert(a))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+AsistenciaDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "asistencia_delete")
    public String asistencia_delete(@WebParam(name = "id_usuario") String id_usuario, @WebParam(name = "id_evento") int id_evento) {
        String ret = "";
        if(AsistenciaDAO.delete(id_usuario, id_evento))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+AsistenciaDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "asistencia_getAll")
    public String asistencia_getAll() {
        String ret = "";
        Asistencia asi[] = AsistenciaDAO.getAll();
        if(asi!=null){
            ret+="<asistencias>";
            for(Asistencia a : asi){
                ret+= "<asistencia>"
                        + "<usuario>"+a.getId_usuario()+"</usuario>"
                        + "<evento>"+a.getId_evento()+"</evento>"
                        + "</asistencia>";
            }
            ret+="</asistencias>";
        }
        else
            ret +=  "<error>"+AsistenciaDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "asistencia_getAllByUser")
    public String asistencia_getAllByUser(@WebParam(name = "id_usuario") String id_usuario) {
        String ret = "";
        Asistencia asi[] = AsistenciaDAO.getAll();
        if(asi!=null){
            ret+="<asistencias>";
            for(Asistencia a : asi){
                if(a.getId_usuario().equals(id_usuario)){
                    ret+= "<asistencia>"
                            + "<usuario>"+a.getId_usuario()+"</usuario>"
                            + "<evento>"+a.getId_evento()+"</evento>"
                            + "</asistencia>";
                }
            }
            ret+="</asistencias>";
        }
        else
            ret +=  "<error>"+AsistenciaDAO.getMessage()+"</error>";
        return ret;
    }
    
    @WebMethod(operationName = "asistencia_getAllByEvent")
    public String asistencia_getAllByEvent(@WebParam(name = "id_evento") int id_evento) {
        String ret = "";
        Asistencia asi[] = AsistenciaDAO.getAll();
        if(asi!=null){
            ret+="<asistencias>";
            for(Asistencia a : asi){
                if(a.getId_evento() == id_evento){
                    ret+= "<asistencia>"
                            + "<usuario>"+a.getId_usuario()+"</usuario>"
                            + "<evento>"+a.getId_evento()+"</evento>"
                            + "</asistencia>";
                }
            }
            ret+="</asistencias>";
        }
        else
            ret +=  "<error>"+AsistenciaDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "asistencia_get")
    public String asistencia_get(@WebParam(name = "id_usuario") String id_usuario, @WebParam(name = "id_evento") int id_evento) {
        String ret = "";
        Asistencia asi[] = AsistenciaDAO.get(id_usuario, id_evento);
        if(asi!=null){
            ret+="<asistencias>";
            if(asi.length > 0){
                Asistencia a = asi[0];
                ret+= "<asistencia>"
                        + "<usuario>"+a.getId_usuario()+"</usuario>"
                        + "<evento>"+a.getId_evento()+"</evento>"
                        + "</asistencia>";
            }
            ret+="</asistencias>";
        }
        else
            ret +=  "<error>"+AsistenciaDAO.getMessage()+"</error>";
        return ret;
    }

    /****************************
     **  OPERACIONES GRUPO  **
     * *************************/
    @WebMethod(operationName = "grupo_insert")
    public String grupo_insert(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "id_salon") int id_salon) {
        Grupo g = new Grupo(id, nombre, id_salon);
        String ret = "";
        if(GrupoDAO.insert(g))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+GrupoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "grupo_delete")
    public String grupo_delete(@WebParam(name = "id") int id) {
        String ret = "";
        if(GrupoDAO.delete(id))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+GrupoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "grupo_update")
    public String grupo_update(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "id_salon") int id_salon) {
        Grupo g = new Grupo(id, nombre, id_salon);
        String ret = "";
        if(GrupoDAO.update(id, g))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+GrupoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "grupo_getAll")
    public String grupo_getAll() {
        String ret = "";
        Grupo gru[] = GrupoDAO.getAll();
        if(gru!=null){
            ret+="<grupos>";
            for(Grupo g : gru){
                ret+= "<grupo>"
                        + "<id>"+g.getId()+"</id>"
                        + "<nombre>"+g.getNombre()+"</nombre>"
                        + "<salon>"+g.getId_salon()+"</salon>"
                        + "</grupo>";
            }
            ret+="</grupos>";
        }
        else
            ret +=  "<error>"+GrupoDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "grupo_get")
    public String grupo_get(@WebParam(name = "id") int id) {
        String ret = "";
        Grupo gru[] = GrupoDAO.get(id);
        if(gru!=null){
            ret+="<grupos>";
            if(gru.length > 0){
                Grupo g = gru[0];
                ret+= "<grupo>"
                        + "<id>"+g.getId()+"</id>"
                        + "<nombre>"+g.getNombre()+"</nombre>"
                        + "<salon>"+g.getId_salon()+"</salon>"
                        + "</grupo>";
            }
            ret+="</grupos>";
        }
        else
            ret +=  "<error>"+GrupoDAO.getMessage()+"</error>";
        return ret;
    }

    /****************************
     **  OPERACIONES CLASE  **
     * *************************/
    @WebMethod(operationName = "clase_insert")
    public String clase_insert(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "id_grupo") int id_grupo) {
        Clase c = new Clase(id, nombre, id_grupo);
        String ret = "";
        if(ClaseDAO.insert(c))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+ClaseDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "clase_delete")
    public String clase_delete(@WebParam(name = "id") int id) {
        String ret = "";
        if(ClaseDAO.delete(id))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+ClaseDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "clase_update")
    public String clase_update(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "id_grupo") int id_grupo) {
        Clase c = new Clase(id, nombre, id_grupo);
        String ret = "";
        if(ClaseDAO.update(id, c))
            ret += "<mensaje>Success</mensaje>";
        else
            ret +=  "<error>"+ClaseDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "clase_getAll")
    public String clase_getAll() {
        String ret = "";
        Clase cla[] = ClaseDAO.getAll();
        if(cla!=null){
            ret+="<clases>";
            for(Clase c : cla){
                ret+= "<clase>"
                        + "<id>"+c.getId()+"</id>"
                        + "<nombre>"+c.getNombre()+"</nombre>"
                        + "<grupo>"+c.getId_grupo()+"</grupo>"
                        + "</clase>";
            }
            ret+="</clases>";
        }
        else
            ret +=  "<error>"+ClaseDAO.getMessage()+"</error>";
        return ret;
    }

    @WebMethod(operationName = "clase_get")
    public String clase_get(@WebParam(name = "id") int id) {
        String ret = "";
        Clase cla[] = ClaseDAO.get(id);
        if(cla!=null){
            ret+="<clases>";
            if(cla.length > 0){
                Clase c = cla[0];
                ret+= "<clase>"
                        + "<id>"+c.getId()+"</id>"
                        + "<nombre>"+c.getNombre()+"</nombre>"
                        + "<grupo>"+c.getId_grupo()+"</grupo>"
                        + "</clase>";
            }
            ret+="</clases>";
        }
        else
            ret +=  "<error>"+ClaseDAO.getMessage()+"</error>";
        return ret;
    }
}
