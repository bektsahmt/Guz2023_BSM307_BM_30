
package com.grup30.service;

/**
 *
 * @author ahmet
 */

import com.grup30.event.PublicEvent;
import com.grup30.model.Model_Recieve_Message;
import com.grup30.model.Model_User_Account;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Service {

    

    private static Service instance;
    private Socket client;
    private final int PORT_NUMBER = 9999;
    private final String IP = "localhost";
    private Model_User_Account user;
    

    public static Service getInstance() { 
        if (instance == null) {
            instance = new Service(); //Service sınıfının yeni bir örneği instance değişkenine atanır.
        }
        return instance; //instance nesnesi dönecek 
    }

    private Service() { //Dışarıdan nesne oluşturulmasını engeller.
    }

    public void startServer() {
        try {
            client = IO.socket("http://" + IP + ":" + PORT_NUMBER); //Sunucuya bağlantı kurmak için soket nesnesi oluşturuldu
            client.on("list_user", new Emitter.Listener() { //"list_user" olayı dinlendi, sunucudan tetiklenmesi bekleniyor
                @Override
                public void call(Object... os) { // Tetikleneceği zaman çalışacağı kısım
                    List<Model_User_Account> users = new ArrayList<>();
                    for(Object o:os){ 
                        Model_User_Account u = new Model_User_Account(o);
                        if(u.getUserID() != user.getUserID()){ //userID kontrolü yapılacak aynı değilse
                            users.add(u); //Eğer kullanıcı farklı ise bu yeni bir kullanıcı ise users listesine eklenecek.
                        }
                    }
                    PublicEvent.getInstance().getEventMenuLeft().newUser(users); //Yeni kullanıcı sol tarafa eklendi
                }
            });
            client.on("user_status", new Emitter.Listener() { //"user_status" olayı dinlendi, sunucudan tetiklenmesi bekleniyor.
                @Override
                public void call(Object... os) { //os sunucudan gönderilen verileri içerir
                    int userID = (Integer) os[0]; //ilk veri userID
                    boolean status = (Boolean) os[1]; //ikinci veri aktiflik statüsü
                    if(status){ //true ise kullanıcı bağlı kabul edilecek
                        //Bağlan
                        PublicEvent.getInstance().getEventMenuLeft().userConnect(userID);
                    } else { //false ise bağlı değil kabul edilecek
                        //Bağlantı kopuk
                        PublicEvent.getInstance().getEventMenuLeft().userDisconnect(userID);
                    }
                }
            });
            client.on("recieve_ms", new Emitter.Listener() { //Kullanıcıdan mesaj alınmasını sağlar.
                @Override
                public void call(Object... os) {
                    Model_Recieve_Message message = new Model_Recieve_Message(os[0]);
                    PublicEvent.getInstance().getEventChat().recieveMessage(message);
                }
            });
            client.open(); //İstemcinin sunucuya bağlanması sağlanır.
        } catch (URISyntaxException e) {
            error(e);
        }
    }

    public Socket getClient() { //Başka bir sınıf kullanarak sunucuya veri gönderme, olay dinleme yapabilir.
        return client;
    }
    
    public Model_User_Account getUser() {
        return user;
    }
    public void setUser(Model_User_Account user) {
        this.user = user;
    }

    private void error(Exception e) {
        System.err.println(e);
    }

    
}
