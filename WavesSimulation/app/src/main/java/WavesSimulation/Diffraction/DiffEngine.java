
package WavesSimulation.Diffraction;

import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author KarenFl
 */
public class DiffEngine {
    
    private int wavelength;
    private int diameter;
    private int ecc;

    public DiffEngine() {
    }

    public DiffEngine(int wavelength, int diameter, int ecc) {
        this.wavelength = wavelength;
        this.diameter = diameter;
        this.ecc = ecc;
    }
    
    public void addDiffraction(Pane paneAnimation){
        
        //The circles on the right
        Circle rightCircle = new Circle (); 
        rightCircle.setTranslateX(340);
        rightCircle.setTranslateY(300);
        rightCircle.setFill(Color.WHITE);
        rightCircle.setRadius(100);
        rightCircle.setEffect(new BoxBlur(10, 10, 3));
        
        Circle arcCircle1 = new Circle (); 
        arcCircle1.setTranslateX(340);
        arcCircle1.setTranslateY(300);
        arcCircle1.setRadius(150);
        arcCircle1.setStrokeWidth(50.0);
        arcCircle1.setStroke(Color.WHITE);
        arcCircle1.setFill(Color.BLACK);
        arcCircle1.setOpacity(0.7);
        arcCircle1.setEffect(new BoxBlur(20, 20, 3));
       
        Circle arcCircle2 = new Circle (); 
        arcCircle2.setTranslateX(340);
        arcCircle2.setTranslateY(300);
        arcCircle2.setRadius(250);
        arcCircle2.setStrokeWidth(50.0);
        arcCircle2.setStroke(Color.WHITE);
        arcCircle2.setFill(Color.BLACK);
        arcCircle2.setOpacity(0.5);
        arcCircle2.setEffect(new BoxBlur(20, 20, 3));
        
        Circle arcCircle3 = new Circle (); 
        arcCircle3.setTranslateX(340);
        arcCircle3.setTranslateY(300);
        arcCircle3.setRadius(350);
        arcCircle3.setStrokeWidth(50.0);
        arcCircle3.setStroke(Color.WHITE);
        arcCircle3.setFill(Color.BLACK);
        arcCircle3.setOpacity(0.2);
        arcCircle3.setEffect(new BoxBlur(28, 28, 3));
        
        paneAnimation.getChildren().addAll(arcCircle3, arcCircle2, arcCircle1, rightCircle); 
    }
    
    public void addLaser(int wavelength, Pane paneScreen){
    }
    
    public void adjustDiameter(int wavelength){
        DiffractionSim diffSim = new DiffractionSim();
        diffSim.calculationAngle(wavelength);
        double circleRadius = diffSim.calculationDiffractionRadius(); 
        System.out.println(circleRadius);
    }
    
    public void adjustEcc(int ecc){
    }
    
    public boolean isInside(){
        return true; //for now
    }
}
