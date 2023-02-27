/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WavesSimulation.UI;

import javafx.fxml.FXML;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author 2153617
 */
public class UIController extends Stage {
    
    Stage owner;
    
    @FXML
    private Rectangle recInt;
    
    @FXML 
    private Rectangle recSlit;
    
    @FXML
    private Rectangle recDiff;
    
    public UIController (Stage owner){
        this.owner = owner;
        
        //recInt.setFill(value);
    }
    
    
}
