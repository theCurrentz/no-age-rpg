package enemy;

import com.almasb.fxgl.dsl.FXGL;

public class EnemyComposer {
    public void createEnemyBatch(int amount) {
        for (int i = 0; i < amount; i++) {
            FXGL.spawn("Enemy");
        }
    }
}
