/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos.entidades;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author AFBL
 */
public class Denuncia {
    private int id_denuncia;
    private Date fecha_denuncia;
    private Date fecha_perdida;
    private Time hora_perdida;

    public int getId_denuncia() {
        return id_denuncia;
    }

    public void setId_denuncia(int id_denuncia) {
        this.id_denuncia = id_denuncia;
    }

    public Date getFecha_denuncia() {
        return fecha_denuncia;
    }

    public void setFecha_denuncia(Date fecha_denuncia) {
        this.fecha_denuncia = fecha_denuncia;
    }

    public Date getFecha_perdida() {
        return fecha_perdida;
    }

    public void setFecha_perdida(Date fecha_perdida) {
        this.fecha_perdida = fecha_perdida;
    }

    public Time getHora_perdida() {
        return hora_perdida;
    }

    public void setHora_perdida(Time hora_perdida) {
        this.hora_perdida = hora_perdida;
    }
    
}
