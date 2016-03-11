package loesungen;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Aufgabe4 extends JFrame {

	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private String [] digits = {"7", "8", "9", "/", 
								"4", "5", "6", "*", 
								"1", "2", "3", "-", 
								"0", ".", "=", "+"};

	public Aufgabe4(String title) {
		super (title);
		
		for (int i = 0; i < 16; i++)
		{
			buttons.add(new JButton(digits[i]));
		}
		
		setLayout(new GridLayout(4, 4));
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				add (buttons.get(4*i + j));
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new Aufgabe4("Caluclator");
		
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
