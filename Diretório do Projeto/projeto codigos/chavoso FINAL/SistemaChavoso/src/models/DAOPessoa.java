/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Ententys.Pessoa;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author elias
 */
public class DAOPessoa {
     Connection conexao;

    public DAOPessoa(Connection conexao) {
        this.conexao = conexao;
    }
    
    public boolean VerificarAss(String senha){
     PreparedStatement stmt = null;
     
     ResultSet rs = null;
     
     boolean check = false;
     
    
        try {
            stmt = this.conexao.prepareStatement("SELECT * FROM pessoa WHERE senha = ?");
        
            stmt.setString(1,senha);
            
            rs = stmt.executeQuery();

            if(rs.next()) {
                check = true;
            }
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
          
        return check;
      }
    
    public int getIdPessoaSenha(String senha){
     PreparedStatement stmt = null;
     
     ResultSet rs = null;
     
     int id = 0;
     
    
        try {
            stmt = this.conexao.prepareStatement("SELECT id_pessoa as ident FROM pessoa WHERE senha in (?) LIMIT 1");
        
            stmt.setString(1,senha);
            
            rs = stmt.executeQuery();

            if(rs.next()) {
                id = rs.getInt("ident");
            }
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
          
        return id;
    }
    
    public boolean logar(String cpf, String senha){
        PreparedStatement stmt = null;
     
     ResultSet rs = null;
     
     boolean check = false;
     
    
        try {
            stmt = this.conexao.prepareStatement("SELECT 0 FROM `pessoa` WHERE `cpf` in (?) and `senha` in (?) and `id_pessoa` in ( SELECT `id_pessoa` FROM `adiministrador`)");
            //System.out.println("Antes: "+stmt.toString());
            stmt.setString(1,cpf);
            stmt.setString(2, senha);
            //System.out.println("Depois: "+stmt.toString());
            rs = stmt.executeQuery();

            if(rs.next()) {
                check = true;
            }
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
          
        return check;
    }
    
    public boolean VerificaCpf(String cpf){
     PreparedStatement stmt;
     boolean check = false;

        try {
            stmt = this.conexao.prepareStatement("SELECT * FROM pessoa WHERE cpf = ?");
        
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                check = true;
            }
            } catch (SQLException ex) {
        }
          
        return check;
}
    
    public void create(Pessoa p){

        PreparedStatement stmt = null;
        
        try {
            stmt = this.conexao.prepareStatement("INSERT INTO pessoa (nome,senha,cpf) VALUES (?,?,?)");
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getSenha());
            stmt.setString(3,p.getCpf());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo Com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO ao Salvar!! "+ex);
        }
        
    }
    
    public int PegarId(String senha){
     PreparedStatement stmt;
     int id = 0;

        try {
            stmt = this.conexao.prepareStatement("SELECT * FROM pessoa WHERE senha = ?");
        
            stmt.setString(1, senha);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                id = rs.getInt("id_pessoa");
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return id;
}
    
    public void Professor(int iddep , int idpessoa){
        
        PreparedStatement stmt = null;
        
        try {
            stmt = this.conexao.prepareStatement("INSERT INTO professor (id_departamento,id_pessoa) VALUES (?,?)");
            stmt.setInt(1,iddep);
            stmt.setInt(2,idpessoa);          
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO ao Salvar!! "+ex);
        }
        
    }
    public void Limpeza(int idpessoa){
        

        PreparedStatement stmt = null;
        
        try {
            stmt = this.conexao.prepareStatement("INSERT INTO auxiliar_limpeza (id_pessoa) VALUES (?)");
            stmt.setInt(1,idpessoa);          
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO ao Salvar!! "+ex);
        }
        
    }
    
    public void Administrador(int idpessoa){
              
        PreparedStatement stmt = null;
        
        try {
            stmt = this.conexao.prepareStatement("INSERT INTO adiministrador (id_pessoa) VALUES (?)");
            stmt.setInt(1,idpessoa);          
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO ao Salvar!! "+ex);
        }
        
    }
          
    public List<Pessoa> buscaPessoa(String cpf){
     PreparedStatement stmt;
     
     List<Pessoa> ps  = new ArrayList<>();
    
     
        try {
            stmt = this.conexao.prepareStatement("SELECT * FROM pessoa WHERE cpf LIKE ?");
        
            stmt.setString(1,cpf);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                
                Pessoa p = new Pessoa();
                p.setNome(rs.getString("nome"));
                p.setSenha(rs.getString("senha"));
                p.setCpf(rs.getString("cpf"));
                ps.add(p);
            }
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO ao Buscar!! "+ex);
            }
          
        return ps;
}
        public void alterarPessoa(Pessoa p, String cpf){

        PreparedStatement stmt = null;
        
        try {
            stmt = this.conexao.prepareStatement("update pessoa set nome=?,senha=?,cpf=? where cpf = ?");
            stmt.setString(1,p.getNome());
            stmt.setString(2,p.getSenha());
            stmt.setString(3,p.getCpf());
            stmt.setString(4,cpf);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado Com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO ao Salvar!! "+ex);
        }
        
    }
        
     public boolean VerificaAssinatura(String senha){
     PreparedStatement stmt;
     Connection con = ConnectionFactory.getConnection();
     boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM pessoa WHERE senha = ?");
        
            stmt.setString(1, senha);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                check = true;
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return check;
}
     
     public boolean VerificaPessoaLimpeza(int idpessoa){
     PreparedStatement stmt;
     Connection con = ConnectionFactory.getConnection();
     boolean check = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM auxiliar_limpeza WHERE id_pessoa = ? limit 1");
        
            stmt.setInt(1, idpessoa);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                check = true;
            }
            
            } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return check;
}
     
     public boolean VerificaSenhaeditar(String senha , int idpessoa){
     PreparedStatement stmt;
     Connection con = ConnectionFactory.getConnection();
     boolean check = false;

        try {
            stmt = con.prepareStatement("select * from pessoa where senha = ? and id_pessoa != ?");
        
            stmt.setString(1, senha);
            stmt.setInt(2, idpessoa);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                check = true;
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return check;
}
     
     public boolean VerificaCPFeditar(String cpf , int idpessoa){
     PreparedStatement stmt;
     Connection con = ConnectionFactory.getConnection();
     boolean check = false;

        try {
            stmt = con.prepareStatement("select * from pessoa where cpf = ? and id_pessoa != ?");
        
            stmt.setString(1, cpf);
            stmt.setInt(2, idpessoa);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                check = true;
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return check;
}
     
     public int PegarIdByCPF(String cpf){
     PreparedStatement stmt;
     int id = 0;

        try {
            stmt = this.conexao.prepareStatement("SELECT * FROM pessoa WHERE cpf = ?");
        
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                id = rs.getInt("id_pessoa");
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAOPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return id;
}
     
    public int getNumeroAdmin(){
         PreparedStatement stmt = null;
     
     ResultSet rs = null;
     
     int id = 0;
     
    
        try {
            stmt = this.conexao.prepareStatement("SELECT count(`id_adm`) as admins FROM `adiministrador`");
            
            rs = stmt.executeQuery();

            if(rs.next()) {
                id = rs.getInt("admins");
            }
            
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
          
        return id;
    }
     
}
