/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.vtv.quiztestv1;

import com.vtv.pojo.Category;
import com.vtv.pojo.Choice;
import com.vtv.services.CategoryServices;
import com.vtv.services.LevelServices;
import com.vtv.pojo.Level;
import com.vtv.pojo.Question;
import com.vtv.services.QuestionServices;
import com.vtv.utils.MyAlert;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {

    @FXML
    private TextArea txtContent;
    @FXML
    private ComboBox<Category> cbCates;
    @FXML
    private ComboBox<Level> cbLevels;
    @FXML
    private VBox vboxChoices;
    
    @FXML private ToggleGroup toggleChoice;
    
    
    private final static CategoryServices cateService = new CategoryServices();
    private final static LevelServices levelService = new LevelServices();
    private final static QuestionServices questionServices = new QuestionServices();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            this.cbCates.setItems(FXCollections.observableList(cateService.getCates()));
            this.cbLevels.setItems(FXCollections.observableList(levelService.getLevels()));
        } catch (SQLException ex) {
            System.getLogger(QuestionsController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void addChoice(ActionEvent event) {
        HBox hb = new HBox();
        hb.getStyleClass().add("Main");
        RadioButton rb = new RadioButton();
        rb.setToggleGroup(toggleChoice);
        TextField txt = new TextField();
        txt.getStyleClass().add("Input");
        hb.getChildren().addAll(rb, txt);
        this.vboxChoices.getChildren().add(hb);
    }

    public void addQuestion(ActionEvent event) {
        try {
            Question.Builder b = new Question.Builder(this.txtContent.getText(),
                    this.cbCates.getSelectionModel().getSelectedItem(),
                    this.cbLevels.getSelectionModel().getSelectedItem());
            
            for(var c: this.vboxChoices.getChildren()) {
                HBox h = (HBox) c;
                
                Choice choice = new Choice(((TextField)h.getChildren().get(1)).getText(), ((RadioButton)h.getChildren().get(0)).isSelected());
                
                b.addChoice(choice); 
            }
                
                questionServices.addQuestion(b.builder());
                MyAlert.getInstance().showMsg("Them cau hoi thanh cong! ");
                
                
        }catch(SQLException ex){
            
        } 
        catch (Exception ex) {
            MyAlert.getInstance().showMsg("Du lieu khong hop le !");
        }

    }

}
