package zombie.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import zombie.domain.Actor;
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
            actorcontroller.moveActor(player, "UP");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            actorcontroller.moveActor(player, "DOWN");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            actorcontroller.moveActor(player, "LEFT");
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            actorcontroller.moveActor(player, "RIGHT");
        }
    }
    

}
