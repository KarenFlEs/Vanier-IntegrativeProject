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
    private Circle topCirc2 = new Circle(30);
    private Circle bottomCirc2 = new Circle(30);
    private Circle topCirc3 = new Circle(30);
    private Circle bottomCirc3 = new Circle(30);
   

    private Arc topArc = new Arc(400, 300, 240, 240, -90, 180);
    private Arc bottomArc = new Arc(400, 300, 240, 240, -90, 180);

    private ScaleTransition scaleTopCirc = new ScaleTransition(Duration.seconds(5), topCirc);
    private ScaleTransition scaleBottomCirc = new ScaleTransition(Duration.seconds(5), bottomCirc);
    private ScaleTransition scaleTopCirc2 = new ScaleTransition(Duration.seconds(5), topCirc);
    private ScaleTransition scaleBottomCirc2 = new ScaleTransition(Duration.seconds(5), bottomCirc);
    private ScaleTransition scaleTopCirc3 = new ScaleTransition(Duration.seconds(5), topCirc);
    private ScaleTransition scaleBottomCirc3 = new ScaleTransition(Duration.seconds(5), bottomCirc);
    
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
        topCirc.fillProperty().set(null);
        topCirc2.fillProperty().set(null);
        topCirc3.fillProperty().set(null);
        scaleTopCirc.setByX(60f);
        scaleTopCirc.setByY(60f);
        scaleTopCirc2.setByX(60f);
        scaleTopCirc2.setByY(60f);
        scaleTopCirc3.setByX(60f);
        scaleTopCirc3.setByY(60f);
        scaleTopCirc2.setDelay(Duration.seconds(2));
        scaleTopCirc3.setDelay(Duration.seconds(3));
        scaleTopCirc.play();
        scaleTopCirc2.play();
        scaleTopCirc3.play();
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

    /**
     * Set the animation with the correct data for the circles
     *
     * @param animationPane
     */
    public void setAnimation(Pane animationPane) {
        topCirc.setFill(Color.BLUE);
        topCirc.setStrokeWidth(5);
        topCirc.setStroke(Color.BLUE);
        topCirc.setLayoutX(40);
        topCirc.setLayoutY(270);
        topCirc2.setFill(Color.BLUE);
        topCirc2.setStrokeWidth(5);
        topCirc2.setStroke(Color.BLUE);
        topCirc2.setLayoutX(40);
        topCirc2.setLayoutY(270);
        topCirc3.setFill(Color.BLUE);
        topCirc3.setStrokeWidth(5);
        topCirc3.setStroke(Color.BLUE);
        topCirc3.setLayoutX(40);
        topCirc3.setLayoutY(270);
        //  topCirc.setEffect(blurCircle);
        animationPane.getChildren().addAll(topCirc, topCirc2, topCirc3);

        scaleTopCirc.setByX(8f);
        scaleTopCirc.setByY(8f);
        scaleTopCirc.setCycleCount(Animation.INDEFINITE);

        bottomCirc.setFill(Color.BLUE);
        bottomCirc.setStrokeWidth(5);
        bottomCirc.setStroke(Color.BLUE);
        bottomCirc.setLayoutX(40);
        bottomCirc.setLayoutY(490);
        bottomCirc2.setFill(Color.BLUE);
        bottomCirc2.setStrokeWidth(5);
        bottomCirc2.setStroke(Color.BLUE);
        bottomCirc2.setLayoutX(40);
        bottomCirc2.setLayoutY(490);
        bottomCirc3.setFill(Color.BLUE);
        bottomCirc3.setStrokeWidth(5);
        bottomCirc3.setStroke(Color.BLUE);
        bottomCirc3.setLayoutX(40);
        bottomCirc3.setLayoutY(490);

        //  bottomCirc.setEffect(blurCircle);
        animationPane.getChildren().addAll(bottomCirc, bottomCirc2, bottomCirc3);

        scaleBottomCirc.setByX(8f);
        scaleBottomCirc.setByY(8f);
        scaleBottomCirc.setCycleCount(Animation.INDEFINITE);

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
