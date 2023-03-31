
package WavesSimulation.Interference;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author Darina
 */
public class InterEngine {
    
    private int frequency;
    private int amplitude;
    private int slitSep;
    
    private Circle topCirc = new Circle(30);
    private Circle bottomCirc = new Circle(30);
    
    private TranslateTransition translateTopCirc = new TranslateTransition(Duration.seconds(4), topCirc);
    private TranslateTransition translateBottomCirc = new TranslateTransition(Duration.seconds(4), bottomCirc);
    
    private ScaleTransition scaleTopCirc = new ScaleTransition(Duration.seconds(4), topCirc);
    private ScaleTransition scaleBottomCirc = new ScaleTransition(Duration.seconds(4), bottomCirc);
    
    private InterController interController; 
    
    public void playTopAnimation(){
        translateTopCirc.play();
        scaleTopCirc.play();
    }
    
     public void playBottomAnimation(){
        translateBottomCirc.play(); 
        scaleBottomCirc.play();
    }
    
    public void setAnimation(Pane animationPane){
        topCirc.setFill(Color.BLUE);
        topCirc.setLayoutY(270);
        topCirc.setLayoutX(30);
        animationPane.getChildren().addAll(topCirc);
        
        translateTopCirc.setByX(800);
        translateTopCirc.setInterpolator(Interpolator.LINEAR);
        translateTopCirc.setCycleCount(Animation.INDEFINITE);
        
        scaleTopCirc.setByX(6f);
        scaleTopCirc.setByY(6f);
        scaleTopCirc.setCycleCount(Animation.INDEFINITE);
        
        bottomCirc.setFill(Color.BLUE);
        bottomCirc.setLayoutY(490);
        bottomCirc.setLayoutX(30);
        animationPane.getChildren().addAll(bottomCirc);
        
        translateBottomCirc.setByX(800);
        translateBottomCirc.setInterpolator(Interpolator.LINEAR);
        translateBottomCirc.setCycleCount(Animation.INDEFINITE);
        
        scaleBottomCirc.setByX(6f);
        scaleBottomCirc.setByY(6f);
        scaleBottomCirc.setCycleCount(Animation.INDEFINITE);
    }
    
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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(int amplitude) {
        this.amplitude = amplitude;
    }

    public int getSlitSep() {
        return slitSep;
    }

    public void setSlitSep(int slitSep) {
        this.slitSep = slitSep;
    }

    public Circle getTopCirc() {
        return topCirc;
    }

    public void setTopCirc(Circle topCirc) {
        this.topCirc = topCirc;
    }

    public Circle getBottomCirc() {
        return bottomCirc;
    }

    public void setBottomCirc(Circle bottomCirc) {
        this.bottomCirc = bottomCirc;
    }

    public TranslateTransition getTranslateTopCirc() {
        return translateTopCirc;
    }

    public void setTranslateTopCirc(TranslateTransition translateTopCirc) {
        this.translateTopCirc = translateTopCirc;
    }

    public TranslateTransition getTranslateBottomCirc() {
        return translateBottomCirc;
    }

    public void setTranslateBottomCirc(TranslateTransition translateBottomCirc) {
        this.translateBottomCirc = translateBottomCirc;
    }
    
}

