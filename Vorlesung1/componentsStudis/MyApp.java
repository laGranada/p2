package componentsStudis;

import javax.swing.JFrame;

public class MyApp {

	public static void main(String[] args){
		JFrame frame = new MyFrame("Test");
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
