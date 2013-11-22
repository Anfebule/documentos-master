/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Usuario_reporta;
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
public class Usuario_reportaDAO implements DAOInterface<Usuario_reporta>{

    @Override
    public boolean save(Usuario_reporta entity) {
        String sql="";
         boolean exito;
      
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement;
            if(this.findById(entity.getDocumento_usuario_reporta())==null) 
            {    
             statement = c.prepareStatement("insert into usuario_reporta values(?,?,?,?,?,?,?)");
            
                statement.setString(1, entity.getDocumento_usuario_reporta());
                statement.setString(2, entity.getNombres());
                statement.setString(3, entity.getApellido1());
                statement.setString(4, entity.getApellido2());
                statement.setString(5, entity.getDireccion());
                statement.setString(6, entity.getTelefono());
                statement.setString(7, entity.getCorreo());
                
            }
            else
            {
                 statement=
                    c.prepareStatement("update usuario_reporta set documento_usuario_reporta=?, nombres=?, apellido1=?, apellido2=?, direccion=?, telefono=?, correo=? where documento_usuario_reporta=?");
                statement.setString(1, entity.getDocumento_usuario_reporta());
                statement.setString(2, entity.getNombres());
                statement.setString(3, entity.getApellido1());
                statement.setString(4, entity.getApellido2());
                statement.setString(5, entity.getDireccion());
                statement.setString(6, entity.getTelefono());
                statement.setString(7, entity.getCorreo());
                statement.setString(8, entity.getDocumento_usuario_reporta());
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
    public boolean delete(Usuario_reporta entity) {
        boolean exito;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from usuario_reporta where documento_usuario_reporta=?");
            
            statement.setString(1, entity.getDocumento_usuario_reporta());
           
            
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
    public Usuario_reporta findById(Object id) {
        Usuario_reporta entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select * from usuario_reporta where documento_usuario_reporta=?"
                    );
            statement.setString(1, (String)id);
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
                entity = new Usuario_reporta();
                entity.setDocumento_usuario_reporta(results.getString(1));
                entity.setNombres(results.getString(2));
                entity.setApellido1(results.getString(3));
                entity.setApellido2(results.getString(4));
                entity.setDireccion(results.getString(5));
                entity.setTelefono(results.getString(6));
                entity.setCorreo(results.getString(7));
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
    public ArrayList<Usuario_reporta> findAll() {
        ArrayList<Usuario_reporta> entities = new ArrayList<>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select * from usuario_reporta"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                Usuario_reporta entity = new Usuario_reporta();
                entity.setDocumento_usuario_reporta(results.getString(1));
                entity.setNombres(results.getString(2));
                entity.setApellido1(results.getString(3));
                entity.setApellido2(results.getString(4));
                entity.setDireccion(results.getString(5));
                entity.setTelefono(results.getString(6));
                entity.setCorreo(results.getString(7));
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
