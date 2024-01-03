
package com.grup30.event;

import com.grup30.model.Model_User_Account;
import java.util.List;

/**
 *
 * @author ahmet
 */
public interface EventMenuLeft { //Sol menü olaylarını yönetir
    
    public void newUser(List<Model_User_Account> users); //Yeni bir kullanıcı geldiğinde eklenmesi
    public void userConnect(int userID); //Kullanıcının bağlanması durumunda olacak değişiklik
    public void userDisconnect(int userID); // Kullanıcı çıktığı zaman olacak değişiklik
}
