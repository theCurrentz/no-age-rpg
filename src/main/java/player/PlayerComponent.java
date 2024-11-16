package player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

public class PlayerComponent extends Component {

private TransformComponent position = new TransformComponent();

//    private double speed = 0;\
    AnimatedTexture playerTexture;
    AnimationChannel idle;

    PlayerComponent(){
        idle = new AnimationChannel(FXGL.image("player/Idle_KG_1.png"), Duration.seconds(0.5), 4);
        playerTexture = new AnimatedTexture(idle);
    }

    //private AnimationChannel left;

    @Override
    public void onAdded() {
        entity.getViewComponent().addChild(playerTexture);
        playerTexture.loopAnimationChannel(idle);
    }

    @Override
    public void onUpdate(double tpf) {
//        speed = tpf * 60;
    }

    public void up() {
        position.translateY(-5);
        if (playerTexture.getAnimationChannel() != idle) {
            playerTexture.loopAnimationChannel(idle);
        }
    }

    public void down() {
        position.translateY(5);
        if (playerTexture.getAnimationChannel() != idle) {
            playerTexture.loopAnimationChannel(idle);
        }
    }

    public void left() {
        position.translateX(-5);
        if (playerTexture.getAnimationChannel() != idle) {
            playerTexture.loopAnimationChannel(idle);
        }
    }

    public void right() {
        position.translateX(5);
        if (playerTexture.getAnimationChannel() != idle) {
            playerTexture.loopAnimationChannel(idle);
        }
    }
}