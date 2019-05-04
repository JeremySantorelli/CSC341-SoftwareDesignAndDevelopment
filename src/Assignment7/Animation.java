package Assignment7;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Animation {

	public static void main(String[] args) {
		RainSimu sim = new RainSimu();
		sim.init();
		sim.runAnimation();
	}
}

interface IAnimation{
	void init();
	void runAnimation();
	void display();
}

class RainSimu implements IAnimation{
	Raindrop[] drops;	
	RainSimFrame fr;
	RainTask task;
	Thread animator;
	
	@Override
	public void init() {
		drops = new Raindrop[10];
		task = new RainTask();
		animator = new Thread(task);
		fr = new RainSimFrame(drops, animator);
		
		for(int i = 0; i < drops.length; i++){
			drops[i] = new Raindrop();
			System.out.println((int) (Math.random()*fr.getWidth()) + (int) (Math.random()*fr.getHeight()) );
			drops[i].setPosition( (int) Math.random()*fr.getWidth(), (int) Math.random()*fr.getHeight());
		}
	}
	
	@Override
	public void runAnimation() {
		animator.start();
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub		
	}	
	
	class RainTask implements Runnable{
		@Override
		public void run() {
			while(true){
				for(int i = 0; i < drops.length; i++){
					Raindrop drop = drops[i];
					drop.ripple();
					if( !drop.isVisible()){
						drop.setPosition( (int) (Math.random()*fr.getWidth()), (int) (Math.random()*fr.getHeight()));
					}
				}
				try{
					Thread.sleep(30);
				}catch(InterruptedException e){
					System.out.println(e.getMessage());
				}
				fr.repaint();
			}			
		}		
	}
}

class RainSimFrame extends JFrame{
	Raindrop[] drops;
	RainPanel pnl;
	Thread animator;
	
	public RainSimFrame(Raindrop[] drops, Thread anim){
		animator = anim;
		this.drops = drops;		
		this.setSize(600, 600);
		this.setLocation(300, 100);
		pnl = new RainPanel();
		this.add(pnl);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				animator.stop();
				e.getWindow().dispose();
				System.exit(0);
			}
		});
		this.setVisible(true);
	}
	
	public void repaint(){
		super.repaint();
		pnl.repaint();
	}
	
	class RainPanel extends JPanel{
		public RainPanel(){
			this.setBackground(Color.white);
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			for(int i = 0; i < drops.length; i++){
				drops[i].draw(g);
			}
		}
	}
}
