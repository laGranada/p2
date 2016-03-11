package loesungen;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class Aufgabe3 extends JFrame {

	//create all components
	private JTextField textField = new JTextField ("enter text here");
	private JCheckBox checkbox = new JCheckBox ("ich stimme zu...");
	private JRadioButton italicRadio = new JRadioButton ("italic");
	private JRadioButton plainRadio = new JRadioButton ("plain");
	private JRadioButton boldRadio = new JRadioButton ("bold");
	private ButtonGroup radioGroup = new ButtonGroup ();
	private JButton okBtn = new JButton ("Ok");
	private JButton cnzlBtn = new JButton ("Canzel");
	private JPanel line1 = new JPanel();
	private JPanel line2 = new JPanel();
	private JPanel line3 = new JPanel();
	
	public Aufgabe3(String title) {
		
		//set layout
		setLayout(new GridLayout(3, 1));

		//add panels to frame
		add (line1);
		add (line2);
		add (line3);
		
		//add components to north panel
		line1.setLayout(new FlowLayout());
		line1.add (textField);
		line1.add(checkbox);

		//add radio button to a group, just one can be selected
		radioGroup.add(plainRadio);
		radioGroup.add(boldRadio);
		radioGroup.add(italicRadio);
		
		//add radio button to central panel
		line2.add(plainRadio);
		line2.add(boldRadio);
		line2.add(italicRadio);
		
		//add button to south panel
		line3.add(okBtn);
		line3.add(cnzlBtn);
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new Aufgabe3("Frame with many components");
		
		frame.setVisible (true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
	}

}
