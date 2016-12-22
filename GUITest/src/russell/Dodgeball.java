package russell;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the beginning of a simple game. You should expand it into a dodgeball
 * game, where the user controls an object with the mouse or keyboard, and tries
 * to avoid the balls flying around the screen. If they get hit, it's game over.
 * If they survive for 20 seconds (or some other fixed time), they go on to the
 * next level. <br>
 * <br>
 * Should be run at around 500x300 pixels.<br>
 * <br>
 * @version Nov. 2015
 * 
 * @author Christina Kemp adapted from Sam Scott
 */
@SuppressWarnings("serial")
public class Dodgeball extends JPanel implements Runnable, KeyListener {

	private boolean gameOver = false;
	
	int width = 2000;
	int height = 970;
	
	int key = 0;
	/**
	 * The number of balls on the screen.
	 */
	final int numBalls = 10;
	/**
	 * The pause between repainting (should be set for about 30 frames per
	 * second).
	 */
	final int pauseDuration = 50;
	/**
	 * An array of balls.
	 */
	FlashingBall[] ball = new FlashingBall[numBalls];
	
	PlayerCursor cursor = new PlayerCursor(50, 50, 0, width, 0, height, Shape.SQUARE , 10);

	/** main program (entry point) */
	public static void main(String[] args) {

		// Set up main window (using Swing's Jframe)
		JFrame frame = new JFrame("Dogeball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(2000, 1100));
		frame.setAutoRequestFocus(false);
		frame.setVisible(true);
		Container c = frame.getContentPane();
		c.add(new Dodgeball());
		frame.pack();
		

	}

	public Dodgeball(){
		// Start the ball bouncing (in its own thread)
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.WHITE);
		
		cursor.setXSpeed(0);
		cursor.setYSpeed(0);
		cursor.setColor(new Color(0,0,255));
		
		for (int i = 0; i < numBalls; i++) {
			ball[i] = new FlashingBall(1700, 50, 0, width, 0, height, 100);
			ball[i].setXSpeed(Math.random() * 12-6);
			ball[i].setYSpeed(Math.random() * 12-6);
			ball[i].setColor(new Color((int) (Math.random() * 256), 
					(int) (Math.random() * 256), (int) (Math.random() * 256)));
		}
		
		addKeyListener(this);
		
		Thread gameThread = new Thread(this);
		gameThread.start();

	}

	/**
	 * Repaints the frame periodically.
	 */
	public void run() {
		while (true) {
			if(!gameOver){
				this.requestFocus();
				if(key==38){
					cursor.setYSpeed(-7);
					cursor.setXSpeed(0);
				}
				else if(key==40){
					cursor.setYSpeed(7);
					cursor.setXSpeed(0);
				}
				else if(key==37){
					cursor.setXSpeed(-7);
					cursor.setYSpeed(0);
				}
				else if(key==39){
					cursor.setXSpeed(7);
					cursor.setYSpeed(0);
				}
				for(int i=0; i<numBalls; i++){
					if(didCursorCollide(cursor, ball[i])){
						gameOver();
					}
				}
				repaint();
				try {
					Thread.sleep(pauseDuration);
				} catch (InterruptedException e) {
				}
			}
			else{
				if(key==82){
					resetGame();
					gameOver = false;
				}
			}
		}
	}
	private void resetGame() {
		for (int i = 0; i < numBalls; i++) {
			ball[i] = new FlashingBall(1700, 50, 0, width, 0, height, 100);
			ball[i].setXSpeed(Math.random() * 12-6);
			ball[i].setYSpeed(Math.random() * 12-6);
			ball[i].setColor(new Color((int) (Math.random() * 256), 
					(int) (Math.random() * 256), (int) (Math.random() * 256)));
			ball[i].startThread();
		}
	}

	//4162369195 Dietrich Home Phone Number
	/**
	 * Clears the screen and paints the balls.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < numBalls; i++) {
			ball[i].draw(g);
		}
		cursor.draw(g);

	}
	
	
	public boolean didCursorCollide(PlayerCursor cursor, FlashingBall ball){
		int radius = ball.getRadius();
		double xTotal = cursor.getX() - ball.getX();
		double yTotal = cursor.getY() - ball.getY();
		double dist = Math.sqrt(Math.pow(xTotal, 2) + Math.pow(yTotal, 2));
		return radius>=dist;
	}
	
	public void gameOver(){
		gameOver = true;
		cursor.move(10, 10);
		Color redColour = new Color(255, 0, 0);
		for(int i=0; i<numBalls; i++){
			ball[i].stopThread();
			ball[i].setColor(redColour);
		}
		cursor.stopThread();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		key = e.getKeyCode();
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		key = 0;
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
