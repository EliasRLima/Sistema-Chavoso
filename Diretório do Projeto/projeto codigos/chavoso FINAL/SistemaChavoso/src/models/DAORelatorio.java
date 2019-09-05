/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Ententys.Acao;
import Ententys.Chave;
import Ententys.Departamento;
import Ententys.Header;
import Ententys.Relatorio;
import Ententys.Laboratorio;
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
public class DAORelatorio {
    Connection conexao;

    public DAORelatorio(Connection conexao) {
        this.conexao = conexao;
    }
    
    public int insertRelatorio(Relatorio relatorio) {
        
        PreparedStatement stmt;
        ResultSet rs;

        int id = 0;

        try {
            stmt = this.conexao.prepareStatement("INSERT INTO `relatorio`(`id_pessoa_autor`, `id_pessoa_admin`, `verificacao_senha`, `lab_disponibilidade`, `id_header` , `numero_chave`) VALUES (?,?,?,?,?,?)");
            stmt.setInt(1, relatorio.getId_pessoa_autor());
            stmt.setInt(2, relatorio.getId_pessoa_admin());
            stmt.setBoolean(3, relatorio.getVerificacao_senha());
            stmt.setString(4, relatorio.getLab_disponibilidade());
            stmt.setInt(5, relatorio.getId_header());
            stmt.setInt(6, relatorio.getId_chave());
            id = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAODepartamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;

    }
    
    public List<Relatorio> buscaRelatorio(int iddep){
     PreparedStatement stmt;    
     List<Relatorio> hst  = new ArrayList<>();
     
        try {
            stmt = this.conexao.prepareStatement("select id_relatorio, numero_chave, (select nome from pessoa where r.id_pessoa_autor = id_pessoa) as nome,(select nome from pessoa where r.id_pessoa_admin = id_pessoa) as nome_admin , r.verificacao_senha, r.lab_disponibilidade, (select data from header where id_header = r.id_header) as data,(select nome from acoes where id_acao = h.id_acao) as acao from relatorio r join header h on r.id_header = h.id_header where r.numero_chave in (select numero_chave from laboratorio where id_departamento = ? )order by r.id_header desc");
            stmt.setInt(1,iddep);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                
                Relatorio historico = new Relatorio();
                Header h = new Header();
                Acao a = new Acao();
                
                historico.setId_chave(rs.getInt("numero_chave"));
                historico.setPessoa_autor(rs.getString("nome"));
                historico.setPessoa_admin(rs.getString("nome_admin"));
                historico.setVerificacao(rs.getInt("r.verificacao_senha"));
                historico.setLab_disponibilidade(rs.getString("r.lab_disponibilidade"));
                h.setData(rs.getString("data"));
                a.setNome(rs.getString("acao"));
                h.setAcao(a);
                historico.setHeader(h);
                hst.add(historico);
            }
            } catch (SQLException ex) {
            Logger.getLogger(DAOLaboratorio.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return hst;
}
}
