package WavesSimulation.Slits;

import java.util.ArrayList;
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

    private int frequency;
    private int amplitude;
    private int slitSep;

    private Rectangle slitTopWall;
    private Rectangle slitBottomWall;

    private Rectangle slitSeperationTop;
    private Rectangle slitSeperationBottom;

    private Rectangle straightWave1 = new Rectangle(100, 900);
    private Rectangle straightWave2 = new Rectangle(100, 900);
    private Rectangle straightWave3 = new Rectangle(100, 900);

    Arc arc1 = new Arc(400, 300, 40, 150, -90, 180);
    Arc arc2 = new Arc(400, 300, 40, 150, -90, 180);
    Arc arc3 = new Arc(400, 300, 40, 150, -90, 180);

    Arc arc4 = new Arc(400, 300, 40, 40, -90, 180);
    Arc arc5 = new Arc(400, 300, 40, 40, -90, 180);
    Arc arc6 = new Arc(400, 300, 40, 40, -90, 180);

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

    private ArrayList<Rectangle> listRectangle = new ArrayList<>();

    private int nbSlits;
    private int slitWidth;

    private BoxBlur blurRectangle = new BoxBlur(75, 75, 3);
    private BoxBlur blurArc = new BoxBlur(30, 30, 3);

    //private SlitsController slitsController =  new SlitsController();

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
        straightWave1.setFill(Color.WHITE);
        paneAnimation.getChildren().addAll(straightWave1);
        straightWave1.setEffect(blurRectangle);
        translateRectangle1.setByX(240);
        translateRectangle1.setByX(450);
        translateRectangle1.setInterpolator(Interpolator.LINEAR);
        translateRectangle1.setCycleCount(Animation.INDEFINITE);

        straightWave2.setFill(Color.WHITE);
        paneAnimation.getChildren().add(straightWave2);
        straightWave2.setEffect(blurRectangle);
        translateRectangle2.setByX(240);
        translateRectangle2.setByX(450);
        translateRectangle2.setInterpolator(Interpolator.LINEAR);
        translateRectangle2.setCycleCount(Animation.INDEFINITE);
        translateRectangle2.setDelay(Duration.seconds(2));

        straightWave3.setFill(Color.WHITE);
        paneAnimation.getChildren().add(straightWave3);
        straightWave3.setEffect(blurRectangle);
        translateRectangle3.setByX(240);
        translateRectangle3.setByX(450);
        translateRectangle3.setInterpolator(Interpolator.LINEAR);
        translateRectangle3.setCycleCount(Animation.INDEFINITE);
        translateRectangle3.setDelay(Duration.seconds(4));
    }
    public void setUpArc(Pane paneAnimation) {

        arc1.setLayoutY(150);
        arc1.setLayoutX(75);
        arc1.setEffect(blurArc);
        arc1.setType(ArcType.OPEN);
        arc1.setStrokeWidth(25);
        arc1.setStroke(Color.WHITE);
        arc1.setStrokeType(StrokeType.INSIDE);
        arc1.setFill(null);
        paneAnimation.getChildren().add(arc1);
        translateArc.setByX(450);
        translateArc.setByX(500);
        translateArc.setInterpolator(Interpolator.LINEAR);
        //scale.setToX(15.0);
        scaleArc1.setToY(5.0);
        parallelTransition1.setDelay(Duration.seconds(5.5));
        parallelTransition1.setCycleCount(Animation.INDEFINITE);

        arc2.setLayoutY(150);
        arc2.setLayoutX(75);
        arc2.setEffect(blurArc);
        arc2.setType(ArcType.OPEN);
        arc2.setStrokeWidth(25);
        arc2.setStroke(Color.WHITE);
        arc2.setStrokeType(StrokeType.INSIDE);
        arc2.setFill(null);
        paneAnimation.getChildren().add(arc2);
        translateArc2.setByX(450);
        translateArc2.setByX(500);
        translateArc2.setInterpolator(Interpolator.LINEAR);
        //scale.setToX(15.0);
        scaleArc2.setToY(5.0);
        parallelTransition2.setDelay(Duration.seconds(7.5));
        parallelTransition2.setCycleCount(Animation.INDEFINITE);

        arc3.setLayoutY(150);
        arc3.setLayoutX(75);
        arc3.setEffect(blurArc);
        arc3.setType(ArcType.OPEN);
        arc3.setStrokeWidth(25);
        arc3.setStroke(Color.WHITE);
        arc3.setStrokeType(StrokeType.INSIDE);
        arc3.setFill(null);
        paneAnimation.getChildren().add(arc3);
        translateArc3.setByX(450);
        translateArc3.setByX(500);
        translateArc3.setInterpolator(Interpolator.LINEAR);
        //scale.setToX(15.0);
        scaleArc3.setToY(5.0);
        parallelTransition3.setDelay(Duration.seconds(9.5));
        parallelTransition3.setCycleCount(Animation.INDEFINITE);

            arc4.setVisible(false);
            arc4.setLayoutY(175);
            arc4.setLayoutX(75);
            arc4.setEffect(blurArc);
            arc4.setType(ArcType.OPEN);
            arc4.setStrokeWidth(25);
            arc4.setStroke(Color.WHITE);
            arc4.setStrokeType(StrokeType.INSIDE);
            arc4.setFill(null);
            paneAnimation.getChildren().add(arc4);
            translateArc4.setByX(450);
            translateArc4.setByX(500);
            translateArc4.setInterpolator(Interpolator.LINEAR);
            //scale.setToX(15.0);
            scaleArc4.setToY(15.0);
            parallelTransition4.setDelay(Duration.seconds(5.5));
            parallelTransition4.setCycleCount(Animation.INDEFINITE);

            
            arc5.setVisible(false);
            arc5.setLayoutY(175);
            arc5.setLayoutX(75);
            arc5.setEffect(blurArc);
            arc5.setType(ArcType.OPEN);
            arc5.setStrokeWidth(25);
            arc5.setStroke(Color.WHITE);
            arc5.setStrokeType(StrokeType.INSIDE);
            arc5.setFill(null);
            paneAnimation.getChildren().add(arc5);
            translateArc5.setByX(450);
            translateArc5.setByX(500);
            translateArc5.setInterpolator(Interpolator.LINEAR);
            //scale.setToX(15.0);
            scaleArc5.setToY(15.0);
            parallelTransition5.setDelay(Duration.seconds(7.5));
            parallelTransition5.setCycleCount(Animation.INDEFINITE);

            arc6.setVisible(false);
            arc6.setLayoutY(175);
            arc6.setLayoutX(75);
            arc6.setEffect(blurArc);
            arc6.setType(ArcType.OPEN);
            arc6.setStrokeWidth(25);
            arc6.setStroke(Color.WHITE);
            arc6.setStrokeType(StrokeType.INSIDE);
            arc6.setFill(null);
            paneAnimation.getChildren().add(arc6);
            translateArc6.setByX(450);
            translateArc6.setByX(500);
            translateArc6.setInterpolator(Interpolator.LINEAR);
            //scale.setX(15.0);
            scaleArc6.setToY(15.0);
            parallelTransition6.setDelay(Duration.seconds(9.5));
            parallelTransition6.setCycleCount(Animation.INDEFINITE);
    }
    
    //TODO: Adjust arcs' radius in accordance to the slits
    public void handleSliderWidth(Slider sldWidth, Slider sldSeperation, Label labelSlitSeperation, Label labelSlitWidth) {
        sldWidth.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int slitHeight = (int) sldWidth.getValue();
                slitTopWall.setHeight(slitHeight);
                slitBottomWall.setHeight(slitHeight);
                slitBottomWall.setLayoutY(900 - slitHeight);
                labelSlitWidth.setText(Integer.toString(slitHeight) + " cm");

                arc1.setRadiusY(450 - slitHeight);
                arc2.setRadiusY(450 - slitHeight);
                arc3.setRadiusY(450 - slitHeight);
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
            }
        });
    }

    public void handleSliderAmplitude(Slider slitAmplitude) {

        slitAmplitude.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int AmplitudeValue = (int) slitAmplitude.getValue();
                blurRectangle.setIterations(AmplitudeValue / 15);
            }
        });
    }

    public void hadnleSliderFrequency(Slider slitFrequency) {

        slitFrequency.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int frequencyValue = (int) slitFrequency.getValue();

                straightWave1.setWidth(frequencyValue);
                straightWave2.setWidth(frequencyValue);
                straightWave3.setWidth(frequencyValue);
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

    public SlitsEngine(int frequency, int amplitude, int slitSep, int nbSlits, int slitWidth) {
        this.frequency = frequency;
        this.amplitude = amplitude;
        this.slitSep = slitSep;
        this.nbSlits = nbSlits;
        this.slitWidth = slitWidth;
    }

    /**
     *
     * @param amplitude
     * @param frequency
     */
    //TODO:
    public void addWaves(int amplitude, int frequency) {
    }

    public void addSlit(int slitSep, int nbSlits, int slitWid) {
    }

    public void motion() {
    }

    public boolean isInside() {
        return true;
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

}



