
package com.grup30.model;

/**
 *
 * @author ahmet
 */
public class Model_Login {

    
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
}
