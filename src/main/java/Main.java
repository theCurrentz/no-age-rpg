import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.components.TransformComponent;
import composer.Composer;
import config.Config;
import javafx.scene.input.KeyCode;
import player.PlayerComponent;

import java.util.Map;

import static com.almasb.fxgl.dsl.FXGLForKtKt.onKey;



public class Main extends GameApplication {
    Config config = Config.getInstance();
    Composer composer = Composer.getInstance();

//    private TransformComponent position = new TransformComponent();

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
    protected void initInput() {
        FXGL.onKey(KeyCode.D, "Move right", ()-> { composer.player.getComponent(PlayerComponent.class).right();});
        FXGL.onKey(KeyCode.A, "Move left", ()-> { composer.player.getComponent(PlayerComponent.class).left();});
        FXGL.onKey(KeyCode.S, "Move down", ()-> { composer.player.getComponent(PlayerComponent.class).down();});
        FXGL.onKey(KeyCode.W, "Move up", ()-> { composer.player.getComponent(PlayerComponent.class).up();});
    }


    public static void main(String[] args) {
        launch(args);
    }
}
