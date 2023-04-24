package WavesSimulation.Slits;

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
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

/**
 *
 * @author StevenDy
 */
public class SlitsEngine {
    private Rectangle slitTopWall;
    private Rectangle slitBottomWall;

    private Rectangle slitSeperationTop;
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

    private int nbSlits;
    private int slitWidth;

    private BoxBlur blurRectangle = new BoxBlur(75, 75, 3);
    private BoxBlur blurArc = new BoxBlur(30, 30, 3);

    public SlitsEngine() {

    }

    public void playAnimation() {
        translateRectangle1.play();
        translateRectangle2.play();
        translateRectangle3.play();

        parallelTransition1.play();
        parallelTransition2.play();
        parallelTransition3.play();
        parallelTransition4.play();
        parallelTransition5.play();
        parallelTransition6.play();
    }

    public void pauseAnimation() {
        translateRectangle1.pause();
        translateRectangle2.pause();
        translateRectangle3.pause();

        parallelTransition1.pause();
        parallelTransition2.pause();
        parallelTransition3.pause();
        parallelTransition4.pause();
        parallelTransition5.pause();
        parallelTransition6.pause();
    }

    public void setUpRectangle(Pane paneAnimation) {

        for (Rectangle rectangle : listRectangle) {
            rectangle.setFill(Color.WHITE);
            paneAnimation.getChildren().add(rectangle);
            rectangle.setEffect(blurRectangle);
        }

        translateRectangle1.setByX(240);
        translateRectangle1.setByX(450);
        translateRectangle1.setInterpolator(Interpolator.LINEAR);
        translateRectangle1.setCycleCount(Animation.INDEFINITE);

        translateRectangle2.setByX(240);
        translateRectangle2.setByX(450);
        translateRectangle2.setInterpolator(Interpolator.LINEAR);
        translateRectangle2.setCycleCount(Animation.INDEFINITE);
        translateRectangle2.setDelay(Duration.seconds(2));

        translateRectangle3.setByX(240);
        translateRectangle3.setByX(450);
        translateRectangle3.setInterpolator(Interpolator.LINEAR);
        translateRectangle3.setCycleCount(Animation.INDEFINITE);
        translateRectangle3.setDelay(Duration.seconds(4));
    }

    public void setUpArc(Pane paneAnimation) {

        for (Arc arc : listArc) {
            arc.setLayoutY(150);
            arc.setLayoutX(75);
            arc.setEffect(blurArc);
            arc.setType(ArcType.OPEN);
            arc.setStrokeWidth(25);
            arc.setStroke(Color.WHITE);
            arc.setStrokeType(StrokeType.INSIDE);
            arc.setFill(null);
            paneAnimation.getChildren().add(arc);
        }

        translateArc.setByX(450);
        translateArc.setByX(500);
        translateArc.setInterpolator(Interpolator.LINEAR);
        //scale.setToX(15.0);
        scaleArc1.setToY(5.0);
        parallelTransition1.setDelay(Duration.seconds(5.5));
        parallelTransition1.setCycleCount(Animation.INDEFINITE);

        translateArc2.setByX(450);
        translateArc2.setByX(500);
        translateArc2.setInterpolator(Interpolator.LINEAR);
        //scale.setToX(15.0);
        scaleArc2.setToY(5.0);
        parallelTransition2.setDelay(Duration.seconds(7.5));
        parallelTransition2.setCycleCount(Animation.INDEFINITE);

        translateArc3.setByX(450);
        translateArc3.setByX(500);
        translateArc3.setInterpolator(Interpolator.LINEAR);
        scaleArc3.setToY(5.0);
        parallelTransition3.setDelay(Duration.seconds(9.5));
        parallelTransition3.setCycleCount(Animation.INDEFINITE);

        for (Arc arc : listArc2) {
            arc.setVisible(false);
            arc.setLayoutY(175);
            arc.setLayoutX(75);
            arc.setEffect(blurArc);
            arc.setType(ArcType.OPEN);
            arc.setStrokeWidth(25);
            arc.setStroke(Color.WHITE);
            arc.setStrokeType(StrokeType.INSIDE);
            arc.setFill(null);
            paneAnimation.getChildren().add(arc);
        }

        translateArc4.setByX(450);
        translateArc4.setByX(500);
        translateArc4.setInterpolator(Interpolator.LINEAR);
        //scale.setToX(15.0);
        scaleArc4.setToY(5.0);
        parallelTransition4.setDelay(Duration.seconds(5.5));
        parallelTransition4.setCycleCount(Animation.INDEFINITE);

        translateArc5.setByX(450);
        translateArc5.setByX(500);
        translateArc5.setInterpolator(Interpolator.LINEAR);
        //scale.setToX(15.0);
        scaleArc5.setToY(5.0);
        parallelTransition5.setDelay(Duration.seconds(7.5));
        parallelTransition5.setCycleCount(Animation.INDEFINITE);

        translateArc6.setByX(450);
        translateArc6.setByX(500);
        translateArc6.setInterpolator(Interpolator.LINEAR);
        //scale.setX(15.0);
        scaleArc6.setToY(5.0);
        parallelTransition6.setDelay(Duration.seconds(9.5));
        parallelTransition6.setCycleCount(Animation.INDEFINITE);
    }

    //TODO: Adjust arcs' radius in accordance to the slits
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
                    slitBottomWall.setLayoutY(900 - slitHeight);

                    labelSlitWidth.setText(Integer.toString(slitHeight) + " cm");

                    arc1.setRadiusY(450 - slitHeight);
                    arc2.setRadiusY(450 - slitHeight);
                    arc3.setRadiusY(450 - slitHeight);
                } else if (sldWidth.getMin() == 350 && sldWidth.getMax() == 425) {
                    int slitHeight = (int) sldWidth.getValue();
                    slitTopWall.setHeight(slitHeight - 275);
                    slitBottomWall.setHeight(slitHeight - 275);
                    slitBottomWall.setLayoutY(1175 - slitHeight);

                    labelSlitWidth.setText(Integer.toString(slitHeight - 200) + " cm");

                    slitHeight = slitHeight - 50;

                    for (Arc arc : listArc) {
                        arc.setRadiusY(450 - slitHeight);
                        arc.setLayoutY(slitTopWall.getHeight() - 200);
                    }
                    for (Arc arc : listArc2) {
                        arc.setRadiusY(450 - slitHeight);
                        System.out.println(slitSeperationBottom.getLayoutY());
                        arc.setLayoutY(slitBottomWall.getLayoutY() - 400);
                    }

                }
            }
        });
    }

    public void handleSliderSeperation(Slider sldWidth, Slider sldSeperation, Label labelSlitSeperation, Label labelSlitWidth) {
        sldSeperation.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int seperationHeight = (int) sldSeperation.getValue();
                slitSeperationTop.setHeight(seperationHeight);
                slitSeperationTop.setLayoutY(425 - seperationHeight);
                slitSeperationBottom.setHeight(seperationHeight + 50);
                labelSlitSeperation.setText(Integer.toString(seperationHeight) + " cm");

                for (Arc arc : listArc) {
                    arc.setRadiusY(550 - (int) sldWidth.getValue() - seperationHeight);
                    arc.setLayoutY(slitSeperationTop.getLayoutY() - 450);
                }

                for (Arc arc : listArc2) {
                    arc.setRadiusY(550 - (int) sldWidth.getValue() - seperationHeight);
                    arc.setLayoutY(800 - slitSeperationBottom.getLayoutY());
                }
            }
        });
    }

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

    public void startSlit(Pane paneAnimation, CheckBox btn, Slider sldSeperation) {
        slitTopWall = new Rectangle(15, 300, Color.GAINSBORO);
        slitTopWall.setLayoutX(500);

        slitBottomWall = new Rectangle(15, 300, Color.GAINSBORO);
        slitBottomWall.setLayoutX(500);
        slitBottomWall.setLayoutY(600);

        slitSeperationTop = new Rectangle(15, 150, Color.GAINSBORO);
        slitSeperationTop.setLayoutX(500);
        slitSeperationTop.setLayoutY(325);
        slitSeperationTop.setVisible(false);

        slitSeperationBottom = new Rectangle(15, 150, Color.GAINSBORO);
        slitSeperationBottom.setLayoutX(500);
        slitSeperationBottom.setLayoutY(425);
        slitSeperationBottom.setVisible(false);

        paneAnimation.getChildren().addAll(slitTopWall, slitBottomWall, slitSeperationTop, slitSeperationBottom);

        btn.setSelected(true);
        sldSeperation.setDisable(true);
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

    public Rectangle getSlitSeperationTop() {
        return slitSeperationTop;
    }

    public void setSlitSeperationTop(Rectangle slitSeperationTop) {
        this.slitSeperationTop = slitSeperationTop;
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

}
