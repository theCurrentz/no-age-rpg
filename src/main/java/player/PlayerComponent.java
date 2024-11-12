package player;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;
import com.almasb.fxgl.ui.Position;
import composer.Composer;

public class PlayerComponent extends Component {

    private static PlayerComponent instance;

//    Composer composer = Composer.getInstance();



    public static PlayerComponent getInstance() {
        if (instance == null) {
            instance = new PlayerComponent();
        }
        return instance;
    }
    // note that this component is injected automatically
//    private TransformComponent position;
    private TransformComponent position = new TransformComponent();


//    private double speed = 0;

    @Override
    public void onUpdate(double tpf) {
//        speed = tpf * 60;
    }

    public void up() {
        position.translateY(5);
    }

    public void down() {
        position.translateY(-5);
    }

    public void left() {
        position.translateX(-5);
    }

    public void right() {
        position.translateX(5);
    }
}