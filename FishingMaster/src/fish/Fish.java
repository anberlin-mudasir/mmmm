package fish;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Fish {
	int x, y, direction;
	int kind;
	Image fishImg[] = new Image[11];

	static final int left_to_right = 0;
	static final int right_to_left = 1;
	static final int up_to_buttom = 2;

	public Fish(int x, int y, int direction, int kind) {
		super();
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.kind = kind;
	}

	public void drawFish(Graphics g, int number) {
		String pre = null, path = null;
		if (direction == 0)
			pre = "left_to_right";
		if (direction == 1)
			pre = "right_to_left";
		if (direction == 2)
			pre = "up_to_buttom";

		for (int i = 0; i < fishImg.length; i++) {
			if (kind < 10) {
				path = "images/" + pre + "/fish0" + kind + "_0" + (i + 1) + ".png";
				fishImg[i] = new ImageIcon(path).getImage();
			}
			if (kind >= 10) {
				path = "images/" + pre + "/fish" + kind + "_0" + (i + 1) + ".png";
				fishImg[i] = new ImageIcon(path).getImage();

			}

		}

		g.drawImage(fishImg[number], x, y, null);

	}

	public void moveFish() {
		switch (direction) {
		case left_to_right:
			x += 1;
			break;

		case right_to_left:
			x -= 1;
			break;

		case up_to_buttom:
			y++;
			break;

		}

	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

}
