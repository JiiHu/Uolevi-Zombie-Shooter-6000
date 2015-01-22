
package zombie;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class GameLauncher {
    
    private int width;
    private int height;
    
    public GameLauncher(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void start() {
        Game game = new Game(width, height);
        
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        configureUI(config);
	LwjglApplication app = new LwjglApplication(new zombie.ui.UserInterface(game), config);
    }
    
    public void configureUI(LwjglApplicationConfiguration config) {
        config.title = "Super Uolevi Zombie Shooter 6000 HD";
        config.resizable = false;
        config.width = this.width;
        config.height = this.height;
    }
    
}
