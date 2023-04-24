
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
import javafx.scene.shape.Rectangle;

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
    private Button btnStartTop;
    
    @FXML 
    private Button btnStartBottom;
    
    @FXML
    private Label lblTitle; 
    
    @FXML
    private Label labelFreq;
   
    @FXML
    private Label labelAmp;
    
    ImageView imageFaucetBottom = new ImageView("/images/faucet.png");
    ImageView imageFaucetTop = new ImageView("/images/faucet.png");
    
    InterEngine engine = new InterEngine();
    
    public void initialize(){  
        imageFaucetTop.setFitHeight(140);
        imageFaucetTop.setFitWidth(140);
        imageFaucetTop.setTranslateX(160);
        imageFaucetTop.setTranslateY(270);
        
        imageFaucetBottom.setFitHeight(140);
        imageFaucetBottom.setFitWidth(140);
        imageFaucetBottom.setTranslateX(160);
        imageFaucetBottom.setTranslateY(490);
        
        backgroundPane.getChildren().addAll(imageFaucetTop, imageFaucetBottom);
        btnStartTop.toFront();
        btnStartBottom.toFront();
       
        engine.setAnimation(animationPane);
        handleSldAmp();
        handleSldFreq();
        engine.setAnimationArc(animationPane);
    }

    public InterController() {
    }
 
    public InterController(Stage owner) {
        this.owner = owner;
    }
    
    @FXML
    public void handleBtnStartTop(ActionEvent event){
        engine.playTopAnimation();
        System.out.println("Top Button");
    }
    
    @FXML
    public void handleBtnStartBottom(ActionEvent event){
        engine.playBottomAnimation();
        System.out.println("Bottom Button");
    }
    
    public void getFreq(){
        sldFreq.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                int freq; 
                freq = (int) sldFreq.getValue();
                System.out.println(freq);
            }
        }); 
    }
   
    public void getAmp(){
        sldAmp.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                int amp;
                amp = (int) sldAmp.getValue();
                System.out.println(amp);
            }
        });   
    }
    
    public void getSep(){     
        sldSep.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                int sep;
                sep = (int) sldSep.getValue();
                System.out.println(sep);
            }
        });   
    }  
    
    public void handleSldAmp(){
        sldAmp.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                int amp;
                amp = (int) sldAmp.getValue();
                labelAmp.setText(Integer.toString(amp));
            }
        });   
    }
    
    public void handleSldFreq(){
        sldFreq.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue){
                int freq;
                freq = (int) sldFreq.getValue();
                labelFreq.setText(Integer.toString(freq));
            }
        });   
    }
    
}


