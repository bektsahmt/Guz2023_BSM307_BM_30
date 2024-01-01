package com.grup30.service;

import com.grup30.connection.DatabaseConnection;
import com.grup30.model.Model_Message;
import com.grup30.model.Model_Register;
import com.grup30.model.Model_User_Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceUser {

    public ServiceUser() {
        this.con = DatabaseConnection.getInstance().getConnection();
    }

    public Model_Message register(Model_Register data) {
        //  Check user exit
        Model_Message message = new Model_Message();
        try {
            PreparedStatement p = con.prepareStatement(CHECK_USER);
            p.setString(1, data.getUserName());
            ResultSet r = p.executeQuery();
            if (r.next()) {
                message.setAction(false);
                message.setMessage("User Already Exit");
            } else {
                message.setAction(true);
            }
            r.close();
            p.close();
            if (message.isAction()) {
                //  Insert User Register
                con.setAutoCommit(false);
                p = con.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
                p.setString(1, data.getUserName());
                p.setString(2, data.getPassword());
                p.execute();
                r = p.getGeneratedKeys();
                r.first(); // Hata alma durumunda buraya bi bak.
                int userID = r.getInt(1);
                r.close();
                p.close();
                // Kullanıcı hesabı oluşturma
                p = con.prepareStatement(INSERT_USER_ACCOUNT);
                p.setInt(1, userID);
                p.setString(2, data.getUserName());
                p.execute();
                p.close();
                con.commit();
                con.setAutoCommit(true);
                message.setAction(true);
                message.setMessage("Ok");
                message.setData(new Model_User_Account(userID, data.getUserName(), true));
            }
        } catch (SQLException e) {
            message.setAction(false);
            message.setMessage("Server Error");
            try{
                if(con.getAutoCommit() == false){
                   con.rollback();
                   con.setAutoCommit(true);
                }
            } catch(SQLException e1){   
            }
        }
        return message;
    }
    
    public List<Model_User_Account> getUser(int existUser) throws SQLException{
        List<Model_User_Account> list = new ArrayList<>();
        PreparedStatement p = con.prepareStatement(SELECT_USER_ACCOUNT);
        p.setInt(1, existUser);
        ResultSet r = p.executeQuery();
        while (r.next()) {
            int userID = r.getInt(1);
            String userName = r.getString(2);
            list.add(new Model_User_Account(userID, userName,true));
        }
        r.close();
        p.close();
        return list;
    }

    //  SQL
    private final String SELECT_USER_ACCOUNT = "select UserID, UserName from user_account where user_account.`Status`='1' and UserID<>?";
    private final String INSERT_USER = "insert into user (UserName, `Password`) values (?,?)";
    private final String INSERT_USER_ACCOUNT = "insert into user_account (UserID, UserName) values(?,?)";
    private final String CHECK_USER = "select UserID from user where UserName =? limit 1";
    //  Instance
    private final Connection con;
}
