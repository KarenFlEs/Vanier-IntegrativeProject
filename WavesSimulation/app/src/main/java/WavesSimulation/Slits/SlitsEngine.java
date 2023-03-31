/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WavesSimulation.Slits;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author 2045287
 */
public class SlitsEngine {
    
    private int frequency;
    private int amplitude;
    private int slitSep;
    
    private Rectangle slitTopWall;
    private Rectangle slitBottomWall;
    
    private Rectangle slitSeperationTop;
    private Rectangle slitSeperationBottom;
    
    BoxBlur blurRectangle = new BoxBlur(50, 50, 3);
    
    private Rectangle straightWave = new Rectangle(100, 900);
    private Rectangle straightWave2 = new Rectangle(100, 900);
    private Rectangle straightWave3 = new Rectangle(100, 900);
    
    private TranslateTransition translateRectangle = new TranslateTransition(Duration.seconds(6), straightWave);
    private TranslateTransition translateRectangle2 = new TranslateTransition(Duration.seconds(6), straightWave2);
    private TranslateTransition translateRectangle3 = new TranslateTransition(Duration.seconds(6), straightWave3);
    
    private int nbSlits;
    private int slitWidth;
    
    private SlitsController slitsController;
    
    public SlitsEngine() {
        
    }
    
    public void playAnimation() {
        
        translateRectangle.play();
        translateRectangle2.play();
        translateRectangle3.play();
    }
    
    public void pauseAnimation() {
        translateRectangle.pause();
        translateRectangle2.pause();
        translateRectangle3.pause();
    }
    
    public void setUpInput(Pane paneAnimation) {
        straightWave.setFill(Color.WHITE);
        
        paneAnimation.getChildren().addAll(straightWave);
        
        straightWave.setEffect(blurRectangle);
        
        translateRectangle.setByX(240);
        translateRectangle.setByX(450);
        translateRectangle.setInterpolator(Interpolator.LINEAR);
        translateRectangle.setCycleCount(Animation.INDEFINITE);

        //translateRectangle.play();
        straightWave2.setFill(Color.WHITE);
        
        paneAnimation.getChildren().add(straightWave2);
        
        straightWave2.setEffect(blurRectangle);
        
        translateRectangle2.setByX(240);
        translateRectangle2.setByX(450);
        translateRectangle2.setInterpolator(Interpolator.LINEAR);
        translateRectangle2.setCycleCount(Animation.INDEFINITE);
        translateRectangle2.setDelay(Duration.seconds(2));
        //translateRectangle2.play();

        straightWave3.setFill(Color.WHITE);
        
        paneAnimation.getChildren().add(straightWave3);
        
        straightWave3.setEffect(blurRectangle);
        
        translateRectangle3.setByX(240);
        translateRectangle3.setByX(450);
        translateRectangle3.setInterpolator(Interpolator.LINEAR);
        translateRectangle3.setCycleCount(Animation.INDEFINITE);
        translateRectangle3.setDelay(Duration.seconds(4));
        //translateRectangle3.play();

    }
    
    public void handleSlitWidth(Slider sldWidth, Slider sldSeperation, Label labelSlitSeperation, Label labelSlitWidth) {
        sldWidth.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                int slitHeight = (int) sldWidth.getValue();
                slitTopWall.setHeight(slitHeight);
                slitBottomWall.setHeight(slitHeight);
                slitBottomWall.setLayoutY(900 - slitHeight);
                labelSlitWidth.setText(Integer.toString(slitHeight) + " cm");
                
            }
            
        });
        
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
                
                straightWave.setWidth(frequencyValue);
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
    
    public void addWaves(int amplitude, int frequency) {
        
    }
    
    public void addSlit(int slitSep, int nbSlits, int slitWid) {
        
    }
    
    public void motion() {
        
    }
    
    public boolean isInside() {
        return true; //for now
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
        return straightWave;
    }
    
    public void setStraightWave(Rectangle straightWave) {
        this.straightWave = straightWave;
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
