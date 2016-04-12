package aufgaben;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * This class shows a color window
 * 
 * @author Stephi
 * @version 1.0
 * 
 * last modified: 12.04.2014
 *
 */
public class ColorChanger extends JFrame{

	/**
	 * This constructor creates a color window in which you can change the color between green and blue.
	 */
	public ColorChanger() {
		//create components
		JRadioButton green = new JRadioButton("grün");
		JRadioButton blue = new JRadioButton("blau");
		ButtonGroup group = new ButtonGroup();
		JPanel colorPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		//arrange components
		add (colorPanel, BorderLayout.CENTER);
		add (buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(green);
		buttonPanel.add(blue);

		//add radio buttons to a group so just one can be selected
		group.add(green);
		group.add(blue);
		
		//this listener reacts is the blue radio button is selected or not anymore. 
		//If the blue radio button is set to selected, the panel gets the color blue else black
		blue.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println("in actionPerformed");
					if (blue.isSelected())
					colorPanel.setBackground(Color.blue);
				else 
					colorPanel.setBackground(Color.black);
			}
		});	
		
		
		//set window settings
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 200);
	}
	
	public static void main(String[] args) {
		new ColorChanger();
	}

}
