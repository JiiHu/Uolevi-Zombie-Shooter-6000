

package zombie.logic;

import zombie.domain.Direction;
import zombie.domain.Player;


public class InputController {
    
    private Player player;
    private ActorController actorController;
    
    public InputController(Player player, ActorController ac) {
        this.player = player;
        this.actorController = ac;
    }
    
    public void movePlayer(Direction direction) {
        actorController.moveActor(player, direction);
    }
    
    public void mousePosition(int x, int y) {
        rotatePlayer(x, y);
    }

    private void rotatePlayer(int x, int y) {
        int angle = calculateAngle(x, y, player.getX(), player.getY());
        player.setAngle((int) angle);
    }
    
    // calculates angle followingly
    //  -135    -90     -45
    //  180     x,y     0
    //  135     90      -45
    private int calculateAngle(int mouseX, int mouseY, int x, int y) {
        int diffX = mouseX - x;
        int diffY = mouseY - y;
        double radians = Math.atan2(diffY, diffX);
        double angle = radians * 180 / Math.PI;
        return (int) angle;
    }
    
}
