package invaderz.test;


import invaderz.model.Invader;
import invaderz.model.Missile;
import invaderz.model.SIGame;
import invaderz.model.Tank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Unit tests for the Game class.
 */
public class GameTest {
	private SIGame siGame;
	
	@BeforeEach
	public void runBefore() {
		siGame = new SIGame();
	}
	
	@Test
	public void testConstructor() {
		Tank t = siGame.getTank();
		assertEquals(SIGame.WIDTH / 2, t.getX());
		List<Invader> invaders = siGame.getInvaders();
		assertEquals(0, invaders.size());
		List<Missile> missiles = siGame.getMissiles();
		assertEquals(0, missiles.size());
	}
	
	@Test
	public void testUpdate() {
		Tank t = siGame.getTank();
		assertEquals(SIGame.WIDTH / 2, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 + Tank.DX, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 + 2 * Tank.DX, t.getX());
		assertEquals(0, siGame.getMissiles().size());
	}
	
	@Test
	public void testNonKeyPadKeyEvent() {
		Tank t = siGame.getTank();
		siGame.keyPressed(KeyEvent.VK_LEFT);
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - 2 * Tank.DX, t.getX());
		siGame.keyPressed(KeyEvent.VK_RIGHT);
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2, t.getX());		
	}
	
	@Test
	public void testKeyPadKeyEvent() {
		Tank t = siGame.getTank();
		siGame.keyPressed(KeyEvent.VK_KP_LEFT);
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - 2 * Tank.DX, t.getX());
		siGame.keyPressed(KeyEvent.VK_KP_RIGHT);
		siGame.update();
		assertEquals(SIGame.WIDTH / 2 - Tank.DX, t.getX());
		siGame.update();
		assertEquals(SIGame.WIDTH / 2, t.getX());		
	}
	
	@Test
	public void testSpaceKeyEvent() {
		siGame.keyPressed(KeyEvent.VK_SPACE);
		assertEquals(1, siGame.getMissiles().size());
		siGame.keyPressed(KeyEvent.VK_SPACE);
		siGame.keyPressed(KeyEvent.VK_SPACE);
		assertEquals(3, siGame.getMissiles().size());
	}
}
