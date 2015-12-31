package fish;

import javax.swing.JFrame;

public class FishJframe extends JFrame{	
	public FishJframe(){
		this.setTitle("FishingMaster");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(100, 100, 800,480);
		
		FishJpanel fjp=new FishJpanel(); 
		
		this.addMouseListener(fjp); //添加鼠标监听
		this.addKeyListener(fjp); //添加键盘监听
		
		fjp.bulletRunThread(); //开启炮弹线程
		fjp.fishRunThread();   //
		fjp.coutTime();   //游戏计时器
		this.add(fjp);   //将面板加到窗口里
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new FishJframe();
	}
}
