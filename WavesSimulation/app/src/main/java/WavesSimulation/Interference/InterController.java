
package WavesSimulation.Interference;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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
    
    @FXML
    private Pane backgroundPane;
   
    @FXML 
    private Button btnStart;
    
    @FXML 
    private Button btnStart2;
    
    @FXML
    private Label lblTitle; 
    
    
    ImageView imageFaucetBottom = new ImageView("/images/faucet.png");
    ImageView imageFaucetTop = new ImageView("/images/faucet.png");
    
    
    @FXML
    public void handleBtnStart(ActionEvent event){
        
    }
    
    @FXML
    public void handleBtnStart2(ActionEvent event){
        
    }
    
    public void initialize(){
        
        imageFaucetBottom.setFitHeight(140);
        imageFaucetBottom.setFitWidth(140);
        imageFaucetBottom.setTranslateX(160);
        imageFaucetBottom.setTranslateY(490);
        
        imageFaucetTop.setFitHeight(140);
        imageFaucetTop.setFitWidth(140);
        imageFaucetTop.setTranslateX(160);
        imageFaucetTop.setTranslateY(270);
        
        backgroundPane.getChildren().clear();
        backgroundPane.getChildren().addAll(animationPane, lblTitle, imageFaucetBottom, imageFaucetTop, btnStart, btnStart2);
    }
    
    public void getFreq(){
        sldFreq.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                int freq; 
                freq = (int)sldFreq.getValue();
                System.out.println(freq);
            }
        }); 
    }
   
    public void getAmp(){
        
        sldAmp.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                int amp;
                amp = (int)sldAmp.getValue();
                System.out.println(amp);
            }
        });   
    }
    
    public void getSep(){
        
        sldSep.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                int sep;
                sep = (int)sldSep.getValue();
                System.out.println(sep);
            }
        });   
    }   
}


