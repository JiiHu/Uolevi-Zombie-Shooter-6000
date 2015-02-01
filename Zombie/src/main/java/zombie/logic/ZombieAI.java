package zombie.logic;

import java.util.ArrayList;
import java.util.Random;
import zombie.domain.Direction;
import zombie.domain.Place;
import zombie.domain.Player;
import zombie.domain.Zombie;

public class ZombieAI {

    private ActorController ac;
    private ArrayList<Zombie> zombies;
    private Player player;
    private PlaceController placeController;
    private Random random;
    private int textureAmount;

    public ZombieAI(ActorController ac, Player player, int textureAmount) {
        this.ac = ac;
        this.player = player;
        this.textureAmount = textureAmount;
        
        random = new Random(19);
        zombies = new ArrayList<Zombie>();
        placeController = new PlaceController();
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }
    
    private int randomZombieTextureNumber() {
        return random.nextInt(textureAmount)+1;
    }

    public void addZombie() {
        Place place = placeController.getRandomPlace();
        int textureNumber = randomZombieTextureNumber();
        Zombie zombie = new Zombie(place.getX(), place.getY(), textureNumber+"");
        zombies.add(zombie);
    }

    public void removeZombie(Zombie zombie) {
        zombies.remove(zombie);
    }

    public void moveZombies() {
        for (Zombie zombie : zombies) {
            moveZombieTowardsPlayer(zombie);
            ac.rotateZombie(zombie);
            System.out.println(zombie.getAngle());
        }
    }

    private void moveZombieTowardsPlayer(Zombie zombie) {
        int playerX = player.getX();
        int playerY = player.getY();

        int zombieX = zombie.getX();
        int zombieY = zombie.getY();

        if (playerX < zombieX) {
            ac.moveActor(zombie, Direction.LEFT);
        } else if (playerX > zombieX) {
            ac.moveActor(zombie, Direction.RIGHT);
        }
        
        if (playerY < zombieY) {
            ac.moveActor(zombie, Direction.DOWN);
        } else if (playerY > zombieY) {
            ac.moveActor(zombie, Direction.UP);
        }        
    }

}
