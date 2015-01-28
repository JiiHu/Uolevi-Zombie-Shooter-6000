package zombie.logic;

import java.util.ArrayList;
import zombie.domain.Direction;
import zombie.domain.Player;
import zombie.domain.Zombie;

public class ZombieAI {

    private ActorController ac;
    private ArrayList<Zombie> zombies;
    private Player player;

    public ZombieAI(ActorController ac, Player player) {
        this.ac = ac;
        zombies = new ArrayList<Zombie>();
        this.player = player;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }

    public void addZombie() {
        Zombie zombie = new Zombie(100, 100);
        zombies.add(zombie);
    }

    public void removeZombie(Zombie zombie) {
        zombies.remove(zombie);
    }

    public void moveZombies() {
        for (Zombie zombie : zombies) {
            moveZombieTowardsPlayer(zombie);
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
