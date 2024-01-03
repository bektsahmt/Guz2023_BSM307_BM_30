
package com.grup30.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ahmet
 */
public class Model_Recieve_Message { //Mesaj alma işlemi

    
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

    public Model_Recieve_Message(Object json) {  
        JSONObject obj = (JSONObject) json;     //Bir json nesnesi kabul ediyor
        try {                                   //bu parametreyi JSONObject'e dönüştürüyor. Gelen bu json nesnesini
            fromUserID = obj.getInt("fromUserID");  //fromUserID ve text şeklinde ayrıştırmayı sağlıyor.
            text = obj.getString("text");
        } catch (JSONException e) {
            System.err.println(e);
        }
    }

    public Model_Recieve_Message(int fromUserID, String text) {
        this.fromUserID = fromUserID;
        this.text = text;
    }
    
    private int fromUserID;
    private String text;
    
    public JSONObject toJsonObject(){
        try {
            JSONObject json = new JSONObject();
            json.put("fromUserID", getFromUserID());
            json.put("text", getText());
            return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
