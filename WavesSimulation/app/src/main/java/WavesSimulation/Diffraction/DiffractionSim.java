
package WavesSimulation.Diffraction;

/**
 * The math part of Diffraction
 * @author KarenFl
 */
public class DiffractionSim {
    
    private double diffractionAngle; 
    private double diffractionRadius; 
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
    
    /**
     * calculates the angle according to the equation: 
     * dsin(angle)= (orderNum)(wavelength)
     * @param wavelength
     * @param slitDistance
     * @param orderNum
     * @return angle
     */
    protected double calculationAngle (int wavelength, double slitDistance, int orderNum){
       double sinOfAngle = (Math.pow(10, -4)*wavelength*orderNum)/slitDistance; 
       double angle = Math.toDegrees(Math.asin(sinOfAngle)); 
       setDiffractionAngle(angle); 
       
       return getDiffractionAngle(); 
   }
    
    /**
     * Calculates the radius according to the equation:
     * y=Ltan(angle)
     * @return radius
     */
    protected double calculationDiffractionRadius (){
       double height = LENGTH_TO_SCREEN*Math.tan(getDiffractionAngle()); 
       setDiffractionRadius(height); 
       
       return getDiffractionRadius(); 
   }
    
}

