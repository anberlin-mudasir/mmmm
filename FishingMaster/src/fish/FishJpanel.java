package fish;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class FishJpanel extends JPanel implements MouseMotionListener, MouseListener, KeyListener {
	Image bgImg, bgBottomImg, cannonImg, netImg, buImg, moImg, TimeBarImg;
	Image fishImg[]=new Image[10];
	Image muImg[] = new Image[4];
	List<Bullet> bullets = new ArrayList<Bullet>();
	List<Fish> fishs = new ArrayList<Fish>();
	List<Net> nets = new ArrayList<Net>();
	List<Multiple> multiples = new ArrayList<Multiple>();
	List<Money> moneys = new ArrayList<Money>();
	double px;
	double py;
	double rt;
	int fishNumber = 1 /*鱼的当前动作图编号*/, timer = 200;
	int ltrx = 0, moneyremove = 0, addMoney = 0;
	int sumMoney = 0, money_1 = 0, money_2 = 0, money_3 = 0, money_4 = 0, money_5 = 0, money_6 = 0;
	boolean rungame = true, space = false;

	public FishJpanel() {
		bgImg = new ImageIcon("images/bg/bg_in.png").getImage();
		bgBottomImg = new ImageIcon("images/bg/bg_bottom.jpg").getImage();
		cannonImg = new ImageIcon("images/cannon.png").getImage();
		buImg = new ImageIcon("images/bullet.png").getImage();
		netImg = new ImageIcon("images/net.png").getImage();
		for (int i = 0; i < muImg.length; i++) {
			String multi = "images/money/m" + (i + 1) * 2 + ".png";
			muImg[i] = new ImageIcon(multi).getImage();

		}

		moImg = new ImageIcon("images/money/money.png").getImage();
		TimeBarImg = new ImageIcon("images/TimeBar.png").getImage();

		
		Fish fish1 = new Fish(ltrx, 300, 0, 2);
		Fish fish2 = new Fish(ltrx, 100, 0, 3);
		Fish fish3 = new Fish((int) (Math.random() * 800), 0, 2, 3);
		Fish fish4 = new Fish((int) (Math.random() * 800), 0, 1, 9);
		Fish fish5 = new Fish((int) (Math.random() * 800), 0, 2, 8);
		Fish fish6 = new Fish((int) (Math.random() * 800), 0, 0, 7);
		Fish fish7 = new Fish((int) (Math.random() * 800), 0, 1, 6);
		Fish fish8 = new Fish((int) (Math.random() * 800), 0, 1, 5);
		Fish fish9 = new Fish((int) (Math.random() * 800), 0, 1, 4);
		Fish fish10 = new Fish((int) (Math.random() * 800), 0, 1, 2);
		fishs.add(fish1);
		fishs.add(fish2);
		fishs.add(fish3);
		fishs.add(fish4);
		fishs.add(fish5);
		fishs.add(fish6);
		fishs.add(fish7);
		fishs.add(fish8);
		fishs.add(fish9);
		fishs.add(fish10);

		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(bgImg, 0, 0, null); //绘制背景
		g.drawImage(bgBottomImg, 0, 385, null); //绘制底部
		g.drawImage(TimeBarImg, 540, 430, timer, 18, null); //绘制时间条

		if (rungame) {
			for (int i = 0; i < bullets.size(); i++) {
				bullets.get(i).drawBullet(g);
			}
			Graphics2D g2 = (Graphics2D) g;// 定义二维画笔
			if (py < 415 && px != 440) //鼠标位于1,2象限
			{
				rt = Math.atan((440.0 - px) / (415.0 - py));
				g2.rotate(-rt, 440, 415);// 转动画笔
				g2.drawImage(cannonImg, 420, 380, null);
				g2.rotate(rt, 440, 415);// 把画笔转回来
			} else if (px > 440 && py >= 415) // 鼠标位于第4象限
			{
				rt = Math.asin(1);
				g2.rotate(rt, 440, 415);
				g2.drawImage(cannonImg, 420, 380, null);
				g2.rotate(-rt, 440, 415);
			} else if (px < 440 && py >= 415) // 鼠标位于第3象限
			{
				rt = Math.asin(1);
				g2.rotate(-rt, 440, 415);
				g2.drawImage(cannonImg, 420, 380, null);
				g2.rotate(rt, 440, 415);
			} else {
				g2.drawImage(cannonImg, 420, 380, null);// 斜率为零的特殊情况
			}

			for (int i = 0; i < nets.size(); i++) {
				nets.get(i).drawnet(g);
			}

			for (int i = 0; i < fishs.size(); i++) {
				fishs.get(i).drawFish(g, fishNumber);

			}
			if (fishs.size() < 10) { // 自动生成鱼
				int direction = (int) (Math.random() * 3);
				if (direction == 0) {
					Fish fish = new Fish(0, (int) (Math.random() * 380), 0, (int) (Math.random() * 11 + 1));
					fishs.add(fish);
				}
				if (direction == 1) {
					Fish fish = new Fish(800, (int) (Math.random() * 380), 1, (int) (Math.random() * 11 + 1));
					fishs.add(fish);
				}
				if (direction == 2) {
					Fish fish = new Fish((int) (Math.random() * 800), 0, 2, (int) (Math.random() * 11 + 1));
					fishs.add(fish);
				}

			}

			for (int i = 0; i < multiples.size(); i++) { // 加金币
				multiples.get(i).drawMultiple(g);

			}

			g.setColor(Color.black);
			Font font = new Font("宋体", Font.BOLD, 22);
			g.setFont(font);
			g.drawString("" + money_1, 25, 450);
			g.drawString("" + money_2, 45, 450);
			g.drawString("" + money_3, 70, 450);
			g.drawString("" + money_4, 90, 450);
			g.drawString("" + money_5, 115, 450);
			g.drawString("" + money_6, 140, 450);

			for (int i = 0; i < moneys.size(); i++) {
				moneys.get(i).drawMoney(g);
			}

		}

		if (!rungame) {
			g.setColor(Color.red);
			Font font2 = new Font("楷体", Font.BOLD, 45);// 设置字体
			g.setFont(font2);
			g.drawString("游戏结束", 170, 150);
			g.drawString("得分：" + addMoney, 400, 150);
			g.drawString("空格键重新开始游戏", 170, 250);

		}
	}

	public void bulletRunThread() {
		new Thread() {
			public void run() {
				while (rungame) {
					for (int i = 0; i < bullets.size(); i++) { // 移动子弹
						int d = bullets.get(i).moveBullet();
						if (d == 1)
							bullets.remove(i);
							//break;
					}

					ltrx++;
					if (ltrx > 800)
						ltrx = -100;
					for (int i = 0; i < fishs.size(); i++) {
						fishs.get(i).moveFish();
						if (fishs.get(i).getX() < 0 || fishs.get(i).getX() > 800 || fishs.get(i).getY() < 0
								|| fishs.get(i).getY() > 400)
							fishs.remove(i);

					}

					for (int i = 0; i < bullets.size(); i++) { 
						Bullet bul = bullets.get(i);
						int bx = bul.getBx();
						int by = bul.getBy();
						for (int j = 0; j < fishs.size(); j++) {
							Fish fish = fishs.get(j);
							int fx = fish.getX();
							int fy = fish.getY();
							int moneyMultiple = fish.getKind() / 4;
							Net net = new Net(fx - 20, fy - 20, netImg);
							Multiple mul = new Multiple(50, 340, muImg[moneyMultiple]);
							if (bx >= fx - 20 && bx <= fx + 50) 
								if (by >= fy - 20 && by <= fy + 50) { // 炮弹打中鱼
									nets.add(net);
									for (int k = 0; k <= moneyMultiple; k++) {
										Money money = new Money(20, 300 + k * 10, moImg);
										moneys.add(money);
									}
									timer += 2;

									sumMoney += (moneyMultiple + 1) * 2;
									addMoney += (moneyMultiple + 1) * 2;
									multiples.add(mul);
									if (bullets.size() >= 1) {
										bullets.remove(i);
									}
									fishs.remove(j);
								}

						}
					}

					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					repaint();

				}
			}
		}.start();
	}

	public void fishRunThread() {
		new Thread() {
			public void run() {
				while (rungame) {
					for (int i = 0; i < moneys.size(); i++) { // 移动金币
						moneys.get(i).moveMoney();
					}
					
					while (sumMoney > 0) {
						sumMoney--;
						money_6 = money_6 + 1;
						if (money_6 > 9) {
							money_5++;
							if (money_5 > 9) {
								money_4++;
								if (money_4 > 9) {
									money_3++;
									if (money_3 > 9) {
										money_2++;
										if (money_2 > 9) {
											if (money_1 != 9) {
												money_1++;
											}
											money_2 = money_2 - 10;
										}
										money_3 = money_3 - 10;
									}
									money_4 = money_4 - 10;
								}
								money_5 = money_5 - 10;
							}
							money_6 = money_6 - 10;
						}
					}

					for (int i = 0; i < moneys.size(); i++) {
						if (moneys.get(i).getY() > 380){
							moneys.remove(i);
							break;
						}
					}

					try {
						fishNumber++;
						if (fishNumber >= 9)
							fishNumber = 1;
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();   //重绘

				}
			}
		}.start();
	}

	public void coutTime() {
		new Thread() {
			public void run() {
				while (rungame) {
					timer -= 5;
					if (timer <= 0) {
						fishs.clear();
						bullets.clear();
						nets.clear();
						multiples.clear();
						moneys.clear();
						rungame = false;
						space = true;
						timer = 0;
					}
					for (int i = 0; i < nets.size(); i++) {
						nets.remove(i);
					}

					for (int i = 0; i < multiples.size(); i++) {
						multiples.remove(i);
					}

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();

				}
			}
		}.start();
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		px = e.getX();
		py = e.getY();
		repaint();

	}

	public void mouseClicked(MouseEvent e) { //鼠标点击，添加炮弹
		// TODO Auto-generated method stub
		if (py < 415) // 子弹的转动角度
		{
			rt = Math.atan((440 - px) / (415 - py));
		} else if (py >= 415 && px > 440) {
			rt = Math.asin(1);
		} else if (py >= 415 && px < 440) {
			rt = -Math.asin(1);
		} else {
			rt = Math.asin(0);
		}
		Bullet bu = new Bullet(440, 415, px, py, rt, buImg);
		bullets.add(bu);
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {  
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SPACE && space) { //点击空格重新开始
			rungame = true;
			sumMoney = 0;
			addMoney = 0;
			money_1 = 0;
			money_2 = 0;
			money_3 = 0;
			money_4 = 0;
			money_5 = 0;
			money_6 = 0;

			Fish fish1 = new Fish(ltrx, 300, 0, 2);
			Fish fish2 = new Fish(ltrx, 100, 0, 3);
			Fish fish3 = new Fish((int) (Math.random() * 800), 0, 2, 3);
			Fish fish4 = new Fish((int) (Math.random() * 800), 0, 1, 9);
			Fish fish5 = new Fish((int) (Math.random() * 800), 0, 2, 8);
			Fish fish6 = new Fish((int) (Math.random() * 800), 0, 0, 7);
			Fish fish7 = new Fish((int) (Math.random() * 800), 0, 1, 6);
			Fish fish8 = new Fish((int) (Math.random() * 800), 0, 1, 5);
			Fish fish9 = new Fish((int) (Math.random() * 800), 0, 1, 4);
			Fish fish10 = new Fish((int) (Math.random() * 800), 0, 1, 2);
			fishs.add(fish1);
			fishs.add(fish2);
			fishs.add(fish3);
			fishs.add(fish4);
			fishs.add(fish5);
			fishs.add(fish6);
			fishs.add(fish7);
			fishs.add(fish8);
			fishs.add(fish9);
			fishs.add(fish10);
			
			this.bulletRunThread();
			this.fishRunThread();
			this.coutTime();

			timer = 222;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
