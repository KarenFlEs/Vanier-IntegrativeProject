
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
    
    private final int POSITION_X = 340;
    private final int POSITION_Y = 300;
    
    BoxBlur circleBoxBlur = new BoxBlur(10, 10, 3);
    BoxBlur arc1BoxBlur = new BoxBlur(20, 20, 3);
    BoxBlur arc2BoxBlur = new BoxBlur(25, 25, 3);
    BoxBlur arc3BoxBlur = new BoxBlur(28, 28, 3);

    public DiffEngine() {
    }
    
    
    public void addDiffraction(Pane paneAnimation, int wavelength, double eccentricity, double slitDistance){
        
        Color color = addColor(wavelength); 
        double newRadius1 = adjustRadius(wavelength, slitDistance, 1); 
        double newRadius2 = adjustRadius(wavelength, slitDistance, 2); 
        double newRadius3 = adjustRadius(wavelength, slitDistance, 3); 
        double newRadius4 = adjustRadius(wavelength, slitDistance, 4); 
        
        //The circles on the right
        Circle rightCircle = new Circle (); 
        rightCircle.setTranslateX(POSITION_X);
        rightCircle.setTranslateY(POSITION_Y);
        rightCircle.setFill(color);
        rightCircle.setRadius(newRadius1*130);
        rightCircle.setEffect(circleBoxBlur);
        rightCircle.setScaleX(eccentricity);
        
        Circle arcCircle1 = new Circle (); 
        arcCircle1.setTranslateX(POSITION_X);
        arcCircle1.setTranslateY(POSITION_Y);
        arcCircle1.setRadius(newRadius2*100);
        arcCircle1.setStrokeWidth((newRadius2 - newRadius1)*50);
        arcCircle1.setStroke(color);
        arcCircle1.setFill(Color.BLACK);
        arcCircle1.setOpacity(0.7);
        arcCircle1.setEffect(arc1BoxBlur);
        arcCircle1.setScaleX(eccentricity);
       
        Circle arcCircle2 = new Circle (); 
        arcCircle2.setTranslateX(POSITION_X);
        arcCircle2.setTranslateY(POSITION_Y);
        arcCircle2.setRadius(newRadius3*100);
        arcCircle2.setStrokeWidth((newRadius3 - newRadius2)*50);
        arcCircle2.setStroke(color);
        arcCircle2.setFill(Color.BLACK);
        arcCircle2.setOpacity(0.5);
        arcCircle2.setEffect(arc2BoxBlur);
        arcCircle2.setScaleX(eccentricity); 
        
        Circle arcCircle3 = new Circle (); 
        arcCircle3.setTranslateX(POSITION_X);
        arcCircle3.setTranslateY(POSITION_Y);
        arcCircle3.setRadius(newRadius4*100);
        arcCircle3.setStrokeWidth((newRadius4 - newRadius3)*50);
        arcCircle3.setStroke(color);
        arcCircle3.setFill(Color.BLACK);
        arcCircle3.setOpacity(0.2);
        arcCircle3.setEffect(arc3BoxBlur);
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
    
    // Intergrate the math calculations in the animation
    public double adjustRadius(int wavelength, double slitDistance, int orderNum){
        DiffractionSim diffSim = new DiffractionSim();
        diffSim.calculationAngle(wavelength, slitDistance, orderNum);
        double circleRadius = diffSim.calculationDiffractionRadius(); 
        return circleRadius; 
    }
    
    /*
    public double diffractionRadius(boolean isWavelengthChanged, boolean isDiameterChanged, int wavelength){
        double diffractionRadius; 
                
        if (isWavelengthChanged){
            diffractionRadius = adjustRadius(wavelength); 
        }
        if (isDiameterChanged)
                
    }
    */
    
   
    public boolean isInside(){
        return true; //for now
    }
}
