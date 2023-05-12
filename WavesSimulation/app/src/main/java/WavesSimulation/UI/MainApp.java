
package WavesSimulation.UI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 2045287
 */
public class MainApp extends Application {
    
    public void menuPage (Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/CoverPageLayout.fxml"));
        UIController mainController = new UIController(stage);
        loader.setController(mainController);
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Waves Simulation");
        stage.setMaximized(true);
        stage.show();
    }
    
    public void start(Stage stage) throws Exception {
        menuPage(stage); 
        System.out.println("Note: the simulation will work with screen dimensions of 1295 x 687");
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
