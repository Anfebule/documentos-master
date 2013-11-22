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
public class Documento {
    private int id_documento;
    private String no_documento;
    private int id_tipo_documento;
    private int id_denuncia;
    private String documento_funcionario;
    private String documento_usuario_reporta;
    private String documento_usuario_denuncia;
    private int id_estado;

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getNo_documento() {
        return no_documento;
    }

    public void setNo_documento(String no_documento) {
        this.no_documento = no_documento;
    }

    public int getId_tipo_documento() {
        return id_tipo_documento;
    }

    public void setId_tipo_documento(int id_tipo_documento) {
        this.id_tipo_documento = id_tipo_documento;
    }

    public int getId_denuncia() {
        return id_denuncia;
    }

    public void setId_denuncia(int id_denuncia) {
        this.id_denuncia = id_denuncia;
    }

    public String getDocumento_funcionario() {
        return documento_funcionario;
    }

    public void setDocumento_funcionario(String documento_funcionario) {
        this.documento_funcionario = documento_funcionario;
    }

    public String getDocumento_usuario_reporta() {
        return documento_usuario_reporta;
    }

    public void setDocumento_usuario_reporta(String documento_usuario_reporta) {
        this.documento_usuario_reporta = documento_usuario_reporta;
    }

    public String getDocumento_usuario_denuncia() {
        return documento_usuario_denuncia;
    }

    public void setDocumento_usuario_denuncia(String documento_usuario_denuncia) {
        this.documento_usuario_denuncia = documento_usuario_denuncia;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
    
}
