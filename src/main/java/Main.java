import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;

import composer.Composer;
import config.Config;
import javafx.scene.input.KeyCode;
import player.PlayerComponent;


public class Main extends GameApplication {
    Config config = Config.getInstance();
    Composer composer = Composer.getInstance();

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
