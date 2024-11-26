package player;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.physics.PhysicsComponent;


public class PlayerComponent extends Component {


private PhysicsComponent physics = new PhysicsComponent();

//    private double speed = 0;

//    @Override
    public void onUpdate(Entity entity, double tpf) {
//        speed = tpf * 60;
    }

    public void left() { physics.setVelocityX(-150); }

    public void right() { physics.setVelocityX(150); }

    public void jump(){ physics.setVelocityY(-200); }

}