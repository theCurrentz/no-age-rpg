package player;


import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;

import com.almasb.fxgl.dsl.FXGL;

import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;


public class PlayerComponent extends Component {


private PhysicsComponent physics = new PhysicsComponent();
    Cooldown coolDown = new Cooldown();

//    private double speed;
    AnimatedTexture playerTexture;
    AnimationChannel idle;

//    @Override
//    public void onUpdate(Entity entity, double tpf) {
//       speed = tpf * 60;
//    }

    public void left() { physics.setVelocityX(-100);
        if (playerTexture.getAnimationChannel() != idle) {
            playerTexture.loopAnimationChannel(idle);
        }
    }

    public void right() { physics.setVelocityX(100);
        if (playerTexture.getAnimationChannel() != idle) {
            playerTexture.loopAnimationChannel(idle);
        }
    }

    public void jump() {
        coolDown.jumpCoolDown();
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


    public class Cooldown {

        private static Timer timer;

        public Cooldown() {
        }
        public void jumpCoolDown() {
            if (timer == null) {
                // Perform the action
                physics.setVelocityY(-300);
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        timer = null; // Reset the timer
                    }
                }, 1500); // Cooldown of 1.5 second
            } else {
                System.out.println("Action on cooldown!");
            }
        }
    }







public static class EnemyComponent extends PlayerComponent{
    EnemyComponent(){
        idle = new AnimationChannel(FXGL.image("brick.png"), Duration.seconds(5), 100);
        playerTexture = new AnimatedTexture(idle);
    }
}









//    public void right() {
//        position.translateX(speed);
//        if (playerTexture.getAnimationChannel() != idle) {
//            playerTexture.loopAnimationChannel(idle);
//        }
//    }

}