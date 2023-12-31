
package com.grup30.connection;

import java.sql.SQLException;
import java.sql.Connection;

public class DatabaseConnection 
{
    private static DatabaseConnection instace;
   private Connection connectioan;
   
    public static DatabaseConnection getInsatace()
    {
        if (instace==null)
        {
         instace=new DatabaseConnection();   
        }
       return instace; 
    }
    
    private DatabaseConnection()
    {
    }
    public void connectToDatabase() throws SQLException {
        String server="localhost";
        String port="3306";
        String database="chat_aplication";
        String userName ="root";
        String password="";
        setConnectioan(java.sql.DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+database, userName, password));
        
    }

    
    public Connection getConnectioan() {
        return connectioan;
    }

    public void setConnectioan(Connection connectioan) {
        this.connectioan = connectioan;
    }
}
