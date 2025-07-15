/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtv.services;

import com.vtv.pojo.Question;
import com.vtv.utils.MyConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vuong
 */
public class QuestionServices {
    public void addQuestion(Question q) throws SQLException{
        Connection conn = MyConnector.getInstance().connect();
        
        conn.setAutoCommit(false);
        
        String sql = "INSERT INTO question(content, hint, image, category_id, level_id) VALUES(?, ?, ?, ?, ?)";


        PreparedStatement stm = conn.prepareCall(sql);
        stm.setString(1, q.getContent());
        stm.setString(2, q.getHint());
        stm.setString(3, q.getImage());
        stm.setInt(4, q.getCategory().getId());
        stm.setInt(5, q.getLevel().getId());
        
        if(stm.executeUpdate() > 0) {
            int questionId = -1 ;
            ResultSet r = stm.getGeneratedKeys();
            
            if(r.next()){
                questionId = r.getInt(1);
            }
            
            sql = "INSERT INTO choice(content, question_id ) VALUES(?, ?)";
            
            for  (var c: q.getChoices()) {
                stm = conn.prepareCall(sql);                 
                stm.setString(1, c.getContent());
                stm.setInt(2, questionId);
                
                stm.executeUpdate();
                
            }
            conn.commit();
        }
        else{
            conn.rollback();
        }
    }
}
