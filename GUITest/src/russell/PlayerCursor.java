package russell;

import java.awt.Graphics;

public class PlayerCursor extends MovingObject{
	private Shape shape;
	private int length;

	public PlayerCursor(double x, double y, int left, int right, int top, int bottom) {
		super(x, y, left, right, top, bottom);
		// TODO Auto-generated constructor stub
	}
	
	public PlayerCursor(double x, double y, int left, int right, int top, int bottom, Shape shape, int length) {
		super(x, y, left, right, top, bottom);
		this.shape = shape;
		this.length = length;
		
	}

	@Override
	public void draw(Graphics g) {
		switch(shape){
		case CIRCLE:{
			int radius = length/2;
			int drawX = (int) getX() - radius;
			int drawY = (int) getY() - radius;

			g.setColor(color);
			g.fillOval(drawX, drawY, length, length);
		}
		case SQUARE:{
			g.setColor(color);
			g.fillRect((int) getX() - length/2, (int) getY() - length/2, length, length);
		}
		}
		
	}

	@Override
	public void animateOneStep() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean outOfBounds(){
		return getX()>=getRight()+30||getX()<=getLeft()-30||getY()<=getTop()-30||getY()>=getBottom()+30;
	}
	
	public int getLength(){
		return this.length;
	}
	

}
