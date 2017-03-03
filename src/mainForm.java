
import controler.BoatDAO;
import controler.SerieDAO;
import controler.ClassUserDAO;
import controler.UserDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modele.ClassUser;

import modele.Serie;
import modele.User;
/**
 *
 * @author cerbere
 */
public class mainForm extends javax.swing.JFrame {

    public SerieDAO             series;
    public ClassUserDAO         classusers;
    public UserDAO              users;
    public BoatDAO              boats;
    UI.ProprietaireTableModel   proprietairesFind;
    UI.UserTableModel           userFind;
    
    /**
     * Creates new form mainForm
     */
    public mainForm() {
        users               = new UserDAO();
        series              = new SerieDAO();
        classusers          = new ClassUserDAO();
        boats               = new BoatDAO();
        proprietairesFind   = new UI.ProprietaireTableModel(boats.findAllBoat());
        userFind            = new UI.UserTableModel(users.findAll());
        
        initComponents();
        JLError.setVisible(false);
        jDesktopPane1.setEnabled(false);
        jLabelAddPro.setVisible(false);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jDesktopPane6 = new javax.swing.JDesktopPane();
        jDesktopPane12 = new javax.swing.JDesktopPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVoilier = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jCBSerie = new javax.swing.JComboBox<>();
        JBCreaBateau = new javax.swing.JButton();
        jCBProprio = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jTFNomBateau = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabelClass = new javax.swing.JLabel();
        jCBClass = new javax.swing.JComboBox<>();
        JLError = new javax.swing.JLabel();
        jButtonAddProprio = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPrenom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldTelephone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldAge = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAjoutPro = new javax.swing.JButton();
        jLabelAddPro = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableVoilier.setModel(proprietairesFind
        );
        jScrollPane2.setViewportView(jTableVoilier);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel30.setText("Selection d'une série");

        jCBSerie.setModel(new javax.swing.DefaultComboBoxModel(series.findAll().toArray()));
        jCBSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBSerieActionPerformed(evt);
            }
        });

        JBCreaBateau.setVisible(false);
        JBCreaBateau.setText("CREATION DU VOILIER");
        JBCreaBateau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBCreaBateauActionPerformed(evt);
            }
        });

        jCBProprio.setVisible(false);
        jCBProprio.setModel(new javax.swing.DefaultComboBoxModel(users.findAll().toArray()));
        jCBProprio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBProprioActionPerformed(evt);
            }
        });

        jLabel33.setVisible(false);
        jLabel33.setText("Selection du propriétaire");

        jTFNomBateau.setVisible(false);
        jTFNomBateau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNomBateauActionPerformed(evt);
            }
        });

        jLabel34.setVisible(false);
        jLabel34.setText("Nom du bateau");

        jLabelClass.setVisible(false);
        jLabelClass.setText("Selection d'une classe");

        jCBClass.setVisible(false);
        int serie = (((Serie)jCBSerie.getSelectedItem()).getSerie_id());
        jCBClass.setModel(new javax.swing.DefaultComboBoxModel(classusers.findBySerie(serie).toArray()));
        jCBClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBClassActionPerformed(evt);
            }
        });

        JLError.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        JLError.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLError.setText("Erreur");

        jButtonAddProprio.setText("Propriétaire inexistant");
        jButtonAddProprio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProprioActionPerformed(evt);
            }
        });

        jDesktopPane12.setLayer(jPanel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane12.setLayer(jLabel30, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane12.setLayer(jCBSerie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane12.setLayer(JBCreaBateau, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane12.setLayer(jCBProprio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane12.setLayer(jLabel33, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane12.setLayer(jTFNomBateau, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane12.setLayer(jLabel34, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane12.setLayer(jLabelClass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane12.setLayer(jCBClass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane12.setLayer(JLError, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane12.setLayer(jButtonAddProprio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane12Layout = new javax.swing.GroupLayout(jDesktopPane12);
        jDesktopPane12.setLayout(jDesktopPane12Layout);
        jDesktopPane12Layout.setHorizontalGroup(
            jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane12Layout.createSequentialGroup()
                .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDesktopPane12Layout.createSequentialGroup()
                        .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelClass, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBClass, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPane12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(JBCreaBateau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jDesktopPane12Layout.createSequentialGroup()
                                    .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(18, 18, 18)
                                    .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCBProprio, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTFNomBateau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(JLError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButtonAddProprio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jDesktopPane12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jCBClass, jCBProprio, jCBSerie, jTFNomBateau});

        jDesktopPane12Layout.setVerticalGroup(
            jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jDesktopPane12Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelClass)
                            .addComponent(jCBClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jCBProprio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFNomBateau)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(JBCreaBateau)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAddProprio)
                        .addGap(54, 54, 54)
                        .addComponent(JLError)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        JLError.getAccessibleContext().setAccessibleName("jLabelError");
        JLError.getAccessibleContext().setAccessibleDescription("");

        jDesktopPane6.setLayer(jDesktopPane12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane6Layout = new javax.swing.GroupLayout(jDesktopPane6);
        jDesktopPane6.setLayout(jDesktopPane6Layout);
        jDesktopPane6Layout.setHorizontalGroup(
            jDesktopPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane12)
                .addContainerGap())
        );
        jDesktopPane6Layout.setVerticalGroup(
            jDesktopPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane12)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Ajout voilier", jDesktopPane6);

        jLabel1.setText("Prenom");

        jLabel2.setText("Nom");

        jTextFieldTelephone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelephoneActionPerformed(evt);
            }
        });

        jLabel3.setText("Telephone");

        jLabel4.setText("Email");

        jLabel5.setText("Age");

        jLabel6.setText("NOUVEAU PROPRIETAIRE");

        jTable1.setModel(userFind
        );
        jScrollPane1.setViewportView(jTable1);

        jButtonAjoutPro.setText("Ajouter un proprietaire");
        jButtonAjoutPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAjoutProActionPerformed(evt);
            }
        });

        jLabelAddPro.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabelAddPro.setText("text");

        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldPrenom, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldNom, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldTelephone, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTextFieldAge, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButtonAjoutPro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelAddPro, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(86, 86, 86)
                                .addComponent(jTextFieldAge, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(38, 38, 38)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNom, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldTelephone, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldEmail)
                                    .addComponent(jTextFieldPrenom)))
                            .addComponent(jButtonAjoutPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabelAddPro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAjoutPro)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelAddPro)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane4.addTab("Infos. Propriétaire", jDesktopPane1);

        jTabbedPane3.addTab("INSERTION", jTabbedPane4);

        jMenuBar2.setBorder(new javax.swing.border.MatteBorder(null));

        jMenu3.setText("Fichier");

        jMenuItem2.setText("Nouveau fichier");
        jMenu3.add(jMenuItem2);
        jMenu3.add(jSeparator1);

        jMenuItem3.setText("Ouvrir fichier");
        jMenu3.add(jMenuItem3);

        jMenuItem7.setText("Sauvegarder");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);
        jMenu3.add(jSeparator2);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Quitter");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
                System.out.println("Fin du processus");
            }
        });

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edition");

        jMenuItem6.setText("Ajout");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem4.setText("Modification");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem8.setText("Suppression");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenuBar2.add(jMenu4);

        jMenu1.setText("A propos");
        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButtonAjoutProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAjoutProActionPerformed
        // Ajout d'un proprietaire

        String userSurname  = jTextFieldPrenom.getText();
        String userName     = jTextFieldNom.getText();
        int    userPhone    = Integer.parseInt(jTextFieldTelephone.getText());
        String userEmail    = jTextFieldEmail.getText();
        int    userAge      = Integer.parseInt(jTextFieldAge.getText());
        if (userName.isEmpty() == true || userSurname.isEmpty() == true || userEmail.isEmpty() == true)
        {
            JLError.setText("Veuillez remplir tout les champs");
            JLError.setVisible(true);
        }
        else
        {
            try {
                controler.UserDAO.insertUser(userName, userSurname, userPhone, userEmail, userAge);
                userFind.setModel(users.findAll());
                jLabelAddPro.setText("L'enregistrement est validé");
                jLabelAddPro.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
    }//GEN-LAST:event_jButtonAjoutProActionPerformed

    private void jTextFieldTelephoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelephoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelephoneActionPerformed

    private void jButtonAddProprioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProprioActionPerformed
        jDesktopPane1.setVisible(true);
    }//GEN-LAST:event_jButtonAddProprioActionPerformed

    private void jCBClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBClassActionPerformed
        jLabel33.setVisible(true);
        jCBProprio.setVisible(true);
    }//GEN-LAST:event_jCBClassActionPerformed

    private void jTFNomBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNomBateauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNomBateauActionPerformed

    private void jCBProprioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBProprioActionPerformed
        jLabel34.setVisible(true);
        jTFNomBateau.setVisible(true);
        JBCreaBateau.setVisible(true);
    }//GEN-LAST:event_jCBProprioActionPerformed

    private void JBCreaBateauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBCreaBateauActionPerformed

        String serie = String.valueOf(((Serie)jCBSerie.getSelectedItem()).getSerie_id());
        System.out.println(serie);
        int classUser = (((ClassUser)jCBClass.getSelectedItem()).getClass_id());
        System.out.println(classUser);
        int user = (((User)jCBProprio.getSelectedItem()).getId());
        System.out.println(user);
        String text = jTFNomBateau.getText();
        System.out.println(text);
        if (text.isEmpty() == true)
        {
            JLError.setText("Veuillez mettre un nom de bateau");
            JLError.setVisible(true);
        }
        else
        {
            try {
                controler.BoatDAO.insertVoilier(user, classUser, text);
                JLError.setText("La bateau a été enregistré");
                JLError.setVisible(true);
                proprietairesFind.setModel(boats.findAllBoat());
            } catch (Exception ex) {
                Logger.getLogger(mainForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_JBCreaBateauActionPerformed

    private void jCBSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBSerieActionPerformed
        jLabelClass.setVisible(true);
        jCBClass.setVisible(true);
        int serie = (((Serie)jCBSerie.getSelectedItem()).getSerie_id());
        System.out.println("Série: " + serie);
        jCBClass.setModel(new javax.swing.DefaultComboBoxModel(classusers.findBySerie(serie).toArray()));
    }//GEN-LAST:event_jCBSerieActionPerformed
    
    
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
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainForm().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBCreaBateau;
    private javax.swing.JLabel JLError;
    private javax.swing.JButton jButtonAddProprio;
    private javax.swing.JButton jButtonAjoutPro;
    private javax.swing.JComboBox<String> jCBClass;
    private javax.swing.JComboBox<String> jCBProprio;
    private javax.swing.JComboBox<Serie> jCBSerie;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane12;
    private javax.swing.JDesktopPane jDesktopPane6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelAddPro;
    private javax.swing.JLabel jLabelClass;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTFNomBateau;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableVoilier;
    private javax.swing.JTextField jTextFieldAge;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldPrenom;
    private javax.swing.JTextField jTextFieldTelephone;
    // End of variables declaration//GEN-END:variables
}
