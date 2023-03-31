
package WavesSimulation.Diffraction;

/**
 *
 * @author KarenFl
 */
public class DiffractionSim {
    
    private int orderNumber; 
    private double diffractionAngle; 
    private double diffractionRadius; 
    private final double DISTANCE_BETWEEN_SLITS = 0.1; 
    private final double LENGTH_SLIT = 0.1; 

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getDiffractionAngle() {
        return diffractionAngle;
    }

    public void setDiffractionAngle(double diffractionAngle) {
        this.diffractionAngle = diffractionAngle;
    }
    
     private double calculationAngle (int wavelength){
       //dsin(angle)= m(wavelength)
       double sinOfAngle = (wavelength*getOrderNumber())/DISTANCE_BETWEEN_SLITS; 
       double angle = Math.asin(sinOfAngle); 
       setDiffractionAngle(angle); 
               
       return getDiffractionAngle(); 
   }
    
    private double calculationDiffractionRadius (){
       //y=Ltan(angle)
       double height = LENGTH_SLIT*Math.tan(getDiffractionAngle()); 
       setDiffractionAngle(height); 
       
       return getDiffractionAngle(); 
   }
    
}

