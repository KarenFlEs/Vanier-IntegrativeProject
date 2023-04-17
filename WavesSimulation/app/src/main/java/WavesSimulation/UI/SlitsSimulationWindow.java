
package WavesSimulation.UI;

import WavesSimulation.Slits.SlitsController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Steven & Darina
 */
public class SlitsSimulationWindow extends Stage {

    public SlitsSimulationWindow() throws IOException {
        loadComponents();
    }
    
    private void loadComponents() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/SlitsSimLayout.fxml"));
        
        SlitsController mainController = new SlitsController(this);
        loader.setController(mainController);

        Parent root = loader.load();
        
        Scene scene = new Scene(root, 800, 600);
        this.setScene(scene);
        this.setTitle("Slits Simulation");
        this.setMaximized(true);
        this.show();
    }
   
}

