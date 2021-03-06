/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * Sets up connection and provides for db query
 */
public class DbConnection {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private String userName;
    private String password;
    
    public void connect() throws Exception {
        try {
            /*
          connection = DriverManager.getConnection("jdbc:mysql:sql3.freemysqlhosting.net",
                  "sql368756", "qG6%pU4%");
            */
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database",
                  "root", "password");
        } catch (SQLException ex) {
            connection.close();
            System.out.println("connection failed");
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet selectDataColumn(String table, String column, String identifier ) {
        ResultSet results = null;
        try {
            Statement statement = connection.createStatement();
            results = statement.executeQuery("SELECT + " + column  + " "
                    + " + FROM "+ table + " WHERE " + identifier);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
    public boolean login(String userName, String password) {
        boolean answer = false;
        this.userName = userName;
        this.password = password;
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT 1 FROM USER WHERE Uname = " 
                    + userName + " and Password = " + password); 
            if(results.first())
                answer = true;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return answer;
    }
     
}
