/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Usuario_denuncia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AFBL
 */
public class Usuario_denunciaDAO implements DAOInterface<Usuario_denuncia>{

    @Override
    public boolean save(Usuario_denuncia entity) {
        
        String sql="";
         boolean exito;
      
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement;
            if(this.findById(entity.getDocumento_usuario_denuncia())==null) 
            {    
             statement = c.prepareStatement("insert into usuario_denuncia values(?,?,?,?,?,?,?,?)");
            
                statement.setString(1, entity.getDocumento_usuario_denuncia());
                statement.setString(2, entity.getNombres());
                statement.setString(3, entity.getApellido1());
                statement.setString(4, entity.getApellido2());
                statement.setDate(5, entity.getFecha_nacimiento());
                statement.setString(6, entity.getDireccion());
                statement.setString(7, entity.getTelefono());
                statement.setString(8, entity.getCorreo());
                
            }
            else
            {
                 statement=
                    c.prepareStatement("update  usuario_denuncia set documento_usuario_denuncia=?, nombres=?, apellido1=?, apellido2=?, fecha_nacimiento=?, direccion=?, telefono=?, correo=? where documento_usuario_denuncia=?");
                statement.setString(1, entity.getDocumento_usuario_denuncia());
                statement.setString(2, entity.getNombres());
                statement.setString(3, entity.getApellido1());
                statement.setString(4, entity.getApellido2());
                statement.setDate(5, entity.getFecha_nacimiento());
                statement.setString(6, entity.getDireccion());
                statement.setString(7, entity.getTelefono());
                statement.setString(8, entity.getCorreo());
                statement.setString(9, entity.getDocumento_usuario_denuncia());
            }    
            
            statement.execute();
            
            exito=true;
            c.close();
            
            } catch (SQLException ex) {
                Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
                exito=false;
            }
        
        
        return exito;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Usuario_denuncia entity) {
        boolean exito;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from usuario_denuncia where documento_usuario_denuncia=?");
            
            statement.setString(1, entity.getDocumento_usuario_denuncia());
           
            
            statement.execute();
            exito = true;
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return false;
        }
        return exito;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario_denuncia findById(Object id) {
        Usuario_denuncia entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select * from usuario_denuncia where documento_usuario_denuncia=?");
            statement.setString(1, (String)id);
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
                entity = new Usuario_denuncia();
                entity.setDocumento_usuario_denuncia(results.getString(1));
                entity.setNombres(results.getString(2));
                entity.setApellido1(results.getString(3));
                entity.setApellido2(results.getString(4));
                entity.setFecha_nacimiento(results.getDate(5));
                entity.setDireccion(results.getString(6));
                entity.setTelefono(results.getString(7));
                entity.setCorreo(results.getString(8));
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
            return null;
        }
        
        
        return entity;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario_denuncia> findAll() {
        ArrayList<Usuario_denuncia> entities = new ArrayList<>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select * from usuario_denuncia"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                Usuario_denuncia entity = new Usuario_denuncia();
                entity.setDocumento_usuario_denuncia(results.getString(1));
                entity.setNombres(results.getString(2));
                entity.setApellido1(results.getString(3));
                entity.setApellido2(results.getString(4));
                entity.setFecha_nacimiento(results.getDate(5));
                entity.setDireccion(results.getString(6));
                entity.setTelefono(results.getString(7));
                entity.setCorreo(results.getString(8));
                entities.add(entity);
            }    
            
            c.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
        
        
        return entities;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
