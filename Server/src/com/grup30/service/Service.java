
package com.grup30.service;

import com.corundumstudio.socketio.AckRequest;  //Soket.IO olaylarının alındığını onaylamak için
import com.corundumstudio.socketio.Configuration;  //Socket.IO sunucusunun genel yapılandırma ayarlarını içerir.
import com.corundumstudio.socketio.SocketIOClient;  //Bu sınıf, Soket.IO sunucusu ile iletişimde olan bir istemciyi temsil eder. 
import com.corundumstudio.socketio.SocketIOServer;  //Bu sınıf, Socket.IO sunucusunu temsil eder.
import com.corundumstudio.socketio.listener.ConnectListener;  //Bu listener, istemcinin sunucuya bağlandığı zaman gerçekleşen olayları dinlemek için kullanılır.
import com.corundumstudio.socketio.listener.DataListener;  //Bu listener, belirli bir veri olayının gerçekleştiği zaman gerçekleşen olayları dinlemek için kullanılır. 
import com.corundumstudio.socketio.listener.DisconnectListener;  //Bir istemcinin sunucudan bağlantısını kestiği zaman gerçekleşen olayları dinlemek için kullanılır. 
import com.grup30.model.Model_Client;
import com.grup30.model.Model_Login;
import com.grup30.model.Model_Message;
import com.grup30.model.Model_Recieve_Message;
import com.grup30.model.Model_Register;
import com.grup30.model.Model_Send_Message;
import com.grup30.model.Model_User_Account;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;

/**
 *
 * @author ahmet
 */

// Socket.IO sunucu uygulaması

public class Service {

    

    private static Service instance; //instance adında static değişken kullanılarak singleton tasarım deseni uygulanmıştır. 
    //Sadece bir tane service oluşturulmasını sağlar
    private SocketIOServer server;
    private ServiceUser serviceUser;
    private List<Model_Client> listClient;
    private JTextArea textArea; //GUI tarafından kullanıcıya sunulan metin alanı
    private final int PORT_NUMBER = 9999;

    public static Service getInstance(JTextArea textArea) {
        if (instance == null) {
            instance = new Service(textArea);
        }
        return instance;
    }

    private Service(JTextArea textArea) {
        this.textArea = textArea;
        serviceUser = new ServiceUser();
        listClient = new ArrayList<>();
    }

    public void startServer() {  //Soket.IO sunucuyu başlatmak ve dinlemek için 
        Configuration config = new Configuration(); //Netty kütüphanesi Configuration sınıfı kullanılarak yapılandırma ayarları belirlenir.
        config.setPort(PORT_NUMBER);  //istemciler belirtilen port üerinden sunucuya bağlanır
        server = new SocketIOServer(config);
        server.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient sioc) {  // sioc nesnesi aracılığıyla stemci ile etkileşimde bulunabilir ve istemciye özgü bilgileri alabilirsiniz.
                textArea.append("One client connected\n");
            }
        });
        server.addEventListener("register", Model_Register.class, new DataListener<Model_Register>() {  //sunucuya bağlantı olayı dinleyicisi eklenir
            @Override
            public void onData(SocketIOClient sioc, Model_Register t, AckRequest ar) throws Exception {
                Model_Message message = serviceUser.register(t);
                ar.sendAckData(message.isAction(), message.getMessage(), message.getData());
                if(message.isAction()){
                    textArea.append("User has Register :" + t.getUserName() + " Pass :" + t.getPassword() + "\n");
                    server.getBroadcastOperations().sendEvent("list_user", (Model_User_Account)message.getData());
                    addClient(sioc, (Model_User_Account) message.getData());
                }
            }
        });
        server.addEventListener("login", Model_Login.class, new DataListener<Model_Login>() {  // login olay dinleyicisi eklenir
            @Override
            public void onData(SocketIOClient sioc, Model_Login t, AckRequest ar) throws Exception {
                Model_User_Account login = serviceUser.login(t);
                if(login != null){
                    ar.sendAckData(true, login);  //başarılı giriş yapıldığında onay mesajı
                    addClient(sioc,login);  //istemci listesine yeni eleman eklenir
                    userConnect(login.getUserID());  //diğer istemcilere kullanıcının çevrimiçi olduğu belirtilir
                } else {
                    ar.sendAckData(false);  //başarısız giriş mesajı
                }
            }
        });
        server.addEventListener("list_user", Integer.class, new DataListener<Integer>(){  //belirli bir kullanıcıdan bağlantı noktası hariç tüm kullanıcıları istemciye getirir
            @Override
            public void onData(SocketIOClient sioc, Integer userID, AckRequest ar) throws Exception{
                try {
                    List<Model_User_Account> list = serviceUser.getUser(userID);
                    sioc.sendEvent("list_user", list.toArray());                  
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        });
        server.addEventListener("send_to_user", Model_Send_Message.class, new DataListener<Model_Send_Message>() {  //kullanıcıdan gelen mesajı dinler
            @Override
            public void onData(SocketIOClient sioc, Model_Send_Message t, AckRequest ar) throws Exception {
                sendToClient(t); // gelen mesajı diğer kullanıcıya iletir
                
            }
        });
        server.addDisconnectListener(new DisconnectListener() {  //istemcilerin bağlantılarının kesilmesini dinler
            @Override
            public void onDisconnect(SocketIOClient sioc) {
                int userID = removeClient(sioc);  // client nesnesini listeden kaldırır
                if(userID != 0){
                    userDisconnect(userID);  //kullanıcının durumu güncellenir ve diğer kullanıcılara bildirilir
                }
            }
        });
        server.start();  // sunucu başlatılır
        textArea.append("Server has Start on port : " + PORT_NUMBER + "\n");  // başlatılma mesajı arayüze eklendi
    }
    
    private void userConnect(int userID){
        server.getBroadcastOperations().sendEvent("user_status", userID, true);  // kullanıcının bağlandığını tüm istemcilere belirtir
    }
    
    private void userDisconnect(int userID){
        server.getBroadcastOperations().sendEvent("user_status", userID, false);  // kullanıcının bağlantısının kesildiğini diğer tüm istemcilere belirtir
    }
    
    private void addClient(SocketIOClient client, Model_User_Account user){
        listClient.add(new Model_Client(client, user));
    }
    
    private void sendToClient(Model_Send_Message data){  //kullanıcılar arasında mesaj gönderimi
        for(Model_Client c:listClient){
            if(c.getUser().getUserID() == data.getToUserID()){  // istemcinin kullanıcı kimliği ile gönderilmek istenen verinin toUsherID özelliğinin aynılığını kontrol
                c.getClient().sendEvent("recieve_ms", new Model_Recieve_Message(data.getFromUserID(), data.getText()));
                break;
            }
        }
    }
    
    public int removeClient(SocketIOClient client){  //istemci bağlantısı sona erdiğinde istemci bilgilerinin listeden kaldırılması
        for(Model_Client d: listClient){
            if(d.getClient()== client){
                listClient.remove(d);
                return d.getUser().getUserID();
            }
        }
        return 0;
    }
    
    public List<Model_Client> getListClient() {
        return listClient;
    }
}
