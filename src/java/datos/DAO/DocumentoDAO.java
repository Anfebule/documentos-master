/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Documento;
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
public class DocumentoDAO implements DAOInterface <Documento>{

    @Override
    public boolean save(Documento entity) {
        String sql="";
         boolean exito;
      
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement;
            if(this.findById(entity.getId_documento())==null) 
            {    
             statement = c.prepareStatement("insert into documento values(?,?,?,?,?,?,?,?)");
            
                statement.setInt(1, entity.getId_documento());
                statement.setString(2, entity.getNo_documento());
                statement.setInt(3, entity.getId_tipo_documento());
                statement.setInt(4, entity.getId_denuncia());
                statement.setString(5, entity.getDocumento_funcionario());
                statement.setString(6, entity.getDocumento_usuario_reporta());
                statement.setString(7, entity.getDocumento_usuario_denuncia());
                statement.setInt(8, entity.getId_estado());
                
            }
            else
            {
                 statement=
                    c.prepareStatement("update  documento set id_documento=?, no_documento=?, id_tipo_documento=?, id_denuncia=?, documento_funcionario=?, documento_usuario_reporta=?, documento_usuario_denuncia=?, d_estado=? "
                            + "where id_documento=?");
                statement.setInt(1, entity.getId_documento());
                statement.setString(2, entity.getNo_documento());
                statement.setInt(3, entity.getId_tipo_documento());
                statement.setInt(4, entity.getId_denuncia());
                statement.setString(5, entity.getDocumento_funcionario());
                statement.setString(6, entity.getDocumento_usuario_reporta());
                statement.setString(7, entity.getDocumento_usuario_denuncia());
                statement.setInt(8, entity.getId_estado());
            }    
            
            exito = statement.execute();
            
            //exito=true;
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
    public boolean delete(Documento entity) {
        boolean exito;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from documento where id_documento=?");
            
            statement.setInt(1, entity.getId_documento());
           
            
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
    public Documento findById(Object id) {
        Documento entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select * from documento where id_documento=?"
                    );
            statement.setString(1, (String)id);
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
                entity = new Documento();
                entity.setId_documento(results.getInt(1));
                entity.setNo_documento(results.getString(2));
                entity.setId_tipo_documento(results.getInt(3));
                entity.setId_denuncia(results.getInt(4));
                entity.setDocumento_funcionario(results.getString(5));
                entity.setDocumento_usuario_reporta(results.getString(6));
                entity.setDocumento_usuario_denuncia(results.getString(7));
                entity.setId_estado(results.getInt(8));
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
    public ArrayList<Documento> findAll() {
        ArrayList<Documento> entities = new ArrayList<>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select * from documento"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                Documento entity = new Documento();
                entity.setId_documento(results.getInt(1));
                entity.setNo_documento(results.getString(2));
                entity.setId_tipo_documento(results.getInt(3));
                entity.setId_denuncia(results.getInt(4));
                entity.setDocumento_funcionario(results.getString(5));
                entity.setDocumento_usuario_reporta(results.getString(6));
                entity.setDocumento_usuario_denuncia(results.getString(7));
                entity.setId_estado(results.getInt(8));
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
