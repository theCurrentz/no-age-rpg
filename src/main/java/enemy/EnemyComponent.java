package enemy;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

public class EnemyComponent extends Component {
    AnimatedTexture texture;
    AnimationChannel idle;

    EnemyComponent() {
        idle = new AnimationChannel(FXGL.image("player/IdleSkeleton.png"), Duration.seconds(2), 4);
        texture = new AnimatedTexture(idle);
    }
}