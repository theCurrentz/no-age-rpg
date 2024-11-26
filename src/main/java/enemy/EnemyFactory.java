package enemy;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EnemyFactory implements EntityFactory {
    private static final int SIZE = 10;

    public enum EntityType {
        ENEMY
    }


    @Spawns("Enemy")
    public Entity spawnEnemy(SpawnData data) {
        double x = FXGLMath.random(0, FXGL.getAppWidth() - SIZE);
        double y = FXGLMath.random(0, FXGL.getAppHeight() - SIZE);

        return FXGL.entityBuilder()
                .at(x, y)
                .viewWithBBox(new Rectangle(40, 40, Color.RED))
                .type(EntityType.ENEMY)
                .buildAndAttach();
    }
}
