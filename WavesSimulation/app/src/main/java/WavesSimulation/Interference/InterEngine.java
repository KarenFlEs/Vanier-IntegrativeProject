/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WavesSimulation.Interference;

/**
 *
 * @author Darina
 */
public class InterEngine {
    
    private int frequency;
    private int amplitude;
    private int slitSep;

    public InterEngine() {
    }

    public InterEngine(int frequency, int amplitude, int slitSep) {
        this.frequency = frequency;
        this.amplitude = amplitude;
        this.slitSep = slitSep;
    }
    
    
    public void addWaves(int frequency, int amplitude){
        
    }
    
    public void adjustSeparation(int slitSep){
        
    }
    
    public void motion(){
        
    }
    public boolean isInside(){
        return true; //for now
    }
}

