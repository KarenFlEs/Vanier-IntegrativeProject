package WavesSimulation.Interference;

import java.util.ArrayList;
import java.util.Arrays;
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
    
    final int animationDuration = 6;
    
    private int frequency;
    private int amplitude;
    private int slitSep;
    
    //top Circles
    private Circle topCirc = new Circle(30);
    private Circle topCirc2 = new Circle(30);
    private Circle topCirc3 = new Circle(30);
    
    //bottom Circles
    private Circle bottomCirc = new Circle(30);
    private Circle bottomCirc2 = new Circle(30);
    private Circle bottomCirc3 = new Circle(30);
    
    //circles arrays
    private ArrayList<Circle> listCircles = new ArrayList<>(Arrays.asList(topCirc, topCirc2, topCirc3));
    private ArrayList<Circle> listBottomCircles = new ArrayList<>(Arrays.asList(bottomCirc, bottomCirc2, bottomCirc3));

    //scale top circle animations
    private ScaleTransition scaleTopCirc = new ScaleTransition(Duration.seconds(animationDuration), topCirc);
    private ScaleTransition scaleTopCirc2 = new ScaleTransition(Duration.seconds(animationDuration), topCirc2);
    private ScaleTransition scaleTopCirc3 = new ScaleTransition(Duration.seconds(animationDuration), topCirc3);
    private ArrayList<ScaleTransition> listScaleTopCirc = new ArrayList<>(Arrays.asList(scaleTopCirc, scaleTopCirc2, scaleTopCirc3));
    
    //scale bottom circle animations
    private ScaleTransition scaleBottomCirc = new ScaleTransition(Duration.seconds(animationDuration), bottomCirc);
    private ScaleTransition scaleBottomCirc2 = new ScaleTransition(Duration.seconds(animationDuration), bottomCirc2);
    private ScaleTransition scaleBottomCirc3 = new ScaleTransition(Duration.seconds(animationDuration), bottomCirc3);
    private ArrayList<ScaleTransition> listScaleBottomCirc = new ArrayList<>(Arrays.asList(scaleBottomCirc, scaleBottomCirc2, scaleBottomCirc3));
    
    //top arcs
    private Arc topArc = new Arc(400, 300, 80, 80, -90, 180);
    private Arc topArc2 = new Arc(400, 300, 80, 80, -90, 180);
    private Arc topArc3 = new Arc(400, 300, 80, 80, -90, 180);
    private ArrayList<Arc> listTopArcs = new ArrayList<>(Arrays.asList(topArc, topArc2, topArc3));
    //bottom arcs
    private Arc bottomArc = new Arc(400, 300, 80, 80, -90, 180);
    private Arc bottomArc2 = new Arc(400, 300, 80, 80, -90, 180);
    private Arc bottomArc3= new Arc(400, 300, 80, 80, -90, 180);
    private ArrayList<Arc> listBottomArcs = new ArrayList<>(Arrays.asList(bottomArc, bottomArc2, bottomArc3));
    
    //top arcs animations
    private TranslateTransition translateTopArc = new TranslateTransition(Duration.seconds(animationDuration), topArc);
    private TranslateTransition translateTopArc2 = new TranslateTransition(Duration.seconds(animationDuration), topArc2);
    private TranslateTransition translateTopArc3 = new TranslateTransition(Duration.seconds(animationDuration), topArc3);
    private ScaleTransition scaleTopArc = new ScaleTransition(Duration.seconds(animationDuration), topArc);
    private ScaleTransition scaleTopArc2 = new ScaleTransition(Duration.seconds(animationDuration), topArc2);
    private ScaleTransition scaleTopArc3 = new ScaleTransition(Duration.seconds(animationDuration), topArc3);
    private ParallelTransition parallelTransitionTop = new ParallelTransition(translateTopArc, scaleTopArc);
    private ParallelTransition parallelTransitionTop2 = new ParallelTransition(translateTopArc2, scaleTopArc2);
    private ParallelTransition parallelTransitionTop3 = new ParallelTransition(translateTopArc3, scaleTopArc3);
    
    private ArrayList<TranslateTransition> listTransTopArc = new ArrayList<>(Arrays.asList(translateTopArc, translateTopArc2, translateTopArc3));
    private ArrayList<ScaleTransition> listScaleTopArc = new ArrayList<>(Arrays.asList(scaleTopArc, scaleTopArc2, scaleTopArc3));
    private ArrayList<ParallelTransition> listParTopArc = new ArrayList<>(Arrays.asList(parallelTransitionTop, parallelTransitionTop2, parallelTransitionTop3));
    //bottom arcs animations
    private TranslateTransition translateBottomArc = new TranslateTransition(Duration.seconds(animationDuration), bottomArc);
    private TranslateTransition translateBottomArc2 = new TranslateTransition(Duration.seconds(animationDuration), bottomArc2);
    private TranslateTransition translateBottomArc3 = new TranslateTransition(Duration.seconds(animationDuration), bottomArc3);
    private ScaleTransition scaleBottomArc = new ScaleTransition(Duration.seconds(animationDuration), bottomArc);
    private ScaleTransition scaleBottomArc2 = new ScaleTransition(Duration.seconds(animationDuration), bottomArc2);
    private ScaleTransition scaleBottomArc3 = new ScaleTransition(Duration.seconds(animationDuration), bottomArc3);
    private ParallelTransition parallelTransitionBottom = new ParallelTransition(translateBottomArc, scaleBottomArc);
    private ParallelTransition parallelTransitionBottom2 = new ParallelTransition(translateBottomArc2, scaleBottomArc2);
    private ParallelTransition parallelTransitionBottom3 = new ParallelTransition(translateBottomArc3, scaleBottomArc3);
    
    private ArrayList<TranslateTransition> listTransBottomArc = new ArrayList<>(Arrays.asList(translateBottomArc, translateBottomArc2, translateBottomArc3));
    private ArrayList<ScaleTransition> listScaleBottomArc = new ArrayList<>(Arrays.asList(scaleBottomArc, scaleBottomArc2, scaleBottomArc3));
    private ArrayList<ParallelTransition> listParBottomArc = new ArrayList<>(Arrays.asList(parallelTransitionBottom, parallelTransitionBottom2, parallelTransitionBottom3));
    
    final int initialArcBlur = 10;
    final int initialCircleBlur = 4;
   
    private BoxBlur blurCircle = new BoxBlur(initialCircleBlur, initialCircleBlur, 1);
    private BoxBlur blurArc = new BoxBlur(initialArcBlur, initialArcBlur, 1);

    private InterController interController;
    
    /**
     * Play the top faucet's animations
     */
    public void playTopAnimation() {
        for (Circle circle : listCircles) {
            circle.setFill(null);
        }
        for (ScaleTransition scale : listScaleTopCirc) {
            scale.play();
            scale.setByX(100f);
            scale.setByY(100f);
            scale.setInterpolator(Interpolator.LINEAR);
            scale.setCycleCount(Animation.INDEFINITE);
            scale.setDuration(Duration.seconds(animationDuration + 10));
        }   
        
    }
    
    public void stopTopAnimation() {
        for (ScaleTransition scale : listScaleTopCirc) {
            scale.stop();
        }
    }

    /**
     * Play the bottom faucet's animations
     */
    public void playBottomAnimation() {
        for (Circle circle : listBottomCircles) {
            circle.setFill(null);
        }
        for (ScaleTransition scale : listScaleBottomCirc) {
            scale.play();
        }   
    }
  
    public void stopBottomAnimation() {
        for (ScaleTransition scale : listScaleBottomCirc) {
            scale.stop();
        }   
    }
    
     /**
     * Play the Both Faucet's animations
     */
    public void playAnimation(){
        //top animations
        for(Circle topCircs : listCircles){
            topCircs.fillProperty().set(null);
        }
        for(ScaleTransition scaleTopCircs : listScaleTopCirc){
            scaleTopCircs.play();
        }
        for(Arc topArcs : listTopArcs){
            topArcs.setVisible(true);
        }
        for(ParallelTransition parTop : listParTopArc){
            parTop.play();
        }
        //bottom animations
        for(Circle bottomCircs : listBottomCircles){
            bottomCircs.fillProperty().set(null);
        }
        for(ScaleTransition scaleBottomCircs : listScaleBottomCirc){
            scaleBottomCircs.play();
        }
        for(Arc bottomArcs : listBottomArcs){
            bottomArcs.setVisible(true);
        }
        for(ParallelTransition parBottom : listParBottomArc){
            parBottom.play();
        }
        
    }
    public void stopAnimation(){
        topCirc.fillProperty().set(null);
        scaleTopCirc.stop();
        topArc.setVisible(false);
        parallelTransitionTop.stop();
        bottomCirc.fillProperty().set(null);
        scaleBottomCirc.stop();
        bottomArc.setVisible(false);
        parallelTransitionBottom.stop();
    }      
    
    public void setBlur (int blur){
        blurCircle.setHeight(initialCircleBlur + blur);
        blurCircle.setWidth(initialCircleBlur + blur);
        blurArc.setHeight(initialArcBlur + blur);
        blurArc.setWidth(initialArcBlur + blur);
        
        for(Circle topCircs : listCircles){
            topCircs.setEffect(blurCircle);
        }
        for(Circle bottomCircs : listBottomCircles){
            bottomCircs.setEffect(blurCircle);
        }
        for(Arc topArcs : listTopArcs){
            topArcs.setEffect(blurArc);
        }
        for(Arc topArcs : listTopArcs){
            topArcs.setEffect(blurArc);
        }
        
    }
    public void setAnimationTopCircles(Pane animationPane){
        
        for (Circle circle : listCircles) {
            circle.setFill(Color.BLUE);
            circle.setStrokeWidth(5);
            circle.setStroke(Color.BLUE);
            circle.setLayoutX(40);
            circle.setLayoutY(270);
            animationPane.getChildren().add(circle);
        }
        for (ScaleTransition scale : listScaleTopCirc) {
            scale.setByX(100f);
            scale.setByY(100f);
            scale.setInterpolator(Interpolator.LINEAR);
            scale.setCycleCount(Animation.INDEFINITE);
        }

        scaleTopCirc2.setDelay(Duration.seconds(2));
        scaleTopCirc3.setDelay(Duration.seconds(4));
        
        clipPane(animationPane);
    }
    
    public void setAnimationBottomCircles(Pane animationPane){
        for (Circle circle : listBottomCircles) {
            circle.setFill(Color.BLUE);
            circle.setStrokeWidth(5);
            circle.setStroke(Color.BLUE);
            circle.setLayoutX(40);
            circle.setLayoutY(490);
            animationPane.getChildren().add(circle);
        }
        for (ScaleTransition scale : listScaleBottomCirc) {
            scale.setByX(60f);
            scale.setByY(60f);
            scale.setInterpolator(Interpolator.LINEAR);
            scale.setCycleCount(Animation.INDEFINITE);
        }

        scaleBottomCirc2.setDelay(Duration.seconds(2));
        scaleBottomCirc3.setDelay(Duration.seconds(4));
        
        clipPane(animationPane);
    }
    /**
     * Set the animation with the correct data for the circles
     *
     * @param animationPane
     */
    public void setAnimation(Pane animationPane) {
        
        for (Circle circle : listCircles) {
            circle.setFill(Color.BLUE);
            circle.setStrokeWidth(5);
            circle.setStroke(Color.BLUE);
            circle.setLayoutX(40);
            circle.setLayoutY(270);
            circle.setEffect(blurCircle);
            animationPane.getChildren().add(circle);
        }
        
        for (Circle circle : listBottomCircles) {
            circle.setFill(Color.BLUE);
            circle.setStrokeWidth(5);
            circle.setStroke(Color.BLUE);
            circle.setLayoutX(40);
            circle.setLayoutY(490);
            circle.setEffect(blurCircle);
            animationPane.getChildren().add(circle);
        }
        
        for (ScaleTransition scale : listScaleTopCirc) {
            scale.setByX(3f);
            scale.setByY(3f);
            scale.setInterpolator(Interpolator.LINEAR);
            scale.setCycleCount(Animation.INDEFINITE);
        }
        
        for (ScaleTransition scale : listScaleBottomCirc) {
            scale.setByX(3f);
            scale.setByY(3f);
            scale.setInterpolator(Interpolator.LINEAR);
            scale.setCycleCount(Animation.INDEFINITE);
        }
        
        scaleTopCirc2.setDelay(Duration.seconds(2));
        scaleTopCirc3.setDelay(Duration.seconds(4));
        
        scaleBottomCirc2.setDelay(Duration.seconds(2));
        scaleBottomCirc3.setDelay(Duration.seconds(4));
       
        clipPane(animationPane);
    }

    /**
     * Set the animation with the correct data for the arcs
     *
     * @param animationPane
     */

    public void setAnimationArc(Pane animationPane) {
        //the arcs at the top
        for (Arc arc : listTopArcs) {
            arc.setLayoutX(-320);
            arc.setLayoutY(-40);
            arc.setStrokeWidth(15);
            arc.setStroke(Color.BLUE);
            arc.fillProperty().set(null);
            arc.setEffect(blurArc);
            arc.setVisible(false);
            animationPane.getChildren().add(arc);
        }
       
        //the arcs at the bottom
        for (Arc arc : listBottomArcs) {
            arc.setLayoutX(-320);
            arc.setLayoutY(200);
            arc.setStrokeWidth(15);
            arc.setStroke(Color.BLUE);
            arc.fillProperty().set(null);
            arc.setEffect(blurArc);
            arc.setVisible(false);
            animationPane.getChildren().add(arc);
        }
        
        //animations top arcs
        for(ScaleTransition scale : listScaleTopArc){
            //scale.setByX(2f);
            scale.setByY(2f);
        }
        
        for(TranslateTransition translate : listTransTopArc){
            translate.setByX(1500);
            translate.setInterpolator(Interpolator.LINEAR);
        }
        
        for(ParallelTransition parallel : listParTopArc){
            parallel.setCycleCount(Animation.INDEFINITE);
        }
        parallelTransitionTop.setDelay(Duration.seconds(2));
        parallelTransitionTop2.setDelay(Duration.seconds(4));
        parallelTransitionTop3.setDelay(Duration.seconds(6));
        
        //animations bottom arcs
        for(ScaleTransition scale : listScaleBottomArc){
            //scale.setByX(2f);
            scale.setByY(2f);
        }
        
        for(TranslateTransition translate : listTransBottomArc){
            translate.setByX(1500);
            translate.setInterpolator(Interpolator.LINEAR);
        }
        
        for(ParallelTransition parallel : listParBottomArc){
            parallel.setCycleCount(Animation.INDEFINITE);
        }
        parallelTransitionBottom.setDelay(Duration.seconds(2));
        parallelTransitionBottom2.setDelay(Duration.seconds(4));
        parallelTransitionBottom3.setDelay(Duration.seconds(6));
 
        clipPane(animationPane);
    }

    /**
     * Makes the animation stay inside the rectangle, cutting its borders
     *
     * @param animationPane
     */
    public void clipPane(Pane animationPane) {
        int rectangleWidth = 1049;
        int rectangleHeight = 704;
        Rectangle clipRectangle = new Rectangle();
        clipRectangle.setWidth(rectangleWidth);
        clipRectangle.setHeight(rectangleHeight);
        animationPane.setClip(clipRectangle);

        animationPane.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            clipRectangle.setWidth(newValue.getWidth());
            clipRectangle.setHeight(newValue.getHeight());
        });
    }

    public InterEngine() {
    }

    public InterEngine(int frequency, int amplitude, int slitSep) {
        this.frequency = frequency;
        this.amplitude = amplitude;
        this.slitSep = slitSep;
    }

    public void addWaves(int frequency, int amplitude) {
    }

    public void adjustSeparation(int slitSep) {
    }

    public void motion() {
    }

    public boolean isInside() {
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

    public Circle getTopCirc2() {
        return topCirc2;
    }

    public void setTopCirc2(Circle topCirc2) {
        this.topCirc2 = topCirc2;
    }

    public Circle getTopCirc3() {
        return topCirc3;
    }

    public void setTopCirc3(Circle topCirc3) {
        this.topCirc3 = topCirc3;
    }
    

    public Circle getBottomCirc() {
        return bottomCirc;
    }

    public void setBottomCirc(Circle bottomCirc) {
        this.bottomCirc = bottomCirc;
    }

    public Circle getBottomCirc2() {
        return bottomCirc2;
    }

    public void setBottomCirc2(Circle bottomCirc2) {
        this.bottomCirc2 = bottomCirc2;
    }

    public Circle getBottomCirc3() {
        return bottomCirc3;
    }

    public void setBottomCirc3(Circle bottomCirc3) {
        this.bottomCirc3 = bottomCirc3;
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

    public ArrayList<Circle> getListCircles() {
        return listCircles;
    }

    public void setListCircles(ArrayList<Circle> listCircles) {
        this.listCircles = listCircles;
    }
    
}
