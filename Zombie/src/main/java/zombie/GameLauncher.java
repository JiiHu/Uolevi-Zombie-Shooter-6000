
package zombie;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class GameLauncher {
    
    public void start() {
        Game game = new Game();
        
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        configureUI(config);
	LwjglApplication app = new LwjglApplication(new zombie.ui.UserInterface(game), config);
    }
    
    public void configureUI(LwjglApplicationConfiguration config) {
        config.title = "Super Uolevi Zombie Shooter 6000 HD";
        config.width = 1280;
        config.height = 720;
    }
    
}
