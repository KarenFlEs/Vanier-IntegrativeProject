package WavesSimulation.Diffraction;

import WavesSimulation.UI.MainApp;
import WavesSimulation.UI.UIController;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The main controller for Diffraction
 *
 * @author KarenFl
 */
public class DiffController extends Stage {

    Stage stageSim;
    Stage stageWaveInfo = new Stage();
    Stage stageDiamInfo = new Stage();
    Stage stageEccInfo = new Stage();

    @FXML
    private AnchorPane diffScreen;

    @FXML
    private Pane paneLaser;
    
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
    
    DiffEngine diffEngine = new DiffEngine();
    
    ImageView imvLaser = new ImageView("/images/laser.png");

    private final int PREFSIZE_X = 300; 
    private final int PREFSIZE_Y = 100; 
    private final int WAVE_INFO_POSITION_X = 80; 
    private final int WAVE_INFO_POSITION_Y = 740;
    private final int DIAM_INFO_POSITION_X = 860;
    private final int DIAM_INFO_POSITION_Y = 770;
    private final int ECC_INFO_POSITION_X = 870;
    private final int ECC_INFO_POSITION_Y = 900;
    private final int HELP_INFO_POSITION = 50;
    private final int LASER_POSITION_Y = 355;
    private final int LASER_HEIGHT = 180;
    private final int LASER_WIDTH = 200;
    private final int LCIRCLE_POSITION_X = 278;
    private final int LCIRCLE_POSITION_Y = 235;
    private final int SLIDER_DIAMETER_MIN = 10; 
    private final int SLIDER_DIAMETER_MAX = 130; 
    private final int SLIDER_WAVE_MIN = 380; 
    private final int SLIDER_WAVE_MAX = 780; 
    private final double SLIDER_ECC_MIN = 0.0; 
    private final double SLIDER_ECC_MAX = 0.7; 
    
    int circleRadius = 10; 
    int wavelength = 380;
    double slitDistance = 10.0;
    double eccentricity = 1.0;
    
    String strWaveInfo = "When the wavelength changes, there is a specific color that"
        + " the laser will have. As the wavelength increases, the diffraction pattern"
        + " gets bigger"; 
    
    String strDiamInfo = "The opening of the slit increases if the diameter"
        + " increases which will create a smaller diffraction pattern."; 
    
    String strEccInfo = "When the eccentricity increases, the height of the"
                + " slit opening decreases which will affect the diffraction patterned"
                + " as its width will get smaller."; 
    
    public DiffController(Stage stageDiff) {
        this.stageSim = stageDiff;
    }
    
    /**
     * This is the initialize method which runs when the DiffractionWindow opens
     */
    @FXML
    public void initialize() {
        //Laser
        imvLaser.setTranslateY(LASER_POSITION_Y);
        imvLaser.setFitHeight(LASER_HEIGHT);
        imvLaser.setFitWidth(LASER_WIDTH); 
        diffScreen.getChildren().add(imvLaser); 
        
        //The circle in the left pane (the left black square) 
        Circle circle = new Circle();
        circle.setTranslateX(LCIRCLE_POSITION_X);
        circle.setTranslateY(LCIRCLE_POSITION_Y);
        circle.setFill(Color.WHITE);
        circle.setRadius(circleRadius);

        //Diameter
        sliderDiameter.setMin(SLIDER_DIAMETER_MIN);
        sliderDiameter.setMax(SLIDER_DIAMETER_MAX);

        sliderDiameter.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                circleRadius = (int) sliderDiameter.getValue() / 2;
                circle.setRadius(circleRadius);
                labelDiameter.setText(circleRadius / 100.0 + " mm");

                slitDistance = sliderDiameter.getValue();
                paneAnimation.getChildren().clear();
                paneLaser.getChildren().clear();
                diffEngine.addDiffraction(paneLaser, paneAnimation, wavelength, eccentricity, slitDistance);
            }
        });

        //Eccentricity
        sliderEcc.setMax(SLIDER_ECC_MAX);

        sliderEcc.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                eccentricity = 1 - sliderEcc.getValue();
                circle.setScaleY(eccentricity);
                double eccentricityLabel = Math.round((1 - eccentricity) * 100) / 100.0;
                labelEcc.setText(eccentricityLabel + " mm");

                paneAnimation.getChildren().clear();
                paneLaser.getChildren().clear();
                diffEngine.addDiffraction(paneLaser, paneAnimation, wavelength, eccentricity, slitDistance);
            }
        });

        paneSquare.getChildren().add(circle);

        //Wavelength 
        Stop[] stops = new Stop[]{new Stop(0, Color.PURPLE),
            new Stop(0.2, Color.BLUE),
            new Stop(0.3, Color.CYAN),
            new Stop(0.4, Color.LIME),
            new Stop(0.5, Color.YELLOW),
            new Stop(0.6, Color.ORANGE),
            new Stop(0.8, Color.RED),
            new Stop(1, Color.DARKRED)
        };

        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        rectangleWave.setFill(linearGradient);

        sliderWave.setMax(SLIDER_WAVE_MAX);
        sliderWave.setMin(SLIDER_WAVE_MIN);

        sliderWave.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                wavelength = (int) sliderWave.getValue();
                labelWave.setText(wavelength + " nm");

                paneAnimation.getChildren().clear();
                paneLaser.getChildren().clear();
                diffEngine.addDiffraction(paneLaser, paneAnimation, wavelength, eccentricity, slitDistance);
            }
        });
    }

    /**
     * Opens the menu page
     * @throws IOException 
     */
    public void openMenu () throws IOException{
        stageSim.close();
        Stage stageMenu = new Stage(); 
        MainApp mainApp = new MainApp(); 
        mainApp.menuPage(stageMenu);
    }
    
    /**
     * This allows for the wave information pop-out to show 
     * when the mouse is placed on top of the button i next to the wavelength setting
     */
    @FXML
    public void enteredMouseWaveInfo (){
        stageWaveInfo.setTitle("Wavelength information");
        stageWaveInfo.setX(WAVE_INFO_POSITION_X);
        stageWaveInfo.setY(WAVE_INFO_POSITION_Y);
        
        StackPane stackPaneWaveInfo = new StackPane();
        
        TextArea textWave = new TextArea();
        textWave.autosize();
        textWave.setText(strWaveInfo);
        textWave.setFont(Font.font("Book Antica", 14));
        textWave.setPrefSize(PREFSIZE_X, PREFSIZE_Y);
        textWave.setWrapText(true);
        textWave.setEditable(false);
        
        stackPaneWaveInfo.getChildren().add(textWave);
        
        Scene scene = new Scene(stackPaneWaveInfo, PREFSIZE_X, PREFSIZE_Y);
        stageWaveInfo.setScene(scene);
        stageWaveInfo.show();
    }
    
    /**
     * This allows for the wave information to close when the mouse is not 
     * on top of the button i next to the wavelength setting
     */
    @FXML
    public void exitedMouseWaveInfo (){
        stageWaveInfo.close();
    }
    
    /**
     * This allows for the diameter information pop-out to show 
     * when the mouse is placed on top of the button i next to the diameter setting
     */
    @FXML
    public void enteredMouseDiamInfo (){
        stageDiamInfo.setTitle("Diameter information");
        stageDiamInfo.setX(DIAM_INFO_POSITION_X);
        stageDiamInfo.setY(DIAM_INFO_POSITION_Y);
        
        StackPane stackPaneDiamInfo = new StackPane();
        
        TextArea textDiam = new TextArea();
        textDiam.autosize();
        textDiam.setText(strDiamInfo);
        textDiam.setFont(Font.font("Book Antica", 14));
        textDiam.setPrefSize(PREFSIZE_X, PREFSIZE_Y);
        textDiam.setWrapText(true);
        textDiam.setEditable(false);
        
        stackPaneDiamInfo.getChildren().add(textDiam);
        
        Scene scene = new Scene(stackPaneDiamInfo, PREFSIZE_X, PREFSIZE_Y);
        stageDiamInfo.setScene(scene);
        stageDiamInfo.show();
    }
    
    /**
     * This allows for the diameter information to close when the mouse is not 
     * on top of the button i next to the diameter setting
     */
    @FXML
    public void exitedMouseDiamInfo (){
        stageDiamInfo.close();
    }
    
    /**
     * This allows for the eccentricity information pop-out to show 
     * when the mouse is placed on top of the button i next to the eccentricity setting
     */
    @FXML
    public void enteredMouseEccInfo (){
        stageEccInfo.setTitle("Eccentricity information");
        stageEccInfo.setX(ECC_INFO_POSITION_X);
        stageEccInfo.setY(ECC_INFO_POSITION_Y);
        
        StackPane stackPaneEccInfo = new StackPane();
        
        TextArea textEcc = new TextArea();
        textEcc.autosize();
        textEcc.setText(strEccInfo);
        textEcc.setFont(Font.font("Book Antica", 14));
        textEcc.setPrefSize(PREFSIZE_X, PREFSIZE_Y);
        textEcc.setWrapText(true);
        textEcc.setEditable(false);
        
        stackPaneEccInfo.getChildren().add(textEcc);
        
        Scene scene = new Scene(stackPaneEccInfo, PREFSIZE_X, PREFSIZE_Y);
        stageEccInfo.setScene(scene);
        stageEccInfo.show();
    }
    
    /**
     * This allows for the eccentricity information to close when the mouse is not 
     * on top of the button i next to the eccentricity setting
     */
    @FXML
    public void exitedMouseEccInfo (){
        stageEccInfo.close(); 
    }
    
    /**
     * By clicking the arrow button, it goes back to the menu page
     * @throws IOException 
     */
    @FXML
    public void handleBtnMenuArrow () throws IOException{
        openMenu(); 
    }
    
    /**
     * Closes the simulation when pressing the File Close option
     */
    @FXML
    public void handleClose (){
        stageSim.close();
    }
    
    /**
     * Resets the simulation when pressing the Edit Reset option
     */
    @FXML
    public void handleReset (){
        sliderWave.setValue(SLIDER_WAVE_MIN);
        sliderDiameter.setValue(SLIDER_DIAMETER_MIN);
        sliderEcc.setValue(SLIDER_ECC_MIN);
        paneAnimation.getChildren().clear(); 
        paneLaser.getChildren().clear();
    }
    
    /**
     * Opens the Interference simulation from the menu bar
     */
    @FXML
    public void handleOpenInterSim () throws IOException{
       UIController uiController = new UIController (stageSim); 
       uiController.openInterSimulation();
    }
    
    /**
     * Opens the Slits simulation from the menu bar
     */
    @FXML
    public void handleOpenSlitsSim () throws IOException{
       UIController uiController = new UIController (stageSim); 
       uiController.openSlitsSimulation();
    }
    
    /**
     * handles the OpenMenuPage from the menu bar
     */
    @FXML
    public void handleOpenMenuPage () throws IOException {
        openMenu(); 
    }
    
    /**
     * Opens the description of the simulation which is found in the menu bar
     */
    @FXML
    public void handleAbout (){ 
        Stage stageAbout = new Stage();
        stageAbout.initModality(Modality.NONE);
        stageAbout.setTitle("Diffraction information");
        stageAbout.setX(HELP_INFO_POSITION); 
        stageAbout.setY(HELP_INFO_POSITION); 
        
        StackPane stakePaneAbout = new StackPane();
        String strDiffractionDef = "Diffraction is the process of putting a beam light through "
                + "a narrow aperture in which spreads out the waves"; 
        
        TextArea textDiffractionInfo = new TextArea();
        textDiffractionInfo.autosize();
        textDiffractionInfo.setText(strDiffractionDef + "\n\nWavelength: " + strWaveInfo 
                + "\n\nDiameter: " + strDiamInfo + "\n\nEccentricity: " + strEccInfo );
        textDiffractionInfo.setFont(Font.font("Book Antica", 14));
        textDiffractionInfo.setPrefSize(PREFSIZE_X, PREFSIZE_Y + 100);
        textDiffractionInfo.setWrapText(true);
        textDiffractionInfo.setEditable(false);
        
        stakePaneAbout.getChildren().add(textDiffractionInfo);
        
        Scene scene = new Scene(stakePaneAbout, PREFSIZE_X, PREFSIZE_Y + 300);
        stageAbout.setScene(scene);
        stageAbout.show();
    }

}
