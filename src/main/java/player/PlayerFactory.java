package player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;



public class PlayerFactory implements EntityFactory {
    public enum EntityType{
        PLAYER;
    }


    @Spawns("Player")
    public Entity spawnPlayer(SpawnData data) {

        return FXGL.entityBuilder(data)
                .type(EntityType.PLAYER)
                .at((double) FXGL.getAppWidth() /2, (double) FXGL.getAppHeight()/2)
                .view(new Circle(20, Color.BLUE))
                .with(new PlayerComponent())
                .build();
    }

}
