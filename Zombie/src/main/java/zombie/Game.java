
package zombie;

import zombie.ui.UserInterface;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Game {
    
    public Game() {
        
    }
    
    public void start() {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	LwjglApplication app = new LwjglApplication(new UserInterface(), config);
    }
    
}
