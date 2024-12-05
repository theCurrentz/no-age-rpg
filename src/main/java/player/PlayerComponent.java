package player;


import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerComponent extends Component {

private final PhysicsComponent physics = new PhysicsComponent();

    Cooldown coolDown = new Cooldown();
    AnimatedTexture playerTexture;
    AnimationChannel idle;
    AnimationChannel walk;
    AnimationChannel jump;
    AnimationChannel land;

    int currentHealth = 100;
    int maxHealth = 100;

    int currentMana = 100;
    int maxMana = 100;

    int currentExp;
    int maxExp = 100;

    int damage = 25;

    int level = 1;
    int maxLevel = 30;

    boolean died;
    boolean move;
    boolean reachedMaxLevel = false;

    @Override
    public void onAdded() {
        entity.getViewComponent().addChild(playerTexture);
        //playerTexture.loopAnimationChannel(idle);
    }

    PlayerComponent(){
        idle = new AnimationChannel(FXGL.image("player/Idle_KG_1.png"),  Duration.seconds(1), 4);
        walk = new AnimationChannel(FXGL.image("player/Walking_KG_1.png"),  Duration.seconds(2), 7);
        jump = new AnimationChannel(FXGL.image("player/Jump_KG_1.png"),  Duration.seconds(1), 6);
        land = new AnimationChannel(FXGL.image("player/Landing_KG_1.png"),  Duration.seconds(0.4), 4);
        playerTexture = new AnimatedTexture(idle);
        currentHealth = maxHealth;
        currentMana = maxMana;
        boolean died = false;
        boolean move = true;
    }

    //1 tick = 1/1,000,000 of a second
    //TPF = Tick per frame
    @Override
    public void onUpdate(double tpf) {
        playerTexture.loopAnimationChannel(isMoving() ? walk : idle);
    }

    public boolean isMoving(){
        return FXGLMath.abs(physics.getVelocityX()) > 0;
    }

    public void left() { physics.setVelocityX(-150);
        getEntity().setScaleX(-1);
    }

    public void right() { physics.setVelocityX(150);
        getEntity().setScaleX(1);
    }

    public void jump() { physics.setVelocityY(-200);
        coolDown.jumpCoolDown();
        playerTexture.playAnimationChannel(jump);
    }

    public void dealDamage(){
        //ToDo: Have the ability to deal damage to the other closest enemy or enemies that will take damage.
        //enemyHealth -= damage;
    }

    public void takeDamage(int damageAmount){
        if(!died){
            if(currentHealth < damageAmount){
                currentHealth = 0;
                died = true;
            }
            currentHealth -= damageAmount;
        }
    }

    public void revive(){
        if(died){
            died = false;
            currentHealth = maxHealth;
        }
        //ToDo: Animate the character reviving; Do not let the character move as she revives.
    }

    public void heal(int healAmount){
        if(!died){
             currentHealth += healAmount;
             if(currentHealth > maxHealth ) currentHealth = maxHealth;
        }
    }

    public void gainMana(int manaAmount){
        currentMana += manaAmount;
        if(currentMana > maxMana) currentMana = maxMana;
    }

    public void consumeMana(int manaCost){
        currentMana -= manaCost;
        if(currentMana < 0) currentMana = 0;
    }

    public void gainExp(int amount){
        if(!reachedMaxLevel){
            //EXP difference is the amount of experience left.
            int expDifference = currentExp - maxExp;
            if(amount > expDifference){
                int excessAmount = expDifference - maxExp;
                level++;
                currentExp = 0;
                currentExp += excessAmount;

            }else if(amount == expDifference){
                currentExp = 0;
                level++;
            } else currentExp += amount;
        }else currentExp = maxExp;
    }

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

// Note: This is the excess Exp demonstration.
//                               |||||||
//|||||||||||||||||||||||||||||||    '
//___________________________________'

// Note: This is the excess Exp demonstration.
//|||                                '
//___________________________________'

//    public void right() {
//        position.translateX(speed);
//        if (playerTexture.getAnimationChannel() != idle) {
//            playerTexture.loopAnimationChannel(idle);
//        }
//    }

}