package listener;


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

public class Vorbereitung extends JFrame {

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
	
	public Vorbereitung(String title) {
		
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

		//add listenener for textfield
		textField.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				textField.setText("focuslost");				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textField.setText("focusGained");				
				
			}
		});

		//add listener for ok button
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Text:\t" + textField.getText());
				System.out.println("Seele verkauft:\t" + checkbox.isSelected());
				
				if (boldRadio.isSelected()) {
					System.out.println(boldRadio.getText() + " is selected");
				}
				else if (plainRadio.isSelected()) {
					System.out.println(plainRadio.getText() + " is selected");					
				}
				else if (italicRadio.isSelected()) {
					System.out.println(italicRadio.getText() + " is selected");					
				}				
				closeFrame();
			}
		});

		//add listener for canzel button
		cnzlBtn.addActionListener(l -> textField.setText("enter text here"));

// add listener to textfield
//		addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				System.out.println("mouse released");
//				textField.setText("MouseReleased");
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				
//				textField.setText("MousePressed");
//	
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent e) {
//				
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent e) {
//
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//			}
//		});
//		
	}
	
	//this methode close the frame
	void closeFrame ()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dispose();
	}
	
	public static void main(String[] args) {
		JFrame frame = new Vorbereitung("Frame with many components");
		
		frame.setVisible (true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
	}

}
