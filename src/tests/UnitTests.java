

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.physics.PhysicsComponent;
import config.Config;
import environment.EnvironmentFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getSettings;
import static java.lang.System.getProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.app.GameApplication;
import player.PlayerComponent;
import player.PlayerFactory;

import java.net.http.WebSocket;

@DisplayName("NOA Unit Tests")
public class UnitTests {//Eric



    @Test
    @DisplayName("Test Screen Height")

     void testScreenHeight(){
        Config config = Config.getInstance();
        int gameHeight = Integer.parseInt(config.getProperty("game.height"));;
        assertEquals(960, gameHeight );
    }

    @Test
    @DisplayName("Test Screen Width")
    void testScreenWidth(){
        Config config = Config.getInstance();
        int gameWidth = Integer.parseInt(config.getProperty("game.width"));;
        assertEquals(1280, gameWidth);    }

}
//
//    @Test
//    void right() {
//        assertEquals(1280, gameWidth);    }
//
//    }
//
//    @Test
//    void jump() {
//        assertEquals(1280, gameWidth);    }
//
//    }

