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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Ententys.Chave;
import Ententys.Departamento;
import Ententys.Laboratorio;
import connection.ConnectionFactory;

/**
 *
 * @author David Alysson
 */
public class DAOLaboratorio {
    
    Connection conexao;

    public DAOLaboratorio(Connection con) {
        this.conexao = con;
    }
    
    public List<Laboratorio> buscaLabDeDep(int iddep){
     PreparedStatement stmt;    
     List<Laboratorio> laboratorios  = new ArrayList<>();
     
        try {
            stmt = this.conexao.prepareStatement("select * from laboratorio join departamento on departamento.id_departamento = laboratorio.id_departamento join chave on chave.numero = laboratorio.numero_chave where departamento.id_departamento = ? order by laboratorio.numero desc");
            stmt.setInt(1,iddep);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                
                Laboratorio laboratorio = new Laboratorio();
                Chave chave = new Chave();
                Departamento dep = new Departamento();
                
                chave.setNumero(rs.getInt("chave.numero")); 
                
                dep.setNome(rs.getString("departamento.nome"));
   
                laboratorio.setNumero(rs.getInt("laboratorio.numero"));
                laboratorio.setDisponibilidade(rs.getString("disponibilidade"));
                laboratorio.setAcao(rs.getString("acao"));
                laboratorio.setChave(chave);
                laboratorio.setDepartamento(dep);
                laboratorios.add(laboratorio);
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAOLaboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return laboratorios;
}
        
    
    public List<Laboratorio> read() {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Laboratorio> laboratorios = new ArrayList<>();

        try {
            stmt = this.conexao.prepareStatement("select * from laboratorio join departamento on departamento.id_departamento = laboratorio.id_departamento where departamento.sigla = ?");
          
            while (rs.next()) {

                Laboratorio laboratorio = new Laboratorio();

                laboratorio.setNumero(rs.getInt("numero"));
                laboratorios.add(laboratorio);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return laboratorios;

    }
    
    public String Disponibiblidade(int iddep , int num) {
        
        PreparedStatement stmt = null;

        String disp = null;
    

        try {
           stmt = this.conexao.prepareStatement("select disponibilidade from laboratorio where id_departamento = ? and numero = ?");
           stmt.setInt(1,iddep);
           stmt.setInt(2,num);
           ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

               disp = rs.getString("disponibilidade");
                  
 
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return disp;

    }
    
     public String LabAcao(int iddep , int num) {
        
        PreparedStatement stmt = null;

        String acao = null;
    

        try {
           stmt = this.conexao.prepareStatement("select acao from laboratorio where id_departamento = ? and numero = ?");
           stmt.setInt(1,iddep);
           stmt.setInt(2,num);
           ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

               acao = rs.getString("acao");
                  
 
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return acao;

    }
    
    public int PegarId(int num, int iddep){
     PreparedStatement stmt;
     int id = 0;
     
        try {
            stmt = this.conexao.prepareStatement("SELECT * FROM laboratorio WHERE numero LIKE ? and id_departamento = ?");
        
            stmt.setInt(1,num);
            stmt.setInt(2,iddep);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                id = rs.getInt("id_laboratorio");
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return id;
    }
    
    public int PegarIdChave(int num , int iddep){
     PreparedStatement stmt;
     int id = 0;
     
        try {
            stmt = this.conexao.prepareStatement("SELECT numero_chave FROM laboratorio WHERE numero = ? and id_departamento = ?");
        
            stmt.setInt(1,num);
            stmt.setInt(2,iddep);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                id = rs.getInt("numero_chave");
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return id;
    }
    
    public void AlterarDisp(String estado, int iddep , int num , String acao){
      
        PreparedStatement stmt = null;
        
        try {
            stmt = this.conexao.prepareStatement("update laboratorio set disponibilidade = ?, acao = ? where id_departamento = ? and numero = ?");
            stmt.setString(1,estado);
            stmt.setString(2,acao);
            stmt.setInt(3,iddep);
            stmt.setInt(4,num);
            
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO ao Salvar!! " +ex);
        }
        
    }
     
    public void create(int num , int iddep){
        PreparedStatement stmt = null;
        if(this.PegarId(num, iddep) > 0){
            JOptionPane.showMessageDialog(null,"Esse laboratorio ja existe!");
        }else{
            try {
                
                stmt = this.conexao.prepareStatement("SELECT IFNULL(`numero`, 0)+1 AS numero FROM  chave order by `numero` desc LIMIT 1");
                ResultSet rs = stmt.executeQuery();
                int chave_numero = 0;
                while(rs.next()) {
                    chave_numero = rs.getInt("numero");
                }
                
                int idlab = this.PegarId(num,iddep);
                stmt = this.conexao.prepareStatement("INSERT INTO `chave`(`numero`) VALUES (?)");
                stmt.setInt(1,chave_numero);
            
                stmt.executeUpdate();
                
                stmt = this.conexao.prepareStatement("INSERT INTO laboratorio (numero,id_departamento,disponibilidade,numero_chave,acao) VALUES (?,?,?,?,?)");
                stmt.setInt(1,num);
                stmt.setInt(2,iddep);
                stmt.setString(3,"disponivel");
                stmt.setInt(4,chave_numero);
                stmt.setString(5,"Chave com o Administrador");
            
                stmt.executeUpdate();
                
            
                JOptionPane.showMessageDialog(null,"Salvo Com Sucesso!!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"ERRO ao Salvar!! "+ex);
            }
        }
        
        
    } 
    
    public void alterarLaboratorio(Laboratorio lab , int idlab){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("update laboratorio set numero = ? , id_departamento = ? where id_laboratorio = ?");
            stmt.setInt(1,lab.getNumero());
            stmt.setInt(2,lab.getId_departamento());
            stmt.setInt(3,idlab);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado Com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO ao Salvar!! "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    
        
}
