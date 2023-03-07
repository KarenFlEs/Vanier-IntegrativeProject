/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WavesSimulation.Slits;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

/**
 *
 * @author Steven Dy
 */
public class SlitsController extends Stage {
    
    Stage owner;
    
    @FXML
    private CheckBox btn1Slit;
    
    @FXML
    private CheckBox btn2Slit;
    
    @FXML
    private CheckBox btn3Slit;
    
    @FXML
    private Slider sldFrequency;
    
    @FXML 
    private Slider sldAmplitude;
    
    @FXML 
    private Slider sldWidth;
    
    @FXML 
    private Slider sldSeperation;

    public SlitsController(Stage owner) {
        this.owner = owner;
    }
    
    @FXML
    public void handle1Slit(){
        
    }
    
    @FXML
    public void handle2Slit(){
        
    }
    
    @FXML
    public void handle3Slit(){
        
    }
    
    
}
