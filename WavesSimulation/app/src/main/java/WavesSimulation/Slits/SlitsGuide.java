/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WavesSimulation.Slits;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 2153617
 */
public class SlitsGuide extends Stage {

    public SlitsGuide() throws IOException {
        loadComponents();
    }

    private void loadComponents() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/SlitsGuideLayout.fxml"));

        //SlitsController mainController = new SlitsController(this);
        //loader.setController(mainController);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        this.setScene(scene);
        this.show();
    }
}

class FrequencyGuide extends Stage {
public FrequencyGuide() throws IOException {
        loadComponents();
    }

    private void loadComponents() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/FrequencyGuidelayout.fxml"));

        //SlitsController mainController = new SlitsController(this);
        //loader.setController(mainController);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        this.setScene(scene);
        this.show();
    }
}

class AmplitudeGuide extends Stage {
   public AmplitudeGuide() throws IOException {
        loadComponents();
    }

    private void loadComponents() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/AmplitudeGuideLayout.fxml"));

        //SlitsController mainController = new SlitsController(this);
        //loader.setController(mainController);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        this.setScene(scene);
        this.show();
    }
}

class WidthGuide extends Stage {
    public WidthGuide() throws IOException {
        loadComponents();
    }

    private void loadComponents() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/WidthGuidelayout.fxml"));

        //SlitsController mainController = new SlitsController(this);
        //loader.setController(mainController);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        this.setScene(scene);
        this.show();
    }

}

class SeperationGuide extends Stage {
public SeperationGuide() throws IOException {
        loadComponents();
    }

    private void loadComponents() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/SeperationGuidelayout.fxml"));

        //SlitsController mainController = new SlitsController(this);
        //loader.setController(mainController);
        Parent root = loader.load();

        Scene scene = new Scene(root);
        this.setScene(scene);
        this.show();
    }
}