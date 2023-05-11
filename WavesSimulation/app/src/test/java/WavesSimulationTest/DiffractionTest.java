/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package WavesSimulationTest;

import WavesSimulation.Diffraction.DiffractionSim;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


class DiffractionTest {
    
    private final DiffractionSim diffSim = new DiffractionSim(); 
    
    /**
     * If the number is calculated, then it does not have a value of 0.00
     * @param num
     * @return 
     */
    private boolean isCalculated (double num){
        return num != 0.00 ; 
    }
    
    @Test void testDiffAngle (){
        System.out.println("Test Angle Calculation");
        boolean expResult = true; 
        int wavelength = 380; 
        double slitDistance = 10.0; 
        int orderNum = 1; 
        System.out.println("Calculated Angle: " + diffSim.calculationAngle(wavelength, slitDistance, orderNum));
        
        boolean calcResult = isCalculated(diffSim.calculationAngle(wavelength, slitDistance, orderNum)); 
        assertEquals (expResult, calcResult); 
    }
    
    @Test void testDiffRadius (){
        System.out.println("Test Radius Calculation");
        boolean expResult = true; 
        double angle = 0.217; 
        diffSim.setDiffractionAngle(angle);
        System.out.println("Calculated Radius: " + diffSim.calculationDiffractionRadius());
        
        boolean calcResult = isCalculated(diffSim.calculationDiffractionRadius()); 
        assertEquals (expResult, calcResult); 
    }
    
}
