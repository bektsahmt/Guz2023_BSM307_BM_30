package com.grup30.model;

/**
 *
 * @author ahmet
 */
import org.json.JSONException;
import org.json.JSONObject;

public class Model_Register { //Kullanıcı kaydı ile ilgili verileri temsil etmek ve bu verileri JSON formatına dönüştürmek
                              //için kullanılacak.

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Model_Register(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Model_Register() {
    }

    private String userName;
    private String password;

    public JSONObject toJsonObject() {
        try {
            JSONObject json = new JSONObject();
            json.put("userName", userName);
            json.put("password", password);
            return json;
        } catch (JSONException e) {
            return null;
        }
    }

}
