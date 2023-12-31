
package com.grup30.model;

import org.json.JSONException;
import org.json.JSONObject;


public class Model_Register {
    private String username;
    private String password;

    
    public String getUsername() {
        return username;
    }

    
    

    
    public String getPassword() {
        return password;
    }

    public Model_Register() {
    }

    public Model_Register(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    public JSONObject toJsonObject()
    {
        try {
            JSONObject json= new JSONObject();
     json.put("username",username);
     json.put("password",password);
     return json;
        } catch (JSONException e) {
            return null;
        }
    }
}
