
package WavesSimulation.UI;

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
    
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/CoverPageLayout.fxml"));
        UIController mainController = new UIController(stage);
        loader.setController(mainController);
        Parent root = loader.load();
        
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Waves Simulation");
        stage.setMaximized(true);
        stage.show();
        
        System.out.println(stage.heightProperty().getValue().toString());
        System.out.println(stage.widthProperty().getValue().toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
