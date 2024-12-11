import com.almasb.fxgl.dsl.FXGL;
import composer.Composer;
import config.Config;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import com.almasb.fxgl.ui.UI;
public class GameUI{

    private static GameUI instance;
    Config config = Config.getInstance();

    public static GameUI getInstance() {
        if (instance == null) {
            instance = new GameUI();
        }
        return instance;
    }

    int width = Integer.parseInt(config.getProperty("game.width"));
    int height = Integer.parseInt(config.getProperty("game.height"));

        Rectangle statRectangle = new Rectangle();

        statRectangle.setHeight(100);
        statRectangle.setWidth(100);
        statRectangle.setStyle("-fx-fill: gray; -fx-stroke: black; -fx-stroke-width: 3;");
        FXGL.addUINode(statRectangle, width-105, 2);

////        New Text format for UI binding to Observable values
//        Text textHP = FXGL.getUIFactoryService().newText("HP", 50);
//        textHP.setTranslateX(100);
//        textHP.setTranslateY(100);
//        textHP.setStroke(Color.RED);
//
//        textHP.textProperty().bind(composer.player.getComponent(PlayerComponent.class).getCurrentHealthAsString());
//        getGameScene().addUINode(textHP);




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
