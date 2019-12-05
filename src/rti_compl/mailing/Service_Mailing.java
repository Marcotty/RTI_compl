/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rti_compl.mailing;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;
import javax.mail.*;

/**
 *
 * @author fredm
 */
public class Service_Mailing {
    private ServerSocket SSocket;
    private int port = 50056;
    
    static String host = "u2.tech.hepl.local";

    public Service_Mailing(int PORT_MAIL)
    {
        CreerServeur(PORT_MAIL);
        
        //Test();
        
        ThreadServeur server = new ThreadServeur(SSocket);
        server.start();
    }

    private void CreerServeur(int PORT_MAIL) {
        try
        {
            SSocket = new ServerSocket(port);
            
        }catch(IOException e)
        {
            System.err.println("Erreur de port d'écoute ! ? [" + e + "]"); 
        }
    }

    private void Test() {
        String user ="marcotty";
        String pwd = "azerty";
        
        Properties prop = System.getProperties();
        System.out.println("MAILING | Création de la session mail");
        prop.put("mail.pop3.host", host);
        prop.put("mail.disable.top", "true");
        
        Session sess = Session.getDefaultInstance(prop, null);
        prop.list(System.out);
        
        try
        {
            System.out.println("MAILING | Obtention d'un objet Store");
            Store st = sess.getStore("pop3");
            st.connect(host, user, pwd);
            
            System.out.println("Obtention d'un objet folder");
            Folder f = st.getFolder("INBOX");
            f.open(Folder.READ_ONLY);
            System.out.println("MAILING | Obtention des messages");
            Message msg[] = f.getMessages();
            System.out.println("MAILING | Nombre de messages : " + f.getMessageCount());
            System.out.println("MAILING | Nombre de nouveaux messages : " + f.getNewMessageCount());
            
            System.out.println("MAILING | Liste des messages :");
            for(int i =0; i< msg.length; i++)
            {
                if(msg[i].isMimeType("text/plain"))
                {
                    System.out.println("MAILING | Expéditeur : " + msg[i].getFrom()[0]);
                    System.out.println("MAILING | Sujet = " + msg[i].getSubject());
                    System.out.println("MAILING | Texte : " + (String)msg[i].getContent());
                }
            }
            System.out.println("MAILING | Fin des messages");
        }
        catch(NoSuchProviderException e)
        {
            System.out.println("Erreur sur provider : " + e.getMessage());
        }
        catch(MessagingException e)
        {
            System.out.println("Erreur sur provider : " + e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println("Erreur sur provider : " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Erreur sur provider : " + e.getMessage());
        }
    }
}
