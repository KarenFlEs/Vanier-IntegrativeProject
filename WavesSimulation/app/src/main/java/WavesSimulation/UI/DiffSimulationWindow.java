
package WavesSimulation.UI;

import WavesSimulation.Diffraction.DiffController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Steven & Karen
 */
public class DiffSimulationWindow extends Stage {
    
    public DiffSimulationWindow() throws IOException {
        loadComponents();
    }
    
    private void loadComponents() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/DiffractionSimLayout.fxml"));
        
        DiffController mainController = new DiffController();
        loader.setController(mainController);

        Parent root = loader.load();
        
        Scene scene = new Scene(root, 800, 600);
        this.setScene(scene);
        this.setTitle("Diffraction Simulation");
        this.setMaximized(true);
        this.show();
    }
}

