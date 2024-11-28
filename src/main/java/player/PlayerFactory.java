package player;

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
import com.almasb.fxgl.physics.box2d.dynamics.FixtureDef;
import player.PlayerComponent.EnemyComponent;


public class PlayerFactory implements EntityFactory {
    public enum EntityType{
        ENEMY, PLAYER
    }


    @Spawns("Player")
    public Entity spawnPlayer(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
       // physics.setFixtureDef(new FixtureDef().friction(0).density(0.1f));

        return FXGL.entityBuilder(data)
                .type(EntityType.PLAYER)
                .at((double) FXGL.getAppWidth() /2, (double) FXGL.getAppHeight()/2)

//                .with(new CollidableComponent(true))
                .with(physics)

                .bbox(new HitBox(BoundingShape.box(32, 64)))

                .with(new PlayerComponent())
                .collidable()
                .build();
    }

    @Spawns("Enemy")
    public Entity spawnEnemy(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);
        // physics.setFixtureDef(new FixtureDef().friction(0).density(0.1f));

        return FXGL.entityBuilder(data)
               .type(EntityType.ENEMY)
                .at((double)FXGLMath.random(0, FXGL.getAppWidth() - 10) , (double)FXGLMath.random(0, FXGL.getAppHeight() - 300))

//                .with(new CollidableComponent(true))
                .with(physics)

                .bbox(new HitBox(BoundingShape.box(50, 50)))

                .with(new EnemyComponent())
                .collidable()
                .build();
    }

}
