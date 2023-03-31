
package WavesSimulation.Interference;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Darina
 */
public class InterController extends Stage{
   
    Stage owner; 
    
    @FXML
    private Slider sldFreq;
    
    @FXML
    private Slider sldAmp;
    
    @FXML
    private Slider sldSep;
    
    @FXML
    private Pane animationPane;
}
