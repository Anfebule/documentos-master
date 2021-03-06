/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Administrador;
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
public class AdministradorDAO implements DAOInterface<Administrador>{

    @Override
    public boolean save(Administrador entity) {
        
        String sql="";
         boolean exito;
      
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement;
            if(this.findById(entity.getNumero_documento())==null) 
            {    
             statement = c.prepareStatement("insert into administrador values(?,?,?,?,?,?)");
            
                statement.setString(1, entity.getLogin());
                statement.setString(2, entity.getClave());
                statement.setString(3, entity.getNumero_documento());
                statement.setString(4, entity.getNombres());
                statement.setString(5, entity.getApellido1());
                statement.setString(6, entity.getApellido2());
            }
            else
            {
                 statement=
                    c.prepareStatement("update  administrador set login=?. clave=?, numero_documento=?, nombres=?, apellido1=?, apellido2=? where numero_documento=?");
                statement.setString(1, entity.getLogin());
                statement.setString(2, entity.getClave());
                statement.setString(3, entity.getNumero_documento());
                statement.setString(4, entity.getNombres());
                statement.setString(5, entity.getApellido1());
                statement.setString(6, entity.getApellido2());
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
    public boolean delete(Administrador entity) {
        boolean exito;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from administrador where numero_documento=?");
            
            statement.setString(1, entity.getNumero_documento());
           
            
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
    public Administrador findById(Object id) {
        Administrador entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select * from administrador where numero_documento=?"
                    );
            statement.setString(1, (String)id);
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
                entity = new Administrador();
                entity.setLogin(results.getString(1));
                entity.setClave(results.getString(2));
                entity.setNumero_documento(results.getString(3));
                entity.setNombres(results.getString(4));
                entity.setApellido1(results.getString(5));
                entity.setApellido2(results.getString(6));
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
    public ArrayList<Administrador> findAll() {
        ArrayList<Administrador> entities = new ArrayList<>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select * from administrador"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                Administrador entity = new Administrador();
                entity.setLogin(results.getString(1));
                entity.setClave(results.getString(2));
                entity.setNumero_documento(results.getString(3));
                entity.setNombres(results.getString(4));
                entity.setApellido1(results.getString(5));
                entity.setApellido2(results.getString(6));
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
