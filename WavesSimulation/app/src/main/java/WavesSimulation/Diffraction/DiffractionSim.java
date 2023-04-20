
package WavesSimulation.Diffraction;

/**
 *
 * @author KarenFl
 */
public class DiffractionSim {
    
    private final int ORDER_NUM = 1; 
    private double diffractionAngle; 
    private double diffractionRadius; 
    //private final double slitDistance = 0.001; 
    private final double LENGTH_TO_SCREEN = 5.0; 

    public double getDiffractionAngle() {
        return diffractionAngle;
    }

    public void setDiffractionAngle(double diffractionAngle) {
        this.diffractionAngle = diffractionAngle;
    }

    public double getDiffractionRadius() {
        return diffractionRadius;
    }

    public void setDiffractionRadius(double diffractionRadius) {
        this.diffractionRadius = diffractionRadius;
    }
    
    protected double calculationAngle (int wavelength, double slitDistance){
       //dsin(angle)= m(wavelength)
       double sinOfAngle = (Math.pow(10, -4)*wavelength*ORDER_NUM)/slitDistance; 
       double angle = Math.toDegrees(Math.asin(sinOfAngle)); 
       setDiffractionAngle(angle); 
       
       return getDiffractionAngle(); 
   }
    
    protected double calculationDiffractionRadius (){
       //y=Ltan(angle)
       double height = LENGTH_TO_SCREEN*Math.tan(getDiffractionAngle()); 
       setDiffractionRadius(height); 
       
       return getDiffractionRadius(); 
   }
    
}

