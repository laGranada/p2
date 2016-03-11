package loesungen;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Aufgabe2 extends JFrame{

	//create components
	private JButton northBtn = new JButton ("North");
	private JButton southBtn = new JButton ("South");
	private JButton westBtn = new JButton ("West");
	private JButton eastBtn = new JButton ("East");
	private JButton centerBtn = new JButton ("Center");
	
	
	
	public Aufgabe2(String text) {
		super (text);

		//setlayout
		setLayout (new BorderLayout());

		//add components
		add (northBtn, BorderLayout.NORTH);
		add (southBtn, BorderLayout.SOUTH);
		add (westBtn, BorderLayout.WEST);
		add (eastBtn, BorderLayout.EAST);
		add (centerBtn, BorderLayout.CENTER);
		
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new Aufgabe2("BorderLayout");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 600);
		frame.setVisible(true);

	}

}
