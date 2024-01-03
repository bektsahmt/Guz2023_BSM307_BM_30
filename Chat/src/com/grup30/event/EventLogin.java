
package com.grup30.event;

import com.grup30.model.Model_Login;
import com.grup30.model.Model_Register;

/**
 *
 * @author ahmet
 */
public interface EventLogin { //Login ve Register 
    
    public void login(Model_Login data); //giriş yapmak için

    public void register(Model_Register data, EventMessage message); //kayıt olma olayı için

    public void goRegister();

    public void goLogin();
}
