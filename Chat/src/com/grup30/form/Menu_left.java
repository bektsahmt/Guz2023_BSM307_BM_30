
package com.grup30.form;

import com.grup30.component.Item_People;
import com.grup30.event.EventMenuLeft;
import com.grup30.event.PublicEvent;
import com.grup30.model.Model_User_Account;
import com.grup30.swing.ScrollBar;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import net.miginfocom.swing.MigLayout;


public class Menu_left extends javax.swing.JPanel {

    private List<Model_User_Account> userAccount;
 
    public Menu_left() {
        initComponents();
        init();
    }
    
    private void init(){
        sp.setVerticalScrollBar(new ScrollBar());
        menuList.setLayout(new MigLayout("fillx","0[]0","0[]0"));
        userAccount = new ArrayList<>();
        PublicEvent.getInstance().addEventMenuLeft(new EventMenuLeft() { 
            @Override
            public void newUser(List<Model_User_Account> users) { //Yeni bir kullanıcı geldiğinde kullanıcı listesine
                for(Model_User_Account d:users){                //ekleniyor ve gösteriliyor.
                    userAccount.add(d);
                    menuList.add(new Item_People(d), "wrap");
                    refreshMenu();
                }
            }

            @Override
            public void userConnect(int userID) { //Kullanıcının bağlantı durumunun güncellenmesi
                for(Model_User_Account u: userAccount){
                    if(u.getUserID() == userID){
                        u.setStatus(true);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if(menuMessage.isSelected()){
                    for(Component com: menuList.getComponents()){ //menuList'in içindeki alt bileşenler geziliyor
                        Item_People item = (Item_People) com;
                        if(item.getUser().getUserID() == userID){
                            item.updateStatus(); //eğer parametre olarak alınan userID ile eşleşiyorsa update et
                            break;
                        }
                    }    
                }
            }

            @Override
            public void userDisconnect(int userID) {
                for (Model_User_Account u : userAccount) {
                    if (u.getUserID() == userID) {
                        u.setStatus(false);
                        PublicEvent.getInstance().getEventMain().updateUser(u);
                        break;
                    }
                }
                if (menuMessage.isSelected()) {
                    for (Component com : menuList.getComponents()) {
                        Item_People item = (Item_People) com;
                        if (item.getUser().getUserID() == userID) {
                            item.updateStatus();
                            break;
                        }
                    }
                }
            }
            
            
            
        });
        showMessage();
    }
    
    private void showMessage(){
        menuList.removeAll();
        for (Model_User_Account d: userAccount) {
            menuList.add(new Item_People(null), "wrap");
        }
        refreshMenu();
    }
    
 
    private void refreshMenu(){
        menuList.repaint();
        menuList.revalidate();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JLayeredPane();
        menuMessage = new com.grup30.component.MenuButton();
        sp = new javax.swing.JScrollPane();
        menuList = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(244, 244, 244));

        menu.setBackground(new java.awt.Color(229, 229, 229));
        menu.setOpaque(true);
        menu.setLayout(new java.awt.GridLayout(1, 3));

        menuMessage.setBorder(null);
        menuMessage.setIconSelected(new javax.swing.ImageIcon(getClass().getResource("/com/grup30/icons/message_selected_.png"))); // NOI18N
        menuMessage.setIconSimple(new javax.swing.ImageIcon(getClass().getResource("/com/grup30/icons/message.png"))); // NOI18N
        menuMessage.setMaximumSize(new java.awt.Dimension(50, 50));
        menuMessage.setSelected(true);
        menuMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMessageActionPerformed(evt);
            }
        });
        menu.add(menuMessage);

        sp.setBackground(new java.awt.Color(244, 244, 244));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setToolTipText("");

        menuList.setBackground(new java.awt.Color(244, 244, 244));
        menuList.setOpaque(true);

        javax.swing.GroupLayout menuListLayout = new javax.swing.GroupLayout(menuList);
        menuList.setLayout(menuListLayout);
        menuListLayout.setHorizontalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        menuListLayout.setVerticalGroup(
            menuListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
        );

        sp.setViewportView(menuList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menuMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMessageActionPerformed
        if(!menuMessage.isSelected()){
            menuMessage.setSelected(true);         
            showMessage();
        }
    }//GEN-LAST:event_menuMessageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane menu;
    private javax.swing.JLayeredPane menuList;
    private com.grup30.component.MenuButton menuMessage;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
