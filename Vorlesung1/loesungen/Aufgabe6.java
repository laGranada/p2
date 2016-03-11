package loesungen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Aufgabe6 extends JFrame {

	//create all components
	private JPanel panel = new JPanel();
	private JButton okBtn = new JButton("Ok");
	private JButton cnzlBtn = new JButton("Canzel");
	private JPanel btnPanel = new JPanel();

	
	public Aufgabe6(String title) {
		super (title);
			
		//set layout
		add (panel, BorderLayout.CENTER);

		panel.setBackground(Color.YELLOW);
		
		//organize button panel
		btnPanel.setLayout(new FlowLayout());
		btnPanel.add (okBtn);
		btnPanel.add (cnzlBtn);
		add(btnPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		JFrame frame = new Aufgabe6("BorderLayout");
		frame.setVisible(true);
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
