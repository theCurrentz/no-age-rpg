package player;

import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import composer.Composer;

import javafx.util.Duration;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerComponent extends Component {

    private final PhysicsComponent physics = new PhysicsComponent();

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
        playerTexture.setTranslateX(-32);
        currentHealth = maxHealth;
        currentMana = maxMana;
        boolean died = false;
        boolean move = true;
    }

    public int getCurrentHealth(){
        return this.currentHealth;
    }

    public ObservableValue<? extends String> getCurrentHealthAsString() {
        ObservableValue<String> health = new SimpleStringProperty(Integer.toString(this.currentHealth));
        return health;
    }

    public int getCurrentMana(){
        return this.currentMana;
    }

    public int getCurrentExp(){
        return this.currentExp;
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

    public void left() {
        physics.setVelocityX(-62);
        getEntity().setScaleX(-1);
    }

    public void right() {
        physics.setVelocityX(62);
        getEntity().setScaleX(1);
    }

    public void jump() {
        if (physics.getVelocityY() == -0.0) {
            physics.setVelocityY(-280);
            playerTexture.playAnimationChannel(jump);
        }

    }

    public void dealDamage(){
        // ToDo: Have the ability to deal damage to the other closest enemy or enemies that will take damage.
        //enemyHealth -= damage;
    }


    public void takeDamage(int damageAmount) {
        if (currentHealth <= damageAmount) {
            currentHealth = 0;
            died = true;
            Composer composer = Composer.getInstance();
            composer.gameOverSequence();
        } else {
            currentHealth -= damageAmount;
        }
        System.out.println("Player current health: " + currentHealth);
    }

    public void heal(int healAmount) {
        if(!died){
            currentHealth += healAmount;
            if(currentHealth > maxHealth ) currentHealth = maxHealth;
        }
    }

    public void gainMana(int manaAmount) {
        currentMana += manaAmount;
        if(currentMana > maxMana) currentMana = maxMana;
    }

    public void consumeMana(int manaCost) {
        currentMana -= manaCost;
        if(currentMana < 0) currentMana = 0;
    }

    public void gainExp(int amount) {
        if(!reachedMaxLevel) {
            //EXP difference is the amount of experience left.
            int expDifference = currentExp - maxExp;
            if(amount > expDifference) {
                int excessAmount = expDifference - maxExp;
                level++;
                currentExp = 0;
                currentExp += excessAmount;

            }else if(amount == expDifference) {
                currentExp = 0;
                level++;
            } else currentExp += amount;
        }else currentExp = maxExp;
    }
}