import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.ui.FXGLButton;
import composer.Composer;
import config.Config;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import player.PlayerComponent;
import javafx.scene.shape.Rectangle;


import java.awt.*;
import java.util.Map;


public class Main extends GameApplication {
    Config config = Config.getInstance();
    Composer composer = Composer.getInstance();

    static int hpValue = 100;
    static int manaValue = 100;
    static int expValue = 0;

    @Override
    protected void initSettings(GameSettings settings) {
        //Create the width and height.
        int width = Integer.parseInt(config.getProperty("game.width"));
        int height = Integer.parseInt(config.getProperty("game.height"));
        //Title for the No Age game window.
        settings.setTitle("The No Age");
        //Set the window width and height.
        settings.setWidth(width);
        settings.setHeight(height);
    }

    @Override
    protected void initGame() {
        composer.initGameWorld();

        int width = Integer.parseInt(config.getProperty("game.width"));
        int height = Integer.parseInt(config.getProperty("game.height"));
    }
    @Override
    protected void initGameVars(Map<String, Object> vars) {//Eric
        vars.put("HP", hpValue);
        vars.put("Mana", manaValue);
        vars.put("Exp", expValue);
    }
    @Override
    protected void initUI() {// Eric
        int width = Integer.parseInt(config.getProperty("game.width"));
        int height = Integer.parseInt(config.getProperty("game.height"));

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



        Button attackButton = new Button("Attack!");
        attackButton.setFont(Font.font(20.0));
        FXGL.addUINode(attackButton, width-250, height-65);

        Button dashButton = new Button("Dash!");
        dashButton.setFont(Font.font(20.0));
        FXGL.addUINode(dashButton, width-125, height-65);

    }

    @Override
    protected void initInput() {
        FXGL.onKey(KeyCode.W, "Move up", ()->  composer.player.getComponent(PlayerComponent.class).up());
        FXGL.onKey(KeyCode.A, "Move left", ()-> composer.player.getComponent(PlayerComponent.class).left());
        FXGL.onKey(KeyCode.S, "Move down", ()-> composer.player.getComponent(PlayerComponent.class).down());
        FXGL.onKey(KeyCode.D, "Move right", ()-> composer.player.getComponent(PlayerComponent.class).right());
    }



    public static void main(String[] args) {
        launch(args);
    }
}
