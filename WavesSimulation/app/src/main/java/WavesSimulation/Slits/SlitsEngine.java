package WavesSimulation.Slits;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import javax.swing.Timer;

/**
 *
 * @author StevenDy
 */
public class SlitsEngine {
    
    private final int HALF_HEIGHT_PANE_ANIMATION = 450;
    private final int HEIGHT_ADJUSTMENT_PANE = 100;
    private final int POSITION_X_ARC = 75;

    private Rectangle slitTopWall;
    private Rectangle slitBottomWall;

    private Rectangle slitSeperationBottom;

    private Rectangle straightWave1 = new Rectangle(100, 900);
    private Rectangle straightWave2 = new Rectangle(100, 900);
    private Rectangle straightWave3 = new Rectangle(100, 900);

    private Arc arc1 = new Arc(400, 300, 40, 150, -90, 180);
    private Arc arc2 = new Arc(400, 300, 40, 150, -90, 180);
    private Arc arc3 = new Arc(400, 300, 40, 150, -90, 180);

    private Arc arc4 = new Arc(400, 300, 40, 40, -90, 180);
    private Arc arc5 = new Arc(400, 300, 40, 40, -90, 180);
    private Arc arc6 = new Arc(400, 300, 40, 40, -90, 180);

    private TranslateTransition translateRectangle1 = new TranslateTransition(Duration.seconds(6), straightWave1);
    private TranslateTransition translateRectangle2 = new TranslateTransition(Duration.seconds(6), straightWave2);
    private TranslateTransition translateRectangle3 = new TranslateTransition(Duration.seconds(6), straightWave3);

    private TranslateTransition translateArc = new TranslateTransition(Duration.seconds(6), arc1);
    private TranslateTransition translateArc2 = new TranslateTransition(Duration.seconds(6), arc2);
    private TranslateTransition translateArc3 = new TranslateTransition(Duration.seconds(6), arc3);
    private TranslateTransition translateArc4 = new TranslateTransition(Duration.seconds(6), arc4);
    private TranslateTransition translateArc5 = new TranslateTransition(Duration.seconds(6), arc5);
    private TranslateTransition translateArc6 = new TranslateTransition(Duration.seconds(6), arc6);

    private ScaleTransition scaleArc1 = new ScaleTransition(Duration.seconds(6), arc1);
    private ScaleTransition scaleArc2 = new ScaleTransition(Duration.seconds(6), arc2);
    private ScaleTransition scaleArc3 = new ScaleTransition(Duration.seconds(6), arc3);
    private ScaleTransition scaleArc4 = new ScaleTransition(Duration.seconds(6), arc4);
    private ScaleTransition scaleArc5 = new ScaleTransition(Duration.seconds(6), arc5);
    private ScaleTransition scaleArc6 = new ScaleTransition(Duration.seconds(6), arc6);

    private ParallelTransition parallelTransition1 = new ParallelTransition(translateArc, scaleArc1);
    private ParallelTransition parallelTransition2 = new ParallelTransition(translateArc2, scaleArc2);
    private ParallelTransition parallelTransition3 = new ParallelTransition(translateArc3, scaleArc3);
    private ParallelTransition parallelTransition4 = new ParallelTransition(translateArc4, scaleArc4);
    private ParallelTransition parallelTransition5 = new ParallelTransition(translateArc5, scaleArc5);
    private ParallelTransition parallelTransition6 = new ParallelTransition(translateArc6, scaleArc6);

    private ArrayList<Rectangle> listRectangle = new ArrayList<>(Arrays.asList(straightWave1, straightWave2, straightWave3));
    private ArrayList<Arc> listArc = new ArrayList<>(Arrays.asList(arc1, arc2, arc3));
    private ArrayList<Arc> listArc2 = new ArrayList<>(Arrays.asList(arc4, arc5, arc6));

    private ArrayList<TranslateTransition> listTranslateRectangle = new ArrayList<>(Arrays.asList(translateRectangle1, translateRectangle2, translateRectangle3));
    private ArrayList<TranslateTransition> listTranslateArc = new ArrayList<>(Arrays.asList(translateArc, translateArc2, translateArc3, translateArc4, translateArc5, translateArc6 ));
    private ArrayList<ParallelTransition> listParallelTransitions = new ArrayList<>(Arrays.asList(parallelTransition1, parallelTransition2, parallelTransition3,
            parallelTransition4, parallelTransition5, parallelTransition6));
    private ArrayList<ScaleTransition> listScaleArc = new ArrayList<>(Arrays.asList(scaleArc1, scaleArc2, scaleArc3, scaleArc4, scaleArc5, scaleArc6));

    private int nbSlits;
    private int slitWidth;

    private BoxBlur blurRectangle = new BoxBlur(75, 75, 3);
    private BoxBlur blurArc = new BoxBlur(30, 30, 3);
    Timer timer;
    int seconds = 0;
    //Tooltip tooltip = new Tooltip("A tooltip");

    public SlitsEngine() {

    }

    /**
     * Plays the animation whenever the button is clicked
     */
    public void playAnimation() {
        for (TranslateTransition translateTransition : listTranslateRectangle) {
            translateTransition.play();
        }
        for (ParallelTransition parallelTransition : listParallelTransitions) {
            parallelTransition.play();
        }
        timer.start();
    }

    /**
     * Pauses the animation whenever the button is clicked
     */
    public void pauseAnimation() {
        for (TranslateTransition translateTransition : listTranslateRectangle) {
            translateTransition.pause();
        }
        for (ParallelTransition parallelTransition : listParallelTransitions) {
            parallelTransition.pause();
        }
        timer.stop();
    }

    /**
     * Sets up the properties of the rectangles and also their animation
     *
     * @param paneAnimation
     */
    public void setUpRectangle(Pane paneAnimation) {
        for (Rectangle rectangle : listRectangle) {
            rectangle.setFill(Color.WHITE);
            paneAnimation.getChildren().add(rectangle);
            rectangle.setEffect(blurRectangle);
        }

        for (TranslateTransition translateTransition : listTranslateRectangle) {
            translateTransition.setByX(450);
            translateTransition.setInterpolator(Interpolator.LINEAR);
            translateTransition.setCycleCount(Animation.INDEFINITE);
        }

        translateRectangle2.setDelay(Duration.seconds(2));
        translateRectangle3.setDelay(Duration.seconds(4));
    }

    /**
     * Sets up the properties of the arcs and their animation
     *
     * @param paneAnimation
     */
    public void setUpArc(Pane paneAnimation) {

        for (Arc arc : listArc) {
            arc.setLayoutY(150);
            arc.setLayoutX(POSITION_X_ARC);
            arc.setEffect(blurArc);
            arc.setType(ArcType.OPEN);
            arc.setStrokeWidth(25);
            arc.setStroke(Color.WHITE);
            arc.setStrokeType(StrokeType.INSIDE);
            arc.setFill(null);
            paneAnimation.getChildren().add(arc);
            arc.setVisible(false);
            
           
        }

        for (Arc arc : listArc2) {
            arc.setVisible(false);
            arc.setLayoutY(175);
            arc.setLayoutX(POSITION_X_ARC);
            arc.setEffect(blurArc);
            arc.setType(ArcType.OPEN);
            arc.setStrokeWidth(25);
            arc.setStroke(Color.WHITE);
            arc.setStrokeType(StrokeType.INSIDE);
            arc.setFill(null);
            paneAnimation.getChildren().add(arc);
        }
        
        for (TranslateTransition translateArc : listTranslateArc) {
            translateArc.setByX(HALF_HEIGHT_PANE_ANIMATION);
            translateArc.setInterpolator(Interpolator.LINEAR);
            
        }
        
        for (ScaleTransition scaleArc : listScaleArc) {
            scaleArc.setToY(5.0);
        }
        
        for (ParallelTransition parallelTransition : listParallelTransitions) {
            parallelTransition.setCycleCount(Animation.INDEFINITE);
        }
        
        parallelTransition1.setDelay(Duration.seconds(5.5));
        parallelTransition2.setDelay(Duration.seconds(7.5));
        parallelTransition3.setDelay(Duration.seconds(9.5));
        parallelTransition4.setDelay(Duration.seconds(5.5));
        parallelTransition5.setDelay(Duration.seconds(7.5));
        parallelTransition6.setDelay(Duration.seconds(9.5));
    }

    /**
     * Handles the change of the width of the slits TODO: Fix the placement of
     * the waves whenever the slit width is changed
     *
     * @param sldWidth
     * @param sldSeperation
     * @param labelSlitSeperation
     * @param labelSlitWidth
     */
    public void handleSliderWidth(Slider sldWidth, Slider sldSeperation, Label labelSlitSeperation, Label labelSlitWidth) {
        if (sldWidth.getMin() == 0 && sldWidth.getMax() == 100) {
            sldWidth.setMin(150);
            sldWidth.setMax(300);
        }
        sldWidth.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (sldWidth.getMin() == 150 && sldWidth.getMax() == 300) {

                    int slitHeight = (int) sldWidth.getValue();

                    slitTopWall.setHeight(slitHeight);
                    slitBottomWall.setHeight(slitHeight);
                    slitBottomWall.setLayoutY((HALF_HEIGHT_PANE_ANIMATION * 2) - slitHeight);

                    labelSlitWidth.setText(Integer.toString(slitHeight) + " cm");
                    
                    for (Arc arc : listArc) {
                        arc.setRadiusY(HALF_HEIGHT_PANE_ANIMATION - slitHeight);
                    }


                } else if (sldWidth.getMin() == 350 && sldWidth.getMax() == 500) {
                    int slitHeight = (int) sldWidth.getValue();
                    slitTopWall.setHeight(slitHeight - 275);
                    slitBottomWall.setHeight(slitHeight - 275);
                    slitBottomWall.setLayoutY(1175 - slitHeight);

                    labelSlitWidth.setText(Integer.toString(slitHeight) + " cm");
                    
                    for (Arc arc : listArc) {
                        arc.setRadiusY(HALF_HEIGHT_PANE_ANIMATION - slitTopWall.getHeight() - slitSeperationBottom.getHeight() / 2 - HEIGHT_ADJUSTMENT_PANE);
                        arc.setLayoutY(((slitSeperationBottom.getHeight() / 2 + arc.getRadiusY() / 2) * -1) + HEIGHT_ADJUSTMENT_PANE);

                        //arc.setRadiusY(450 - slitHeight);
                        //arc.setLayoutY(slitTopWall.getHeight() - 200);
                    }
                    for (Arc arc : listArc2) {
                        arc.setRadiusY(HALF_HEIGHT_PANE_ANIMATION - slitTopWall.getHeight() - slitSeperationBottom.getHeight() / 2 - HEIGHT_ADJUSTMENT_PANE);
                        //System.out.println(slitSeperationBottom.getLayoutY());
                        arc.setLayoutY(slitSeperationBottom.getHeight() + arc.getRadiusY() + HEIGHT_ADJUSTMENT_PANE);
                    }

                }
            }
        });
    }

    /**
     * Handles the changes of the properties and the animation of the waves
     * TODO: Fix the placements of the waves when the seperation between the
     * slits is changed
     *
     * @param sldWidth
     * @param sldSeperation
     * @param labelSlitSeperation
     * @param labelSlitWidth
     */
    public void handleSliderSeperation(Slider sldWidth, Slider sldSeperation, Label labelSlitSeperation, Label labelSlitWidth) {
        sldSeperation.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int seperationHeight = (int) sldSeperation.getValue();
                slitSeperationBottom.setHeight(seperationHeight);
                slitSeperationBottom.setLayoutY(HALF_HEIGHT_PANE_ANIMATION - seperationHeight / 2);
                labelSlitSeperation.setText(Integer.toString(seperationHeight) + " cm");

                for (Arc arc : listArc) {

                    arc.setRadiusY(HALF_HEIGHT_PANE_ANIMATION - slitTopWall.getHeight() - slitSeperationBottom.getHeight() / 2 - HEIGHT_ADJUSTMENT_PANE);
                    arc.setLayoutY(((slitSeperationBottom.getHeight() / 2 + arc.getRadiusY() / 2) * -1) + HEIGHT_ADJUSTMENT_PANE);

                }

                for (Arc arc : listArc2) {
                    arc.setRadiusY(HALF_HEIGHT_PANE_ANIMATION - slitTopWall.getHeight() - slitSeperationBottom.getHeight() / 2 - HEIGHT_ADJUSTMENT_PANE);
                    arc.setLayoutY(slitSeperationBottom.getHeight() + arc.getRadiusY() + HEIGHT_ADJUSTMENT_PANE);

                }
            }
        });
    }

    /**
     * Handles the brightness of the waves when the amplitude is changed
     *
     * @param slitAmplitude
     */
    public void handleSliderAmplitude(Slider slitAmplitude) {

        slitAmplitude.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int AmplitudeValue = (int) slitAmplitude.getValue();
                blurRectangle.setIterations(AmplitudeValue / 15);
                blurArc.setIterations(AmplitudeValue / 15);
            }
        });
    }

    /**
     * Handles the speed and the length of the waves when the frequency is
     * changed TODO: Fix the width of the rectangles when both frequency and
     * amplitude are modified
     *
     * @param slitFrequency
     */
    public void hadnleSliderFrequency(Slider slitFrequency) {
        slitFrequency.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int frequencyValue = (int) slitFrequency.getValue();

                for (Rectangle rectangle : listRectangle) {
                    rectangle.setWidth(frequencyValue);
                }
                for (Arc arc : listArc) {
                    arc.setRadiusX(frequencyValue);
                }
                for (Arc arc : listArc2) {
                    arc.setRadiusX(frequencyValue);
                }
            }
        });
    }

    /**
     * Sets up the slits into their places
     *
     * @param paneAnimation
     * @param btn
     * @param sldSeperation
     */
    public void startSlit(Pane paneAnimation, CheckBox btn, Slider sldSeperation) {
        slitTopWall = new Rectangle(15, 300, Color.GAINSBORO);
        slitTopWall.setLayoutX(500);

        slitBottomWall = new Rectangle(15, 300, Color.GAINSBORO);
        slitBottomWall.setLayoutX(500);
        slitBottomWall.setLayoutY(600);

        slitSeperationBottom = new Rectangle(15, 150, Color.GAINSBORO);
        slitSeperationBottom.setLayoutX(500);
        slitSeperationBottom.setLayoutY(425);
        slitSeperationBottom.setVisible(false);

        paneAnimation.getChildren().addAll(slitTopWall, slitBottomWall, slitSeperationBottom);

        btn.setSelected(true);
        sldSeperation.setDisable(true);
    }

    /**
     * Handles the boundaries when the animation is out of bound
     *
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
    
    public void simpleTimer() {
        
        
        
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                
                if(seconds == 5){
                    for (Arc arc : listArc) {
                        arc.setVisible(true);
                    }
                }

            }
        });
    }


    public int getSlitWidth() {
        return this.slitWidth;
    }

    public void setSlitWid(int slitWidth) {
        this.slitWidth = slitWidth;
    }

    public Rectangle getSlitTopWall() {
        return slitTopWall;
    }

    public void setSlitTopWall(Rectangle slitTopWall) {
        this.slitTopWall = slitTopWall;
    }

    public Rectangle getSlitBottomWall() {
        return slitBottomWall;
    }

    public void setSlitBottomWall(Rectangle slitBottomWall) {
        this.slitBottomWall = slitBottomWall;
    }

    public Rectangle getSlitSeperationBottom() {
        return slitSeperationBottom;
    }

    public void setSlitSeperationBottom(Rectangle slitSeperationBottom) {
        this.slitSeperationBottom = slitSeperationBottom;
    }

    public BoxBlur getBlurRectangle() {
        return blurRectangle;
    }

    public void setBlurRectangle(BoxBlur blurRectangle) {
        this.blurRectangle = blurRectangle;
    }

    public Rectangle getStraightWave() {
        return straightWave1;
    }

    public void setStraightWave(Rectangle straightWave) {
        this.straightWave1 = straightWave;
    }

    public Rectangle getStraightWave2() {
        return straightWave2;
    }

    public void setStraightWave2(Rectangle straightWave2) {
        this.straightWave2 = straightWave2;
    }

    public Rectangle getStraightWave3() {
        return straightWave3;
    }

    public void setStraightWave3(Rectangle straightWave3) {
        this.straightWave3 = straightWave3;
    }

    public Arc getArc1() {
        return arc1;
    }

    public void setArc1(Arc arc1) {
        this.arc1 = arc1;
    }

    public Arc getArc2() {
        return arc2;
    }

    public void setArc2(Arc arc2) {
        this.arc2 = arc2;
    }

    public Arc getArc3() {
        return arc3;
    }

    public void setArc3(Arc arc3) {
        this.arc3 = arc3;
    }

    public Arc getArc4() {
        return arc4;
    }

    public void setArc4(Arc arc4) {
        this.arc4 = arc4;
    }

    public Arc getArc5() {
        return arc5;
    }

    public void setArc5(Arc arc5) {
        this.arc5 = arc5;
    }

    public Arc getArc6() {
        return arc6;
    }

    public void setArc6(Arc arc6) {
        this.arc6 = arc6;
    }

    public ArrayList<Arc> getListArc() {
        return listArc;
    }

    public void setListArc(ArrayList<Arc> listArc) {
        this.listArc = listArc;
    }

    public ArrayList<Arc> getListArc2() {
        return listArc2;
    }

    public void setListArc2(ArrayList<Arc> listArc2) {
        this.listArc2 = listArc2;
    }

    
}
