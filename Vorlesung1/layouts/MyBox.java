package layouts;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyBox extends JFrame{

//  Variante 1
//	private Box box = Box.createVerticalBox();		//die Elemente untereinander anordnen
//	private Box box = Box.createHorizontalBox();	//die Elemente nebeneinander anordnen
	
	private JButton [] buttons = new JButton [4];

//Variante 2
	private JPanel panel = new JPanel();
	
	public MyBox() {
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("" + i);
//			Variante 1
//			box.add(buttons[i]);

//			Variante 2
//			panel.add(buttons[i]);
		}
	
//		Variante 2
//		add (panel);
		
//Variante 1
//		add (box);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		JFrame frame = new MyBox();
		frame.setSize(200, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
