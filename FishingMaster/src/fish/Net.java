package fish;

import java.awt.Graphics;
import java.awt.Image;

public class Net {
	int x,y;
	Image netImg;
	public Net(int x, int y, Image netImg) {
		super();
		this.x = x;
		this.y = y;
		this.netImg = netImg;
	}
	public void drawnet(Graphics g){
		g.drawImage(netImg, x, y, null);
		
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	
}
