
package com.grup30.component;

/**
 *
 * @author tuğçe
 */
public class Chat_File extends javax.swing.JPanel {

    
    public Chat_File() {
        initComponents();
        setOpaque(false);
        
    }
    public void setFile(String fileName, String size){
        IbFileName.setText(fileName);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progress1 = new com.grup30.swing.Progress();
        jPanel1 = new javax.swing.JPanel();
        IbFileName = new javax.swing.JLabel();
        IbFileSize = new javax.swing.JLabel();

        progress1.setProgressType(com.grup30.swing.Progress.ProgressType.FILE);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        IbFileName.setText("My File Name.file");
        jPanel1.add(IbFileName);

        IbFileSize.setBackground(new java.awt.Color(214, 217, 223));
        IbFileSize.setForeground(new java.awt.Color(137, 121, 218));
        IbFileSize.setText("5 MB");
        jPanel1.add(IbFileSize);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progress1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(progress1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IbFileName;
    private javax.swing.JLabel IbFileSize;
    private javax.swing.JPanel jPanel1;
    private com.grup30.swing.Progress progress1;
    // End of variables declaration//GEN-END:variables
}
