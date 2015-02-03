package zombie.ui;

import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import zombie.domain.Player;
import zombie.domain.Zombie;
import zombie.game.ZombieGame;

/**
 * Class is used to draw image with LibGDX
 */
public class UserInterface implements ApplicationListener {

    SpriteBatch batch;

    private ZombieGame game;
    private Texture background;
    private Texture[] zombieTextures;
    private Sprite playerSprite;
    private InputHandler input;
    private int zombieTextureAmount;
    private Player player;
    
    public UserInterface(ZombieGame game) {
        zombieTextureAmount = game.getZombieTexturesAmount();
        zombieTextures = new Texture[zombieTextureAmount+1];
        this.game = game;
        this.input = new InputHandler(game.getInputController());
        this.player = game.getPlayer();
    }

    @Override
    public void create() {
        createTextures();
        createPlayerSprite();
        batch = new SpriteBatch();
    }
    
    private void createTextures() {
        background = new Texture(Gdx.files.internal("assets/background.jpg"));    
        for (int i = 1; i <= zombieTextureAmount; i++) {
            zombieTextures[i] = new Texture(Gdx.files.internal("assets/zombie-"+i+".png"));
        }
    }

    private void createPlayerSprite() {
        playerSprite = new Sprite(new Texture(Gdx.files.internal(player.getTexture())));
        playerSprite.setOrigin(playerSprite.getWidth() / 2, playerSprite.getHeight() / 2);
    }

    @Override
    public void render() {
        clearScreen();
        
        input.lookForInput();
        game.play();
        
        batch.begin();
        
        drawText();

        drawBackground();
        drawZombies();
        drawPlayer();

        batch.end();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
    }

    private void drawText() {
        BitmapFont font = new BitmapFont();
        font.setColor(Color.RED);
        font.draw(batch, "playerSprite.getRotation(): "+playerSprite.getRotation(), 200, 140);
        font.draw(batch, "player.getX(): "+player.getX()+"player.getY(): "+player.getY(), 200, 110);
        font.draw(batch, "mouse X: "+Gdx.input.getX()+"mouse Y: "+(720-Gdx.input.getY()), 200, 80);
    }
    
    private int calculateAngleDifference(int angle, int currentRotation) {
        return angle - currentRotation;
    }

    private void drawPlayer() {
        int difference = calculateAngleDifference(player.getAngle(), (int) playerSprite.getRotation());
        playerSprite.rotate(difference);
        playerSprite.setPosition(player.getX(), player.getY());
        playerSprite.draw(batch);
    }

    private void drawZombies() {
        for (Zombie zombie : game.getZombieAI().getZombies()) {
            drawZombie(zombie);
        }
    }
    
    public void drawZombie(Zombie zombie) {
        int textureId = zombie.getTextureAsInt();
        Texture texture = zombieTextures[textureId];
        //batch.draw(texture, zombie.getX(), zombie.getY());
        
        int angle = zombie.getAngle();
        
        batch.draw(texture, zombie.getX(), zombie.getY(),
                0, 0, texture.getWidth(), texture.getHeight(),
                1, 1,
                angle, 0, 0,
                texture.getWidth(), texture.getHeight(), false, false);
        
        // Texture texture, float x, float y,
        // float originX, float originY, float width, float height,
        // float scaleX, float scaleY,
        // float rotation, int srcX, int srcY,
        //int srcWidth, int srcHeight, boolean flipX, boolean flipY
    }


    private void drawSprite(Sprite sprite, int x, int y) {
        batch.draw(sprite, x, y);
    }

    private void drawBackground() {
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
