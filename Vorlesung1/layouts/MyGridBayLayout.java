package layouts;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyGridBayLayout extends JFrame{

	private JButton [] buttons = new JButton[4];
	private JPanel gridPanel = new JPanel();
	
	public MyGridBayLayout() {

		
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("" + i);
			
		}
		
		setLayout(new GridBagLayout());
		
		
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.anchor = GridBagConstraints.LINE_START;
		gc.weightx = 0.5;
		gc.weighty = 0.5;
		
		gc.gridx = 0;
		gc.gridy = 0;

		add (buttons[0], gc);

		
		gc.gridx = 1;
		gc.gridy = 1;

		add (buttons[1], gc);

		gc.gridx = 1;
		gc.gridy = 0;

		add (buttons[2], gc);

		
		gc.gridx = 0;
		gc.gridy = 1;

		add (buttons[3], gc);
		
		
		
	}
		
		
		
	
	
	
	
	public static void main(String[] args) {

		JFrame frame = new MyGridBayLayout();
		frame.setVisible(true);
		frame.setSize(200, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
