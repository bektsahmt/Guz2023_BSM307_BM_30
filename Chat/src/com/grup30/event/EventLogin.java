
package com.grup30.event;

import com.grup30.model.Model_Register;

/**
 *
 * @author ahmet
 */
public interface EventLogin {
    
    public void login();

    public void register(Model_Register data, EventMessage message);

    public void goRegister();

    public void goLogin();
}
