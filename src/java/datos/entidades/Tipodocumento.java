/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.entidades;

/**
 *
 * @author 201
 */
public class Tipodocumento {
    private int idtipo;
    private String Nombre;
    private String Descripcion;

    public Tipodocumento(int idtipo, String Nombre, String Descripcion) {
        this.idtipo = idtipo;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "Tipodocumento{" + "idtipo=" + idtipo + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + '}';
    }

    public Tipodocumento() {
    }
    
    
}
