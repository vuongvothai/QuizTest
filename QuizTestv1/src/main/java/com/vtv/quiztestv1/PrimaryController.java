package com.vtv.quiztestv1;

import com.vtv.utils.MyAlert;
import com.vtv.utils.MyStage;
import com.vtv.utils.theme.DefaultFactory;
import com.vtv.utils.theme.Theme;
import com.vtv.utils.theme.ThemeManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class PrimaryController implements Initializable{
    @FXML private ComboBox<Theme> cbTheme;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbTheme.setItems(FXCollections.observableArrayList(Theme.values()));
    }
    
    public void changeTheme(ActionEvent event){
        this.cbTheme.getSelectionModel().getSelectedItem().updateTheme(this.cbTheme.getScene());
        
    }
    
    public void handleQuestionManagement(ActionEvent event) throws IOException{
       MyStage.getInstance().showStage("questions.fxml");

    }
    
    
    public void handlePractice(ActionEvent event){
        MyAlert.getInstance().showMsg("Coming soon.......");
        
    }

    
}
