package fish;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JPanel;

public class Bullet {
	int bx=420,by=380;
	double px,py,rt;
	Image buImg;
	
	
	public Bullet(int bx, int by, double px, double py, double rt, Image buImg) {
		super();
		this.bx = bx;
		this.by = by;
		this.px = px;
		this.py = py;
		this.rt = rt;
		this.buImg = buImg;
	}
	
	public Bullet()
    {
    	if(px<440)
    	{    	
    		bx=435;
    		by=420;
    	}
    	else
    	{
    		bx=445;
    		by=420;
    	}
    }
  
    public int moveBullet()
    {
    	int flag = 0;
    	if(py<415&&px!=440) //斜率不存在的情况
    	{
    		bx-=10*Math.sin(rt);
        	by-=10*Math.cos(rt);
    	}
    	else if(px<440&&py>=415) 
    	{
    		if(bx<=0)flag=1;
    	}
    	else if(px>440&&py>=415)
    	{
    		if(bx>=800)flag=1;
    	}
    	else
    	{
    		by-=10;
    	}
    	if(bx<=0||bx>=800||by<=0||by>=480)flag=1;
    	return flag;
    	
    }
    
    public void drawBullet(Graphics g)
    {
    	Graphics2D g2=(Graphics2D)g.create();
    	if(py<415&&px!=440)
    	{
    		g2.rotate(-rt,bx,by);
    	}
    	else if(py>=415&&px<440)
    	{
    		g2.rotate(-Math.asin(1), bx, by);
    	}
    	else if(py>=415&&px>440)
    	{
    		g2.rotate(Math.asin(1), bx, by);
    	}
    	g2.drawImage(buImg, bx,by, null);
    }
    
    
    
	public int getBx() {
		return bx;
	}
	public void setBx(int bx) {
		this.bx = bx;
	}
	public int getBy() {
		return by;
	}
	public void setBy(int by) {
		this.by = by;
	}
	public double getPx() {
		return px;
	}
	public void setPx(double px) {
		this.px = px;
	}
	public double getPy() {
		return py;
	}
	public void setPy(double py) {
		this.py = py;
	}
    
    

}
