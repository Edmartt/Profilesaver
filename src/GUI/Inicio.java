/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author sam
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pan_slide = new javax.swing.JPanel();
        lbl_slide = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_set = new javax.swing.JButton();
        btn_ver = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lbl_user = new javax.swing.JLabel();
        pan_form = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_url = new javax.swing.JTextField();
        txt_username = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        btn_reg = new javax.swing.JButton();
        lbl_user_id = new javax.swing.JLabel();
        pan_tab = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tb_mostrar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan_slide.setBackground(new java.awt.Color(24, 75, 228));
        pan_slide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_slide.setBackground(new java.awt.Color(255, 32, 0));
        lbl_slide.setFont(new java.awt.Font("Cantarell", 1, 12)); // NOI18N
        lbl_slide.setForeground(new java.awt.Color(254, 254, 254));
        lbl_slide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_slide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu2.png"))); // NOI18N
        lbl_slide.setText("<html>\n--<br/>\n--<br/>\n--<br/>\n</html>");
        lbl_slide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pan_slide.add(lbl_slide, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 25, 25));

        btn_add.setBackground(new java.awt.Color(254, 254, 254));
        btn_add.setFont(new java.awt.Font("L M Mono Caps10", 1, 15)); // NOI18N
        btn_add.setForeground(new java.awt.Color(24, 75, 228));
        btn_add.setText("Añadir");
        btn_add.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 1));
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.setFocusPainted(false);
        pan_slide.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -190, 170, 50));

        btn_set.setBackground(new java.awt.Color(254, 254, 254));
        btn_set.setFont(new java.awt.Font("L M Mono Caps10", 1, 15)); // NOI18N
        btn_set.setForeground(new java.awt.Color(24, 75, 228));
        btn_set.setText("Ajustes");
        btn_set.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 1));
        btn_set.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_set.setFocusPainted(false);
        pan_slide.add(btn_set, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -400, 170, 50));

        btn_ver.setBackground(new java.awt.Color(254, 254, 254));
        btn_ver.setFont(new java.awt.Font("L M Mono Caps10", 1, 15)); // NOI18N
        btn_ver.setForeground(new java.awt.Color(24, 75, 228));
        btn_ver.setText("Guardados");
        btn_ver.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 1));
        btn_ver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ver.setFocusPainted(false);
        pan_slide.add(btn_ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -260, 170, 50));

        jButton4.setBackground(new java.awt.Color(254, 254, 254));
        jButton4.setText("jButton1");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pan_slide.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -330, 170, 50));

        lbl_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/user.png"))); // NOI18N
        pan_slide.add(lbl_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 90, 80));

        jPanel1.add(pan_slide, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 50, 550));

        pan_form.setBackground(new java.awt.Color(254, 254, 254));
        pan_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("L M Roman Caps10", 1, 13)); // NOI18N
        jLabel1.setText("Password");
        pan_form.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));
        pan_form.add(txt_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 290, 40));
        pan_form.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 290, 40));
        pan_form.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 290, 40));

        jLabel2.setFont(new java.awt.Font("L M Roman Caps10", 1, 13)); // NOI18N
        jLabel2.setText("URL");
        pan_form.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("L M Roman Caps10", 1, 13)); // NOI18N
        jLabel3.setText("Nombre de Usuario");
        pan_form.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("L M Roman Caps10", 1, 13)); // NOI18N
        jLabel4.setText("Email");
        pan_form.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));
        pan_form.add(txt_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 290, 40));

        btn_reg.setText("Registrar");
        pan_form.add(btn_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 320, 120, 40));

        jPanel1.add(pan_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 600, 390));

        lbl_user_id.setOpaque(true);
        jPanel1.add(lbl_user_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 40, 40));

        pan_tab.setBackground(new java.awt.Color(254, 254, 254));
        pan_tab.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scroll.setBackground(new java.awt.Color(254, 254, 254));

        tb_mostrar.setBackground(new java.awt.Color(254, 254, 254));
        tb_mostrar.setFont(new java.awt.Font("Michroma", 1, 12)); // NOI18N
        tb_mostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "user_id", "web_id", "URL", "Nombre", "Email", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_mostrar.setSelectionBackground(new java.awt.Color(24, 75, 228));
        tb_mostrar.setSelectionForeground(new java.awt.Color(254, 254, 254));
        tb_mostrar.setShowVerticalLines(false);
        tb_mostrar.getTableHeader().setReorderingAllowed(false);
        scroll.setViewportView(tb_mostrar);
        if (tb_mostrar.getColumnModel().getColumnCount() > 0) {
            tb_mostrar.getColumnModel().getColumn(0).setResizable(false);
            tb_mostrar.getColumnModel().getColumn(1).setResizable(false);
            tb_mostrar.getColumnModel().getColumn(2).setResizable(false);
            tb_mostrar.getColumnModel().getColumn(3).setResizable(false);
            tb_mostrar.getColumnModel().getColumn(4).setResizable(false);
            tb_mostrar.getColumnModel().getColumn(5).setResizable(false);
        }

        pan_tab.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 730, 580));

        jPanel1.add(pan_tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 800, 600));

        jPanel2.setBackground(new java.awt.Color(27, 76, 152));
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_add;
    public javax.swing.JButton btn_reg;
    public javax.swing.JButton btn_set;
    public javax.swing.JButton btn_ver;
    public javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JLabel lbl_slide;
    public javax.swing.JLabel lbl_user;
    public javax.swing.JLabel lbl_user_id;
    public javax.swing.JPanel pan_form;
    public javax.swing.JPanel pan_slide;
    public javax.swing.JPanel pan_tab;
    public javax.swing.JScrollPane scroll;
    public javax.swing.JTable tb_mostrar;
    public javax.swing.JTextField txt_email;
    public javax.swing.JPasswordField txt_pass;
    public javax.swing.JTextField txt_url;
    public javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
