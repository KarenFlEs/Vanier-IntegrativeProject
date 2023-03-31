package WavesSimulation.Slits;

import java.beans.EventHandler;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Cylinder;
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
    private Slider sldAmplitude;
    
    @FXML
    private Slider sldFrequency;

    @FXML
    private Slider sldWidth;

    @FXML
    private Slider sldSeperation;

    @FXML
    private Pane paneAnimation;

    @FXML
    private Button btnPlayAnimation;

    @FXML
    private Cylinder cylinderWaveGenerator;

    @FXML
    private Label labelSlitWidth;

    @FXML
    private Label labelSlitSeperation;

    //Variables for the seperation of the Waves
    Arc arc = new Arc(400, 300, 40, 40, -90, 180);

    SlitsEngine slit = new SlitsEngine();

    @FXML
    public void initialize() {

        sldWidth.setMin(150);
        sldWidth.setMax(300);

        sldSeperation.setMin(10);
        sldSeperation.setMax(100);

        sldAmplitude.setMin(15);
        sldAmplitude.setMax(150);
        
        sldFrequency.setMin(10);
        sldFrequency.setMax(100);

        slit.startSlit(paneAnimation, btn1Slit, sldSeperation);
        slit.handleSlitWidth(sldWidth, sldSeperation, labelSlitSeperation, labelSlitWidth);

        slit.setUpInput(paneAnimation);
        slit.handleSliderAmplitude(sldAmplitude);
        slit.hadnleSliderFrequency(sldFrequency);
        //slit.playAnimation();

        /*
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
        ParallelTransition par = new ParallelTransition(translateArc, scale);

        SequentialTransition trans2 = new SequentialTransition();
        trans2.getChildren().addAll(translateRectangle, par);
        trans2.setInterpolator(Interpolator.LINEAR);
        trans2.setCycleCount(Animation.INDEFINITE);
        trans2.play();*/
        cylinderWaveGenerator.toFront();
        btnPlayAnimation.toFront();
    }

    public SlitsController(Stage owner) {
        this.owner = owner;
    }

    @FXML
    public void handle1Slit() {
        if (btn2Slit.isSelected()) {
            btn2Slit.setSelected(false);

            sldWidth.setMin(150);
            sldWidth.setMax(400);

            slit.getSlitSeperationTop().setVisible(false);
            slit.getSlitSeperationBottom().setVisible(false);
            sldSeperation.setDisable(true);

        }
    }

    @FXML
    public void handle2Slit() {
        if (btn1Slit.isSelected()) {
            btn1Slit.setSelected(false);
            btn2Slit.setSelected(true);

            sldWidth.setMin(150);
            sldWidth.setMax(300);

            slit.getSlitSeperationTop().setVisible(true);
            slit.getSlitSeperationBottom().setVisible(true);
            sldSeperation.setDisable(false);

        }
    }

    @FXML
    public void handle3Slit() {

    }

    @FXML
    public void handlePlayAnimation() {
        if (btnPlayAnimation.getText().equals("Play")) {
            btnPlayAnimation.setText("Pause");
            slit.playAnimation();
        } else if (btnPlayAnimation.getText().equals("Pause")) {
            btnPlayAnimation.setText("Play");
            slit.pauseAnimation();
        }
    }

}
