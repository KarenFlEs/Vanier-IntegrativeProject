/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WavesSimulation.Slits;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
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

    private Rectangle straightWave = new Rectangle(100,900);
    Arc arc = new Arc(400, 300, 40, 40, -90, 180);
    

    @FXML
    public void initialize() {

        
        straightWave.setFill(Color.WHITE);

        paneAnimation.getChildren().addAll(straightWave);

        BoxBlur blur = new BoxBlur(50, 50, 3);
        BoxBlur blur1 = new BoxBlur(10, 10, 3);
        straightWave.setEffect(blur);

        TranslateTransition trans = new TranslateTransition(Duration.seconds(5), straightWave);
        trans.setByX(240);
        trans.setByX(350);
        trans.setInterpolator(Interpolator.LINEAR);
        trans.play();
        
        
        arc.setLayoutY(150);
        arc.setEffect(blur1);
        arc.setType(ArcType.OPEN);
        arc.setStrokeWidth(30);
        arc.setStroke(Color.WHITE);
        arc.setStrokeType(StrokeType.INSIDE);
        arc.setFill(null);
        paneAnimation.getChildren().addAll(arc);
        
        TranslateTransition trans1 = new TranslateTransition(Duration.seconds(5), arc);
        trans1.setByX(400);
        trans1.setByX(900);
        trans1.setInterpolator(Interpolator.LINEAR);
        ScaleTransition scale = new ScaleTransition(Duration.seconds(1), arc);
        scale.setToX(10.0);
        scale.setToY(10.0);
        ParallelTransition par = new ParallelTransition(trans1,scale);
        
        SequentialTransition trans2 = new SequentialTransition();
        trans2.getChildren().addAll(trans,par);
        trans2.setInterpolator(Interpolator.LINEAR);
        trans2.setCycleCount(Animation.INDEFINITE);
        trans2.play();

    }

    public SlitsController(Stage owner) {
        this.owner = owner;
    }

    @FXML
    public void handle1Slit() {

    }

    @FXML
    public void handle2Slit() {

    }

    @FXML
    public void handle3Slit() {

    }

}
