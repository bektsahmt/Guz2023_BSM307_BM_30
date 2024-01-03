
package com.grup30.form;
import com.grup30.component.Chat_Body;
import com.grup30.component.Chat_Bottom;
import com.grup30.component.Chat_Title;
import com.grup30.event.EventChat;
import com.grup30.event.PublicEvent;
import com.grup30.model.Model_Recieve_Message;
import com.grup30.model.Model_Send_Message;
import com.grup30.model.Model_User_Account;
import net.miginfocom.swing.MigLayout;
/**
 *
 * @author ahmet
 */
public class Chat extends javax.swing.JPanel { 
//Bu sınıf sohbet penceremiz. İçerisinde aşağıdaki componentleri barındırıyor. 
    private Chat_Title chatTitle;
    private Chat_Body chatBody;
    private Chat_Bottom chatBottom;
    
    public Chat() { 
        initComponents();
        init();
    }
    private void init(){ //Sınıfın belirtilen ayarlarla başlatılması
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, bottom]0[shrink 0]"));
        chatTitle = new Chat_Title();
        chatBody = new Chat_Body();
        chatBottom = new Chat_Bottom();
        PublicEvent.getInstance().addEventChat(new EventChat() { //PublicEvent sınıfı addEventChat metoduyla EventChat
            @Override                                            //arayüzünü ekliyor.
            public void sendMessage(Model_Send_Message data) {
                chatBody.addItemRight(data); //Gönderilmiş mesaj sağa eklenecek.
            }

            @Override
            public void recieveMessage(Model_Recieve_Message data) {
                if(chatTitle.getUser().getUserID() == data.getFromUserID()){ //Eğer iki kullanıcının penceresi aynı anda açıksa
                    chatBody.addItemLeft(data); // mesajı sol kısma ekle.
                }
            }

        });
        add(chatTitle, "wrap");
        add(chatBody, "wrap");
        add(chatBottom,"h ::50%");
        
    }

    public void setUser(Model_User_Account user){
        chatTitle.setUserName(user);
        chatBottom.setUser(user);
        chatBody.clearChat(); //yeni bir kullanıcıyla konuştuğunda sohbetin silinmesi
    }
    
    public void updateUser(Model_User_Account user){ //yeni bir kullanıcı seçildiği zaman chatTitle'ın  yeni kullanıcıya göre güncellenmesi
        chatTitle.updateUser(user);
    }
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
