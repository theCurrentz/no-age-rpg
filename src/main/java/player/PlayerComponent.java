package player;


import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;

import com.almasb.fxgl.dsl.FXGL;

import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;


public class PlayerComponent extends Component {


private PhysicsComponent physics = new PhysicsComponent();

//    private double speed;
    AnimatedTexture playerTexture;
    AnimationChannel idle;

//    @Override
//    public void onUpdate(Entity entity, double tpf) {
//       speed = tpf * 60;
//    }

    public void left() { physics.setVelocityX(-150);
        if (playerTexture.getAnimationChannel() != idle) {
            playerTexture.loopAnimationChannel(idle);
        }
    }

    public void right() { physics.setVelocityX(150);
        if (playerTexture.getAnimationChannel() != idle) {
            playerTexture.loopAnimationChannel(idle);
        }
    }

    public void jump() {
        physics.setVelocityY(-200);
        if (playerTexture.getAnimationChannel() != idle) {
            playerTexture.loopAnimationChannel(idle);
        }
    }


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
    //1 tick = 1/1,000,000 of a second
    //TPF = Tick per frame


//    public void right() {
//        position.translateX(speed);
//        if (playerTexture.getAnimationChannel() != idle) {
//            playerTexture.loopAnimationChannel(idle);
//        }
//    }

}