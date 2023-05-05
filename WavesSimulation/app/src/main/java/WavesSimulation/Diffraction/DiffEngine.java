package WavesSimulation.Diffraction;

import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import lombok.NoArgsConstructor;

/**
 * The animation part of Diffraction
 *
 * @author KarenFl
 */
@NoArgsConstructor
public class DiffEngine {

    private final int POSITION_X = 340;
    private final int POSITION_Y = 300;
    
    private final double OPACITY_1 = 0.7;
    private final double OPACITY_2 = 0.5;
    private final double OPACITY_3 = 0.2;

    static BoxBlur circleBoxBlur = new BoxBlur(10, 10, 3);
    static BoxBlur arc1BoxBlur = new BoxBlur(20, 20, 3);
    static BoxBlur arc2BoxBlur = new BoxBlur(25, 25, 3);
    static BoxBlur arc3BoxBlur = new BoxBlur(28, 28, 3);

    /**
     * Add the circles into the scene according to the selected data
     *
     * @param paneAnimation
     * @param wavelength
     * @param eccentricity
     * @param slitDistance
     */
    public void addDiffraction(Pane paneAnimation, int wavelength, double eccentricity, double slitDistance) {

        Color color = selectColor(wavelength);
        double newRadius1 = adjustRadius(wavelength, slitDistance, 1);
        double newRadius2 = adjustRadius(wavelength, slitDistance, 2);
        double newRadius3 = adjustRadius(wavelength, slitDistance, 3);
        double newRadius4 = adjustRadius(wavelength, slitDistance, 4);

        //The circles on the right
        Circle rightCircle = new Circle();
        rightCircle.setTranslateX(POSITION_X);
        rightCircle.setTranslateY(POSITION_Y);
        rightCircle.setFill(color);
        rightCircle.setRadius(newRadius1 * 130);
        rightCircle.setEffect(circleBoxBlur);
        rightCircle.setScaleX(eccentricity);

        Circle arcCircle1 = createArcCircle(newRadius1, newRadius2, eccentricity, OPACITY_1, color, arc1BoxBlur); 
        Circle arcCircle2 = createArcCircle(newRadius2, newRadius3, eccentricity, OPACITY_2, color, arc2BoxBlur); 
        Circle arcCircle3 = createArcCircle(newRadius3, newRadius4, eccentricity, OPACITY_3, color, arc3BoxBlur); 
        
        paneAnimation.getChildren().addAll(arcCircle3, arcCircle2, arcCircle1, rightCircle);

        clipPane(paneAnimation);
    }

    /**
     * Create the circle according to the selected data
     * 
     * @param previousRadius
     * @param currentRadius
     * @param eccentricity
     * @param opacity
     * @param color
     * @param blur
     * @return circle
     */
    public Circle createArcCircle(double previousRadius, double currentRadius, double eccentricity, double opacity, Color color, BoxBlur blur){
        Circle arcCircle = new Circle(); 
        arcCircle.setTranslateX(POSITION_X);
        arcCircle.setTranslateY(POSITION_Y);
        arcCircle.setRadius(currentRadius * 100);
        arcCircle.setStrokeWidth((currentRadius - previousRadius) * 50);
        arcCircle.setStroke(color);
        arcCircle.setFill(Color.BLACK);
        arcCircle.setOpacity(opacity);
        arcCircle.setEffect(blur);
        arcCircle.setScaleX(eccentricity);
        
        return arcCircle; 
    }
    
    /**
     * Add the color according to the selected wavelength
     *
     * @param wavelength
     * @return color
     */
    public Color selectColor(int wavelength) {
        Color color = Color.WHITE;

        if (wavelength <= 420) {
            color = Color.PURPLE;
        } else if (wavelength <= 465) {
            color = Color.BLUE;
        } else if (wavelength <= 510) {
            color = Color.CYAN;
        } else if (wavelength <= 565) {
            color = Color.LIME;
        } else if (wavelength <= 610) {
            color = Color.YELLOW;
        } else if (wavelength <= 660) {
            color = Color.ORANGE;
        } else if (wavelength <= 725) {
            color = Color.RED;
        } else if (wavelength <= 780) {
            color = Color.DARKRED;
        }

        return color;
    }

    /**
     * Integrate the math calculations in the animation
     *
     * @param wavelength
     * @param slitDistance
     * @param orderNum
     * @return the calculated radius
     */
    public double adjustRadius(int wavelength, double slitDistance, int orderNum) {
        DiffractionSim diffSim = new DiffractionSim();
        diffSim.calculationAngle(wavelength, slitDistance, orderNum);
        return diffSim.calculationDiffractionRadius();
    }

    /**
     * Makes the animation stay inside the rectangle, cutting its borders
     * @param paneAnimation
     */
    public void clipPane(Pane paneAnimation) {
        int rectangleWidth = 682; 
        int rectangleHeight = 612; 
        Rectangle clipRectangle = new Rectangle();
        clipRectangle.setWidth(rectangleWidth);
        clipRectangle.setHeight(rectangleHeight);
        paneAnimation.setClip(clipRectangle);

        paneAnimation.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            clipRectangle.setWidth(newValue.getWidth());
            clipRectangle.setHeight(newValue.getHeight());
        });
    }

    /**
     * TODO: (OPTIONAL) add the laser into the scene
     * @param diffPane
     */
    public void addLaser(AnchorPane diffPane) {
        
        Rectangle rectLaser =  new Rectangle(); 
        rectLaser.setHeight(10);
        rectLaser.setWidth(115);
        rectLaser.setLayoutX(164);
        rectLaser.setLayoutY(425);
        rectLaser.setFill(Color.GREENYELLOW);
        
        Polygon polyLaser = new Polygon(); 
        polyLaser.setLayoutX(880);
        polyLaser.setLayoutY(433);
        polyLaser.setFill(Color.GREENYELLOW);
        
        polyLaser.getPoints().addAll(new Double [] {
            -50.0, 0.0, 
            286.0, 20.0, 
            286.0, -20.0 }); 
        
        Stop[] gradientStops = new Stop[]{new Stop(0, Color.WHITE),
            new Stop(0.5, Color.BLACK),
            new Stop(1, Color.WHITE)
        };

        LinearGradient linearGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, gradientStops);
        polyLaser.setFill(linearGradient);
        
        diffPane.getChildren().addAll(rectLaser, polyLaser); 
        
    }

}
