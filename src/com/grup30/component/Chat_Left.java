
package com.grup30.component;

import java.awt.Color;
import javax.swing.Icon;

public class Chat_Left extends javax.swing.JLayeredPane {


    public Chat_Left() {
        initComponents();
        txt.setBackground(new Color(242,242,242));
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
     public void setImage(String... image){
        txt.setImage(false, image);
    }
    
     public void setFile(String fileName, String fileSize){
        txt.setFile(fileName, fileSize);
    }
    public void setTime(){
        txt.setTime("4:23 PM"); // Saat sonradan eklenecek.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new com.grup30.component.Chat_Item();

        setLayer(txt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.grup30.component.Chat_Item txt;
    // End of variables declaration//GEN-END:variables
}
