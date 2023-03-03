/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WavesSimulation.Slits;

/**
 *
 * @author 2045287
 */
public class SlitsEngine {
    int frequency;
    int amplitude;
    int slitSep;
    int nbSlits;
    int slitWid;

    public SlitsEngine() {
    }

    public SlitsEngine(int frequency, int amplitude, int slitSep, int nbSlits, int slitWid) {
        this.frequency = frequency;
        this.amplitude = amplitude;
        this.slitSep = slitSep;
        this.nbSlits = nbSlits;
        this.slitWid = slitWid;
    }
    
    public void addWaves(int amplitude, int frequency){
        
    }
    
    public void addSlit(int slitSep, int nbSlits, int slitWid){
        
    }
    
    public void motion(){
        
    }
   
    public boolean isInside(){
        return true; //for now
    }
}
