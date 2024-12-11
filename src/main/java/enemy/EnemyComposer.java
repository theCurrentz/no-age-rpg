package enemy;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import java.util.ArrayList;

public class EnemyComposer {

    private static EnemyComposer instance;

    private EnemyComposer() {}

    public static EnemyComposer getInstance() {
        if (instance == null) {
            instance = new EnemyComposer();
        }
        return instance;
    }

    ArrayList<Entity> enemies = new ArrayList<Entity>();

    public void addEnemy(Entity enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(int index) {
        enemies.set(index, null);
    }

    public ArrayList<Entity> getEnemies() {
        return enemies;
    }

    public void checkProximityAndHandleAttacks(Entity player) {
        for (Entity enemy : enemies) {
            if (enemy != null) {
                double distance = player.getCenter().distance(enemy.getCenter());

                if (distance <= 100) {
                    EnemyComponent ec = enemy.getComponent(EnemyComponent.class);
                    ec.attack(player);
                }
            }
        }
    }
}
