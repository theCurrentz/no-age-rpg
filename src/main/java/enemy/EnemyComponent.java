package enemy;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;
import player.PlayerComponent;

public class EnemyComponent extends Component {
    private int health = 30;

    AnimatedTexture texture;
    AnimationChannel idle;
    AnimationChannel attack;

    double lastAttackTime = 0.0;
    private final static double cooldownDuration = 2.6;

    public int getHealth() {
        return health;
    }

    public void onAdded() {
        entity.getViewComponent().addChild(texture);
    }

    EnemyComponent() {
        idle = new AnimationChannel(FXGL.image("enemy/Idle.png"), Duration.seconds(2), 4);
        attack = new AnimationChannel(FXGL.image("enemy/Attack.png"), Duration.seconds(0.8), 8);
        texture = new AnimatedTexture(idle);
        texture.setTranslateX(-48);
        texture.setTranslateY(-84);
        texture.setScaleX(-1);
    }

    @Override
    public void onUpdate(double tpf) {
        double currentTime = FXGL.getGameTimer().getNow();

        if ((currentTime - lastAttackTime >= 0.8)) {
            texture.playAnimationChannel(idle);
        }
    }

    public void attack(Entity player) {
        double currentTime = FXGL.getGameTimer().getNow();

        if (currentTime - lastAttackTime >= cooldownDuration) {
            texture.playAnimationChannel(attack);
            PlayerComponent pc = player.getComponent(PlayerComponent.class);
            lastAttackTime = currentTime;
            pc.takeDamage(10);
        }
    }

    public void takeDamage(int damage, int index)  {
        if (health <= damage) {
            EnemyComposer ec = EnemyComposer.getInstance();
            health = 0;
            ec.removeEnemy(index);
            entity.removeFromWorld();
        } else {
            health -= damage;
        }
    }
}