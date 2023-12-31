
package com.grup30.service;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.grup30.model.Model_Register;
import javax.swing.JTextArea;


public class Service {
    
    private static Service instance;
    private  SocketIOServer server;
    private JTextArea textArea;
    private final int PORT_NUMBER=9999;
    public static Service getInstance(JTextArea textArea)
    {
        if(instance==null)
        {
            instance=new Service(textArea);
        }
        return instance;
    }
    private Service(JTextArea textArea)
    {
                this.textArea =textArea;
    }
    public void startService()
    {
        Configuration config=new Configuration();
        config.setPort(PORT_NUMBER);
        server= new SocketIOServer(config);
        server.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient sıoc) 
            {
            textArea.append("one clint connected\n");
            }
        });
        server.addEventListener("register", Model_Register.class, new DataListener<Model_Register>() {
            @Override
            public void onData(SocketIOClient sıoc, Model_Register t, AckRequest ar) throws Exception {
                textArea.append("User Register :"+t.getUsername()+" pass :"+t.getPassword()+"\n");
            }
        });
        server.start();
        textArea.append("server has start on port : "+PORT_NUMBER+"\n");
    }
}
