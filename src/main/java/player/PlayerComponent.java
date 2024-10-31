package player;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;

public class PlayerComponent extends Component {

    // note that this component is injected automatically
    private TransformComponent position;

    private double speed = 0;
    private final static double constantSpeed = 5;

    @Override
    public void onUpdate(double tpf) {
        speed = tpf * 60;
    }

    public void up() {
        position.translateY(-constantSpeed * speed);
    }

    public void down() {
        position.translateY(constantSpeed * speed);
    }

    public void left() {
        position.translateX(-constantSpeed * speed);
    }

    public void right() {
        position.translateX(constantSpeed * speed);
    }
}