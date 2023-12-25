
package com.grup30.component;

import java.awt.Color;
import javax.swing.Icon;

public class Chat_Left_With_Profile extends javax.swing.JLayeredPane {


    public Chat_Left_With_Profile() {
        initComponents();
        txt.setBackground(new Color(242,242,242));
    }
    
    public void setUserProfile(String user){
        txt.setUserProfile(user);
    }
    
    public void setImageProfile(Icon image){
        img.setImage(image);
    }
    
    public void setText(String text){
        if(text.equals("")){
            txt.hideText();
        } else {
            txt.setText(text);
        }
    }
    
    public void setImage(Icon... image){
        txt.setImage(false, image);
    }
    
    public void setTime(){
        txt.setTime("4:23 PM"); // Saat sonradan eklenecek.
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        img = new com.grup30.swing.ImageAvatar();
        txt = new com.grup30.component.Chat_Item();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        img.setBorderSize(2);
        img.setImage(new javax.swing.ImageIcon(getClass().getResource("/com/grup30/icons/cat.jpeg"))); // NOI18N
        img.setMaximumSize(new java.awt.Dimension(31, 31));
        img.setMinimumSize(new java.awt.Dimension(31, 31));

        jLayeredPane1.setLayer(img, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jLayeredPane1);
        add(txt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.grup30.swing.ImageAvatar img;
    private javax.swing.JLayeredPane jLayeredPane1;
    private com.grup30.component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
