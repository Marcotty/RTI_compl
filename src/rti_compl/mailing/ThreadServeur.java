/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rti_compl.mailing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author fredm
 */
class ThreadServeur extends Thread{
    private ServerSocket socketServeur;
    private Socket CSocket;
    public ThreadServeur(ServerSocket s)
    {
        socketServeur = s;
    }
    public void run()
    {
        while(!isInterrupted())
        {
            try
            {
                System.out.println("SERVER MAILING | En attente de clients");
                CSocket = socketServeur.accept();
                ThreadClient client = new ThreadClient(CSocket);
                client.start();
            }
            catch(IOException e)
            {
                
            }
        }
    }
}
