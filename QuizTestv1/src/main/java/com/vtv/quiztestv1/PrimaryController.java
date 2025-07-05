package com.vtv.quiztestv1;

import com.vtv.utils.MyAlert;
import com.vtv.utils.MyStage;
import java.io.IOException;
import javafx.event.ActionEvent;

public class PrimaryController {
    
    
    
    public void handleQuestionManagement(ActionEvent event) throws IOException{
       MyStage.getInstance().showStage("questions.fxml");

    }
    
    
    public void handlePractice(ActionEvent event){
        MyAlert.getInstance().showMsg("Coming soon.......");
        
    }
    
}
