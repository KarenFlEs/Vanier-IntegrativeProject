package WavesSimulation.Slits;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Steven Dy
 */
public class SlitsController extends Stage {

    Stage owner;

    @FXML
    private Pane mainScreen;
    
    @FXML
    private Pane paneSettings;

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

    @FXML
    private Pane paneAnimation;
    
    //Variables for the seperation of the Waves
    private Rectangle slitTopWall;
    private Rectangle slitBottomWall;
    private Rectangle slitSeperation;

    private Rectangle straightWave = new Rectangle(100, 900);
    Arc arc = new Arc(400, 300, 40, 40, -90, 180);

    @FXML
    public void initialize() {
        
        sldWidth.setMin(150);
        sldWidth.setMax(500);
        
        sldSeperation.setMin(150);
        sldSeperation.setMax(500);
        
        startSlit();
        handleSlitWidth();
        straightWave.setFill(Color.WHITE);

        paneAnimation.getChildren().addAll(straightWave);

        //
        BoxBlur blurRectangle = new BoxBlur(50, 50, 3);
        BoxBlur blurArc = new BoxBlur(10, 10, 3);
        straightWave.setEffect(blurRectangle);

        TranslateTransition translateRectangle = new TranslateTransition(Duration.seconds(5), straightWave);
        translateRectangle.setByX(240);
        translateRectangle.setByX(350);
        translateRectangle.setInterpolator(Interpolator.LINEAR);
        translateRectangle.play();
        
        arc.setLayoutY(150);
        arc.setEffect(blurArc);
        arc.setType(ArcType.OPEN);
        arc.setStrokeWidth(25);
        arc.setStroke(Color.WHITE);
        arc.setStrokeType(StrokeType.INSIDE);
        arc.setFill(null);
        paneAnimation.getChildren().addAll(arc);
        
        TranslateTransition translateArc = new TranslateTransition(Duration.seconds(4.5), arc);
        translateArc.setByX(400);
        translateArc.setByX(700);
        translateArc.setInterpolator(Interpolator.LINEAR);
        ScaleTransition scale = new ScaleTransition(Duration.seconds(4), arc);
        scale.setToX(15.0);
        scale.setToY(15.0);
        ParallelTransition par = new ParallelTransition(translateArc,scale);
        
        SequentialTransition trans2 = new SequentialTransition();
        trans2.getChildren().addAll(translateRectangle,par);
        trans2.setInterpolator(Interpolator.LINEAR);
        trans2.setCycleCount(Animation.INDEFINITE);
        trans2.play();
    }
    
    private void setUpInput(){
        
    }
    
    private void handleSlitWidth(){
        
        if(btn1Slit.isSelected()){
            
            sldWidth.valueProperty().addListener(new ChangeListener<Number>(){
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    int slitHeight = (int) sldWidth.getValue();
                    slitTopWall.setHeight(slitHeight);
                    slitBottomWall.setHeight(slitHeight);
                    slitBottomWall.setLayoutY(900 - slitHeight);
                     }
                
            });
        }
        
        if(btn2Slit.isSelected()){
            sldWidth.valueProperty().addListener(new ChangeListener<Number>(){
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    int slitHeight = (int) sldWidth.getValue();
                    slitTopWall.setHeight(slitHeight);
                    slitBottomWall.setHeight(slitHeight);
                    slitBottomWall.setLayoutY(900 - slitHeight);
                     }
                
            });
            
            sldSeperation.valueProperty().addListener(new ChangeListener<Number>(){
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    int seperationHeight = (int) sldSeperation.getValue();
                    
                    slitSeperation.setHeight(seperationHeight);
                    
                       }
                
            });
        }
    }

    public SlitsController(Stage owner) {
        this.owner = owner;
    }

    @FXML
    public void handle1Slit() {
       if(btn2Slit.isSelected()){
           btn2Slit.setSelected(false);
           /*slitTopWall.setLayoutX(500);
           
            slitBottomWall.setLayoutX(500);
            slitBottomWall.setLayoutY(600);*/
           paneAnimation.getChildren().remove(slitSeperation);
           sldSeperation.setDisable(true);
           
       }
    }

    @FXML
    public void handle2Slit() {
        if(btn1Slit.isSelected()){
            btn1Slit.setSelected(false);
            btn2Slit.setSelected(true);
           
            paneAnimation.getChildren().add(slitSeperation);
            sldSeperation.setDisable(false);
            
        }
    }

    @FXML
    public void handle3Slit() {

    }
    
    public void startSlit(){        
        slitTopWall = new Rectangle(15, 300, Color.GAINSBORO);
        slitTopWall.setLayoutX(500);
       
        slitBottomWall = new Rectangle(15, 300, Color.GAINSBORO);
        slitBottomWall.setLayoutX(500);
        slitBottomWall.setLayoutY(600);
        
        slitSeperation = new Rectangle(15, 150, Color.GAINSBORO);
        slitSeperation.setLayoutX(500);
        slitSeperation.setLayoutY(375);
        paneAnimation.getChildren().addAll(slitTopWall,slitBottomWall);
        
        btn1Slit.setSelected(true);
        sldSeperation.setDisable(true);
    }

}
