package DAO;

import Bean.Contato;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.ListDataModel;


public class ContatoDAO {
        private Conexao Con;
    public ListDataModel listaContatos;

public ContatoDAO(){
    Con = new Conexao();
}

 public boolean salvarContato(Contato contato){
     try{
     String sql = "INSERT INTO CONTATO(NOME, ENDERECO, CIDADE, UF, TELEFONE, CELULAR, EMAIL)"
             + "VALUES(?,?,?,?,?,?,?);";
     
     PreparedStatement stmt = Con.getConnection().prepareStatement(sql);
     stmt.setString(1, contato.getNome());
     stmt.setString(2, contato.getEndereco());
     stmt.setString(3, contato.getCidade());
     stmt.setString(4, contato.getUf());
     stmt.setString(5, contato.getTelefone());
     stmt.setString(6, contato.getCelular());
     stmt.setString(7, contato.getEmail());
     
     stmt.execute();
     Con.getConnection().commit();
     
     return true;
     
     }catch(SQLException e){
       Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, e);
     
     }
   
     return false;
 }
 

    public boolean editarContato(Contato contato){
     try{
         
     String sql = "UPDATE CONTATO SET NOME = ?, ENDERECO = ?, CIDADE = ?, UF = ?, TELEFONE = ? ="
             + "CELULAR = ?, EMAIL = ? WHERE ID = ?:";
     
     PreparedStatement stmt = Con.getConnection().prepareStatement(sql);
     stmt.setString(1, contato.getNome());
     stmt.setString(2, contato.getEndereco());
     stmt.setString(3, contato.getCidade());
     stmt.setString(4, contato.getUf());
     stmt.setString(5, contato.getTelefone());
     stmt.setString(6, contato.getCelular());
     stmt.setString(7, contato.getEmail());
     stmt.setInt(8, contato.getId());
     
     stmt.execute();
     Con.getConnection().commit();
     
     return true;
     
     }catch(SQLException e){
       Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, e);
     
     } 

     return false;
     
    }
    
     public boolean excluirContato(Contato contato){
     try{
     String sql = "DELETE FROM CONTATO WHERE ID = ?;";
     
     PreparedStatement stmt = Con.getConnection().prepareStatement(sql);
     stmt.setInt(1, contato.getId());
     
     stmt.execute();
     Con.getConnection().commit();
     
     return true;
     
     }catch(SQLException e){
       Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, e);
     
     }
   return false;
  }
        public List<Contato> listarContato(){
            List<Contato> lista = new ArrayList<Contato>();
     try{
     String sql = "SELECT * FROM CONTATO;";
     
     PreparedStatement stmt = Con.getConnection().prepareStatement(sql);
     ResultSet rs = stmt.executeQuery();
     while(rs.next()){
         Contato contato = new Contato();
         contato.setId(rs.getInt("ID"));
         contato.setNome(rs.getString("NOME"));
         contato.setEndereco(rs.getString("ENDERECO"));
         contato.setCidade(rs.getString("CIDADE"));
         contato.setUf(rs.getString("UF"));
         contato.setTelefone(rs.getString("TELEFONE"));
         contato.setCelular(rs.getString("CELULAR"));
         contato.setEmail(rs.getString("EMAIL"));
          lista.add(contato);
       }
     
     }catch(SQLException e){
       Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, e);
     
     }
   return lista;
  }
}

