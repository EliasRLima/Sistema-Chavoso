/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ententys;

/**
 *
 * @author elias
 */
public class Relatorio {	
   private int  id_chave;	
   private int  id_pessoa_autor;	
   private int  id_pessoa_admin;	
   private boolean  verificacao_senha;	
   private String  lab_disponibilidade;	
   private int  id_header;
   private Header header;
   private String pessoa_autor;
   private String pessoa_admin;
   private int verificacao;

    public Relatorio(int id_chave, int id_pessoa_autor, int id_pessoa_admin, boolean verificacao_senha, String lab_disponibilidade, int id_header) {
        this.id_chave = id_chave;
        this.id_pessoa_autor = id_pessoa_autor;
        this.id_pessoa_admin = id_pessoa_admin;
        this.verificacao_senha = verificacao_senha;
        this.lab_disponibilidade = lab_disponibilidade;
        this.id_header = id_header;
    }
    
    public Relatorio(){
    
    }
    
    public int getVerificacao() {
        return verificacao;
    }

    public void setVerificacao(int verificacao) {
        this.verificacao = verificacao;
    }
    
    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public String getPessoa_autor() {
        return pessoa_autor;
    }

    public void setPessoa_autor(String pessoa_autor) {
        this.pessoa_autor = pessoa_autor;
    }

    public String getPessoa_admin() {
        return pessoa_admin;
    }

    public void setPessoa_admin(String pessoa_admin) {
        this.pessoa_admin = pessoa_admin;
    }

    public int getId_chave() {
        return id_chave;
    }

    public void setId_chave(int id_chave) {
        this.id_chave = id_chave;
    }

    public int getId_pessoa_autor() {
        return id_pessoa_autor;
    }

    public void setId_pessoa_autor(int id_pessoa_autor) {
        this.id_pessoa_autor = id_pessoa_autor;
    }

    public int getId_pessoa_admin() {
        return id_pessoa_admin;
    }

    public void setId_pessoa_admin(int id_pessoa_admin) {
        this.id_pessoa_admin = id_pessoa_admin;
    }

    public boolean getVerificacao_senha() {
        return verificacao_senha;
    }

    public void setVerificacao_senha(boolean verificacao_senha) {
        this.verificacao_senha = verificacao_senha;
    }

    public String getLab_disponibilidade() {
        return lab_disponibilidade;
    }

    public void setLab_disponibilidade(String lab_disponibilidade) {
        this.lab_disponibilidade = lab_disponibilidade;
    }

    public int getId_header() {
        return id_header;
    }

    public void setId_header(int id_header) {
        this.id_header = id_header;
    }
   
   
}
