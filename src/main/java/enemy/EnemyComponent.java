package enemy;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import composer.Composer;
import javafx.util.Duration;
import player.PlayerComponent;

public class EnemyComponent extends Component {


    AnimatedTexture texture;
    AnimationChannel idle;

    double lastAttackTime = 0.0;
    private final static double cooldownDuration = 3.2;

    public void onAdded() {
        entity.getViewComponent().addChild(texture);
        //playerTexture.loopAnimationChannel(idle);
    }

    EnemyComponent() {
        idle = new AnimationChannel(FXGL.image("enemy/Idle.png"), Duration.seconds(2), 4);
        texture = new AnimatedTexture(idle);
        texture.setTranslateX(-48);
        texture.setTranslateY(-84);
    }

    public void attack(Entity player) {
        double currentTime = FXGL.getGameTimer().getNow();

        if (currentTime - lastAttackTime >= cooldownDuration) {
            PlayerComponent pc = player.getComponent(PlayerComponent.class);
            lastAttackTime = currentTime;
            pc.takeDamage(5);
        }
    }
}