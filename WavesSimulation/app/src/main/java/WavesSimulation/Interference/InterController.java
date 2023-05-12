package WavesSimulation.Interference;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;

/**
 *
 * @author Darina
 */
public class InterController extends Stage {

    Stage owner;

    @FXML
    private Slider sldFreq;

    @FXML
    private Slider sldAmp;

    @FXML
    private Button btnSep0;
    
    @FXML
    private Button btnSep1;
     
    @FXML
    private Button btnSep2;

    @FXML
    private Pane animationPane;

    @FXML
    private Pane backgroundPane;

    @FXML
    private Button btnStartTop;

    @FXML
    private Button btnStartBottom;
    
    @FXML
    private Button btnStart;

    @FXML
    private Label lblTitle;

    @FXML
    private Label labelFreq;

    @FXML
    private Label labelAmp;
   
    @FXML
    private Button btnInfoSep;
    
    @FXML
    private Button btnInfoAmp;
    
    @FXML
    private Button btnInfoFreq;
    
    private boolean isPlaying = false;

    ImageView imageFaucetBottom = new ImageView("/images/faucet.png");
    ImageView imageFaucetTop = new ImageView("/images/faucet.png");

    InterEngine engine = new InterEngine();

    /**
     * This is the initialize method which runs when the Interference window is
     * opened
     */
    public void initialize() {
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
        //engine.setAnimation(animationPane);
        handleSldAmp();
        handleSldFreq();
        //engine.setAnimationArc(animationPane);
        
    }
    public InterController() {
    }

    public InterController(Stage owner) {
        this.owner = owner;
    }
    
    @FXML
    public void handleBtnInfoFreq(ActionEvent event){
        Stage newStage = new Stage();
        
        newStage.initModality(Modality.APPLICATION_MODAL);
        
        newStage.setTitle("Frequency information");
        
        StackPane layout = new StackPane();
        
        TextArea text = new TextArea();
        text.autosize();
        text.setText("When increasing the frequency, the velocity of the"
                + " waves moving increases. When decreasing the frequency,"
                + " the velocity of the waves moving decreases.");
        text.setPrefSize(300, 200);
        text.setWrapText(true);
        text.setEditable(false);
        
        layout.getChildren().add(text);
        
        Scene scene = new Scene(layout,300,200);
        
        newStage.setScene(scene);
        
        newStage.show();
    }
    
    @FXML 
    public void handleBtnInfoAmp(ActionEvent event){
        Stage newStage = new Stage();
        
        newStage.initModality(Modality.APPLICATION_MODAL);
        
        newStage.setTitle("Amplitude information");
        
        StackPane layout = new StackPane();
        
        TextArea text = new TextArea();
        text.autosize();
        text.setText("When increasing the amplitude, the waves become more bright and"
                + " sharp in color, while when decreasing the amplitudes, the waves becoming"
                + " less vibrant in color and more blurry.");
        text.setPrefSize(300, 200);
        text.setWrapText(true);
        text.setEditable(false);
        
        layout.getChildren().add(text);
        
        Scene scene = new Scene(layout,300,200);
        
        newStage.setScene(scene);
        
        newStage.show();
    }
    
    @FXML 
    public void handleBtnInfoSep(ActionEvent event){
         Stage newStage = new Stage();
        
        newStage.initModality(Modality.APPLICATION_MODAL);
        
        newStage.setTitle("Separation information");
        
        StackPane layout = new StackPane();
        
        TextArea text = new TextArea();
        text.autosize();
        text.setText("When increasing the separation, the two faucets"
                + " get further away from each other which makes the two waves interfere"
                + " once they meet after the bigger distance. The opposite "
                + "occurs when decreasing the separation.");
        text.setPrefSize(300, 200);
        text.setWrapText(true);
        text.setEditable(false);
    
        layout.getChildren().add(text);
        
        Scene scene = new Scene(layout,300,200);
        
        newStage.setScene(scene);
        
        newStage.show();
    }
    
    @FXML
    public void handleBtnStartTop(ActionEvent event) {
        if(!isPlaying){
            isPlaying = true;
            engine.setAnimationTopCircles(animationPane);
            engine.playTopAnimation();
            btnStartBottom.setDisable(true);
            btnStart.setDisable(true);
        }else{
            isPlaying = false;
            engine.stopTopAnimation();
            animationPane.getChildren().clear();
            btnStartBottom.setDisable(false);
            btnStart.setDisable(false);
        }
    }
    
    @FXML
    public void handleBtnStart(ActionEvent event) {
        if(!isPlaying){
            isPlaying = true;
            engine.setAnimation(animationPane);
            engine.setAnimationArc(animationPane);
            engine.playAnimation();
            btnStartBottom.setDisable(true);
            btnStartTop.setDisable(true);
        }else{
            isPlaying = false;
            engine.stopAnimation();
            animationPane.getChildren().clear();
            btnStartBottom.setDisable(false);
            btnStartTop.setDisable(false);
        }
       
    }

    @FXML
    public void handleBtnStartBottom(ActionEvent event) {
        if(!isPlaying){
            isPlaying = true;
            engine.setAnimationBottomCircles(animationPane);
            engine.playBottomAnimation();
            btnStart.setDisable(true);
            btnStartTop.setDisable(true);
        }else{
            isPlaying = false;
            engine.stopBottomAnimation();
            animationPane.getChildren().clear();
            btnStart.setDisable(false);
            btnStartTop.setDisable(false);
        }
      
    }
    
    @FXML
    public void handleBtnSep0(ActionEvent event) {
      if(!isPlaying){
            isPlaying = true;
            engine.playTopAnimation();
            engine.setAnimationTopCircles(animationPane);
            btnStart.setVisible(false);
            btnStartBottom.setVisible(false);
            imageFaucetBottom.setVisible(false);
            
        }else{
            isPlaying = false;
            engine.stopTopAnimation();
            btnStartBottom.setDisable(false);
            btnStartTop.setDisable(false);
        }
    }
    @FXML
    public void handleBtnSep1(ActionEvent event) {
      
    }
    @FXML
    public void handleBtnSep2(ActionEvent event) {
      
    }
    public void getFreq() {
        sldFreq.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int freq;
                freq = (int) sldFreq.getValue();
                System.out.println(freq);
            }
        });
    }
    
    

    public void getAmp() {
        sldAmp.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int amp;
                amp = (int) sldAmp.getValue();
                System.out.println(amp);
            }
        });
    }


    public void handleSldAmp() {
        sldAmp.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int amp;
                amp = (int) sldAmp.getValue();
                labelAmp.setText(Integer.toString(amp));
            }
        });
    }

    public void handleSldFreq() {
        sldFreq.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int freq;
                freq = (int) sldFreq.getValue();
                labelFreq.setText(Integer.toString(freq));
            }
        });
    }

}
