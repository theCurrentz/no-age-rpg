import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;


import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.input.UserAction;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.ui.FXGLButton;

import composer.Composer;
import config.Config;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import player.PlayerComponent;
import javafx.scene.shape.Rectangle;


import java.awt.*;
import java.util.Map;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getInput;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getSettings;


public class Main extends GameApplication {
    Config config = Config.getInstance();
    Composer composer = Composer.getInstance();

    static int hpValue = 100;
    static int manaValue = 100;
    static int expValue = 0;



    @Override
    protected void initSettings(GameSettings settings) {
        int width = Integer.parseInt(config.getProperty("game.width"));
        int height = Integer.parseInt(config.getProperty("game.height"));

        settings.setTitle("The No Age");
        settings.setWidth(width);
        settings.setHeight(height);
    }

    @Override
    protected void initGame() {
        composer.initGameWorld();
    }

    @Override

    protected void initPhysics(){
    }



    protected void initGameVars(Map<String, Object> vars) {//Eric
        vars.put("HP", hpValue);
        vars.put("Mana", manaValue);
        vars.put("Exp", expValue);
    }
    @Override
    protected void initUI() {// Eric
        int width = Integer.parseInt(config.getProperty("game.width"));
        int height = Integer.parseInt(config.getProperty("game.height"));

        Rectangle statRectangle = new Rectangle();
        statRectangle.setHeight(100);
        statRectangle.setWidth(100);
        statRectangle.setStyle("-fx-fill: gray; -fx-stroke: black; -fx-stroke-width: 3;");
        FXGL.addUINode(statRectangle, width-105, 2);

        Label hpLabel = new Label();
        Label manaLabel = new Label();
        Label expLabel = new Label();


        hpLabel.setTextFill(Color.RED);
        hpLabel.setFont(Font.font(20.0));
        hpLabel.textProperty().bind(FXGL.getip("HP").asString("HP: %d"));

        manaLabel.setTextFill(Color.BLUE);
        manaLabel.setFont(Font.font(20.0));
        manaLabel.textProperty().bind(FXGL.getip("Mana").asString("Mana: %d"));

        expLabel.setTextFill(Color.YELLOW);
        expLabel.setFont(Font.font(20.0));
        expLabel.textProperty().bind(FXGL.getip("Exp").asString("Exp: %d"));



        FXGL.addUINode(hpLabel, width-100, 10);
        hpLabel.textProperty().bind(FXGL.getip("HP").asString("HP: %d"));

        FXGL.addUINode(manaLabel, width-100, 35);
        manaLabel.textProperty().bind(FXGL.getip("Mana").asString("Mana: %d"));

        FXGL.addUINode(expLabel, width-100, 60);
        expLabel.textProperty().bind(FXGL.getip("Exp").asString("Exp: %d"));

        Rectangle buttonRectangle = new Rectangle();
        buttonRectangle.setHeight(65);
        buttonRectangle.setWidth(250);
        buttonRectangle.setStyle("-fx-fill: gray; -fx-stroke: black; -fx-stroke-width: 3;");
        FXGL.addUINode(buttonRectangle, width-260, height-75);

        Button attackButton = new Button("Attack!");
        attackButton.setFont(Font.font(20.0));
        attackButton.setMinWidth(100);
        FXGL.addUINode(attackButton, width-250, height-65);

        Button dashButton = new Button("Dash!");
        dashButton.setFont(Font.font(20.0));
        dashButton.setMinWidth(100);
        FXGL.addUINode(dashButton, width-125, height-65);

    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.D, "Move right", ()-> { composer.player.getComponent(PlayerComponent.class).right();});
        FXGL.onKey(KeyCode.A, "Move left", ()-> { composer.player.getComponent(PlayerComponent.class).left();});
        FXGL.onKey(KeyCode.W, "Jump up", ()-> { composer.player.getComponent(PlayerComponent.class).jump();});

    }



    public static void main(String[] args) {
        launch(args);
    }
}
