/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vtv.quiztestv1;

import com.vtv.pojo.Category;
import com.vtv.services.CategoryServices;
import com.vtv.utils.MyConnector;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {
    
    @FXML private ComboBox<Category> cbCates;
    private final static CategoryServices cateService = new CategoryServices();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            this.cbCates.setItems(FXCollections.observableList(cateService.getCates()));
        } catch (SQLException ex) {
            System.getLogger(QuestionsController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }    
    
}
