package vorbereitung;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFirstPaint extends JPanel{

	
	private Rectangle rec = new Rectangle(25, 25, 200, 300);

	public MyFirstPaint() {
		JFrame f = new JFrame("");
		
		f.add(this);
		f.setSize(400, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);		
	}
	
	protected void paintComponent(java.awt.Graphics g) {
		g.setColor(Color.black);
		g.fillRect(rec.x, rec.y, rec.width, rec.height);
	};

	
	public static void main(String[] args) {
		new MyFirstPaint();

	}

}
