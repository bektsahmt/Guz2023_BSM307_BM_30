
package com.grup30.event;

import com.grup30.model.Model_Message;

/**
 *
 * @author ahmet
 */
public interface EventMessage { //Mesajın olaylarını yönetecek.
    public void callMessage(Model_Message message); //bir mesaj gönderilmesini veya yönetilmesini sağlayacak.
}
