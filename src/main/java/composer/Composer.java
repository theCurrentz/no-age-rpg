package composer;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import environment.EnvironmentFactory;
import player.PlayerFactory;


public class Composer {
    private static Composer instance;
    public Entity player, bottom;
    public Entity enemy;

    public static Composer getInstance() {
        if (instance == null) {
            instance = new Composer();
        }
        return instance;
    }

    public void initGameWorld() {
        FXGL.getGameWorld().addEntityFactory(new EnvironmentFactory());
        FXGL.getGameWorld().addEntityFactory(new PlayerFactory());
        FXGL.getGameWorld().addEntityFactory(new EnemyFactory());
        
        EnemyComposer enemyComposer = new EnemyComposer();

        FXGL.spawn("Background");
        FXGL.setLevelFromMap("wasteland.tmx");
        player = FXGL.spawn("Player");

        //enemyComposer.createEnemyBatch(10);
    }

}
