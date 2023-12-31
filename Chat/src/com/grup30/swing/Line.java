
package com.grup30.swing;

import java.awt.Graphics;
import javax.swing.JLabel;

/**
 *
 * @author ahmet
 */
public class Line extends JLabel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.setColor(getForeground());
        g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
    }
    
}
