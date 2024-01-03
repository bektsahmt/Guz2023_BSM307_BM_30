package com.grup30.model;

/**
 *
 * @author ahmet
 */
public class Model_Message { //Bir eylemi temsil eden action ile eylemle ilgili mesajı içeren bir model sınıfı

    public boolean isAction() {
        return action;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Model_Message(boolean action, String message) {
        this.action = action;
        this.message = message;
    }

    public Model_Message() {
    }

    private boolean action;
    private String message;
}
