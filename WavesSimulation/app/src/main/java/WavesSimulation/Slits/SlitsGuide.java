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

        Scene scene = new Scene(root, 100, 100);
        this.setScene(scene);
        this.show();
    }
}

class FrequencyGuide {

}

class amplitudeGuide {

}

class widthGuide {

}

class seperationGuide {

}
