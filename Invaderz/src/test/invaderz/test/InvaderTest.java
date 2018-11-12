package invaderz.test;

import invaderz.model.Invader;
import invaderz.model.Missile;
import invaderz.model.SIGame;
import invaderz.model.SwiftInvader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Unit tests for the Invader class.
 */
public class InvaderTest {
	private static final int XLOC = SIGame.WIDTH / 2;
	private static final int YLOC = 50;
	private Invader invader;
	private Invader swiftInvader;
	
	@BeforeEach
	public void runBefore() {
		invader = new Invader(XLOC, YLOC);
		swiftInvader = new SwiftInvader(XLOC,YLOC);

	}
	
	@Test
	public void testConstructor() {
		assertEquals(XLOC, invader.getX());
        assertEquals(YLOC, invader.getY());
        assertEquals(XLOC, swiftInvader.getX());
        assertEquals(YLOC, swiftInvader.getY());
	}
	
	@Test
	public void testUpdate() {
		final int NUM_UPDATES = 8;
		
		invader.move();
		// can't test XLOC due to random jiggle behaviour
		assertEquals(YLOC + Invader.DY, invader.getY());

		swiftInvader.move();
        assertEquals(YLOC + SwiftInvader.DY, swiftInvader.getY());


        for(int count = 1; count < NUM_UPDATES; count++) {
			invader.move();
		}
		
		assertEquals(YLOC + NUM_UPDATES * Invader.DY, invader.getY());

        for(int count = 1; count < NUM_UPDATES; count++) {
            swiftInvader.move();
        }
        assertEquals(YLOC + NUM_UPDATES * SwiftInvader.DY, swiftInvader.getY());


    }
	
	@Test 
	public void testCollideWith() {
		Missile m = new Missile(0, 0);
		assertFalse(invader.collidedWith(m));
		
		m = new Missile(invader.getX(), invader.getY());
		assertTrue(invader.collidedWith(m));
		
		m = new Missile(invader.getX() + Invader.SIZE_X / 2 + Missile.SIZE_X / 2, invader.getY());
		assertTrue(invader.collidedWith(m));
		
		m = new Missile(invader.getX() + Invader.SIZE_X / 2 + Missile.SIZE_X / 2 + 1, invader.getY());
		assertFalse(invader.collidedWith(m));
		
		m = new Missile(invader.getX() - Invader.SIZE_X / 2 - Missile.SIZE_X / 2, invader.getY());
		assertTrue(invader.collidedWith(m));
		
		m = new Missile(invader.getX() - Invader.SIZE_X / 2 - Missile.SIZE_X / 2 - 1, invader.getY());
		assertFalse(invader.collidedWith(m));
		
		m = new Missile(invader.getX(), invader.getY() + Invader.SIZE_Y / 2 + Missile.SIZE_Y / 2);
		assertTrue(invader.collidedWith(m));

		m = new Missile(invader.getX(), invader.getY() + Invader.SIZE_Y / 2 + Missile.SIZE_Y / 2 + 1);
		assertFalse(invader.collidedWith(m));
	}
	
}
