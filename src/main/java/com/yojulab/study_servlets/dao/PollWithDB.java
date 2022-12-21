package com.yojulab.study_servlets.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.sql.SQLException;



public class PollWithDB {
public void getQuestion(String questionUid) throws SQLException{
  
        Commons commons = new Commons();
        Statement statement = commons.getStatement(); 
  
        String query = "SELECT * FROM QUESTIONS_LIST" +    
                         "WHERE QUESTIONS_UID = '"+questionUid+"'";              
   
        ResultSet resultSet = statement.executeQuery(query);
        HashMap<String,Object> result;
        while(resultSet.next());    
         resultSet.getString("QUESTIONS_UID");
         resultSet.getString("QUESTIONS");
         resultSet.getString("ORDERS");
         
    }
}


// SELECT * FROM QUESTIONS_LIST
    // WHERE QUESTIONS_UID = 'Q2'