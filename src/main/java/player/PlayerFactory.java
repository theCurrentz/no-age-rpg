package player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.physics.box2d.dynamics.BodyType;


public class PlayerFactory implements EntityFactory {
    public enum EntityType{
        ENEMY, PLAYER
    }


    @Spawns("Player")
    public Entity spawnPlayer(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setBodyType(BodyType.DYNAMIC);

        return FXGL.entityBuilder(data)
                .type(EntityType.PLAYER)
                .at((double) -32, (double) FXGL.getAppHeight()/2)
                .with(physics)
                .bbox(new HitBox(BoundingShape.box(32, 64)))
                .with(new PlayerComponent())
                .collidable()
                .build();
    }
}
