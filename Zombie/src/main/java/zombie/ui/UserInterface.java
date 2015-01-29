package zombie.ui;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.awt.event.KeyEvent;
import zombie.domain.Zombie;
import zombie.game.ZombieGame;

public class UserInterface implements ApplicationListener {

    SpriteBatch batch;

    private ZombieGame game;
    private Texture background;
    private Texture[] zombieTextures;
    private Sprite player;
    private InputHandler input;
    private int zombieTextureAmount;

    public UserInterface(ZombieGame game) {
        zombieTextureAmount = game.getZombieTexturesAmount();
        zombieTextures = new Texture[zombieTextureAmount+1];
        this.game = game;
        this.input = new InputHandler(game.getPlayer(), game.getActorController());
    }

    @Override
    public void create() {
        createTextures();
        createPlayer();
        batch = new SpriteBatch();
    }
    
    
    private void createTextures() {
        background = new Texture(Gdx.files.internal("assets/background.jpg"));
        
        for (int i = 1; i <= zombieTextureAmount; i++) {
            zombieTextures[i] = new Texture(Gdx.files.internal("assets/zombie-"+i+".png"));
        }
    }

    private void createPlayer() {
        player = new Sprite(new Texture(Gdx.files.internal(game.getPlayer().getTexture())));
        player.setOrigin(player.getWidth() / 2, player.getHeight() / 2);
    }

    @Override
    public void render() {
        clearScreen();
        
        input.lookForInput();
        game.play();
        
        batch.begin();

        drawBackground();
        drawZombies();
        drawPlayer();

        batch.end();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
    }

    private void drawPlayer() {
        drawSprite(player, game.getPlayer().getX(), game.getPlayer().getY());
    }

    private void drawZombies() {
        for (Zombie zombie : game.getZombieAI().getZombies()) {
            drawTexture(zombie.getTextureAsInt(), zombie.getX(), zombie.getY());
        }
    }

    private void drawSprite(Sprite sprite, int x, int y) {
        batch.draw(sprite, x, y);
    }


    private void drawBackground() {
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void drawTexture(int textureId, int x, int y) {
        batch.draw(zombieTextures[textureId], x, y);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
    }

}
