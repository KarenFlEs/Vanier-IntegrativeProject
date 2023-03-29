
package WavesSimulation.Diffraction;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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
    private Rectangle rectangleWave; 
    
    @FXML
    private Slider sliderWave; 
    
    @FXML
    private Slider sliderDiameter; 
    
    @FXML
    private Slider sliderEcc; 
    
    @FXML
    private Label labelWave; 
    
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
        circle.setRadius(10);
        
        sliderDiameter.setMin(20);
        sliderDiameter.setMax(130);
        
        sliderDiameter.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double circleRadius = (int) sliderDiameter.getValue()/2; 
                circle.setRadius(circleRadius);
                labelDiameter.setText(Double.toString(circleRadius/100) + " mm");
                System.out.println(circleRadius);
            }
        });
        
        sliderEcc.setMax(0.7);
        
        sliderEcc.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double eccentricity = 1 - sliderEcc.getValue(); 
                circle.setScaleY(eccentricity);
                double eccentricityLabel = (double) Math.round((1 - eccentricity)*100)/100; 
                labelEcc.setText(Double.toString(eccentricityLabel) + " mm");
            }
        });
        
        paneSquare.getChildren().add(circle); 
        
        sliderWave.setMax(780);
        sliderWave.setMin(380);
        
        sliderWave.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int wavelength = (int) sliderWave.getValue(); 
                labelWave.setText(Integer.toString(wavelength) + " nm");
            }
        });
        
        //paneWave
        Stop [] stop = new Stop []{new Stop (0, Color.BLACK),
                                    new Stop (0.5, Color.GREEN),
                                    new Stop (1, Color.RED)
        }; 
        
        LinearGradient linearGradient = new LinearGradient(0,0,1,0, true, CycleMethod.NO_CYCLE, stop); 
        rectangleWave.setFill(linearGradient);
    }
    
}

