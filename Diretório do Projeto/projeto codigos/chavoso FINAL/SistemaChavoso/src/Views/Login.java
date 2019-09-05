/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import controllers.Chavoso;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author proxc
 */
public class Login extends javax.swing.JFrame {

    
    public static boolean login = false;
    public static int idadmin = 4;
    public static String stringmain[];
    public Login(int id, boolean login) {
        initComponents();
         this.setLocationRelativeTo(null);
        setIcon();
        Login.idadmin = id;
        Login.login = login;
        TelaInicial();
    }
    public Login(){
        initComponents();
         this.setLocationRelativeTo(null);
        setIcon();
        TelaInicial();
        
    }
    
    public void TelaInicial(){   
        txtCPF.grabFocus();
        if(Chavoso.checarADM() > 0){
            pn_cadastrar.setVisible(false);
            pn_sobre.setVisible(false);
            btn_login.setText("Login");
            pn_login.setVisible(true);
        }else{
            btn_login.setText("Cadastrar");
            pn_cadastrar.setVisible(true);
            pn_sobre.setVisible(false);
            pn_login.setVisible(false);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_login = new javax.swing.JLabel();
        btn_sobre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_minimizar = new javax.swing.JLabel();
        home = new javax.swing.JPanel();
        pn_login = new javax.swing.JPanel();
        btn_loginsistema = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        txtCPF = new javax.swing.JFormattedTextField();
        pn_sobre = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pn_cadastrar = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtCPF1 = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtsenha = new javax.swing.JPasswordField();
        btn_cadastrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bem vindo, Você está no sistema Chavoso!");
        setLocationByPlatform(true);
        setUndecorated(true);

        main.setBackground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(245, 88, 71));
        header.setPreferredSize(new java.awt.Dimension(838, 200));
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bem vindo(a)!");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sistema Chavoso");

        jLabel3.setBackground(new java.awt.Color(84, 84, 84));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("X");
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        btn_login.setBackground(new java.awt.Color(45, 45, 45));
        btn_login.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_login.setText("Login");
        btn_login.setOpaque(true);
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });

        btn_sobre.setBackground(new java.awt.Color(84, 84, 84));
        btn_sobre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_sobre.setForeground(new java.awt.Color(255, 255, 255));
        btn_sobre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_sobre.setText("Sobre");
        btn_sobre.setOpaque(true);
        btn_sobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_sobreMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        btn_minimizar.setBackground(new java.awt.Color(84, 84, 84));
        btn_minimizar.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        btn_minimizar.setForeground(new java.awt.Color(255, 255, 255));
        btn_minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_minimizar.setText("-");
        btn_minimizar.setOpaque(true);
        btn_minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_minimizarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(headerLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(headerLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(headerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sobre, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(442, 442, 442))))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(btn_minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sobre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        home.setLayout(new java.awt.CardLayout());

        pn_login.setBackground(new java.awt.Color(45, 45, 45));
        pn_login.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_loginsistema.setBackground(new java.awt.Color(0, 150, 62));
        btn_loginsistema.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_loginsistema.setForeground(new java.awt.Color(255, 255, 255));
        btn_loginsistema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_loginsistema.setText("Entrar");
        btn_loginsistema.setOpaque(true);
        btn_loginsistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginsistemaMouseClicked(evt);
            }
        });
        pn_login.add(btn_loginsistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 145, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CPF");
        pn_login.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(422, 41, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SENHA");
        pn_login.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 114, -1, -1));
        pn_login.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 135, 430, 34));

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        pn_login.add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 62, 430, 34));

        home.add(pn_login, "card3");

        pn_sobre.setBackground(new java.awt.Color(45, 45, 45));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sistema Chavoso® - IFMA 2019");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("    Sistema destinado ao gerenciamento de chaves dos laboratórios do Instituto Federal de Educação, Ciência e Tecnologia do Maranhão.");

        javax.swing.GroupLayout pn_sobreLayout = new javax.swing.GroupLayout(pn_sobre);
        pn_sobre.setLayout(pn_sobreLayout);
        pn_sobreLayout.setHorizontalGroup(
            pn_sobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_sobreLayout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_sobreLayout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(124, 124, 124))
        );
        pn_sobreLayout.setVerticalGroup(
            pn_sobreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_sobreLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addComponent(jLabel8)
                .addGap(184, 184, 184))
        );

        home.add(pn_sobre, "card3");

        pn_cadastrar.setBackground(new java.awt.Color(45, 45, 45));

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Primeiro login! Bem-vindo, Administrador!");

        try {
            txtCPF1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("CPF");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Nome");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Senha");

        btn_cadastrar.setBackground(new java.awt.Color(255, 153, 0));
        btn_cadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cadastrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btn_cadastrar.setText("Cadastrar");
        btn_cadastrar.setOpaque(true);
        btn_cadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cadastrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pn_cadastrarLayout = new javax.swing.GroupLayout(pn_cadastrar);
        pn_cadastrar.setLayout(pn_cadastrarLayout);
        pn_cadastrarLayout.setHorizontalGroup(
            pn_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_cadastrarLayout.createSequentialGroup()
                .addGroup(pn_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_cadastrarLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel9))
                    .addGroup(pn_cadastrarLayout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(257, Short.MAX_VALUE))
            .addGroup(pn_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_cadastrarLayout.createSequentialGroup()
                    .addGap(379, 379, 379)
                    .addGroup(pn_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel14)
                        .addGroup(pn_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(txtCPF1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                            .addComponent(jLabel13)
                            .addComponent(txtsenha)
                            .addComponent(txtNome)))
                    .addContainerGap(447, Short.MAX_VALUE)))
        );
        pn_cadastrarLayout.setVerticalGroup(
            pn_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_cadastrarLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(btn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pn_cadastrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_cadastrarLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jLabel10)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel13)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel14)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(txtsenha, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(57, Short.MAX_VALUE)))
        );

        home.add(pn_cadastrar, "card3");

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1191, Short.MAX_VALUE)
            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int xx;
    int xy;
    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
       
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xx,y-xy);
    }//GEN-LAST:event_headerMouseDragged

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        // TODO add your handling code here:
        
        setLblColor(btn_login);
        resetLblColor(btn_sobre);
        //switch bettween Jpanels
        if(btn_login.getText().equals("Login")){
            pn_cadastrar.setVisible(false);
            pn_sobre.setVisible(false);
            pn_login.setVisible(true);
        }else{
            pn_cadastrar.setVisible(true);
            pn_sobre.setVisible(false);
            pn_login.setVisible(false);
        }
        
    }//GEN-LAST:event_btn_loginMouseClicked

    private void btn_sobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sobreMouseClicked

        setLblColor(btn_sobre);
        resetLblColor(btn_login);

            pn_cadastrar.setVisible(false);
            pn_sobre.setVisible(true);
            pn_login.setVisible(false);
        
    }//GEN-LAST:event_btn_sobreMouseClicked

    private void btn_loginsistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginsistemaMouseClicked
        String cpf = txtCPF.getText();
        String senha = new String(txtSenha.getPassword());
        efetuarLogin(cpf, senha);
        //efetuarLogin(cpf, senha);
    }//GEN-LAST:event_btn_loginsistemaMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
                                                                                                        
        JOptionPane.showMessageDialog(null, "INFORMATICA - 602 - 2019:\n                        Alexsando Soares\n                        David Alysson\n                        Elias Lima\n                        Samuel Oliveira\n", "Desenvolvedores", JOptionPane.CLOSED_OPTION, null);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btn_cadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cadastrarMouseClicked
        String senha = new String(txtsenha.getPassword());
        if(Chavoso.cadastrarPessoa(senha,txtNome.getText(),txtCPF1.getText(),"Administrador","")){
            TelaInicial();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Cadastro não efetuado! Verifique o sistema!");
        }
        
    }//GEN-LAST:event_btn_cadastrarMouseClicked

    private void btn_minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_minimizarMouseClicked
        // TODO add your handling code here:
        setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btn_minimizarMouseClicked
    
    // ------------switch between colors for Active/Inactive color
    public void setLblColor(JLabel lbl)
    {
        lbl.setBackground(new Color(45,45,45));
    }
    
      public void resetLblColor(JLabel lbl)
    {
        lbl.setBackground(new Color(84,84,84));
    }
      
           
    public void efetuarLogin(String cpf, String senha){
        if(Chavoso.efetuarLogin(cpf, senha)){
             //System.out.println("24");
            Login.idadmin = Chavoso.getIdBySenha(senha);
            Login.login = true;
            //System.out.println("1");
            Chavoso.main(Login.stringmain);
            closeLogin();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Dados Incorretos ou não preenchidos", "LOGIN", JOptionPane.ERROR_MESSAGE, null);
        }
    }
    
    private void closeLogin(){
        this.dispose();
    }
    public static void Startar(String args[]) {
        /* Set the Nimbus look and feel */
        
        //Change UI look of table.
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login(0,false).setVisible(true);
                Login.stringmain = args;
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_cadastrar;
    private javax.swing.JLabel btn_login;
    private javax.swing.JLabel btn_loginsistema;
    private javax.swing.JLabel btn_minimizar;
    private javax.swing.JLabel btn_sobre;
    private javax.swing.JPanel header;
    private javax.swing.JPanel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel main;
    private javax.swing.JPanel pn_cadastrar;
    private javax.swing.JPanel pn_login;
    private javax.swing.JPanel pn_sobre;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCPF1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables
    private void setIcon() {
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
    }
}
