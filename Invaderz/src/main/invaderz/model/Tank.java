package invaderz.model;

import java.awt.Color;

/**
 * Represents a tank
 */
public class Tank {
	
	public static final int SIZE_X = 15;
	public static final int SIZE_Y = 8;
	public static final int DX = 3;
	public static final int Y_POS = SIGame.HEIGHT - 40;
	public static final Color COLOR = new Color(250, 128, 20);
	private int xCordinate;
	private int direction;



	// EFFECTS: places tank at position (x, Y_POS) moving right.
	public Tank(int x) {
		xCordinate = x;
		direction = 1;
	}
	
	public int getX() {
		return xCordinate;
	}

    // EFFECTS: returns true if tank is facing right, false otherwise
    public boolean isFacingRight() {
        if(direction == 1){
            return true;
        }else{
            return false;
        }

    }

	// MODIFIES: this
	// EFFECTS: tank is facing right
	public void faceRight() {
	    direction = 1;
	}

	// MODIFIES: this
	// EFFECTS: tank is facing left
	public void faceLeft() {
	    direction = -1;
	}

	// MODIFIES: this
	// EFFECTS:  tank is moved DX units in whatever direction it is facing and is
	//           constrained to remain within horizontal bounds of game
    public void move() {
        xCordinate = xCordinate + direction * DX;
        handleBoundary();
	}

	// MODIFIES: this
	// EFFECTS: tank is constrained to remain within horizontal bounds of game
	private void handleBoundary() {
        if (xCordinate < 0){
            xCordinate = 0;
        }
        else if (xCordinate > SIGame.WIDTH) {
            xCordinate = SIGame.WIDTH;
        }
	}
}
