package mx.uv.db;

import javax.print.DocFlavor.STRING;

public class Asignacion {
    private int id;
    private int idUsuario;
    private int idCuestionario;
    private String nombre;
    private String estado;
    
    public Asignacion(int id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }
    public Asignacion(int id, int idUsuario, int idCuestionario) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idCuestionario = idCuestionario;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public int getIdCuestionario() {
        return idCuestionario;
    }
    public void setIdCuestionario(int idCuestionario) {
        this.idCuestionario = idCuestionario;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setId(int id) {
        this.id = id;
    }
}
