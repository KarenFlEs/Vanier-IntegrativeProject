package WavesSimulation.Slits;

import WavesSimulation.UI.MainApp;
import WavesSimulation.UI.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Cylinder;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.Timer;

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
    private CheckBox checkBox1Slit;

    @FXML
    private CheckBox checkBox2Slit;

    @FXML
    private Slider sliderAmplitude;

    @FXML
    private Slider sliderFrequency;

    @FXML
    private Slider sliderWidth;

    @FXML
    private Slider sliderSeperation;

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
        slit.simpleTimer();
        //sldWidth.setMin(150);
        //sldWidth.setMax(300);
        sliderSeperation.setMin(10);
        sliderSeperation.setMax(100);

        sliderAmplitude.setMin(15);
        sliderAmplitude.setMax(150);

        sliderFrequency.setMin(10);
        sliderFrequency.setMax(100);

        slit.startSlit(paneAnimation, checkBox1Slit, sliderSeperation);

        slit.handleSliderWidth(sliderWidth, sliderSeperation, labelSlitSeperation, labelSlitWidth);
        slit.handleSliderSeperation(sliderWidth, sliderSeperation, labelSlitSeperation, labelSlitWidth);

        slit.setUpRectangle(paneAnimation);

        slit.setUpArc(paneAnimation);
        slit.handleSliderAmplitude(sliderAmplitude);
        slit.hadnleSliderFrequency(sliderFrequency);

        cylinderWaveGenerator.toFront();
        btnPlayAnimation.toFront();
    }

    public SlitsController(Stage owner) {
        this.owner = owner;
    }

    public SlitsController() {

    }

    public void openMenu() throws IOException {
        owner.close();
        Stage stageMenu = new Stage();
        MainApp mainApp = new MainApp();
        mainApp.menuPage(stageMenu);
    }

    /**
     * Handles the modifications in the animation when the checkbox of 1 slit is
     * selected
     */
    @FXML
    public void handle1Slit() {
        arcDisappearance(slit.getArc4(), slit.getArc5(), slit.getArc6());
        
        for (Arc arc1 : slit.getListArc()) {
            arc1.setLayoutY(150);
        }

        sliderWidth.setMin(150);
        sliderWidth.setMax(300);

        //slit.handleSliderWidth(sldWidth, sldSeperation, labelSlitSeperation, labelSlitWidth);
        if (checkBox2Slit.isSelected()) {
            checkBox2Slit.setSelected(false);

            sliderWidth.setMin(150);
            sliderWidth.setMax(300);

            slit.getSlitSeperationBottom().setVisible(false);
            sliderSeperation.setDisable(true);
        }
    }

    /**
     * Handles the modifications in the animation when the checkbox of 2 slits
     * is selected TODO: Incorporate 2 slits with Arcs' Animation
     */
    @FXML
    public void handle2Slit() {
        arcAppearance(slit.getArc4(), slit.getArc5(), slit.getArc6());

        slit.getSlitSeperationBottom().setLayoutY(450 - slit.getSlitSeperationBottom().getHeight() / 2);

        for (Arc arc1 : slit.getListArc()) {
            arc1.setRadiusY(450 - slit.getSlitTopWall().getHeight() - slit.getSlitSeperationBottom().getHeight() / 2);
            arc1.setLayoutY(((slit.getSlitSeperationBottom().getHeight() / 2 + arc.getRadiusY() / 2) * -1) + 100);
        }

        for (Arc arc2 : slit.getListArc2()) {
            arc2.setRadiusY(450 - slit.getSlitTopWall().getHeight() - slit.getSlitSeperationBottom().getHeight() / 2);
            arc2.setLayoutY(slit.getSlitSeperationBottom().getHeight() + arc.getRadiusY() + 100);
        }

        sliderWidth.setMin(350);
        sliderWidth.setMax(500);

        slit.handleSliderWidth(sliderWidth, sliderSeperation, labelSlitSeperation, labelSlitWidth);

        if (checkBox1Slit.isSelected()) {
            checkBox1Slit.setSelected(false);
            checkBox2Slit.setSelected(true);

            slit.getSlitSeperationBottom().setVisible(true);
            sliderSeperation.setDisable(false);
        }
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
    
    /**
     * Handles the information about the slits information in the menu
     * @param event 
     */
    @FXML
    public void handleAboutSlits(javafx.event.ActionEvent event){
        Stage newStage = new Stage();
        
        newStage.initModality(Modality.APPLICATION_MODAL);
        
        newStage.setTitle("Slits Simulation information");
        
        StackPane layout = new StackPane();
        
        TextArea text = new TextArea();
        text.autosize();
        text.setText("The goal of the slits is to seperate the waves that are"
                    + "going towards them, which result to an interference."
                    + "It can result to a change of form and shape."
                    + "When changing the properties of the waves, the visual"
                    + "perspective will be modified accordingly.");
        text.setPrefSize(300, 200);
        text.setWrapText(true);
        text.setEditable(false);
        
        layout.getChildren().add(text);
        
        Scene scene = new Scene(layout,300,200);
        
        newStage.setScene(scene);
        newStage.setY(200);
        newStage.setX(0);
        newStage.show();
    }
    
    /**
     * Handles the opening of the main page in the menu.
     * @throws IOException 
     */
    @FXML
    public void handleOpenMenuPage() throws IOException {
        openMenu();
    }
    
    /**
     * Handles the opening of the interference simulation in the menu.
     * @throws IOException 
     */
    @FXML
    public void handleOpenInterSim() throws IOException {
        UIController uiController = new UIController(owner);
        uiController.openInterSimulation();
    }
    
    /**
     * Handles the opening of the diffraction simulation in the menu.
     * @throws IOException 
     */
    @FXML
    public void handleOpenDiffSim() throws IOException {
        UIController uiController = new UIController(owner);
        uiController.openDiffSimulation();
    }
    
    /**
     * Handles the opening button of the main page.
     * @throws IOException 
     */
    @FXML
    public void handleBtnMenuArrow() throws IOException{
        openMenu();
    }
    
    /**
     * Handles the information of frequency when entering the frequency button.
     */
    FrequencyGuide frequencyGuide;
    @FXML
    public void enteredFrequency() throws IOException {
        frequencyGuide = new FrequencyGuide();
        frequencyGuide.show();

    }
    
    /**
     * Handles the information of frequency when exiting the frequency button.
     */
    @FXML
    public void exitedFrequency() throws IOException {
        frequencyGuide.close();
    }

    AmplitudeGuide amplitudeGuide;
    
    /**
     * Handles the information of amplitude when entering the amplitude button.
     * @throws IOException 
     */
    @FXML
    public void enteredAmplitude() throws IOException {
        amplitudeGuide = new AmplitudeGuide();
        amplitudeGuide.show();
    }
    
    /**
     * Handles the information of frequency when exiting the frequency button.
     */
    @FXML
    public void exitedAmplitude() {
        amplitudeGuide.close();
    }

    /**
     * Handles the information of slits when entering the slits button.
     */
    SlitsGuide slitsGuide;
    @FXML
    public void enteredSlits() throws IOException {
        slitsGuide = new SlitsGuide();
        slitsGuide.show();
    }
    
    /**
     * Handles the information of slits when exiting the slits button.
     */
    @FXML
    public void exitedSlits() {
        slitsGuide.close();
    }
    
    /**
     * Handles the information of width when entering the width button.
     */
    WidthGuide widthGuide;
    @FXML
    public void enteredWidth() throws IOException {
        widthGuide = new WidthGuide();
        widthGuide.show();
    }
    
    /**
     * Handles the information of width when exiting the width button.
     */
    @FXML
    public void exitedWidth() {
        widthGuide.close();
    }
    
    /**
     * Handles the information of seperation when entering the seperation button.
     */
    SeperationGuide seperationGuide;
    @FXML
    public void enteredSeperation() throws IOException {
        seperationGuide = new SeperationGuide();
        seperationGuide.show();
    }
    
    /**
     * Handles the information of seperation when exiting the seperation button.
     */
    @FXML
    public void exitedSeperation() {
        seperationGuide.close();
    }
    
    /**
     * Makes the arcs appear when the method is called.
     * @param arc1
     * @param arc2
     * @param arc3 
     */
    public void arcAppearance(Arc arc1, Arc arc2, Arc arc3) {
        arc1.setVisible(true);
        arc2.setVisible(true);
        arc3.setVisible(true);

    }
    
    /**
     * Makes the arcs disappear when the method is called.
     * @param arc1
     * @param arc2
     * @param arc3 
     */
    public void arcDisappearance(Arc arc1, Arc arc2, Arc arc3) {
        arc1.setVisible(false);
        arc2.setVisible(false);
        arc3.setVisible(false);

    }
}