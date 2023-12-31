
package com.grup30.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import javax.swing.Icon;
import javax.swing.JButton;

public class MenuButton extends JButton{

    
    public Icon getIconSelected() {
        return iconSelected;
    }

    
    public void setIconSelected(Icon iconSelected) {
        this.iconSelected = iconSelected;
    }

    
    public Icon getIconSimple() {
        return iconSimple;
    }

    
    public void setIconSimple(Icon iconSimple) {
        this.iconSimple = iconSimple;
    }
    
    private Icon iconSelected;
    private Icon iconSimple;

    public MenuButton() {
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void setSelected(boolean b) {
        super.setSelected(b); 
        if(b){
            setIcon(iconSelected);
        } else{
            setIcon(iconSimple);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(isSelected()){
            g.setColor(new Color(252, 182, 209));
            g.fillRect(0, getHeight()-3, getWidth(), getHeight());
        }
    }
    
    
    
}
