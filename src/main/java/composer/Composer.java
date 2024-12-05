package composer;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import enemy.EnemyComposer;
import enemy.EnemyFactory;
import environment.EnvironmentFactory;
import player.PlayerFactory;


public class Composer {
    private static Composer instance;
    public Entity player;
    public Entity enemy;
    private static int numberEnemies = 10;

    public static Composer getInstance() {
        if (instance == null) {
            instance = new Composer();
        }
        return instance;
    }

    public void initGameWorld() {
        FXGL.getGameWorld().addEntityFactory(new EnvironmentFactory());
        FXGL.getGameWorld().addEntityFactory(new PlayerFactory());
        //FXGL.getGameWorld().addEntityFactory(new EnemyFactory());
//
        EnemyComposer enemyComposer = new EnemyComposer();

        FXGL.spawn("Background");


        FXGL.setLevelFromMap("wasteland.tmx");

//        player = FXGL.getGameWorld().spawn("Player");

        player = FXGL.spawn("Player");

        for(int i = 0; i<numberEnemies;i++){
            enemy = FXGL.spawn("Enemy");

        }


        //enemyComposer.createEnemyBatch(10);
    }

}
