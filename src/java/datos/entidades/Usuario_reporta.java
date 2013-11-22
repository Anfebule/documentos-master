/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos.entidades;

/**
 *
 * @author AFBL
 */
public class Usuario_reporta {
    private String documento_usuario_reporta;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String telefono;
    private String correo;

    public String getDocumento_usuario_reporta() {
        return documento_usuario_reporta;
    }

    public void setDocumento_usuario_reporta(String documento_usuario_reporta) {
        this.documento_usuario_reporta = documento_usuario_reporta;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
