
package com.grup30.component;

import com.grup30.swing.ScrollBar;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author ahmet
 */
public class Chat_Body extends javax.swing.JPanel {


    public Chat_Body() {
        initComponents();
        init();
        addItemLeft("Merhabalar! LDJKSFKJDFHGKJDFHGKDJHFGKJDFHGKJHDFKGJHDKFJHGKDJHFGKJDHFGKJFJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ","Ahmet");
        addItemLeft("Merhabalar! LDJKSFKJDFHGKJDFHGKDJHFGKJDFHGKJHDFKGJHDKFJHGKDJHFGKJDHFGKJFJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ","Ahmet");
        addItemRight("Merhabalar! LDJKSFKJDFHGKJDFHGKDJHFGKJDFHGKJHDFKGJHDKFJHGKDJHFGKJDHFGKJFJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ",new ImageIcon(getClass().getResource("/com/grup30/icons/cat.jpeg")));
        addDate("25.12.2023");
        addItemLeft("Merhabalar! LDJKSFKJDFHGKJDFHGKDJHFGKJDFHGKJHDFKGJHDKFJHGKDJHFGKJDHFGKJFJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ","Ahmet",
            new ImageIcon(getClass().getResource("/com/grup30/icons/cat.jpeg")), new ImageIcon(getClass().getResource("/com/grup30/icons/cat.jpeg")));
        addItemLeft("Merhabalar! LDJKSFKJDFHGKJDFHGKDJHFGKJDFHGKJHDFKGJHDKFJHGKDJHFGKJDHFGKJFJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ","Ahmet");
        addItemLeft("","Ahmet",new ImageIcon(getClass().getResource("/com/grup30/icons/cat.jpeg")) );
        
    }   
        
    
    private void init(){
        body.setLayout(new MigLayout("fillx","","5[]5"));
        sp.setVerticalScrollBar(new ScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
    }
    
    public void addItemLeft(String text, String user,Icon... image){
        Chat_Left_With_Profile item = new Chat_Left_With_Profile();
        item.setText(text);
        item.setImage(image);
        item.setTime();
        item.setUserProfile(user);
        body.add(item,"wrap, w :: 80% ");
        body.repaint();
        body.revalidate();
    }
    
    public void addItemRight(String text, Icon... image){
        Chat_Right item = new Chat_Right();
        item.setText(text);
        item.setImage(image);
        item.setTime();
        body.add(item,"wrap,al right, w :: 80% ");
        body.repaint();
        body.revalidate();
    }
    
    public void addDate(String date){
        Chat_Date item = new Chat_Date();
        item.setDate(date);
        body.add(item,"wrap, al center");
        body.repaint();
        body.revalidate();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
