
package WavesSimulation.Interference;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
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
   
    
    private Arc topArc = new Arc(400,300,240,240,-90,180);
    private Arc bottomArc = new Arc(400,300,240,240, -90, 180);
    
    
    private ScaleTransition scaleTopCirc = new ScaleTransition(Duration.seconds(5), topCirc);
    private ScaleTransition scaleBottomCirc = new ScaleTransition(Duration.seconds(5), bottomCirc);
    
    
    private TranslateTransition translateTopArc = new TranslateTransition(Duration.seconds(5), topArc);
    private TranslateTransition translateBottomArc = new TranslateTransition(Duration.seconds(5), bottomArc);
    
    private ScaleTransition scaleTopArc = new ScaleTransition(Duration.seconds(5), topArc);
    private ScaleTransition scaleBottomArc = new ScaleTransition(Duration.seconds(5), bottomArc);
    
    
    private ParallelTransition parallelTransitionTop = new ParallelTransition(translateTopArc, scaleTopArc);
    private ParallelTransition parallelTransitionBottom = new ParallelTransition(translateBottomArc, scaleBottomArc);
    
    private BoxBlur blurCircle = new BoxBlur(10, 10, 1);
    private BoxBlur blurArc = new BoxBlur(10, 10, 1);
    
    private InterController interController; 
    
    public void playTopAnimation(){
        topCirc.fillProperty().set(null);
        scaleTopCirc.play();   
        topArc.setVisible(true);
        parallelTransitionTop.play();
        parallelTransitionTop.setDelay(scaleTopCirc.getCycleDuration());
    }
    
     public void playBottomAnimation(){
        bottomCirc.fillProperty().set(null);
        scaleBottomCirc.play();
        bottomArc.setVisible(true);
        parallelTransitionBottom.play();
        parallelTransitionBottom.setDelay(scaleBottomCirc.getCycleDuration());
    }
    
    public void setAnimation(Pane animationPane){
        topCirc.setFill(Color.BLUE);
        topCirc.setStrokeWidth(5);
        topCirc.setStroke(Color.BLUE);
        topCirc.setLayoutX(40);
        topCirc.setLayoutY(270);
      //  topCirc.setEffect(blurCircle);
        animationPane.getChildren().addAll(topCirc);
      
        scaleTopCirc.setByX(8f);
        scaleTopCirc.setByY(8f);
        scaleTopCirc.setCycleCount(Animation.INDEFINITE);
        
        bottomCirc.setFill(Color.BLUE);
        bottomCirc.setStrokeWidth(5);
        bottomCirc.setStroke(Color.BLUE);
        bottomCirc.setLayoutX(40);
        bottomCirc.setLayoutY(490);
        
      //  bottomCirc.setEffect(blurCircle);
        animationPane.getChildren().addAll(bottomCirc);
       
        scaleBottomCirc.setByX(8f);
        scaleBottomCirc.setByY(8f);
        scaleBottomCirc.setCycleCount(Animation.INDEFINITE);
        
    }
    public void setAnimationArc(Pane animationPane){
        topArc.setLayoutX(-320);
        topArc.setLayoutY(-40);
        topArc.setStrokeWidth(15);
        topArc.setStroke(Color.BLUE);
        topArc.fillProperty().set(null);
        topArc.setEffect(blurArc);
        topArc.setVisible(false);
        animationPane.getChildren().add(topArc);
        
        bottomArc.setLayoutX(-320);
        bottomArc.setLayoutY(200);
        bottomArc.setStrokeWidth(15);
        bottomArc.setStroke(Color.BLUE);
        bottomArc.fillProperty().set(null);
        bottomArc.setEffect(blurArc);
        bottomArc.setVisible(false);
        animationPane.getChildren().add(bottomArc);
        
        scaleTopArc.setByX(2f);
        scaleTopArc.setByY(2f);
        translateTopArc.setByX(400);
        translateTopArc.setInterpolator(Interpolator.LINEAR);
        parallelTransitionTop.setDelay(Duration.seconds(5));
        parallelTransitionTop.setCycleCount(Animation.INDEFINITE);
        
        scaleBottomArc.setByX(2f);
        scaleBottomArc.setByY(2f);
        translateBottomArc.setByX(400);
        translateBottomArc.setInterpolator(Interpolator.LINEAR);
        parallelTransitionBottom.setDelay(Duration.seconds(5));
        parallelTransitionBottom.setCycleCount(Animation.INDEFINITE);
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

    public Arc getTopArc() {
        return topArc;
    }

    public void setTopArc(Arc topArc) {
        this.topArc = topArc;
    }

    public Arc getBottomArc() {
        return bottomArc;
    }

    public void setBottomArc(Arc bottomArc) {
        this.bottomArc = bottomArc;
    }
    
    
}

