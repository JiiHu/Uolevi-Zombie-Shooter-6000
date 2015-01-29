package zombie.domain;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ActorTest {
    
    Actor actor;
    
    @Before
    public void setUp() {
        actor = new Actor();
        actor.setMaxHp(50);
    }
    
    @Test
    public void getHpReturnsCorrectValue() {
        assertEquals(100, actor.getHp());
        actor.setHp(10);
        assertEquals(10, actor.getHp());
        actor.setHp(15);
        assertEquals(15, actor.getHp());
    }
    
    @Test
    public void maxHpSetsAndGetsCorrectValue() {
        actor.setMaxHp(100);
        assertEquals(100, actor.getMaxHp());
        actor.setMaxHp(50);
        assertEquals(50, actor.getMaxHp());
    }
    
    @Test
    public void hpSetsAndGetsRightValue() {
        actor.setMaxHp(100);
        actor.setHp(50);
        assertEquals(50, actor.getHp());
        actor.setHp(100);
        assertEquals(100, actor.getHp());
    }
    
    @Test
    public void speedSetsAndGetsRightValue() {
        actor.setSpeed(2);
        assertEquals(2, actor.getSpeed());
        actor.setSpeed(8);
        assertEquals(8, actor.getSpeed());
    }
    
    @Test
    public void cantSetNegativeMaxHp() {
        actor.setMaxHp(100);
        actor.setMaxHp(-1);
        assertEquals(100, actor.getMaxHp());
    }
    @Test
    public void cantSetZeroMaxHp() {
        actor.setMaxHp(100);
        actor.setMaxHp(0);
        assertEquals(100, actor.getMaxHp());
    }
    
    @Test
    public void cantSetNegativeHp() {
        actor.setHp(-1);
        assertEquals(100, actor.getHp());
    }
    
    @Test
    public void cantSetHpOverMaxHp() {
        actor.setHp(30);
        actor.setHp(51);
        assertEquals(30, actor.getHp());
        actor.setHp(40);
        assertEquals(40, actor.getHp());
    }
    
    @Test
    public void decreaseHpWorksCorrectly() {
        actor.setHp(30);
        actor.decreaseHp(10);
        assertEquals(20, actor.getHp());
        actor.decreaseHp(8);
        assertEquals(12, actor.getHp());
    }
    
    @Test
    public void increaseHpWorksCorrectly() {
        actor.setHp(10);
        actor.increaseHp(10);
        assertEquals(20, actor.getHp());
        actor.increaseHp(8);
        assertEquals(28, actor.getHp());
    }
    
    @Test
    public void increaseHpWontIncreaseOverMaxHp() {
        actor.setHp(45);
        actor.increaseHp(10);
        assertEquals(50, actor.getHp());
    }
    @Test
    public void decreaseHpWontDecreaseUnderZero() {
        actor.setHp(10);
        actor.decreaseHp(15);
        assertEquals(0, actor.getHp());
    }

}
