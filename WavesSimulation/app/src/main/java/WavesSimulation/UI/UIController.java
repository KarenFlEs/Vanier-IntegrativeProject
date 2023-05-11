
package WavesSimulation.UI;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.NoArgsConstructor;

@NoArgsConstructor
/**
 *
 * @author Steven Dy and Karen Florian
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
    
    @FXML
    private MenuItem menuItemReset; 

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
        
        menuItemReset.setDisable(true);
    }

    public UIController(Stage owner) {
        this.owner = owner;
    }
    
    public void openInterSimulation() throws IOException{
        owner.close();
        IntSimulationWindow interSim = new IntSimulationWindow();
        interSim.show();
    }
    
    public void openSlitsSimulation() throws IOException{
        owner.close();
        SlitsSimulationWindow slitsSim = new SlitsSimulationWindow();
        slitsSim.show();
    }
    
    public void openDiffSimulation() throws IOException{
        owner.close();
        DiffSimulationWindow diffSim = new DiffSimulationWindow();
        diffSim.show();
    }
    
    @FXML
    public void handleBtnInt() throws IOException{
        openInterSimulation(); 
    }
    
    @FXML
    public void handleBtnSlit() throws IOException{
        openSlitsSimulation(); 
    }
    @FXML
    public void handleBtnDiff() throws IOException{
        openDiffSimulation(); 
    }
    
    @FXML
    public void handleCloseFile(){
        owner.close();
    }
    
    @FXML
    public void handleInterSimSelection () throws IOException {
        openInterSimulation(); 
    }
    
    @FXML
    public void handleSlitsSimSelection () throws IOException {
        openSlitsSimulation(); 
    }
    
    @FXML
    public void handleDiffSimSelection () throws IOException  {
        openDiffSimulation(); 
    }
    
    @FXML
    public void handleHelpAbout(){
        Stage stageHelp = new Stage();
        stageHelp.initModality(Modality.NONE);
        stageHelp.setTitle("Project information");
        stageHelp.setX(50); 
        stageHelp.setY(50); 
        
        StackPane stakePaneHelp = new StackPane();
       
        String strIntro = "This project is a simulation regarding the physical concepts: "
                + "Interference, Slits and Diffraction";
        
        String strInterferenceDef = "\n\nInterference "; 
        
        String strDiffractionDef = "\n\nDiffraction is the process of putting a beam light through "
                + "a narrow aperture in which spreads out the waves"; 
        
        String strSlitsDef = "\n\nSlits "; 
        
        TextArea textInformation = new TextArea();
        textInformation.autosize();
        textInformation.setText(strIntro + strInterferenceDef + strDiffractionDef + strSlitsDef);
        textInformation.setFont(Font.font("Book Antica", 14));
        textInformation.setPrefSize(300, 200);
        textInformation.setWrapText(true);
        textInformation.setEditable(false);
        
        stakePaneHelp.getChildren().add(textInformation);
        
        Scene scene = new Scene(stakePaneHelp,300,400);
        stageHelp.setScene(scene);
        stageHelp.show();
    }
    
}


