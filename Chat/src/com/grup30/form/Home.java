
package com.grup30.form;

import com.grup30.model.Model_User_Account;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author ahmet
 */
public class Home extends javax.swing.JLayeredPane { 
                                                     
    private Chat chat;
    public Home() {
        initComponents();
        init();
    }
    
    private void init(){ //Menünün sağ kısmını ve chati ekler.
        setLayout(new MigLayout("fillx, filly","0[160!]5[fill, 100%]5[]0","0[fill]0"));
        this.add(new Menu_left());
        chat = new Chat();
        this.add(chat);
        chat.setVisible(false);
    }

    public void setUser(Model_User_Account user){ 
        chat.setUser(user); //Belirtilen kullanıcı bilgisinin eklenmesi
        chat.setVisible(true);
    }
    
    public void updateUser(Model_User_Account user){ //Kullanıcı bilgisinin yenilenmesi
        chat.updateUser(user);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 728, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
