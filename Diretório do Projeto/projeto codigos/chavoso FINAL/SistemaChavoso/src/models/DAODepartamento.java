/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Ententys.Departamento;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author David Alysson
 */
public class DAODepartamento {
    
    Connection conexao;
    public DAODepartamento(Connection con){
        this.conexao = con;
    }
            
    public List<Departamento> read() {
        
        PreparedStatement stmt;
        ResultSet rs;

        List<Departamento> departamentos = new ArrayList<>();

        try {
            stmt = this.conexao.prepareStatement("SELECT * FROM departamento");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Departamento departamento = new Departamento();

                departamento.setSigla(rs.getString("sigla"));
                departamentos.add(departamento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return departamentos;

    }
    
    public int PegarId(Departamento sig){
     PreparedStatement stmt;
     int id = 0;

        try {
            stmt = this.conexao.prepareStatement("SELECT * FROM departamento WHERE sigla = ?");
        
            stmt.setString(1, sig.getSigla());
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                id = rs.getInt("id_departamento");
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return id;
}
    
    public int PegarId(String sig){
     PreparedStatement stmt;
     int id = 0;

        try {
            stmt = this.conexao.prepareStatement("SELECT * FROM departamento WHERE sigla = ?");
        
            stmt.setString(1, sig);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                id = rs.getInt("id_departamento");
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return id;
}
    
     public int PegarIdDep(String senha){
     PreparedStatement stmt;
     int id = 0;

        try {
            stmt = this.conexao.prepareStatement("Select id_departamento from departamento where id_departamento in (select id_departamento from professor where id_pessoa in (select id_pessoa from pessoa where senha = ?))");
        
            stmt.setString(1, senha);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                id = rs.getInt("id_departamento");
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return id;
}
     public void create(Departamento d){
        PreparedStatement stmt = null;
        
        try {
            stmt = this.conexao.prepareStatement("INSERT INTO departamento (nome,sigla) VALUES (?,?)");
            stmt.setString(1,d.getNome());
            stmt.setString(2,d.getSigla());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo Com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nome ou Sigla já existe!!", "AVISO", JOptionPane.ERROR_MESSAGE, null);;
        }
        
    }
     
    public List<Departamento> BuscarDep(int iddep) {

        PreparedStatement stmt = null;
        List<Departamento> departamentos = new ArrayList<>();

        try {
            stmt = this.conexao.prepareStatement("SELECT * FROM departamento where id_departamento like ?");
            stmt.setInt(1,iddep);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Departamento departamento = new Departamento();
                departamento.setNome(rs.getString("nome"));
                departamento.setSigla(rs.getString("sigla"));
                departamentos.add(departamento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return departamentos;

    }
    
    public void alterarDep(Departamento d, int iddep){
        PreparedStatement stmt = null;
        
        try {
            stmt = this.conexao.prepareStatement("update departamento set nome=?,sigla=? where id_departamento = ?");
            stmt.setString(1,d.getNome());
            stmt.setString(2,d.getSigla());
            stmt.setInt(3,iddep);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado Com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO ao Salvar!! "+ex);
        }
        
    }
    
}
