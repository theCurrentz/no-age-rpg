package enemy;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import player.PlayerComponent;
import player.PlayerFactory;

public class EnemyFactory implements EntityFactory {
    private static final int SIZE = 10;

    public enum EntityType {
        ENEMY
    }


    @Spawns("Enemy")
    public Entity spawnEnemy(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        Entity enemy = FXGL.entityBuilder()
                .with(physics)
                .bbox(new HitBox(BoundingShape.box(32, 64)))
                .with(new EnemyComponent())
                .type(EntityType.ENEMY)
                .build();

        EnemyComposer enemyComposer = EnemyComposer.getInstance();
        enemyComposer.addEnemy(enemy);

        return enemy;
    }
}

