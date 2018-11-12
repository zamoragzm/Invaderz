package invaderz.model;

import java.awt.Color;

/*
 * Represents a missile.
 */
public class Missile {
	
	public static final int SIZE_X = 5;
	public static final int SIZE_Y = 9;
	public static final int DY = -2;
	public static final Color COLOR = new Color(128, 50, 20);
	
	private int x;
	private int y;

	// EFFECTS: missile is positioned at coordinates (x, y)
	public Missile(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	// MODIFIES: this
	// EFFECTS: missile is moved DY units (up the screen)
	public void move() {
		y = y + DY;
	}
}
