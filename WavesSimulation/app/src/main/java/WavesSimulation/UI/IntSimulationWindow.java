
package WavesSimulation.UI;

import WavesSimulation.Interference.InterController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * InterfenceSimulationWindow
 * @author Steven & Darina
 */
public class IntSimulationWindow extends Stage {
    
     public IntSimulationWindow() throws IOException {
        loadComponents();
    }
    
    private void loadComponents() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/InterferenceSimLayout.fxml"));
         
        InterController mainController = new InterController(this);
        loader.setController(mainController);

        Parent root = loader.load();
        
        Scene scene = new Scene(root, 800, 600);
        this.setScene(scene);
        this.setTitle("Interference Simulation");
        this.setMaximized(true);
        this.show();
    }
}

