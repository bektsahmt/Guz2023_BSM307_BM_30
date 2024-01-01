
package com.grup30.connection;


import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author ahmet
 */
public class DatabaseConnection {


    private static DatabaseConnection instance;
    private Connection connection;
    
    public static DatabaseConnection getInstance(){
        if(instance == null){
            instance = new DatabaseConnection();       
        }
        return instance;
    }
    
    private DatabaseConnection(){
        
    }
    
    public void connectToDatabase() throws SQLException {
        String server = "localhost";
        String port = "3306";
        String database = "chat";
        String username = "root";
        String password = "h6o73WQJ";
        connection =  java.sql.DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, username, password);
    }
    
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
