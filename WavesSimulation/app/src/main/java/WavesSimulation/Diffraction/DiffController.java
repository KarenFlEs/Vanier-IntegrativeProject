package WavesSimulation.Diffraction;

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

    private final int WAVE_INFO_POSITION_X = 80; 
    private final int WAVE_INFO_POSITION_Y = 740;
    private final int DIAM_INFO_POSITION_X = 860;
    private final int DIAM_INFO_POSITION_Y = 770;
    private final int ECC_INFO_POSITION_X = 870;
    private final int ECC_INFO_POSITION_Y = 900;
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
    
    String strWaveInfo = "When the wavelength changes, there is a specific color"
        + " the laser will have. As it increases, the size of the slit"
        + " hole will be bigger creating a small diffraction pattern."; 
    
    String strDiamInfo = "The opening of the slit increases if the diameter"
        + " increases which will create a smaller diffraction pattern."; 
    
    String strEccInfo = "When the eccentricity increases, the width of the"
                + " slit opening decreases which will affect the diffraction patterned"
                + " as its height will get smaller."; 
    
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
        textWave.setPrefSize(300, 100);
        textWave.setWrapText(true);
        textWave.setEditable(false);
        
        stackPaneWaveInfo.getChildren().add(textWave);
        
        Scene scene = new Scene(stackPaneWaveInfo, 300, 100);
        stageWaveInfo.setScene(scene);
        stageWaveInfo.show();
    }
    
    @FXML
    public void exitedMouseWaveInfo (){
        stageWaveInfo.close();
    }
    
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
        textDiam.setPrefSize(300, 100);
        textDiam.setWrapText(true);
        textDiam.setEditable(false);
        
        stackPaneDiamInfo.getChildren().add(textDiam);
        
        Scene scene = new Scene(stackPaneDiamInfo, 300, 100);
        stageDiamInfo.setScene(scene);
        stageDiamInfo.show();
    }
    
    @FXML
    public void exitedMouseDiamInfo (){
        stageDiamInfo.close();
    }
    
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
        textEcc.setPrefSize(300, 100);
        textEcc.setWrapText(true);
        textEcc.setEditable(false);
        
        stackPaneEccInfo.getChildren().add(textEcc);
        
        Scene scene = new Scene(stackPaneEccInfo, 300, 100);
        stageEccInfo.setScene(scene);
        stageEccInfo.show();
    }
    
    @FXML
    public void exitedMouseEccInfo (){
        stageEccInfo.close(); 
    }
    
    /*
    TODO: fix the functionality
    */
    @FXML
    public void handleClose (){
        stageSim.close();
    }
    
    @FXML
    public void handleReset (){
        sliderWave.setValue(SLIDER_WAVE_MIN);
        sliderDiameter.setValue(SLIDER_DIAMETER_MIN);
        sliderEcc.setValue(SLIDER_ECC_MIN);
        paneAnimation.getChildren().clear(); 
        paneLaser.getChildren().clear();
    }
    
    @FXML
    public void handleOpenInterSim () throws IOException{
       UIController uiController = new UIController (stageSim); 
       uiController.openInterSimulation();
    }
    
    @FXML
    public void handleOpenSlitsSim () throws IOException{
       UIController uiController = new UIController (stageSim); 
       uiController.openSlitsSimulation();
    }
    
    /**
     * TODO
     */
    @FXML
    public void handleOpenMenuPage () {
    }
    
    @FXML
    public void handleAbout (){ 
        Stage stageAbout = new Stage();
        stageAbout.initModality(Modality.NONE);
        stageAbout.setTitle("Diffraction information");
        stageAbout.setX(50); 
        stageAbout.setY(50); 
        
        StackPane stakePaneAbout = new StackPane();
        String strDiffractionDef = "Diffraction is the process of putting a beam light through "
                + "a narrow aperture in which spreads out the waves"; 
        
        TextArea textDiffractionInfo = new TextArea();
        textDiffractionInfo.autosize();
        textDiffractionInfo.setText(strDiffractionDef + "\n\nWavelength: " + strWaveInfo 
                + "\n\nDiameter: " + strDiamInfo + "\n\nEccentricity: " + strEccInfo );
        textDiffractionInfo.setFont(Font.font("Book Antica", 14));
        textDiffractionInfo.setPrefSize(300, 200);
        textDiffractionInfo.setWrapText(true);
        textDiffractionInfo.setEditable(false);
        
        stakePaneAbout.getChildren().add(textDiffractionInfo);
        
        Scene scene = new Scene(stakePaneAbout,300,600);
        stageAbout.setScene(scene);
        stageAbout.show();
    }

}
