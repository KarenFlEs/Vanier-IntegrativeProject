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
    private int frequency;
    private int amplitude;
    private int slitSep;
    private int nbSlits;
    private int slitWid;

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

    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getAmplitude() {
        return this.amplitude;
    }

    public void setAmplitude(int amplitude) {
        this.amplitude = amplitude;
    }

    public int getSlitSep() {
        return this.slitSep;
    }

    public void setSlitSep(int slitSep) {
        this.slitSep = slitSep;
    }

    public int getNbSlits() {
        return this.nbSlits;
    }

    public void setNbSlits(int nbSlits) {
        this.nbSlits = nbSlits;
    }

    public int getSlitWid() {
        return this.slitWid;
    }

    public void setSlitWid(int slitWid) {
        this.slitWid = slitWid;
    }
    
    
}
