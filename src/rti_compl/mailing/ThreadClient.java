/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rti_compl.mailing;

import java.io.IOException;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Header;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import rti_2.checkinap.ReponseCHECKINAP;
import rti_2.checkinap.RequeteCHECKINAP;
import static rti_2.network.NetworkLibrary.EnvoyerReponse;
import static rti_2.network.NetworkLibrary.EnvoyerRequete;
import static rti_2.network.NetworkLibrary.RecevoirRequete;
import static rti_compl.mailing.Service_Mailing.host;

/**
 *
 * @author fredm
 */
class ThreadClient extends Thread{
    private Socket CSocket;
    private Properties prop;
    private Session sess;
    private Store st;
    private Folder f;
    public ThreadClient(Socket s)
    {
        CSocket = s;
    }
    public void run()
    {
        while(!isInterrupted())
        {
            
            System.out.println("SERVER MAILING | Attente Requete");
            
            RequeteCHECKINAP req = RecevoirRequete(CSocket);
            if(req.type == RequeteCHECKINAP.MAILING_LOG)
            {
                System.out.println("SERVER MAILING | charge "  + req.getChargeUtile());
                StringTokenizer parser = new StringTokenizer(req.getChargeUtile(), "#");
                Vector infos = new Vector();
                while(parser.hasMoreTokens())
                    infos.add(parser.nextToken());
                String user = (String) infos.get(0);
                String pass = (String) infos.get(1);
                ConnexionMail(user, pass);
                int number = 0;
                if(!user.equals("admin"))
                {
                    number = getNewMessages();
                }
                if(number > 0)
                {
                    EnvoyerRequete(CSocket, RequeteCHECKINAP.NEW_MAIL, String.valueOf(number));
                }
            }
            else if(req.type == RequeteCHECKINAP.LIST_MAILS)
            {
                System.out.println("SERVER MAILING | recept requete List Mails");
                EnvoyerRequete(CSocket, RequeteCHECKINAP.LIST_MAILS, getListMails());
            }
        }
    }
    private String getListMails()
    {
        String rep = "";
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
                    }
                    else
                    {
                        rep += sujet;
                        rep += "#";
                    }
                    //rep.concat("#" + msg[i].getSubject());
                    System.out.println("MAIL TEST || Sujets : " + msg[i].getSubject());
                    //System.out.println("MAILING | Expéditeur : " + msg[i].getFrom()[0]);
                    //System.out.println("MAILING | Sujet = " + msg[i].getSubject());
                    System.out.println("MAILING | Texte : " + (String)msg[i].getContent());
                } 
            }
            System.out.println("mails " + rep);
        }
        catch(MessagingException | IOException e)
        {
            Logger.getLogger(ThreadClient.class.getName()).log(Level.SEVERE, null, e);
        }
       return rep; 
    }
    private int getNewMessages()
    {
        try {

            Message msg[] = f.getMessages();
            //System.out.println("MAILING | Nombre de nouveaux messages : " + f.getNewMessageCount());
            System.out.println("MAILING | Nombre de messages : " + f.getMessageCount());
            if(f.getMessageCount() > 0)
            {
                return f.getMessageCount();
            }
        
        } catch (MessagingException ex) {
            System.out.println("MAILING | Erreur recup messages");
        }
        
        return 0;
    }
    private void ConnexionMail(String u, String p) {
        if(u.equals("admin") && p.equals("admin"))
        {
            Applic_Mailing app = new Applic_Mailing();
            app.setVisible(true);
        }
        else
        {
            prop = System.getProperties();
            System.out.println("SERVER MAILING | Création de la session mail");
            prop.put("mail.pop3.host", host);
            prop.put("mail.disable.top", "true");

            sess = Session.getDefaultInstance(prop, null);
            //prop.list(System.out);

            try
            {
                System.out.println("SERVER MAILING | Obtention d'un objet Store");
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
    }
private void Test(String u, String p) {
    String user = u, pwd = p;

    Properties prop = System.getProperties();
    System.out.println("MAILING | Création de la session mail");
    prop.put("mail.pop3.host", host);
    prop.put("mail.disable.top", "true");

    Session sess = Session.getDefaultInstance(prop, null);
    //prop.list(System.out);

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
            try
            {
                getHeader(msg);
            }
            catch(MessagingException | IOException e)
            {
                System.out.println("Erreur sur header list : " + e.getMessage());
            }
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
private void getHeader(Message msg[]) throws MessagingException, IOException {
    System.out.println("Liste des messages : ");
    for (int i=0; i<msg.length; i++)
    {
        System.out.println("\n<nHeaders du message n°" + (i+1));
        Enumeration e = msg[i].getAllHeaders();
        Header h = (Header)e.nextElement();
        while (e.hasMoreElements())
        {
        System.out.println(h.getName() + " --> " + h.getValue());
        h = (Header)e.nextElement();
        }
        System.out.println("Texte : " + (String)msg[i].getContent());
    } 
}
}
