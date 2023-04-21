package WavesSimulation.Slits;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Cylinder;
import javafx.stage.Stage;

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

        //sldWidth.setMin(150);
        //sldWidth.setMax(300);

        sldSeperation.setMin(10);
        sldSeperation.setMax(100);

        sldAmplitude.setMin(15);
        sldAmplitude.setMax(150);

        sldFrequency.setMin(10);
        sldFrequency.setMax(100);

        slit.startSlit(paneAnimation, btn1Slit, sldSeperation);
        
        
        slit.handleSliderWidth(sldWidth, sldSeperation, labelSlitSeperation, labelSlitWidth);
        slit.handleSliderSeperation(sldWidth, sldSeperation, labelSlitSeperation, labelSlitWidth);

        slit.setUpRectangle(paneAnimation);

        slit.setUpArc(paneAnimation);
        slit.handleSliderAmplitude(sldAmplitude);
        slit.hadnleSliderFrequency(sldFrequency);

        cylinderWaveGenerator.toFront();
        btnPlayAnimation.toFront();
    }

    public SlitsController(Stage owner) {
        this.owner = owner;
    }

    public SlitsController() {
        
    }

    @FXML
    public void handle1Slit() {
        arcDisappearance(slit.getArc4(), slit.getArc5(), slit.getArc6());

        slit.getArc1().setLayoutY(150);
        slit.getArc2().setLayoutY(150);
        slit.getArc3().setLayoutY(150);
        
        sldWidth.setMin(150);
        sldWidth.setMax(300);
        
        //slit.handleSliderWidth(sldWidth, sldSeperation, labelSlitSeperation, labelSlitWidth);
        
        if (btn2Slit.isSelected()) {
            btn2Slit.setSelected(false);

            sldWidth.setMin(150);
            sldWidth.setMax(300);

            slit.getSlitSeperationTop().setVisible(false);
            slit.getSlitSeperationBottom().setVisible(false);
            sldSeperation.setDisable(true);
        }
    }

    //TODO: Incorporate 2 slits with Arcs' Animation
    @FXML
    public void handle2Slit() {
        arcAppearance(slit.getArc4(), slit.getArc5(), slit.getArc6());
        System.out.println(slit.getSlitSeperationTop().getLayoutY() - slit.getSlitTopWall().getHeight());
        slit.getArc1().setLayoutY(slit.getSlitTopWall().getLayoutY());
        slit.getArc1().setRadiusY(slit.getSlitSeperationTop().getLayoutY() - slit.getSlitTopWall().getHeight());
        slit.getArc2().setLayoutY(slit.getSlitTopWall().getLayoutY());
        slit.getArc2().setRadiusY(slit.getSlitSeperationTop().getLayoutY() - slit.getSlitTopWall().getHeight());
        slit.getArc3().setLayoutY(slit.getSlitTopWall().getLayoutY());
        slit.getArc3().setRadiusY(slit.getSlitSeperationTop().getLayoutY() - slit.getSlitTopWall().getHeight());
        
        sldWidth.setMin(425);
        sldWidth.setMax(450);
        
        slit.handleSliderWidth(sldWidth, sldSeperation, labelSlitSeperation, labelSlitWidth);
        

        if (btn1Slit.isSelected()) {
            btn1Slit.setSelected(false);
            btn2Slit.setSelected(true);

            //sldWidth.setMin(150);
            //sldWidth.setMax(300);

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

    public void arcAppearance(Arc arc1, Arc arc2, Arc arc3) {

        arc1.setVisible(true);
        arc2.setVisible(true);
        arc3.setVisible(true);

    }

    public void arcDisappearance(Arc arc1, Arc arc2, Arc arc3) {

        arc1.setVisible(false);
        arc2.setVisible(false);
        arc3.setVisible(false);

    }

    public CheckBox getBtn2Slit() {
        return btn2Slit;
    }

    public void setBtn2Slit(CheckBox btn2Slit) {
        this.btn2Slit = btn2Slit;
    }

}
