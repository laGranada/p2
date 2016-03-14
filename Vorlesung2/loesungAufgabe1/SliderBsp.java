package loesungAufgabe1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class SliderBsp extends JFrame {

	private JLabel redLabel = new JLabel("red");
	private JLabel greenLabel = new JLabel("green");
	private JLabel blueLabel = new JLabel ("blue");
	
	private JTextField redTextField = new JTextField(3);
	private JTextField greenTextField = new JTextField(3);
	private JTextField blueTextField = new JTextField(3);
	
	private JSlider redSlider = new JSlider();
	private JSlider greenSlider = new JSlider();
	private JSlider blueSlider = new JSlider();
	
	private JPanel northPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	
	public SliderBsp() {
		northPanel.add(redLabel, BorderLayout.WEST);
		northPanel.add(redSlider, BorderLayout.CENTER);
		northPanel.add(redTextField, BorderLayout.EAST);
		
		centerPanel.add(greenLabel, BorderLayout.WEST);
		centerPanel.add(greenSlider, BorderLayout.CENTER);
		centerPanel.add(greenTextField, BorderLayout.EAST);
		
		southPanel.add(blueLabel, BorderLayout.WEST);
		southPanel.add(blueSlider, BorderLayout.CENTER);
		southPanel.add(blueTextField, BorderLayout.EAST);
		
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
//		pack();
	}
	
	
	
	public static void main(String[] args) {
		SliderBsp slider = new SliderBsp();
		
	}

}
