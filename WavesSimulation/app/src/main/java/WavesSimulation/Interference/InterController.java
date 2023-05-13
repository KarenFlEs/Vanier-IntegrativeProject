package WavesSimulation.Interference;

import WavesSimulation.UI.MainApp;
import WavesSimulation.UI.UIController;
import java.io.IOException;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
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
    private CheckBox checkBox1;

    @FXML
    private CheckBox checkBox2;

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

    final int faucetX = 160;
    final int faucetTopY = 270;
    final int faucetBottomY = 490;
    final int faucetSize = 140;

    /**
     * This is the initialize method which runs when the Interference window is
     * opened
     */
    public void initialize() {
        imageFaucetTop.setFitHeight(faucetSize);
        imageFaucetTop.setFitWidth(faucetSize);
        imageFaucetTop.setTranslateX(faucetX);
        imageFaucetTop.setTranslateY(faucetTopY);

        imageFaucetBottom.setFitHeight(faucetSize);
        imageFaucetBottom.setFitWidth(faucetSize);
        imageFaucetBottom.setTranslateX(faucetX);
        imageFaucetBottom.setTranslateY(faucetBottomY);

        backgroundPane.getChildren().addAll(imageFaucetTop, imageFaucetBottom);
        btnStartTop.toFront();
        btnStartBottom.toFront();
        
        checkBox1.setSelected(true);

        sldAmp.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int amp;
                amp = (int) sldAmp.getValue() / 10;
                engine.setBlur(amp);
            }
        });

        sldFreq.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int freq;
                freq = (int) sldFreq.getValue() / 60;
                engine.setSpeed(freq);
            }
        });

    }

    public InterController() {
    }

    public InterController(Stage owner) {
        this.owner = owner;
    }

    /**
     * This method handles the info button for the frequency explaining the
     * changes that will be made when modifying it
     *
     * @param event
     */
    @FXML
    public void handleBtnInfoFreq(ActionEvent event) {
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

        Scene scene = new Scene(layout, 300, 200);

        newStage.setScene(scene);

        newStage.show();
    }

    /**
     * This methods handles the info button for the Amplitude explaining the
     * changes that will be made when modifying it
     *
     * @param event
     */
    @FXML
    public void handleBtnInfoAmp(ActionEvent event) {
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

        Scene scene = new Scene(layout, 300, 200);

        newStage.setScene(scene);

        newStage.show();
    }

    /**
     * This method handles the info button for the Separation explaining the
     * changes that will be made when modifying it
     *
     * @param event
     */
    @FXML
    public void handleBtnInfoSep(ActionEvent event) {
        Stage newStage = new Stage();

        newStage.initModality(Modality.APPLICATION_MODAL);

        newStage.setTitle("Separation information");

        StackPane layout = new StackPane();

        TextArea text = new TextArea();
        text.autosize();
        text.setText("The first option of configuration shows wave interference"
                + " when the waves are closer in distance, while the second "
                + "configuration shows the waves when they are further apart. "
                + "This distance between them determines the time the interference"
                + " would accure, in shorter time when separation is smaller and"
                + " in a longer time when bigger separation.");
        text.setPrefSize(300, 200);
        text.setWrapText(true);
        text.setEditable(false);

        layout.getChildren().add(text);

        Scene scene = new Scene(layout, 300, 200);

        newStage.setScene(scene);

        newStage.show();
    }

    /**
     * This method handles the start button at the top of the animation
     *
     * @param event
     */
    @FXML
    public void handleBtnStartTop(ActionEvent event) {
        if (!isPlaying) {
            isPlaying = true;
            engine.setAnimationTopCircles(animationPane);
            engine.playTopAnimation();
            btnStartBottom.setDisable(true);
            btnStart.setDisable(true);
        } else {
            isPlaying = false;
            engine.stopTopAnimation();
            engine.clearAnimation(animationPane);
            btnStartBottom.setDisable(false);
            btnStart.setDisable(false);
        }
    }

    /**
     * This method handles the start button in the middle for the two faucets
     *
     * @param event
     */
    @FXML
    public void handleBtnStart(ActionEvent event) {
        if (!isPlaying) {
            isPlaying = true;
            engine.clearAnimation(animationPane);
            engine.setAnimation(animationPane);
            engine.setAnimationArc(animationPane);
            engine.playAnimation();
            btnStartBottom.setDisable(true);
            btnStartTop.setDisable(true);
        } else {
            isPlaying = false;
            engine.stopAnimation();
            engine.clearAnimation(animationPane);
            btnStartBottom.setDisable(false);
            btnStartTop.setDisable(false);
        }
    }

    /**
     * This method handles the start button at the bottom of the animation
     *
     * @param event
     */
    @FXML
    public void handleBtnStartBottom(ActionEvent event) {
        if (!isPlaying) {
            isPlaying = true;
            engine.setAnimationBottomCircles(animationPane);
            engine.playBottomAnimation();
            btnStart.setDisable(true);
            btnStartTop.setDisable(true);
        } else {
            isPlaying = false;
            engine.stopBottomAnimation();
            engine.clearAnimation(animationPane);
            btnStart.setDisable(false);
            btnStartTop.setDisable(false);
        }
    }

    /**
     * This method handles the checkBox of the first separation configuration
     *
     * @param event
     */
    @FXML
    public void handleCheckBox1(ActionEvent event) {
        if (checkBox1.isSelected()) {
            checkBox2.setSelected(false);
            checkBox1.setSelected(true);
            engine.setFaucetDistance(0);
            imageFaucetTop.setTranslateY(faucetTopY);
            imageFaucetBottom.setTranslateY(faucetBottomY);
        }
    }

    /**
     * This method handles the checkBox of the second separation configuration
     *
     * @param event
     */
    @FXML
    public void handleCheckBox2(ActionEvent event) {
        if (checkBox2.isSelected()) {
            checkBox1.setSelected(false);
            checkBox2.setSelected(true);
            engine.setFaucetDistance(60);
            imageFaucetTop.setTranslateY(faucetTopY - 60);
            imageFaucetBottom.setTranslateY(faucetBottomY + 60);
        }
    }

    /**
     * This method opens an information window when selected from the menu bar
     * explaining interference
     */
    @FXML
    public void handleAbout() {
        Stage stageAbout = new Stage();
        stageAbout.initModality(Modality.NONE);
        stageAbout.setTitle("Interference Information");
        stageAbout.setX(50);
        stageAbout.setY(50);

        StackPane stakePaneAbout = new StackPane();

        TextArea textInterInfo = new TextArea();
        textInterInfo.autosize();
        textInterInfo.setText("Interference is the phenomenon that occurs"
                + " when two waves meet in the same medium. When changing the"
                + " amplitude, the waves become less bright and precise when the"
                + " amplitude decreases and much more defined when the amplitude"
                + " increases. The frequency modifies the spead of the waves."
                + " Speed increases proportionally to increase in frequency."
                + " Separation also affects the interference, when they are further"
                + " apart, the waves meet further in time. ");
        textInterInfo.setPrefSize(300, 200);
        textInterInfo.setWrapText(true);
        textInterInfo.setEditable(false);

        stakePaneAbout.getChildren().add(textInterInfo);

        Scene scene = new Scene(stakePaneAbout, 300, 400);
        stageAbout.setScene(scene);
        stageAbout.show();
    }

    /**
     * This methods closes the interference simulation window when chosen from
     * the menu bar
     */
    @FXML
    public void handleClose() {
        owner.close();
    }

    /**
     * This method opens the initial window when running the project with the
     * menu
     */
    public void openMenu() throws IOException {
        owner.close();
        Stage stageMenu = new Stage();
        MainApp mainApp = new MainApp();
        mainApp.menuPage(stageMenu);
    }

    /**
     * This method calls the openMenu() method when selected from the menu bar
     */
    @FXML
    public void handleOpenMenu() throws IOException {
        openMenu();

    }

    /**
     * This method opens the diffraction simulation when selected from the menu
     * bar
     */
    @FXML
    public void handleOpenDif() throws IOException {
        UIController uiController = new UIController(owner);
        uiController.openDiffSimulation();
    }

    /**
     * This method opens the slits simulation when selected from the menu bar
     */
    @FXML
    public void handleOpenSlits() throws IOException {
        UIController uiController = new UIController(owner);
        uiController.openSlitsSimulation();
    }
}
