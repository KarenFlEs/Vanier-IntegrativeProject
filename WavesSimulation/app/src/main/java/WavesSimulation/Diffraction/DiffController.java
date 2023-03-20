/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WavesSimulation.Diffraction;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author KarenFl
 */
public class DiffController extends Stage{
    
    Stage Owner; 
    
    @FXML 
    private AnchorPane diffScreen; 
    
    @FXML
    private Pane paneSquare; 
    
    @FXML
    private Pane paneAnimation; 
    
    @FXML
    private Pane paneWave; 
    
    @FXML
    private Slider sldWave; 
    
    @FXML
    private Slider sldDiameter; 
    
    @FXML
    private Slider sldEcc; 
    
    @FXML
    private Label labelDiameter; 
    
    @FXML
    private Label labelEcc; 
    
    
    
    
}
