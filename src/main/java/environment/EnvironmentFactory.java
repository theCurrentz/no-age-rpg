package environment;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.sun.javafx.scene.text.TextLayout;
import config.Config;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;




public class EnvironmentFactory implements EntityFactory {

    public enum EntityType{
        PLATFORM, BORDER, BOTTOM, HEAL
    }



    @Spawns("Background")
    public Entity spawnBackground(SpawnData data) {
        Config config = Config.getInstance();

        double width = Double.parseDouble(config.getProperty("game.width"));
        double height = Double.parseDouble(config.getProperty("game.height"));

        return FXGL.entityBuilder()
                .view(new Rectangle(width, height, Color.DARKGREEN))
                .with(new IrremovableComponent())
                .zIndex(-100)
                .build();
    }
    @Spawns("platform")
    public Entity spawnFloor(SpawnData data){
        return FXGL.entityBuilder(data)
                .type(EntityType.PLATFORM)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .collidable()
                .build();
    }

    @Spawns("border")
    public Entity spawnBorder(SpawnData data){
        return FXGL.entityBuilder(data)
                .type(EntityType.BORDER)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .collidable()
                .build();
    }

    @Spawns("bottom")
    public Entity spawnBottom(SpawnData data){
        return FXGL.entityBuilder(data)
                .type(EntityType.BOTTOM)
                .bbox(new HitBox(BoundingShape.box(data.<Integer>get("width"), data.<Integer>get("height"))))
                .with(new PhysicsComponent())
                .collidable()
                .build();
    }

    @Spawns("heal")
    public Entity spawnHeal(SpawnData data){
        return FXGL.entityBuilder(data)
                .type(EntityType.HEAL)
                .viewWithBBox(new Circle(data.<Integer>get("width") / 2, Color.RED))
                .with(new CollidableComponent(true))
                .collidable()
                .build();
    }
}
