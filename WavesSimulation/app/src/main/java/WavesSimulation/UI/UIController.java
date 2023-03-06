/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WavesSimulation.UI;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author 2153617
 */
public class UIController extends Stage {

    Stage owner;

    @FXML
    private Rectangle recInt;

    @FXML
    private Rectangle recSlit;

    @FXML
    private Rectangle recDiff;

    @FXML
    private Button btnInt;

    @FXML
    private Button btnSlit;
    
    @FXML
    private Button btnDiff;

    Image imvInt = new Image("/images/interference.jpg");
    ImagePattern impInt = new ImagePattern(imvInt);

    Image imvSlit = new Image("/images/Slits.jpg");
    ImagePattern impSlit = new ImagePattern(imvSlit);

    Image imvDiff = new Image("/images/Diffraction.jpg");
    ImagePattern impDiff = new ImagePattern(imvDiff);

    @FXML
    public void initialize() {
        recInt.setFill(impInt);
        recSlit.setFill(impSlit);
        recDiff.setFill(impDiff);
        
        btnSlit.toFront();
        btnInt.toFront();
        btnDiff.toFront();
    }

    public UIController(Stage owner) {
        this.owner = owner;
        
        //recInt.setFill(value);
    }
    
    @FXML
    public void handleBtnInt(){
        
    }
    
    @FXML
    public void handleBtnSlit() throws IOException{
        SlitsSimulationWindow slitsSim = new SlitsSimulationWindow();
        slitsSim.show();
        owner.close();
    }
    @FXML
    public void handleBtnDiff(){
        
    }

}
