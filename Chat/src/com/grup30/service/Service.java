
package com.grup30.service;

import io.socket.client.IO;
import io.socket.client.Socket;
import javax.swing.JTextArea;


public class Service {

   
   
    
    private static Service instance;
    private  Socket client;
    private final int PORT_NUMBER=9999;
    private final String IP="localhost";
    public static Service getInstance()
    {
        if(instance==null)
        {
            instance=new Service();
        }
        return instance;
    }
    private Service()
    {
    }
    public void startService()
    {        
        try {
            client= IO.socket("http://"+IP+":"+PORT_NUMBER);
            client.open();
        } catch (Exception e) {
            error(e);
        }
            
    }
     public Socket getClient() {
        return client;
    }
    private void error(Exception e)
    {
        System.out.println(e);
    }
}
