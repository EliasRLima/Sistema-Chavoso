/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Ententys.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elias
 */
public class DAOHeader {
     Connection conexao;
    public DAOHeader(Connection con){
        this.conexao = con;
    }
            
    public int getHeader(String data) {
        
        PreparedStatement stmt;
        ResultSet rs;

        int id = 0;

        try {
            stmt = this.conexao.prepareStatement("SELECT `id_header` as id FROM `header` WHERE `data` in (?)");
            stmt.setString(1, data);
            rs = stmt.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }
    
    public int insertHeader(int idacao, String data) {
        
        PreparedStatement stmt;
        ResultSet rs;

        int id = 0;

        try {
            stmt = this.conexao.prepareStatement("INSERT INTO `header`( `data`, `id_acao`) VALUES (?, ?)");
            stmt.setString(1, data);
            stmt.setInt(2, idacao);
            id = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }
    
    public String getDataAtual(){
        PreparedStatement stmt;
        ResultSet rs;

        String id = "";

        try {
            stmt = this.conexao.prepareStatement("SELECT convert((select NOW()),char(30)) as data");
            rs = stmt.executeQuery();

            while (rs.next()) {
                id = rs.getString("data");
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }
}
