package fish;

import java.awt.Graphics;
import java.awt.Image;

public class Multiple {
	int x,y;
	Image muImg;
	public Multiple(int x, int y, Image muImg) {
		super();
		this.x = x;
		this.y = y;
		this.muImg = muImg;
	}
	public void drawMultiple(Graphics g){
		g.drawImage(muImg, x, y, null);
	}

}
