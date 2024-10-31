import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import composer.Composer;
import config.Config;

public class Main extends GameApplication {
    Config config = Config.getInstance();
    Composer composer = Composer.getInstance();

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
    }


    public static void main(String[] args) {
        launch(args);
    }
}
