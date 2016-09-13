/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peter.j.cadastrousuario.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import peter.j.cadastrousuario.model.domain.Marca;
import peter.j.cadastrousuario.services.Conexao;

/**
 *
 * @author Peterson
 */
public class MarcaDao {
    
    private  Connection conn;

     public MarcaDao() {
        try {
            
      this.conn = Conexao.getInstance();
        } catch  (Exception e) {
          throw new RuntimeException(e);
       }
    
    }
     
     
     public boolean  salvar(Marca obj) {
        Integer codigo = obj.getCodigo();
        String nome = obj.getNome();
        
        
        StringBuilder sql = new StringBuilder();
        if (codigo==null) {
          /// insert  
          sql.append("insert into marca");
          sql.append(" (codigo, nome) ");
          sql.append(" values (  (select coalesce(max(x.codigo),?)+1 as ID " );
          sql.append(" from marca x) ,? ) ");
      
         try {
              PreparedStatement stm = this.conn.prepareStatement(sql.toString());
              stm.setInt(1, 0);
              stm.setString(2, nome);
              stm.execute();
              return true;
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
          
        }else {
          /// update  
          sql.append("update marca set");
          sql.append(" nome = ? ");
          sql.append(" where codigo = ?");
            
          try {
              PreparedStatement stm = this.conn.prepareStatement(sql.toString());
              stm.setInt(2, codigo);
              stm.setString(1, nome);
              stm.execute();
              return true;
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
          
        }
        
    }
    
    public boolean excluir(Marca obj) {
        Integer codigo = obj.getCodigo();
        StringBuilder sql = new StringBuilder();
        sql.append("delete from marca where codigo = ?");
        try {
            PreparedStatement stm = this.conn.prepareStatement(sql.toString());
            stm.setInt(1, codigo);
            stm.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Marca> listar() {
        List<Marca> lst = new ArrayList<Marca>();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from marca order by codigo");
         try {
            PreparedStatement stm = this.conn.prepareStatement(sql.toString());
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Marca m = new Marca();
                m.setCodigo(rs.getInt("codigo"));
                m.setNome(rs.getString("nome"));
                lst.add(m);
                
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lst;
    }
}

    

