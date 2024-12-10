import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import composer.Composer;
import config.Config;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.Map;

public class UserInterface {

    Config config = Config.getInstance();
    Composer composer = Composer.getInstance();

    static int hpValue = 100;
    static int manaValue = 100;
    static int expValue = 0;

    public UserInterface() {
    }

    public void initGameVars(Map<String, Object> vars) {//Eric
        vars.put("HP", hpValue);
        vars.put("Mana", manaValue);
        vars.put("Exp", expValue);
    }

    public void initUI() {// Eric
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
}
