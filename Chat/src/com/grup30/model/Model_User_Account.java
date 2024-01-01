package com.grup30.model;

import java.time.Clock;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ahmet
 */

public class Model_User_Account {

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Model_User_Account(int userID, String userName,boolean status) {
        this.userID = userID;
        this.userName = userName;
  
        this.status = status;
    }

    public Model_User_Account(Object json) {
        JSONObject obj = (JSONObject) json;
            try{
                userID = obj.getInt("userID");
                userName = obj.getString("userName");
                status = obj.getBoolean("status");
            } catch(JSONException e){
                System.err.println(e);
            }
    }

    private int userID;
    private String userName;
    private boolean status;

}
