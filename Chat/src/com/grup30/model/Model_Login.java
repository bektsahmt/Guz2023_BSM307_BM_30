
package com.grup30.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ahmet
 */
public class Model_Login { //Kullanıcı giriş bilgilerini içeren bir model sınıfı

    
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

    public Model_Login() {
    }

    public Model_Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    
    private String userName;
    private String password;
    
    public JSONObject toJsonObject(){ //JSONObject 
        try {
            JSONObject obj = new JSONObject();
            obj.put("userName",userName);
            obj.put("password", password);
            return obj;
        } catch (JSONException e) {
            return null;
        }
    }
}
