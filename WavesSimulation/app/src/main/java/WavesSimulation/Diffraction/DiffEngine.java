
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
    
    public void addDiffraction(Pane paneAnimation, int wavelength, double eccentricity){
        
        Color color = addColor(wavelength); 
        double newRadius = adjustDiameter(wavelength); 
        
        //The circles on the right
        Circle rightCircle = new Circle (); 
        rightCircle.setTranslateX(340);
        rightCircle.setTranslateY(300);
        rightCircle.setFill(color);
        rightCircle.setRadius(newRadius*500);
        rightCircle.setEffect(new BoxBlur(10, 10, 3));
        rightCircle.setScaleX(eccentricity);
        
        Circle arcCircle1 = new Circle (); 
        arcCircle1.setTranslateX(340);
        arcCircle1.setTranslateY(300);
        arcCircle1.setRadius(150);
        arcCircle1.setStrokeWidth(50.0);
        arcCircle1.setStroke(color);
        arcCircle1.setFill(Color.BLACK);
        arcCircle1.setOpacity(0.7);
        arcCircle1.setEffect(new BoxBlur(20, 20, 3));
        arcCircle1.setScaleX(eccentricity);
       
        Circle arcCircle2 = new Circle (); 
        arcCircle2.setTranslateX(340);
        arcCircle2.setTranslateY(300);
        arcCircle2.setRadius(250);
        arcCircle2.setStrokeWidth(50.0);
        arcCircle2.setStroke(color);
        arcCircle2.setFill(Color.BLACK);
        arcCircle2.setOpacity(0.5);
        arcCircle2.setEffect(new BoxBlur(20, 20, 3));
        arcCircle2.setScaleX(eccentricity); 
        
        Circle arcCircle3 = new Circle (); 
        arcCircle3.setTranslateX(340);
        arcCircle3.setTranslateY(300);
        arcCircle3.setRadius(350);
        arcCircle3.setStrokeWidth(50.0);
        arcCircle3.setStroke(color);
        arcCircle3.setFill(Color.BLACK);
        arcCircle3.setOpacity(0.2);
        arcCircle3.setEffect(new BoxBlur(28, 28, 3));
        arcCircle3.setScaleX(eccentricity); 
        
        paneAnimation.getChildren().addAll(arcCircle3, arcCircle2, arcCircle1, rightCircle); 
    }
    
    public Color addColor(int wavelength){
        Color color = Color.WHITE; 
       
        if (wavelength <= 420){
            color = Color.PURPLE; 
        }
        else if (wavelength <= 465){
            color = Color.BLUE; 
        }
        else if (wavelength <= 510){
            color = Color.CYAN; 
        }
        else if (wavelength <= 565){
            color = Color.LIME; 
        }
        else if (wavelength <= 610){
            color = Color.YELLOW; 
        }
        else if (wavelength <= 660){
            color = Color.ORANGE; 
        }
        else if (wavelength <= 725){
            color = Color.RED; 
        }
        else if (wavelength <= 780){
            color = Color.DARKRED; 
        }
        
        return color; 
    }
    
    // TODO: Intergrate the math calculations in the animation
    public double adjustDiameter(int wavelength){
        DiffractionSim diffSim = new DiffractionSim();
        diffSim.calculationAngle(wavelength);
        double circleRadius = diffSim.calculationDiffractionRadius(); 
        return circleRadius; 
    }
    
    /*
    public double diffractionRadius(boolean isWavelengthChanged, boolean isDiameterChanged, int wavelength){
        double diffractionRadius; 
                
        if (isWavelengthChanged){
            diffractionRadius = adjustDiameter(wavelength); 
        }
        if (isDiameterChanged)
                
    }
    */
    
    // TODO: intergate the eccentricity values in the beginning
    public void adjustEcc(int ecc){
    }
   
    public boolean isInside(){
        return true; //for now
    }
}
