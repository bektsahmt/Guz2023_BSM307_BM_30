
package com.grup30.model;

/**
 *
 * @author ahmet
 */
public class Model_Send_Message {

    
    public int getFromUserID() {
        return fromUserID;
    }

    
    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    
    public int getToUserID() {
        return toUserID;
    }

    
    public void setToUserID(int toUserID) {
        this.toUserID = toUserID;
    }

    
    public String getText() {
        return text;
    }

    
    public void setText(String text) {
        this.text = text;
    }

    public Model_Send_Message() {
    }

    public Model_Send_Message(int fromUserID, int toUserID, String text) {
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.text = text;
    }
    
            
    private int fromUserID;
    private int toUserID;
    private String text;
}
