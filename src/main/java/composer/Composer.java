package composer;

import com.almasb.fxgl.dsl.FXGL;
import environment.EnvironmentFactory;
import player.PlayerFactory;

public class Composer {
    private static Composer instance;

    public static Composer getInstance() {
        if (instance == null) {
            instance = new Composer();
        }
        return instance;
    }

    public void initGameWorld() {
        FXGL.getGameWorld().addEntityFactory(new EnvironmentFactory());
        FXGL.getGameWorld().addEntityFactory(new PlayerFactory());
        FXGL.spawn("Background");
        FXGL.spawn("Player");
    }

}
