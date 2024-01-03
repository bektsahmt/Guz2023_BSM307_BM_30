
package com.grup30.event;

import com.grup30.model.Model_Recieve_Message;
import com.grup30.model.Model_Send_Message;

/**
 *
 * @author tuğçe
 */
public interface EventChat { //mesajlaşma olayları
    
    public void sendMessage(Model_Send_Message data);  
    
    public void recieveMessage(Model_Recieve_Message data);
}
