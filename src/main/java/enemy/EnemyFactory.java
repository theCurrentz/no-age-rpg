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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
        physics.setBodyType(BodyType.DYNAMIC);
        // physics.setFixtureDef(new FixtureDef().friction(0).density(0.1f));
        System.out.println("Trigger enemy spawn");
        return FXGL.entityBuilder(data)
                .type(EnemyFactory.EntityType.ENEMY)
                .at((double)FXGLMath.random(0, FXGL.getAppWidth() - 10) , (double)FXGLMath.random(0, FXGL.getAppHeight() - 300))

//                .with(new CollidableComponent(true))
                .with(physics)

                .bbox(new HitBox(BoundingShape.box(40, 64)))

                .with(new EnemyComponent())
                .collidable()
                .build();

    }



//    @Spawns("Enemy")
////    public Entity spawnEnemy(SpawnData data) {
////        double x = FXGLMath.random(0, FXGL.getAppWidth() - SIZE);
////        double y = FXGLMath.random(0, FXGL.getAppHeight() - SIZE);
////
////        return FXGL.entityBuilder()
////                .at(x, y)
////                .viewWithBBox(new Rectangle(40, 40, Color.RED))
////                .type(EntityType.ENEMY)
////                .buildAndAttach();


//    @Spawns("Enemy")
//    public Entity spawnEnemy(SpawnData data) {
//        PhysicsComponent physics = new PhysicsComponent();
//        physics.setBodyType(BodyType.DYNAMIC);
//        // physics.setFixtureDef(new FixtureDef().friction(0).density(0.1f));
//
//        return FXGL.entityBuilder(data)
//                .type(PlayerFactory.EntityType.ENEMY)
//                .at((double)FXGLMath.random(0, FXGL.getAppWidth() - 10) , (double)FXGLMath.random(0, FXGL.getAppHeight() - 300))
//
////                .with(new CollidableComponent(true))
//                .with(physics)
//
//                .bbox(new HitBox(BoundingShape.box(40, 64)))
//
//                //.with(new PlayerComponent.EnemyComponent())
//                .collidable()
//                .build();
//    }

}

