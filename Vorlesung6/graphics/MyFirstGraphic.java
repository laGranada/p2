package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyFirstGraphic extends JFrame{

	Rectangle rec;
	Color color;
	int red = 0;
	
	public MyFirstGraphic() {
		rec = new Rectangle(0, 100, 50, 50);
		MyPanel panel = new MyPanel();
		Timer timer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (red != 255) {
					red++;
					color = new Color(red, 0, 0);
				}
				panel.repaint();
			}
		});
		
		add(panel);
		timer.start();
		panel.repaint();
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class MyPanel extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(color);
			g.fillRect(rec.x, rec.y, rec.width, rec.height);

			g.setColor(Color.magenta);
			g.drawRect(rec.x, rec.y, rec.width, rec.height);
		}
		
	}
	
	public static void main(String[] args) {
		new MyFirstGraphic();
	}
}
