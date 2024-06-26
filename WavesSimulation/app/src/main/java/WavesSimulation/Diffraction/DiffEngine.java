package WavesSimulation.Diffraction;

import javafx.scene.effect.BoxBlur;
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

    private final int CIRCLE_POSITION_X = 340;
    private final int CIRCLE_POSITION_Y = 310;
    private final int RECT_LASER_HEIGHT = 10;
    private final int RECT_LASER_WIDTH = 129;
    private final int RECT_LASER_LAYOUT_X = 179;
    private final int RECT_LASER_LAYOUT_Y = 323;
    private final int POLY_LASER_LAYOUT_X = 908;
    private final int POLY_LASER_LAYOUT_Y = 328;
    
    private final double POLY_LASER_POINT_1_COORDINATE_X = -50.0;
    private final double POLY_LASER_POINT_1_COORDINATE_Y = 0.0;
    private final double POLY_LASER_POINT_23_COORDINATE_X = 286.0;
    private final double OPACITY_1 = 0.7;
    private final double OPACITY_2 = 0.5;
    private final double OPACITY_3 = 0.3;
    private final double OPACITY_4 = 0.2;
    private final double OPACITY_5 = 0.1;
    private final double OPACITY_6 = 0.09;
    private final double OPACITY_7 = 0.08;

    static BoxBlur circleBoxBlur = new BoxBlur(10, 10, 3);
    static BoxBlur arc1BoxBlur = new BoxBlur(20, 20, 3);
    static BoxBlur arc2BoxBlur = new BoxBlur(24, 24, 3);
    static BoxBlur arc3BoxBlur = new BoxBlur(26, 26, 3);
    static BoxBlur arc4BoxBlur = new BoxBlur(28, 28, 3);
    static BoxBlur arc5BoxBlur = new BoxBlur(29, 39, 3);
    static BoxBlur arc6BoxBlur = new BoxBlur(30, 30, 3);
    static BoxBlur arc7BoxBlur = new BoxBlur(31, 31, 3);

    /**
     * Add the circles into the scene according to the selected data
     *
     * @param paneLaser
     * @param paneAnimation
     * @param wavelength
     * @param eccentricity
     * @param slitDistance
     */
    public void addDiffraction(Pane paneLaser, Pane paneAnimation, int wavelength, double eccentricity, double slitDistance) {

        Color color = selectColor(wavelength);
        double newRadius1 = adjustRadius(wavelength, slitDistance, 1);
        double newRadius2 = adjustRadius(wavelength, slitDistance, 2);
        double newRadius3 = adjustRadius(wavelength, slitDistance, 3);
        double newRadius4 = adjustRadius(wavelength, slitDistance, 4);
        double newRadius5 = adjustRadius(wavelength, slitDistance, 5);
        double newRadius6 = adjustRadius(wavelength, slitDistance, 6);
        double newRadius7 = adjustRadius(wavelength, slitDistance, 7);
        double newRadius8 = adjustRadius(wavelength, slitDistance, 8);

        //Laser
        addLaser(paneLaser, color, newRadius1 * 130); 
        
        //The circles on the right
        Circle rightCircle = new Circle();
        rightCircle.setTranslateX(CIRCLE_POSITION_X);
        rightCircle.setTranslateY(CIRCLE_POSITION_Y);
        rightCircle.setFill(color);
        rightCircle.setRadius(newRadius1 * 130);
        rightCircle.setEffect(circleBoxBlur);
        rightCircle.setScaleX(eccentricity);

        Circle arcCircle1 = createArcCircle(newRadius1, newRadius2, eccentricity, OPACITY_1, color, arc1BoxBlur); 
        Circle arcCircle2 = createArcCircle(newRadius2, newRadius3, eccentricity, OPACITY_2, color, arc2BoxBlur); 
        Circle arcCircle3 = createArcCircle(newRadius3, newRadius4, eccentricity, OPACITY_3, color, arc3BoxBlur); 
        Circle arcCircle4 = createArcCircle(newRadius4, newRadius5, eccentricity, OPACITY_4, color, arc4BoxBlur); 
        Circle arcCircle5 = createArcCircle(newRadius5, newRadius6, eccentricity, OPACITY_5, color, arc5BoxBlur); 
        Circle arcCircle6 = createArcCircle(newRadius6, newRadius7, eccentricity, OPACITY_6, color, arc6BoxBlur); 
        Circle arcCircle7 = createArcCircle(newRadius7, newRadius8, eccentricity, OPACITY_7, color, arc7BoxBlur); 
        
        paneAnimation.getChildren().addAll(arcCircle7, arcCircle6, arcCircle5, arcCircle4, arcCircle3, arcCircle2, arcCircle1, rightCircle);
        
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
        arcCircle.setTranslateX(CIRCLE_POSITION_X);
        arcCircle.setTranslateY(CIRCLE_POSITION_Y);
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
     * Selects the color according to the selected wavelength
     *
     * @param wavelength
     * @return color
     */
    public Color selectColor(int wavelength) {
        Color color = Color.WHITE;

        if (wavelength <= 402) {
            color = Color.PURPLE;
        } else if (wavelength <= 430) {
            color = Color.INDIGO;
        } else if (wavelength <= 450) {
            color = Color.MEDIUMBLUE;
        } else if (wavelength <= 465) {
            color = Color.BLUE;
        } else if (wavelength <= 510) {
            color = Color.CYAN;
        } else if (wavelength <= 525) {
            color = Color.MEDIUMSPRINGGREEN;
        } else if (wavelength <= 545) {
            color = Color.LIME;
        } else if (wavelength <= 565) {
            color = Color.GREENYELLOW;
        } else if (wavelength <= 610) {
            color = Color.YELLOW;
        } else if (wavelength <= 640) {
            color = Color.ORANGE;
        } else if (wavelength <= 666) {
            color = Color.ORANGERED;
        } else if (wavelength <= 718) {
            color = Color.RED;
        } else if (wavelength <= 745) {
            color = Color.FIREBRICK;
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
     * @param paneLaser
     * @param laserColor
     * @param laserRadius
     */
    public void addLaser(Pane paneLaser, Color laserColor, double laserRadius) {
        Rectangle rectLaser =  new Rectangle(); 
        rectLaser.setHeight(RECT_LASER_HEIGHT);
        rectLaser.setWidth(RECT_LASER_WIDTH);
        rectLaser.setLayoutX(RECT_LASER_LAYOUT_X);
        rectLaser.setLayoutY(RECT_LASER_LAYOUT_Y);
        rectLaser.setFill(laserColor);
        
        Polygon polyLaser = new Polygon(); 
        polyLaser.setLayoutX(POLY_LASER_LAYOUT_X);
        polyLaser.setLayoutY(POLY_LASER_LAYOUT_Y);
        
        polyLaser.getPoints().addAll(new Double [] {
            POLY_LASER_POINT_1_COORDINATE_X, POLY_LASER_POINT_1_COORDINATE_Y, 
            POLY_LASER_POINT_23_COORDINATE_X, laserRadius, 
            POLY_LASER_POINT_23_COORDINATE_X, -laserRadius }); 
        
        Stop[] gradientStops = new Stop[]{new Stop(0, Color.WHITE),
            new Stop(0.5, laserColor),
            new Stop(1, Color.WHITE)
        };

        LinearGradient linearGradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, gradientStops);
        polyLaser.setFill(linearGradient);
        
        paneLaser.getChildren().addAll(rectLaser, polyLaser); 
    }
 
}
