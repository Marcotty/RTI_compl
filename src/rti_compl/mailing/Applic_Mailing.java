/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rti_compl.mailing;

import java.io.IOException;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import static rti_compl.mailing.Service_Mailing.host;

/**
 *
 * @author fredm
 */
public class Applic_Mailing extends javax.swing.JFrame {
    private Properties prop;
    private Session sess;
    private Store st;
    private Folder f;
    /**
     * Creates new form Applic_Mailing
     */
    public Applic_Mailing() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CBBoite = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        BVoir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TFTo = new javax.swing.JTextField();
        TFFrom = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TAData = new javax.swing.JTextArea();
        BEnvoyer = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TFSujet = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LMails = new javax.swing.JList();
        BVoirMails = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CBBoite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "marcotty", "heye" }));

        jLabel1.setText("Boite :");

        BVoir.setText("Voir");
        BVoir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BVoirActionPerformed(evt);
            }
        });

        jLabel2.setText("To :");

        jLabel3.setText("From :");

        jLabel4.setText("Data :");

        TFFrom.setText("admin");

        TAData.setColumns(20);
        TAData.setRows(5);
        jScrollPane1.setViewportView(TAData);

        BEnvoyer.setText("Envoyer");
        BEnvoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEnvoyerActionPerformed(evt);
            }
        });

        jButton4.setText("Ajouter");

        jLabel5.setText("Sujet");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(13, 13, 13)
                                .addComponent(TFTo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(TFSujet, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TFFrom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(71, 71, 71)
                                .addComponent(BEnvoyer)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TFTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TFFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TFSujet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(BEnvoyer))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(LMails);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        BVoirMails.setText("Voir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BVoirMails)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BVoir)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(CBBoite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CBBoite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BVoir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BVoirMails)
                        .addGap(54, 54, 54))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BVoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BVoirActionPerformed
        // TODO add your handling code here:
        //System.out.println(CBBoite.getSelectedItem());
        RecupMsg((String) CBBoite.getSelectedItem());
        if(CBBoite.getSelectedItem().equals("marcotty"))
        {
            TFTo.setText("marcotty@u2.tech.hepl.local");
        }
        else if(CBBoite.getSelectedItem().equals("heye"))
        {
            TFTo.setText("heye@u2.tech.hepl.local");
        }
    }//GEN-LAST:event_BVoirActionPerformed

    private void BEnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEnvoyerActionPerformed
        // TODO add your handling code here:
        EnvoyerMail();
    }//GEN-LAST:event_BEnvoyerActionPerformed

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
            java.util.logging.Logger.getLogger(Applic_Mailing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Applic_Mailing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Applic_Mailing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Applic_Mailing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Applic_Mailing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BEnvoyer;
    private javax.swing.JButton BVoir;
    private javax.swing.JButton BVoirMails;
    private javax.swing.JComboBox CBBoite;
    private javax.swing.JList LMails;
    private javax.swing.JTextArea TAData;
    private javax.swing.JTextField TFFrom;
    private javax.swing.JTextField TFSujet;
    private javax.swing.JTextField TFTo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void RecupMsg(String user) {
        if(user.equals("marcotty"))
            ConnexionMail(user, "azerty");
        else if(user.equals("heye"))
            ConnexionMail(user, "Coralie29");
        RecupMsg();
    }
    private void ConnexionMail(String u, String p) {
        prop = System.getProperties();
        System.out.println("MAILING | Création de la session mail");
        prop.put("mail.pop3.host", host);
        prop.put("mail.disable.top", "true");

        sess = Session.getDefaultInstance(prop, null);
        //prop.list(System.out);

        try
        {
            System.out.println("MAILING | Obtention d'un objet Store");
            st = sess.getStore("pop3");
            st.connect(host, u, p);

            System.out.println("Obtention d'un objet folder");
            f = st.getFolder("INBOX");
            f.open(Folder.READ_ONLY);
        }
        catch(NoSuchProviderException e)
        {
            System.out.println("Erreur sur provider : " + e.getMessage());
        }
        catch(MessagingException e)
        {
            System.out.println("Erreur sur provider : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Erreur sur provider : " + e.getMessage());
        }
    }

    private void RecupMsg() {
        String rep = "";
        Vector v = new Vector();
        try
        {
            //f.open(Folder.READ_ONLY);
            System.out.println("SERVER MAILING | test affich ");
            Message msg[] = f.getMessages();
            for(int i=msg.length-1; i >= 0; i--)
            {
                if (msg[i].isMimeType("text/plain")) 
                {
                    String sujet = msg[i].getSubject();
                    if(sujet == null)
                    {
                        String text = (String)msg[i].getContent();
                        rep += text;
                        rep += "#";
                        v.add(text);
                    }
                    else
                    {
                        rep += sujet;
                        rep += "#";
                        v.add(sujet);
                    }
                    //rep.concat("#" + msg[i].getSubject());
                    System.out.println("MAIL TEST || Sujets : " + msg[i].getSubject());
                    //System.out.println("MAILING | Expéditeur : " + msg[i].getFrom()[0]);
                    //System.out.println("MAILING | Sujet = " + msg[i].getSubject());
                    System.out.println("MAILING | Texte : " + (String)msg[i].getContent());
                } 
            }
            
            System.out.println("mails " + rep);
            LMails.setListData(v);
        }
        catch(MessagingException | IOException e)
        {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void EnvoyerMail() {
        prop.put("mail.smtp.host", host);
        
        try
        {
           System.out.println("Création du message");
           String exp = TFFrom.getText() + "@u2.tech.hepl.local";
           String dest = TFTo.getText();
           String sujet = TFSujet.getText();//"test smtp";
           String texte = TAData.getText();
           
           MimeMessage msg = new MimeMessage(sess);
           msg.setFrom(new InternetAddress(exp));
           msg.setRecipient(Message.RecipientType.TO, new InternetAddress(dest));
           msg.setSubject(sujet);
           msg.setText(texte);
           
           System.out.println("Envoi du message");
           Transport.send(msg);
           System.out.println("Message envoyé");
        }
        catch(MessagingException e)
        {
          System.out.println("Erreur sur envoi msg : " + e.getMessage());  
        }
    }
}