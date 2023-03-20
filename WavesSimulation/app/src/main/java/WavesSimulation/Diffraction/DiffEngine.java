/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WavesSimulation.Diffraction;

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
    
    public void addDiffraction(){
        
    }
    
    public void addLaser(int wavelength){
        
    }
    
    public void adjustDiameter(int diameter){
        
    }
    
    public void adjustEcc(int ecc){
 
    }
    
    public boolean isInside(){
        return true; //for now
    }
}
