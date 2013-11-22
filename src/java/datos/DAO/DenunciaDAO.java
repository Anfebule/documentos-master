/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datos.DAO;

import datos.configuracion.Conexion;
import datos.entidades.Denuncia;
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
public class DenunciaDAO implements DAOInterface<Denuncia> {

    @Override
    public boolean save(Denuncia entity) {
        String sql="";
         boolean exito;
      
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement;
            if(this.findById(entity.getId_denuncia())==null) 
            {    
             statement = c.prepareStatement("insert into id_denuncia values(?,?,?,?)");
            
                statement.setInt(1, entity.getId_denuncia());
                statement.setDate(2, entity.getFecha_denuncia());
                statement.setDate(3, entity.getFecha_perdida());
                statement.setTime(4, entity.getHora_perdida());
            }
            else
            {
                 statement=
                    c.prepareStatement("update  denuncia set id_denuncia=?, fecha_denuncia=?, fecha_perdida=?, hora_perdida=? where id_denuncia=?");
                statement.setInt(1, entity.getId_denuncia());
                statement.setDate(2, entity.getFecha_denuncia());
                statement.setDate(3, entity.getFecha_perdida());
                statement.setTime(4, entity.getHora_perdida());
                statement.setInt(5, entity.getId_denuncia());
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
    public boolean delete(Denuncia entity) {
        boolean exito;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement("delete from denuncia where id_denuncia=?");
            
            statement.setInt(1, entity.getId_denuncia());
           
            
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
    public Denuncia findById(Object id) {
        Denuncia entity=null;
        try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select * from denuncia where id_denuncia=?"
                    );
            statement.setInt(1, (Integer)id);
            
            ResultSet results =   statement.executeQuery();
            if(results.next())
            {
                entity = new Denuncia();
                entity.setId_denuncia(results.getInt(1));
                entity.setFecha_denuncia(results.getDate(2));
                entity.setFecha_perdida(results.getDate(3));
                entity.setHora_perdida(results.getTime(4));
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
    public ArrayList<Denuncia> findAll() {
        ArrayList<Denuncia> entities = new ArrayList<>();
        
            try {
            Connection c = Conexion.getConexion();
            PreparedStatement statement=
                    c.prepareStatement(
                    "select * from denuncia"
                    );
            
            
            ResultSet results =   statement.executeQuery();
            while(results.next())
            {
                Denuncia entity = new Denuncia();
                entity.setId_denuncia(results.getInt(1));
                entity.setFecha_denuncia(results.getDate(2));
                entity.setFecha_perdida(results.getDate(3));
                entity.setHora_perdida(results.getTime(4));
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
