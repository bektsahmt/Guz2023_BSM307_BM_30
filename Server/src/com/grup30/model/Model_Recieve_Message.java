
package com.grup30.model;

/**
 *
 * @author ahmet
 */
public class Model_Recieve_Message {

    
    public int getFromUserID() {
        return fromUserID;
    }

    
    public void setFromUserID(int fromUserID) {
        this.fromUserID = fromUserID;
    }

    
    public String getText() {
        return text;
    }

    
    public void setText(String text) {
        this.text = text;
    }

    public Model_Recieve_Message() {
    
    }

    public Model_Recieve_Message(int fromUserID, String text) {
        this.fromUserID = fromUserID;
        this.text = text;
    }
    
    private int fromUserID;
    private String text;
    
}
