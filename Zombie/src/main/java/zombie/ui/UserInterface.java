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
import zombie.logic.HUDController;

/**
 * Class is used to draw image with LibGDX
 */
public class UserInterface implements ApplicationListener {

    SpriteBatch batch;

    private Texture background;
    private Texture startscreen;
    private Texture[][] zombieTextures;
    private Sprite playerSprite;
    private InputHandler input;
    private int zombieTextureAmount;
    private int timeSinceDeath;

    private ZombieGame game;
    private Player player;
    private HUDController hud;
    
    public UserInterface(ZombieGame game) {
        zombieTextureAmount = game.getZombieTexturesAmount();
        zombieTextures = new Texture[zombieTextureAmount + 1][4];
        this.game = game;
        this.input = new InputHandler(game.getInputController());
        this.player = game.getPlayer();
        this.hud = game.getHUDController();
        this.timeSinceDeath = 0;
    }

    @Override
    public void create() {
        createTextures();
        createPlayerSprite();
        batch = new SpriteBatch();
    }
    
    private void createTextures() {
        background = new Texture(Gdx.files.internal("assets/background.jpg"));    
        startscreen = new Texture(Gdx.files.internal("assets/startscreen.jpg"));    
        for (int i = 1; i <= zombieTextureAmount; i++) {
            for (int j = 0; j < 4; j++) {
                zombieTextures[i][j] = new Texture(Gdx.files.internal("assets/zombie-" + i + "-" + (j + 1) + ".png"));
            }
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
        batch.begin();
        drawEverything();
        batch.end();
    }

    private void drawEverything() {
        if (game.hasStarted()) {
            boolean playerIsAlive = game.play();
            drawBackground();
            drawZombies();
            drawPlayer();
            drawText();
            if (!playerIsAlive) {
                drawGameOver();
                lookIfZombieGameObjectShouldBeReseted();
            }
            //drawUnimportantStuff();
        } else {
            drawStartScreen();
        }
    }

    private void lookIfZombieGameObjectShouldBeReseted() {
        timeSinceDeath++;
        if (timeSinceDeath < 300) {
            return;
        }
        game.resetEverything();
        timeSinceDeath = 0;
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(255, 255, 255, 0);
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
    }
    
    private void drawGameOver() {
        BitmapFont font = new BitmapFont();
        font.setColor(Color.RED);
        font.setScale(3);
        font.draw(batch, "GAME OVER", 500, 450);
        font.draw(batch, "Level: " + hud.levelNumber(), 550, 400);
        font.draw(batch, "Zombies killed: " + hud.zombiesKilled(), 470, 350);
    }
    
    /**
     * Method for debugging input
     */
    private void drawUnimportantStuff() {
        BitmapFont font = new BitmapFont();
        font.setColor(Color.BLUE);
        font.draw(batch, "playerSprite.getRotation(): " + playerSprite.getRotation(), 200, 140);
        font.draw(batch, "player.getX(): " + player.getX() + ", player.getY(): " + player.getY(), 200, 110);
        font.draw(batch, "mouse X: " + Gdx.input.getX() + ", mouse Y: " + (720 - Gdx.input.getY()), 200, 80);
    }

    private void drawText() {
        BitmapFont font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.draw(batch, "Level: " + hud.levelNumber(), 30, 710);
        font.draw(batch, "Zombies killed: " + hud.zombiesKilled(), 100, 710);
        font.draw(batch, "HP: " + hud.playerHp(), 250, 710);
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
    
    private void drawZombie(Zombie zombie) {
        int textureId = zombie.getTextureAsInt();
        int bloodSprite = getZombieBloodSpriteId(zombie.getHp());
        Texture texture = zombieTextures[textureId][bloodSprite];
        int angle = zombie.getAngle();
        int width = texture.getWidth();
        int height = texture.getHeight();
        
        batch.draw(texture, zombie.getX(), zombie.getY(),
                width/2, height/2, width, height, 1, 1, angle,
                0, 0, width, height, false, false);
        // Stuff that method above eats:
        // Texture texture, float x, float y,
        // float originX, float originY, float width, float height, float scaleX, float scaleY, float rotation,
        // int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY
    }

    private int getZombieBloodSpriteId(int hp) {
        if (hp >= 80) {
            return 0;
        } else if (hp >= 50) {
            return 1;
        } else if (hp >= 25) {
            return 2;
        }
        return 3;
    }

    private void drawSprite(Sprite sprite, int x, int y) {
        batch.draw(sprite, x, y);
    }

    private void drawBackground() {
        batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    private void drawStartScreen() {
        batch.draw(startscreen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
    
    @Override
    public void resize(int width, int height) {}
    @Override
    public void pause() {}
    @Override
    public void resume() {}
    @Override
    public void dispose() {}
}