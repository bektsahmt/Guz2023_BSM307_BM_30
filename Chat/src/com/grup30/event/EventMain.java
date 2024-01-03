
package com.grup30.event;

import com.grup30.model.Model_User_Account;

/**
 *
 * @author ahmet
 */
public interface EventMain { //Ana ekran ve UI olaylarını yönetiyor 
    
    public void showLoading(boolean show); //yüklenme olayını gösteriyor
    
    public void initChat(); //Sohbet arayüzünü başlatıyor
    
    public void selectUser(Model_User_Account user); //Sol menüden kullanıcının seçilmesini sağlıyor
    
    public void updateUser(Model_User_Account user); //kullanıcı durumu güncellediyorum
}
