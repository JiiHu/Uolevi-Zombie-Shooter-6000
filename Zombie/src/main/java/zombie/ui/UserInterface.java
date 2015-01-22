package zombie.ui;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;
import java.awt.event.KeyEvent;
import zombie.game.ZombieGame;

public class UserInterface implements ApplicationListener {

    Texture testTexture;
    SpriteBatch batch;
    float elapsed;

    private ZombieGame game;
    private Texture background;
    private Sprite player;
    private InputHandler input;

    public UserInterface(ZombieGame game) {
        this.game = game;
        this.input = new InputHandler(game.getPlayer(), game.getActorController());
    }

    @Override
    public void create() {
        testTexture = new Texture(Gdx.files.internal("assets/zombie-1.png"));
        background = new Texture(Gdx.files.internal("assets/background.jpg"));

        createPlayer();

        batch = new SpriteBatch();
    }

    private void createPlayer() {
        player = new Sprite(new Texture(Gdx.files.internal(game.getPlayer().getTexture())));
        player.setOrigin(player.getWidth() / 2, player.getHeight() / 2);
    }

    @Override
    public void render() {
        elapsed += Gdx.graphics.getDeltaTime();
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
        
        input.lookForInput();

        batch.begin();

        drawBackground();
        drawTexture(testTexture);
        drawSprite(player, game.getPlayer().getX(), game.getPlayer().getY());

        batch.end();
    }

    private void drawSprite(Sprite sprite, int x, int y) {
        batch.draw(sprite, x, y);
    }


    private void drawBackground() {
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void drawTexture(Texture texture) {
        batch.draw(texture, 100 + 100 * (float) Math.cos(elapsed), 100 + 25 * (float) Math.sin(elapsed));
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
