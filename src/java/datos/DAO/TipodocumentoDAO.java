/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Tipodocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 201
 */
public class TipodocumentoDAO implements DAOInterface <Tipodocumento>{

    @Override
    public boolean save(Tipodocumento entity) {
        String sql="";
         boolean exito;
      
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=null;
            if(this.findById(entity.getIdtipo())==null) 
            {    
                statement=
                    c.prepareStatement("insert into tipo_documento values(?,?,?)");
            
                statement.setInt(1, entity.getIdtipo());
                statement.setString(2, entity.getNombre());
                statement.setString(3, entity.getDescripcion());
            }
            else
            {
                statement=
                    c.prepareStatement("update  tipo_documento set id_tipo=?, nombre=?,descripcion=? where id_tipo=?");
                statement.setInt(1, entity.getIdtipo());
                statement.setString(2, entity.getNombre());
                statement.setString(3, entity.getDescripcion());
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
    public boolean delete(Tipodocumento entity) {
        boolean exito;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from tipo_documento where numero_documento=?");
            
            statement.setInt(1, entity.getIdtipo());
           
            
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
    public Tipodocumento findById(Object id) {
        Tipodocumento entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select id_tipo, nombre, descripcion from tipo_documento where id_tipo=?"
                    );
            statement.setString(1, (String)id);
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
                 entity = new Tipodocumento();
                 entity.setIdtipo(results.getInt(1));
                 entity.setNombre(results.getString(2));
                 entity.setDescripcion(results.getString(3));
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
    public ArrayList<Tipodocumento> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
