package zombie.game;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;


public class Main {
    public static void main(String[] args) {
        GameLauncher launcher = new GameLauncher(1280, 720);
        launcher.start();
    }
}
