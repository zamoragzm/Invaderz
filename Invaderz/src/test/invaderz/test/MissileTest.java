package invaderz.test;

import invaderz.model.Missile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Missile class.
 */
public class MissileTest {
	private static final int XLOC = 50;
	private static final int YLOC = 100;
	private Missile missile;

	@BeforeEach
	public void runBefore() {
		missile = new Missile(XLOC, YLOC);
	}
	
	@Test
	public void testConstructor() {
		assertEquals(XLOC, missile.getX());
        assertEquals(YLOC, missile.getY());
	}

	@Test
	public void testUpdate() {
		final int NUM_UPDATES = 8;
		
		missile.move();
		assertEquals(XLOC, missile.getX());
		assertEquals(YLOC + Missile.DY, missile.getY());
		
		for(int count = 1; count < NUM_UPDATES; count++) {
			missile.move();
		}
		
		assertEquals(XLOC, missile.getX());
		assertEquals(YLOC + NUM_UPDATES * Missile.DY, missile.getY());
	}
}
