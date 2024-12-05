package environment;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.IrremovableComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.physics.PhysicsComponent;
import config.Config;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;




public class EnvironmentFactory implements EntityFactory {

    public enum EntityType{
        PLATFORM
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
}
