package loesungen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Aufgabe1 extends JFrame{

	//create components
	private JButton okBtn = new JButton("Ok");
	private JButton cnzlBtn = new JButton ("Canzel");
	private JLabel label = new JLabel ("Bitte Text eingeben:");
	private JTextField textField = new JTextField (20);
	private JPanel northPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	
	
	public Aufgabe1(String title) {
		super (title);
		
		//set Layout
		setLayout(new BorderLayout());
		add(southPanel, BorderLayout.SOUTH);
		add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new FlowLayout());
		southPanel.setLayout(new FlowLayout());
		
		//set components in north panel
		northPanel.add(label, FlowLayout.LEFT);
		northPanel.add(textField);

		//add button to south panel
		southPanel.add (okBtn);
		southPanel.add(cnzlBtn);
		
	}
	
	public static void main(String[] args) {

		JFrame frame = new Aufgabe1("Fenster mit Textfeld");
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 100);
	}

}
