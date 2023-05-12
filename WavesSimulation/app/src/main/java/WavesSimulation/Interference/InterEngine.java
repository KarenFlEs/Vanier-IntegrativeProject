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
    private ScaleTransition scaleTopCirc = new ScaleTransition(Duration.seconds(6), topCirc);
    private ScaleTransition scaleTopCirc2 = new ScaleTransition(Duration.seconds(6), topCirc);
    private ScaleTransition scaleTopCirc3 = new ScaleTransition(Duration.seconds(6), topCirc);
    private ArrayList<ScaleTransition> listScaleTopCirc = new ArrayList<>(Arrays.asList(scaleTopCirc, scaleTopCirc2, scaleTopCirc3));
    
    //scale bottom circle animations
    private ScaleTransition scaleBottomCirc = new ScaleTransition(Duration.seconds(5), bottomCirc);
    private ScaleTransition scaleBottomCirc2 = new ScaleTransition(Duration.seconds(5), bottomCirc);
    private ScaleTransition scaleBottomCirc3 = new ScaleTransition(Duration.seconds(5), bottomCirc);
    private ArrayList<ScaleTransition> listScaleBottomCirc = new ArrayList<>(Arrays.asList(scaleBottomCirc, scaleBottomCirc2, scaleBottomCirc3));
    
    //top arcs
    private Arc topArc = new Arc(400, 300, 240, 240, -90, 180);
    private Arc topArc2 = new Arc(400, 300, 240, 240, -90, 180);
    private Arc topArc3 = new Arc(400, 300, 240, 240, -90, 180);
    
    //bottom arcs
    private Arc bottomArc = new Arc(400, 300, 240, 240, -90, 180);
    private Arc bottomArc2 = new Arc(400, 300, 240, 240, -90, 180);
    private Arc bottomArc3= new Arc(400, 300, 240, 240, -90, 180);
    
    
    private TranslateTransition translateTopArc = new TranslateTransition(Duration.seconds(5), topArc);
    private TranslateTransition translateBottomArc = new TranslateTransition(Duration.seconds(5), bottomArc);

    private ScaleTransition scaleTopArc = new ScaleTransition(Duration.seconds(5), topArc);
    private ScaleTransition scaleBottomArc = new ScaleTransition(Duration.seconds(5), bottomArc);

    private ParallelTransition parallelTransitionTop = new ParallelTransition(translateTopArc, scaleTopArc);
    private ParallelTransition parallelTransitionBottom = new ParallelTransition(translateBottomArc, scaleBottomArc);

    private BoxBlur blurCircle = new BoxBlur(10, 10, 1);
    private BoxBlur blurArc = new BoxBlur(10, 10, 1);

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
        }
     
    }
    
    public void stopTopAnimation() {
        scaleTopCirc.stop();
        scaleTopCirc2.stop();
        scaleTopCirc3.stop();
        
    }

    /**
     * Play the bottom faucet's animations
     */
    public void playBottomAnimation() {
        bottomCirc.fillProperty().set(null);
        bottomCirc2.fillProperty().set(null);
        bottomCirc3.fillProperty().set(null);
        scaleBottomCirc.setByX(60f);
        scaleBottomCirc.setByY(60f);
        scaleBottomCirc2.setByX(60f);
        scaleBottomCirc2.setByY(60f);
        scaleBottomCirc3.setByX(60f);
        scaleBottomCirc3.setByY(60f);
        scaleBottomCirc2.setDelay(Duration.seconds(2));
        scaleBottomCirc3.setDelay(Duration.seconds(3));
        scaleBottomCirc.play();
        scaleBottomCirc2.play();
        scaleBottomCirc3.play();
    }
    
    public void stopBottomAnimation() {
        scaleBottomCirc.stop();
        scaleBottomCirc2.stop();
        scaleBottomCirc3.stop();
        topCirc.setVisible(false);
        topCirc2.setVisible(false);
        topCirc3.setVisible(false);
        
    }
    
    public void playAnimation(){
        topCirc.fillProperty().set(null);
        scaleTopCirc.play();
        topArc.setVisible(true);
        parallelTransitionTop.play();
        parallelTransitionTop.setDelay(scaleTopCirc.getCycleDuration());
        bottomCirc.fillProperty().set(null);
        scaleBottomCirc.play();
        bottomArc.setVisible(true);
        parallelTransitionBottom.play();
        parallelTransitionBottom.setDelay(scaleBottomCirc.getCycleDuration());
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
            scale.setByX(60f);
            scale.setByY(60f);
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
            animationPane.getChildren().add(circle);
        }
        
        for (Circle circle : listBottomCircles) {
            circle.setFill(Color.BLUE);
            circle.setStrokeWidth(5);
            circle.setStroke(Color.BLUE);
            circle.setLayoutX(40);
            circle.setLayoutY(490);
            animationPane.getChildren().add(circle);
        }
       
        
        scaleTopCirc.setByX(8f);
        scaleTopCirc.setByY(8f);
        scaleTopCirc.setCycleCount(Animation.INDEFINITE);
        
        scaleTopCirc2.setByX(8f);
        scaleTopCirc2.setByY(8f);
        scaleTopCirc2.setCycleCount(Animation.INDEFINITE);
        
        scaleTopCirc3.setByX(8f);
        scaleTopCirc3.setByY(8f);
        scaleTopCirc3.setCycleCount(Animation.INDEFINITE);
        
        scaleBottomCirc.setByX(8f);
        scaleBottomCirc.setByY(8f);
        scaleBottomCirc.setCycleCount(Animation.INDEFINITE);
        
        scaleBottomCirc2.setByX(8f);
        scaleBottomCirc2.setByY(8f);
        scaleBottomCirc2.setCycleCount(Animation.INDEFINITE);
        
        scaleBottomCirc3.setByX(8f);
        scaleBottomCirc3.setByY(8f);
        scaleBottomCirc3.setCycleCount(Animation.INDEFINITE);
        clipPane(animationPane);
    }

    /**
     * Set the animation with the correct data for the arcs
     *
     * @param animationPane
     */

    public void setAnimationArc(Pane animationPane) {
        //the arc at the top
        topArc.setLayoutX(-320);
        topArc.setLayoutY(-40);
        topArc.setStrokeWidth(15);
        topArc.setStroke(Color.BLUE);
        topArc.fillProperty().set(null);
        topArc.setEffect(blurArc);
        topArc.setVisible(false);
        animationPane.getChildren().add(topArc);

        //the arc at the bottom
        bottomArc.setLayoutX(-320);
        bottomArc.setLayoutY(200);
        bottomArc.setStrokeWidth(15);
        bottomArc.setStroke(Color.BLUE);
        bottomArc.fillProperty().set(null);
        bottomArc.setEffect(blurArc);
        bottomArc.setVisible(false);
        animationPane.getChildren().add(bottomArc);

        //properties of top arc animations
        scaleTopArc.setByX(2f);
        scaleTopArc.setByY(2f);
        translateTopArc.setByX(400);
        translateTopArc.setInterpolator(Interpolator.LINEAR);
        parallelTransitionTop.setDelay(Duration.seconds(5));
        parallelTransitionTop.setCycleCount(Animation.INDEFINITE);

        //properties of bottom arc animations
        scaleBottomArc.setByX(2f);
        scaleBottomArc.setByY(2f);
        translateBottomArc.setByX(400);
        translateBottomArc.setInterpolator(Interpolator.LINEAR);
        parallelTransitionBottom.setDelay(Duration.seconds(5));
        parallelTransitionBottom.setCycleCount(Animation.INDEFINITE);

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
