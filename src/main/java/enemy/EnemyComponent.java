//
package enemy;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;


public class EnemyComponent extends Component {

    AnimatedTexture enemyTexture;
    AnimationChannel skelIdle;
    public void onAdded(){
        entity.getViewComponent().addChild(enemyTexture);
    }
    public EnemyComponent(){
        skelIdle = new AnimationChannel(FXGL.image("enemy/Idle.png"), Duration.seconds(2), 4);
        enemyTexture = new AnimatedTexture(skelIdle);
        System.out.println("trigger EnemyComponent");
    }
}
