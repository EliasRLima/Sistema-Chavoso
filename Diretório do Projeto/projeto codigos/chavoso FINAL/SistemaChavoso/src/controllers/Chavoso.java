/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Ententys.*;
import Views.*;
import models.*;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author elias
 */
public class Chavoso {
    
    private static GerenteDeJanelas gerenciador;
    private static Connection conexao;
    private static DAODepartamento daodep;
    private static DAOLaboratorio daolab;
    private static DAOHeader daoheader;
    private static DAORelatorio daorel;
    private static DAOPessoa daopes;
    public static Relatorio relatorio;
    
    public static void setGerenciador(JDesktopPane jdp){
        Chavoso.gerenciador = new GerenteDeJanelas(jdp);
    }
    
    public static void gerenciarJanelas(JInternalFrame jif){
        Chavoso.gerenciador.abrirJanelas(jif);
    }
    
    public static void AlterarDisponibiliade(String estado, int id, int num, String acao, boolean gerar){
        Chavoso.daolab.AlterarDisp(estado,id,num,acao);
        Chavoso.relatorio.setId_pessoa_autor(Login.idadmin);
        if(gerar){
            Chavoso.gerarHistorico(Chavoso.buscarIdChave(num,id), false, estado, 7);
        }
        
     }
    
    public static boolean VerificarAssinatura(String assinatura, String estado, int id, int num, String acao){
        if (Chavoso.daopes.VerificarAss(assinatura)){
            Chavoso.AlterarDisponibiliade(estado,id,num, acao,false);
            Chavoso.relatorio.setId_pessoa_autor(Chavoso.getIdBySenha(assinatura));
            Chavoso.gerarHistorico(Chavoso.buscarIdChave(num,id), true, estado,1);
            return true;
        }
        return false;
    }
    
    public static boolean VerificarAssinaturaLimpeza(String assinatura, String estado, int id, int num, String acao){
        if (Chavoso.daopes.VerificarAss(assinatura)){
            Chavoso.AlterarDisponibiliade(estado,id,num, acao,false);
            Chavoso.relatorio.setId_pessoa_autor(Chavoso.getIdBySenha(assinatura));
            Chavoso.gerarHistorico(Chavoso.buscarIdChave(num,id), true, estado,3);
            return true;
        }
        return false;
    }
    
    public static boolean VerificarCpf(String cpf){
        return Chavoso.daopes.VerificaCpf(cpf);
    }
    
     public static boolean VerificaPessoaLimpeza(int idpessoa){
        return Chavoso.daopes.VerificaPessoaLimpeza(idpessoa);
    }
    
    public static int checarADM(){
        return Chavoso.daopes.getNumeroAdmin();
    }
    
    public static boolean VerificarAssinatura(String senha){
        return Chavoso.daopes.VerificaAssinatura(senha);
    }
    
    public static int getIdBySenha(String senha){
        return Chavoso.daopes.getIdPessoaSenha(senha);
    }
    
     public static int getIdDepBySenha(String senha){
        return Chavoso.daodep.PegarIdDep(senha);
    }
    
    private static void gerarRelatorio(){
         Chavoso.relatorio = new Relatorio(0, 0, Login.idadmin, false, "", 0);
    }
    
    private static void gerarHistorico(int id_chave, boolean verificacao_senha, String lab_disponibilidade, int idacao){
        String data = Chavoso.daoheader.getDataAtual();
        int header = Chavoso.daoheader.getHeader(data);
        if(header == 0){
            Chavoso.daoheader.insertHeader(idacao, data);
            header = Chavoso.daoheader.getHeader(data);
        }
        Chavoso.relatorio.setId_chave(id_chave);
        Chavoso.relatorio.setId_header(header);
        Chavoso.relatorio.setLab_disponibilidade(lab_disponibilidade);
        Chavoso.relatorio.setVerificacao_senha(verificacao_senha);
        Chavoso.daorel.insertRelatorio(Chavoso.relatorio);
        Chavoso.gerarRelatorio();
    }
    
    private static int buscarIdChave(int id_laboratorio, int iddep){
        return Chavoso.daolab.PegarIdChave(id_laboratorio,iddep);
    }
    
    public static boolean entregarChave(int iddep, int num){
        String estado = "ocupado";
        String result = Chavoso.Disponibiblidade(iddep, num);
        if (result.equals("disponivel")){
            Assinatura ass = new Assinatura();
            PrincipalChavoso.getPainel().add(ass);
            ass.setVisible(true);
            ass.recebendo(estado, iddep, num);
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean entregarChavelimpeza(int iddep, int num){
        String estado = "ocupado";
        String result = Chavoso.Disponibiblidade(iddep, num);
        if (result.equals("disponivel")){
            AssinaturaLimpeza ass = new AssinaturaLimpeza();
            PrincipalChavoso.getPainel().add(ass);
            ass.setVisible(true);
            ass.recebendo(estado, iddep, num);
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean devolveChave(int id, int num, String acao){
        String result = Chavoso.Disponibiblidade(id, num);
        String resulacao = Chavoso.getacaolab(id, num);
        String estado = "disponivel";
        if(result.equals("ocupado")){
        if(!resulacao.equals("Laboratório em Limpeza")){
            Chavoso.AlterarDisponibiliade(estado, id, num, acao,false);
            Chavoso.gerarHistorico(Chavoso.buscarIdChave(num,id), false, estado, 2);
            //JOptionPane.showMessageDialog(null, Chavoso.buscarIdChave(num));
            return true;
        }else{
            Chavoso.AlterarDisponibiliade(estado, id, num, acao,false);
            Chavoso.gerarHistorico(Chavoso.buscarIdChave(num,id), false, estado, 4);
            return true;
        }
        }else{
            return false;
        }
    }
    
    public static int PegarIdDep(Departamento sig){
        return Chavoso.daodep.PegarId(sig);
    }
    
    public static int PegarIdDepString(String sig){
        return Chavoso.daodep.PegarId(sig);
    }
    
    public static List<Laboratorio> buscaLab(int iddep){
        return Chavoso.daolab.buscaLabDeDep(iddep);
    }
    
    public static List<Departamento> buscaDep(int iddep){
        return Chavoso.daodep.BuscarDep(iddep);
    }
    
    public static List<Relatorio> buscaHst(int iddep){
        return Chavoso.daorel.buscaRelatorio(iddep);
    }
    
    public static String Disponibiblidade(int id, int num){
        return Chavoso.daolab.Disponibiblidade(id, num);
    }
    
    public static List<Departamento> getDeps(){
        return Chavoso.daodep.read();
    }
    
    public static String getacaolab(int iddep , int num){
        return Chavoso.daolab.LabAcao(iddep, num);
    }
    
    public static List<Laboratorio> readLabs(){
        return Chavoso.daolab.read();
    }
    
    public static DefaultTableModel gerarTabelaDeps(JTable tabela, int id){
        DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
        modelo.setNumRows(0);
        
        for(Laboratorio l : Chavoso.buscaLab(id)){
            
            modelo.addRow(new Object[]{
              l.getDepartamento().getNome(),
              l.getNumero(), 
              l.getChave().getNumero(),
              l.getDisponibilidade(),
              l.getAcao()
            });
        }
        return modelo;
    }
    
    public static DefaultTableModel gerarTabelaHistorico(JTable tabela, int id){
        DefaultTableModel modelo = (DefaultTableModel)tabela.getModel();
        modelo.setNumRows(0);
        String ver = "";
        
        for(Relatorio h : Chavoso.buscaHst(id)){
            if(h.getVerificacao() == 0){
                ver = "Senha não Verificada";
            }
            else{
                ver = "Senha Verificada";
            }
            modelo.addRow(new Object[]{
            h.getId_chave(),
            h.getPessoa_autor(),
            h.getPessoa_admin(),
            ver,
            h.getLab_disponibilidade(),
            h.getHeader().getData(),
            h.getHeader().getAcao().getNome()
            });
        }
        return modelo;
    }
    
    public static void limparTabela(JTable tabela){
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        int x = modelo.getRowCount();
        for(int a = 0; a < x; a++)
        {
            modelo.removeRow(0);
        }
    }
    
    public static boolean efetuarLogin(String cpf, String senha){
        return Chavoso.daopes.logar(cpf, senha);
    }
    
    public static void cadastrarDepartamento(String nome, String sigla){
        if(nome.equals("")|| sigla.equals("")){
            JOptionPane.showMessageDialog(null, "Campo não preechido!", "AVISO", JOptionPane.ERROR_MESSAGE, null);   
        }
        else{
        Departamento dep = new Departamento();
        dep.setNome(nome);
        dep.setSigla(sigla);
        Chavoso.daodep.create(dep);
        }
    }
    
    public static boolean editarDepartamento(String nome, String sigla, String selecionado){
        if(nome.equals("")||sigla.equals("")){
            JOptionPane.showMessageDialog(null, "Campo não preechido!", "AVISO", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        else{
        int iddep = Chavoso.PegarIdDepString(selecionado);
        Departamento dep = new Departamento();
        dep.setNome(nome);
        dep.setSigla(sigla);
        Chavoso.daodep.alterarDep(dep, iddep);
        return true;
        } 
    }
    
    public static boolean manutencao(Departamento dep, String acao, int id, int num,int realizar){
                if(realizar == 1){
                    Chavoso.AlterarDisponibiliade("manutenção", id, num,acao,false);
                    Chavoso.gerarHistorico(Chavoso.buscarIdChave(num,id), false, "manutenção", 5);
                    return true;
                }else{
                    Chavoso.AlterarDisponibiliade("disponivel", id, num,acao,false);
                    Chavoso.gerarHistorico(Chavoso.buscarIdChave(num,id), false, "disponivel", 6);
                    return false;
                }
            
    }
    
    public static boolean cadastrarPessoa(String senha, String nome, String cpf, String funcao, String dep){
        
        if(nome.equals("") || cpf.equals("") || senha.equals("")){
          JOptionPane.showMessageDialog(null, "Campo não preechido!", "AVISO", JOptionPane.ERROR_MESSAGE, null); 
          return false;
        }
        else{
        Pessoa p = new Pessoa();
        p.setNome(nome);
        p.setSenha(senha);
        p.setCpf(cpf);
        if(!Chavoso.VerificarCpf(cpf)){
        if(!Chavoso.VerificarAssinatura(senha)){
        Chavoso.daopes.create(p);
        int idpessoa = Chavoso.daopes.PegarId(senha);
        if(funcao.equals("Professor")){
          int iddep = daodep.PegarId(dep);
          Chavoso.daopes.Professor(iddep, idpessoa);
        }
        if(funcao.equals("Auxiliar de limpeza")){
          Chavoso.daopes.Limpeza(idpessoa);
        }
        if(funcao.equals("Administrador")){
          Chavoso.daopes.Administrador(idpessoa);
        }
        return true;
        }else{
           JOptionPane.showMessageDialog(null, "Assinatura já cadastrado!", "AVISO", JOptionPane.ERROR_MESSAGE, null);
           return false;
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "CPF já cadastrado!", "AVISO", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        }
    }
    
    public static boolean editarPessoa(String nome, String senha, String cpf , String cpfbusca){
        int idpessoa = Chavoso.daopes.PegarIdByCPF(cpfbusca);
        if(nome.equals("")||cpf.equals("")||senha.equals("")){
            JOptionPane.showMessageDialog(null, "Campo não preechido!", "AVISO", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        else{
        if(Chavoso.daopes.VerificaCPFeditar(cpf, idpessoa)){
           JOptionPane.showMessageDialog(null, "CPF Já Cadastrado", "AVISO", JOptionPane.ERROR_MESSAGE, null);
           return false; 
        }else{
        if(Chavoso.daopes.VerificaSenhaeditar(senha, idpessoa)){
           JOptionPane.showMessageDialog(null, "Senha/Assinatura Já Cadastrado", "AVISO", JOptionPane.ERROR_MESSAGE, null);
           return false;
        }
        else{
        Pessoa p = new Pessoa();
        p.setNome(nome);
        p.setSenha(senha);
        p.setCpf(cpf);
        Chavoso.daopes.alterarPessoa(p, cpfbusca);
            return true;
        }
        }
        }
    }
    
    public static boolean cadastrarLaboratorio(int iddep, String numlab ){
        if(numlab.equals("")){
            JOptionPane.showMessageDialog(null, "Preencha todos os dados!", "AVISO", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        else{
        int num = Integer.parseInt(numlab);
        Chavoso.daolab.create(num, iddep);
        return true;
        }
    }
    
    public static boolean editarLaboratorio(String numlab, int iddep , int iddepbusca , int numlabbusca){
        if(numlab.equals("")){
            JOptionPane.showMessageDialog(null, "Campo não preechido!", "AVISO", JOptionPane.ERROR_MESSAGE, null);
            return false;
        }
        else{
        int numlabo = Integer.parseInt(numlab);
        int idlab = Chavoso.daolab.PegarId(numlabbusca , iddepbusca);
        Laboratorio lab = new Laboratorio();
        lab.setNumero(numlabo);
        lab.setId_departamento(iddep);
        Chavoso.daolab.alterarLaboratorio(lab,idlab);
        return true;
        }
    }
    
    public static List<Pessoa> getPessoas(String cpf){
        return Chavoso.daopes.buscaPessoa(cpf);
    }
    
    public static void entrarMenu(){
        Chavoso.setGerenciador(PrincipalChavoso.getPainel());
        PrincipalChavoso.iniciar();
    }
    
    public static void entrarAdmin(){
        Chavoso.setGerenciador(Administracao.getPainel());
        Administracao.iniciar();
    }
    
    public static void entrarCadastro(){
        Chavoso.setGerenciador(CadastroInicial.getPainel());
        CadastroInicial.iniciar();
    }
    
    private static void conectar(){
        Chavoso.conexao = ConnectionFactory.getConnection();
        Chavoso.daodep = new DAODepartamento(Chavoso.conexao);
        Chavoso.daolab = new DAOLaboratorio(Chavoso.conexao);
        Chavoso.daoheader = new DAOHeader(Chavoso.conexao);
        Chavoso.daorel = new DAORelatorio(Chavoso.conexao);
        Chavoso.daopes = new DAOPessoa(Chavoso.conexao);
    }
    
    public static void main(String args[]) {
           Chavoso.conectar();
           //System.out.println("2");
           if(Login.login){
                Chavoso.gerarRelatorio();
                Chavoso.entrarMenu();
           }
           else{
               Login.Startar(args);
           }
          
    }
    
    
    
    
   
}
