package zombie.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import zombie.domain.Actor;
import zombie.domain.Direction;
import zombie.logic.ActorController;
import zombie.logic.InputController;

public class InputHandler {
    
    private InputController inputController;
    
    public InputHandler(InputController inputController) {
        this.inputController = inputController;
    }
     
    public void lookForInput() {
        lookForMouseInput();
        lookForKeyboardInput();
    }

    private void lookForMouseInput() {
        int x = Gdx.input.getX();
        int y = Gdx.input.getY();
        inputController.mousePosition(x, y);
    }

    private void lookForKeyboardInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            movePlayer(Direction.UP);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            movePlayer(Direction.DOWN);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            movePlayer(Direction.LEFT);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            movePlayer(Direction.RIGHT);
        }
    }
    
    private void movePlayer(Direction direction) {
        inputController.movePlayer(direction);
    }
    

}
