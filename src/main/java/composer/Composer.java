package composer;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import environment.EnvironmentFactory;
import player.PlayerFactory;

import static com.almasb.fxgl.dsl.FXGLForKtKt.spawn;

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
        player = FXGL.spawn("Player");
    }

}
