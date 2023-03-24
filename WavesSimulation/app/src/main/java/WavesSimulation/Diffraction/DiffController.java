
package WavesSimulation.Diffraction;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    
    /**
     * This is the initialize method which runs when the simulationWindow opens
     */
    @FXML
    public void initialize() {
        
        //The circle in the left pane (left black square) 
        Circle circle = new Circle();
        circle.setTranslateX(280);
        circle.setTranslateY(230);
        circle.setFill(Color.WHITE);
        
        sldDiameter.setMin(20);
        sldDiameter.setMax(130);
        
        sldDiameter.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double circleRadius = (int) sldDiameter.getValue()/2; 
                circle.setRadius(circleRadius);
                labelDiameter.setText(Double.toString(circleRadius/100) + " mm");
                System.out.println(circleRadius);
            }
        });
        
        sldEcc.setMax(0.7);
        
        sldEcc.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double eccentricity = 1 - sldEcc.getValue(); 
                circle.setScaleY(eccentricity);
                labelEcc.setText(Double.toString(1 - eccentricity) + " mm");
                System.out.println(eccentricity);
            }
        });
        
        paneSquare.getChildren().add(circle); 
    }
    
    
}
