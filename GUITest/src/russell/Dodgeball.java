package russell;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Dodgeball style program
 * Use arrow keys to move the blue square and avoid the flashing balls
 * @author Brendan Russell
 * @version Dec 22, 2016
 */
@SuppressWarnings("serial")
public class Dodgeball extends JPanel implements Runnable, KeyListener {

	private boolean gameOver = false;
	
	long startTime = 0;
	
	int level = 0;
	
	/**
	 * Width and height of the screen
	 */
	int width = 1900;
	int height = 970;
	/**
	 * The integer value of the current key that is pressed
	 */
	int key = 0;
	/**
	 * The number of balls on the screen.
	 */
	int numBalls = 14;
	/**
	 * The pause between repainting (should be set for about 30 frames per
	 * second).
	 */
	final int pauseDuration = 0;
	/**
	 * An array of balls.
	 */
	ArrayList<FlashingBall> ball = new ArrayList<FlashingBall>();
	Calendar cal;
	/**
	 * Cursor for the player to use
	 */
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
		cursor.setColor(new Color(0,0,0));
		
		for (int i = 0; i < numBalls; i++){
			ball.add(new FlashingBall((int) (Math.random()*1100+500), (int) (Math.random()*700+100), 0, width, 0, height, 100));
		}
		for (int i = 0; i < numBalls; i++) {
			ball.get(i).setXSpeed(Math.random() * 12-6);
			ball.get(i).setYSpeed(Math.random() * 12-6);
			ball.get(i).setColor(new Color((int) (Math.random() * 256), 
					(int) (Math.random() * 256), (int) (Math.random() * 256)));
		}
		
		addKeyListener(this);
		
		startTime = System.currentTimeMillis();
		
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
					if(didCursorCollide(cursor, ball.get(i))){
						gameOver();
					}
				}
				if(cursor.outOfBounds()){
					gameOver();
				}
				if(System.currentTimeMillis() - startTime > 20*1000){//20 seconds * 1000 milliseconds per second
					startTime = System.currentTimeMillis();
					nextLevel();
				}
				repaint();
			}
			else{
				if(key==82){
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
					resetGame();
				}
			}
			if(key==67){
				System.exit(0);
			}
			try {
				Thread.sleep(pauseDuration);
			} catch (InterruptedException e) {
			}
		}
	}
	
	private void nextLevel() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		numBalls++;
		level++;
		ball.add(new FlashingBall((int) (Math.random()*1100+500), (int) (Math.random()*700+100), 0, width, 0, height, 100));
		ball.get(ball.size()-1).setXSpeed(Math.random() * 12-6);
		ball.get(ball.size()-1).setYSpeed(Math.random() * 12-6);
		ball.get(ball.size()-1).setColor(new Color((int) (Math.random() * 256), 
				(int) (Math.random() * 256), (int) (Math.random() * 256)));
	}

	/**
	 * Resets the game to the beginning
	 */
	private void resetGame() {
		gameOver = false;
		this.setBackground(Color.WHITE);
		cursor.move(50, 50);
		for (int i = 0; i < numBalls; i++) {
			ball.get(i).move(Math.random()*1100+500, Math.random()*700+100);
			ball.get(i).setXSpeed(Math.random() * 12-6);
			ball.get(i).setYSpeed(Math.random() * 12-6);
			ball.get(i).setColor(new Color((int) (Math.random() * 256), 
					(int) (Math.random() * 256), (int) (Math.random() * 256)));
			ball.get(i).startThread();
		}
		key = 0;
		cursor.startThread();
	}

	/**
	 * Clears the screen and paints the balls.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < numBalls; i++) {
			ball.get(i).draw(g);
		}
		cursor.draw(g);

	}
	
	
	public boolean didCursorCollide(PlayerCursor cursor, FlashingBall ball){
		int radius = ball.getRadius() + (cursor.getLength()/2);
		double xTotal = cursor.getX() - ball.getX();
		double yTotal = cursor.getY() - ball.getY();
		double dist = Math.sqrt(Math.pow(xTotal, 2) + Math.pow(yTotal, 2));
		return radius>=dist;
	}
	
	public void gameOver(){
		gameOver = true;
		cursor.move(-10, -10);
		this.setBackground(Color.BLACK);
		Color redColour = new Color(255, 0, 0);
		for(int i=0; i<numBalls; i++){
			ball.get(i).stopThread();
			ball.get(i).setColor(redColour);
			ball.get(i).fillCircle();
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
