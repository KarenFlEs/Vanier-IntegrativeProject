package WavesSimulation.Slits;

import java.io.IOException;
import javafx.application.Platform;
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

    @FXML
    private Button buttonInfoFrequency;

    @FXML
    private Button buttonInfoAmplitude;

    @FXML
    private Button buttonInfoSlits;

    @FXML
    private Button buttonInfoWidth;

    @FXML
    private Button buttonInfoSeperation;

    //Variables for the seperation of the Waves
    Arc arc = new Arc(400, 300, 40, 40, -90, 180);

    SlitsEngine slit = new SlitsEngine();

    @FXML
    public void initialize() {

        slit.clipPane(paneAnimation);
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

    /**
     * Handles the modifications in the animation when the checkbox of 1 slit is
     * selected
     */
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

            slit.getSlitSeperationBottom().setVisible(false);
            sldSeperation.setDisable(true);
        }
    }

    /**
     * Handles the modifications in the animation when the checkbox of 2 slits
     * is selected TODO: Incorporate 2 slits with Arcs' Animation
     */
    @FXML
    public void handle2Slit() {
        arcAppearance(slit.getArc4(), slit.getArc5(), slit.getArc6());
        //System.out.println(slit.getSlitSeperationTop().getLayoutY() - slit.getSlitTopWall().getHeight());
        slit.getArc1().setLayoutY(slit.getSlitTopWall().getLayoutY());
        slit.getArc1().setRadiusY(slit.getSlitSeperationBottom().getLayoutY() - slit.getSlitTopWall().getHeight());
        slit.getArc2().setLayoutY(slit.getSlitTopWall().getLayoutY());
        slit.getArc2().setRadiusY(slit.getSlitSeperationBottom().getLayoutY() - slit.getSlitTopWall().getHeight());
        slit.getArc3().setLayoutY(slit.getSlitTopWall().getLayoutY());
        slit.getArc3().setRadiusY(slit.getSlitSeperationBottom().getLayoutY() - slit.getSlitTopWall().getHeight());

        slit.getArc4().setLayoutY(slit.getSlitSeperationBottom().getLayoutY());
        slit.getArc4().setRadiusY(slit.getSlitSeperationBottom().getLayoutY() - slit.getSlitTopWall().getHeight());
        slit.getArc5().setLayoutY(slit.getSlitSeperationBottom().getLayoutY());
        slit.getArc5().setRadiusY(slit.getSlitSeperationBottom().getLayoutY() - slit.getSlitTopWall().getHeight());
        slit.getArc6().setLayoutY(slit.getSlitSeperationBottom().getLayoutY());
        slit.getArc6().setRadiusY(slit.getSlitSeperationBottom().getLayoutY() - slit.getSlitTopWall().getHeight());

        sldWidth.setMin(350);
        sldWidth.setMax(500);

        slit.handleSliderWidth(sldWidth, sldSeperation, labelSlitSeperation, labelSlitWidth);

        if (btn1Slit.isSelected()) {
            btn1Slit.setSelected(false);
            btn2Slit.setSelected(true);

            //sldWidth.setMin(150);
            //sldWidth.setMax(300);
            slit.getSlitSeperationBottom().setVisible(true);
            sldSeperation.setDisable(false);
        }
    }

    @FXML
    public void handle3Slit() {

    }

    /**
     * Handles the play/pause of the animation when the button is clicked
     */
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

    FrequencyGuide frequencyGuide;

    @FXML
    public void enteredFrequency() throws IOException {
        frequencyGuide = new FrequencyGuide();
        frequencyGuide.show();

    }

    @FXML
    public void exitedFrequency() throws IOException {

        frequencyGuide.close();

    }

    AmplitudeGuide amplitudeGuide;

    @FXML
    public void enteredAmplitude() throws IOException {
        amplitudeGuide = new AmplitudeGuide();
        amplitudeGuide.show();
    }

    @FXML
    public void exitedAmplitude() {
        amplitudeGuide.close();
    }

    SlitsGuide slitsGuide;

    @FXML
    public void enteredSlits() throws IOException {
        slitsGuide = new SlitsGuide();
        slitsGuide.show();
    }

    @FXML
    public void exitedSlits() {
        slitsGuide.close();
    }

    WidthGuide widthGuide;

    @FXML
    public void enteredWidth() throws IOException {
        widthGuide = new WidthGuide();
        widthGuide.show();
    }

    @FXML
    public void exitedWidth() {
        widthGuide.close();
    }

    SeperationGuide seperationGuide;

    @FXML
    public void enteredSeperation() throws IOException {
        seperationGuide = new SeperationGuide();
        seperationGuide.show();
    }

    @FXML
    public void exitedSeperation() {
        seperationGuide.close();
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
