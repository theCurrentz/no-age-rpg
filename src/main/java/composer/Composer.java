package composer;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
//import enemy.EnemyComposer;
import enemy.EnemyFactory;
import environment.EnvironmentFactory;
import player.PlayerFactory;


public class Composer {
    private static Composer instance;
    public Entity player, bottom;
    public static int numberEnemies = 10;
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


        FXGL.spawn("Background");
        FXGL.setLevelFromMap("wasteland.tmx");

        FXGL.spawn("Background");
        FXGL.setLevelFromMap("wasteland.tmx");
        player = FXGL.spawn("Player");

        getInstance().createEnemyBatch(10);
    }
//        for(int i = 0; i<numberEnemies;i++){
//            enemy = FXGL.spawn("Enemy");
//            System.out.println("trigger enemy for loop");
//
//        }
        public void createEnemyBatch(int amount) {
            for (int i = 0; i < amount; i++) {
                FXGL.spawn("Enemy");
                System.out.println("trigger create enemy batch");
            }
        }

    }



