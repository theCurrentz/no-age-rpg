//
package enemy;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;
import player.PlayerComponent;


import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;
import java.util.Timer;
import java.util.TimerTask;


public class EnemyComponent extends Component {

    AnimatedTexture enemyTexture;
    AnimationChannel skelIdle;

    public EnemyComponent(){
        skelIdle = new AnimationChannel(FXGL.image("enemy/Idle.png"), Duration.seconds(2), 4);
        enemyTexture = new AnimatedTexture(skelIdle);
        enemyTexture.setTranslateX(-32);

        System.out.println("trigger EnemyComponent");
    }
}
