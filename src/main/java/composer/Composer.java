package composer;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import environment.EnvironmentFactory;
import player.PlayerFactory;


public class Composer {
    private static Composer instance;
    public Entity player;

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

        FXGL.setLevelFromMap("wasteland.tmx");

        player = FXGL.getGameWorld().spawn("Player");
    }

}
