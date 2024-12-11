package composer;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import enemy.EnemyComposer;
import enemy.EnemyFactory;
import environment.EnvironmentFactory;
import player.PlayerFactory;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Composer {
    private static Composer instance;
    public Entity player, bottom;

    public static Composer getInstance() {
        if (instance == null) {
            instance = new Composer();
        }
        return instance;
    }

    public void initGameWorld() {
        FXGL.getGameWorld().addEntityFactory(new EnvironmentFactory());
        FXGL.getGameWorld().addEntityFactory(new PlayerFactory());

        FXGL.getGameWorld().addEntityFactory(new EnemyFactory());
        EnemyComposer enemyComposer = EnemyComposer.getInstance();

        FXGL.spawn("Background");
        FXGL.setLevelFromMap("wasteland.tmx");

        player = FXGL.spawn("Player");

        FXGL.getGameTimer().runAtInterval(() -> enemyComposer.checkProximityAndHandleAttacks(player), javafx.util.Duration.seconds(0.016));
    }

    public void gameOverSequence() {
        Text gameOverText = new Text("Game Over");
        gameOverText.setStyle("-fx-font-size: 48px; -fx-fill: red;");
        gameOverText.setX(FXGL.getAppWidth() / 2.0 - 100);
        gameOverText.setY(FXGL.getAppHeight() / 2.0);

        FXGL.getGameScene().addUINode(gameOverText);

        FXGL.getGameTimer().runOnceAfter(() -> {
            FXGL.getGameScene().removeUINode(gameOverText);
            FXGL.getGameController().startNewGame();
        }, Duration.seconds(5));
    }
}
