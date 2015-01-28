package zombie.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import zombie.domain.Actor;
import zombie.domain.Direction;
import zombie.logic.ActorController;

public class InputHandler {
    
    private Actor player;
    private ActorController actorcontroller;
    
    public InputHandler(Actor player, ActorController actorController) {
        this.player = player;
        this.actorcontroller = actorController;
    }
     
    public void lookForInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            commandActorController(Direction.UP);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            commandActorController(Direction.DOWN);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            commandActorController(Direction.LEFT);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            commandActorController(Direction.RIGHT);
        }
    }
    
    private void commandActorController(Direction direction) {
        actorcontroller.moveActor(player, direction);
    }
    

}
