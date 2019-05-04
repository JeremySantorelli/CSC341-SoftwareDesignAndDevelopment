package Assignment7;

import java.awt.*;
import java.util.*;

public class Raindrop {
	int x, y, currentSize, visibleSize;
	final int MAX_RIPPLE = 30;
	final int RIPPLE_STEP = 2;
	static Random r = new Random();;
	
	public Raindrop(){
		currentSize = 0;
		visibleSize = 0;
		x = y = 0;		
	}
	
	public void setPosition(int xPos, int yPos){
		x = xPos;
		y = yPos;
		visibleSize = Math.abs(r.nextInt()% MAX_RIPPLE ) + 1;
		currentSize = 1;
	}
	
	public void ripple(){
		x -= RIPPLE_STEP /2;
		y -= RIPPLE_STEP /2;
		currentSize += RIPPLE_STEP;
	}
	
	public boolean isVisible(){
		return currentSize < visibleSize;
	}

	public void draw(Graphics g){
		g.drawOval(x, y, currentSize, currentSize);
	}
}
