package invaderz.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.Timer;

import invaderz.model.SIGame;

/*
 * Represents the main window Invaderz
 * game is played
 */
@SuppressWarnings("serial")
public class Invaderz extends JFrame {

	private static final int INTERVAL = 20;
	private SIGame game;
	private GamePanel gp;
	private ScorePanel sp;

	// EFFECTS: sets up window Invaderz game will be played
	public Invaderz() {
		super("Invaderz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		game = new SIGame();
		gp = new GamePanel(game);
		sp = new ScorePanel(game);
		add(gp);
		add(sp, BorderLayout.NORTH);
		addKeyListener(new KeyHandler());
		pack();
		centreOnScreen();
		setVisible(true);
		addTimer();
	}

	// MODIFIES: none
	// EFFECTS:  initializes a timer that updates game each
    //           INTERVAL milliseconds
    private void addTimer() {
        Timer t = new Timer(INTERVAL, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!game.isOver()) {
                    game.update();
                    sp.update();
                }
                gp.repaint();
            }
        });

        t.start();
	}

	// MODIFIES: this
	// EFFECTS:  location of frame is set so frame is centred on desktop
	private void centreOnScreen() {
		Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
	}
	
	/*
	 * A key handler to respond to key events
	 */
	private class KeyHandler extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			game.keyPressed(e.getKeyCode());
		}
	}

	// Play the game
	public static void main(String[] args) {
		new Invaderz();
	}
}
