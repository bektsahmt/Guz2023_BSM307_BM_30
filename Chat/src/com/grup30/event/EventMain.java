
package com.grup30.event;

import com.grup30.model.Model_User_Account;

/**
 *
 * @author ahmet
 */
public interface EventMain {
    
    public void showLoading(boolean show);
    
    public void initChat();
    
    public void selectUser(Model_User_Account user);
    
    public void updateUser(Model_User_Account user);
}
