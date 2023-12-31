
package com.grup30.component;

import java.awt.Color;

/**
 *
 * @author ahmet
 */
public class Chat_Title extends javax.swing.JPanel {

    
    public Chat_Title() {
        initComponents();
    }
    
    public void setUsername(String username){
        lblName.setText(username);
    }
    
    public void statusActive(){
        lblStatus.setText("Çevrimiçi");
        lblStatus.setForeground(new java.awt.Color(40,147,59));
    }
    
    public void setStatusText(String text){
        lblStatus.setText(text);
        lblStatus.setForeground(new Color(160,160,160));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer = new javax.swing.JLayeredPane();
        lblName = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 238, 243));

        layer.setOpaque(true);
        layer.setLayout(new java.awt.GridLayout(0, 1));

        lblName.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(66, 66, 66));
        lblName.setText("Kullanıcı11111111111111111111111111111");
        layer.add(lblName);

        lblStatus.setForeground(new java.awt.Color(40, 147, 59));
        lblStatus.setText("Çevrimiçi");
        layer.add(lblStatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(layer, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(layer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane layer;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
