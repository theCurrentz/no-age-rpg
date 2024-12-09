package enemy;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;

import java.util.ArrayList;

public class EnemyComposer {

    ArrayList<Entity> enemies = new ArrayList<Entity>();

    public ArrayList<Entity> createEnemyBatch(int amount) {

        for (int i = 0; i < amount; i++) {
            Entity enemy = FXGL.spawn("Enemy");
            enemies.add(enemy);
        }

        return enemies;
    }

    public void checkProximityAndHandleAttacks(Entity player) {
        for (Entity enemy : enemies) {
            double distance = player.getCenter().distance(enemy.getCenter());
a
            if (distance <= 125) {
                EnemyComponent ec = enemy.getComponent(EnemyComponent.class);
                ec.attack(player);
            }
        }
    }
}
