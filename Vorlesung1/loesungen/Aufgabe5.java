package loesungen;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Aufgabe5 extends JFrame {

	//create all components
	private JLabel rotLabel = new JLabel("rot");
	private JLabel gruenLabel = new JLabel("grün");
	private JLabel blauLabel = new JLabel("blau");
	
	private JSlider rotSlider = new JSlider();
	private JSlider gruenSlider = new JSlider();
	private JSlider blauSlider = new JSlider();
	
	private JTextField rotText = new JTextField(3);
	private JTextField gruenText = new JTextField(3);
	private JTextField blauText = new JTextField(3);
	
	private JPanel rotPanel = new JPanel();
	private JPanel gruenPanel = new JPanel();
	private JPanel blauPanel = new JPanel();
	
	
	public Aufgabe5(String title) {
		
		//set layout
		setLayout(new GridLayout(3, 1));
		
		//add panels to frame
		add(rotPanel);
		add(gruenPanel);
		add(blauPanel);
		
		//organize components for first panel
		rotPanel.setLayout(new FlowLayout());
		rotPanel.add(rotLabel);
		rotPanel.add(rotSlider);
		rotPanel.add(rotText);

		//organize components for second panel
		gruenPanel.setLayout(new FlowLayout());
		gruenPanel.add(gruenLabel);
		gruenPanel.add(gruenSlider);
		gruenPanel.add(gruenText);
		
		//organize components for last panel
		blauPanel.setLayout(new FlowLayout());
		blauPanel.add(blauLabel);
		blauPanel.add(blauSlider);
		blauPanel.add(blauText);

	}
	
	
	public static void main(String[] args) {
		JFrame frame = new Aufgabe5 ("SliderDemo");
		
		frame.setSize(300, 120);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
