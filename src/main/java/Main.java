import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import composer.Composer;
import config.Config;

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
    }


    public static void main(String[] args) {
        launch(args);
    }
}
