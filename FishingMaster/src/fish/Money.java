package fish;

import java.awt.Graphics;
import java.awt.Image;

public class Money {
	int x,y;
	Image moImg;
	
	
	public Money(int x, int y, Image moImg) {
		super();
		this.x = x;
		this.y = y;
		this.moImg = moImg;
	}

	public void drawMoney(Graphics g){
		g.drawImage(moImg, x, y, null);
	}
	
	public void moveMoney(){
		y+=10;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
