import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

import com.almasb.fxgl.input.UserAction;
import composer.Composer;
import config.Config;
import javafx.scene.input.KeyCode;
import player.PlayerComponent;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getInput;


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
    protected void initPhysics(){
    }


    @Override
    protected void initInput() {

        getInput().addAction(new UserAction("Left") {
            @Override
            protected void onAction() { composer.player.getComponent(PlayerComponent.class).left();
            }
        }, KeyCode.A);
        getInput().addAction(new UserAction("Right") {
            @Override
            protected void onAction() { composer.player.getComponent(PlayerComponent.class).right();
            }
        }, KeyCode.D);
        getInput().addAction(new UserAction("Jump") {
            @Override
            protected void onAction() { composer.player.getComponent(PlayerComponent.class).jump();
            }
        }, KeyCode.SPACE);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
