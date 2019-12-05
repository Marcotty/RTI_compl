/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rti_2.client;

import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTextField;
import rti_2.checkinap.ReponseCHECKINAP;
import rti_2.checkinap.RequeteCHECKINAP;
import static rti_2.network.NetworkLibrary.EnvoyerRequete;
import static rti_2.network.NetworkLibrary.RecevoirReponse;
import static rti_2.network.NetworkLibrary.RecevoirRequete;

/**
 *
 * @author fredm
 */
public class ThreadMailing extends Thread{
    private Socket CSocket;
    private JTextField TFMail;
    private JButton BVoir;
    ThreadMailing(Socket cliSockMail, JTextField TFMail, JButton BVoir) {
        CSocket = cliSockMail;
        this.TFMail = TFMail;
        this.BVoir = BVoir;
    }
    public void run()
    {
        while(!isInterrupted())
        {
            AttenteRequete();
        }
    }

    private void AttenteRequete() {
        
        RequeteCHECKINAP req = RecevoirRequete(CSocket);
        if(req.type == RequeteCHECKINAP.NEW_MAIL)
        {
            System.out.println("CLIENT | " + req.getChargeUtile() + "nouveaux mails");
            TFMail.setText(req.getChargeUtile() + "mails");
        }
        else if(req.type == RequeteCHECKINAP.LIST_MAILS)
        {
            System.out.println("CLIENT | List des mails reçu");
            
            String mails = req.getChargeUtile();
            //mails = "hello#stage#bonjour";
            Vector vect = new Vector();
            StringTokenizer parser = new StringTokenizer(mails, "#");
            while(parser.hasMoreTokens())
                vect.add(parser.nextToken());
            //JLMail.setListData(vect);
            ListMailing list = new ListMailing();
            list.setVisible(true);
            list.setData(vect);
        }
    }

    void getMessages() {
        //ListMailing list = new ListMailing();
        //list.setVisible(true);
        
        System.out.println("LISTMAIL | envoy requete listmails");
        EnvoyerRequete(CSocket, RequeteCHECKINAP.LIST_MAILS, "");
        /*ReponseCHECKINAP rep = null; 
        rep = RecevoirReponse(CSocket);
        if(rep.GetCode() == ReponseCHECKINAP.LIST_MAILS)
        {
            System.out.println("LISTMAIL | recept reponse LIST Mails");
            String mails = rep.getChargeUtile();
            Vector vect = new Vector();
            StringTokenizer parser = new StringTokenizer(mails, "#");
            while(parser.hasMoreTokens())
                vect.add(parser.nextToken());
            //JLMail.setListData(vect);
            list.setData(vect);
        }
                */
    }
}
