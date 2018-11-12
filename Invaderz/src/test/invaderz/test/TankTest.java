package invaderz.test;

import invaderz.model.Tank;
import invaderz.model.SIGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Unit tests for the Tank class.
 */
public class TankTest {
	private static final int XLOC = SIGame.WIDTH / 2;
	private Tank tank;
	
	@BeforeEach
	public void runBefore() {
		tank = new Tank(XLOC);
	}
	
	@Test
	public void testFace() {
        tank.faceRight();
        assertTrue(tank.isFacingRight());
        tank.faceLeft();
        assertFalse(tank.isFacingRight());
    }

    @Test
    public void testConstructor() {
       assertEquals(XLOC,tank.getX());
       assertTrue(tank.isFacingRight());
    }

    @Test
    public void testMove() {
	    tank.move();
        assertEquals(XLOC + Tank.DX, tank.getX());
    }

    @Test
    public void testMoveInTheEnd() {
        Tank tank2c = new Tank(SIGame.WIDTH);
        tank2c.move();
        assertEquals(SIGame.WIDTH, tank2c.getX());
    }


}
