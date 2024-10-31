package player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PlayerFactory implements EntityFactory {

    @Spawns("Player")
    public Entity spawnPlayer(SpawnData data) {

        return FXGL.entityBuilder()
                .at((double) FXGL.getAppWidth() /2, (double) FXGL.getAppHeight()/2)
                .view(new Circle(20, Color.YELLOW))
                .with(new PlayerComponent())
                .build();
    }

}
