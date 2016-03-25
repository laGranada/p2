package loesungen;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

/**
 * 
 * @author Stephanie Böhning
 * @version v1.0
 * 
 * modified: 21.03.2016
 */
public class EditMessage extends JFrame{


	private static final long serialVersionUID = 1L;
	
	public EditMessage(String title) {
		super (title);

		//create components
		//the text of this text area should be saved and loaded
		JTextArea text = new JTextArea();
		//buttons to save and load the text
		JButton saveBtn = new JButton("Save");
		JButton loadBtn = new JButton("Load");
		//this check boxes are for setting the font italic and/or bold
		JCheckBox italicBox = new JCheckBox("italic");
		JCheckBox boldBox = new JCheckBox("bold");
		JLabel fontTypeLabel = new JLabel("Font Type:");
		JLabel fontSizeLabel = new JLabel("Font Size:");
		//this spinner is for changing the text size
		JSpinner sizeSpinner = new JSpinner();

		JPanel panel = new JPanel();
		JPanel fontPanel = new JPanel();
		JPanel btnPanel = new JPanel();

		//create layout of frame
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add (text);
		panel.add(Box.createVerticalStrut(20));
		panel.add(fontPanel);
		panel.add(Box.createVerticalStrut(20));
		panel.add(btnPanel);
		panel.add(Box.createVerticalStrut(10));
		
		//set size of the text area
		text.setRows(10);
		text.setColumns(20);
		
		//create layout of fontpanel
		sizeSpinner.setValue(12);
		fontPanel.setLayout(new BoxLayout(fontPanel, BoxLayout.X_AXIS));
		fontPanel.add(Box.createHorizontalStrut(5));
		fontPanel.add(fontSizeLabel);
		fontPanel.add(Box.createHorizontalStrut(5));
		fontPanel.add(sizeSpinner);
		fontPanel.add(Box.createHorizontalStrut(20));
		fontPanel.add(fontTypeLabel);
		fontPanel.add(Box.createHorizontalStrut(5));
		fontPanel.add(boldBox);
		fontPanel.add(italicBox);
		fontPanel.add(Box.createHorizontalStrut(5));
		sizeSpinner.setMinimumSize(new Dimension(sizeSpinner.getPreferredSize().width * 2, sizeSpinner.getPreferredSize().height));
		sizeSpinner.setMaximumSize(sizeSpinner.getMinimumSize());
		
		//create layout of button panel
		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
		btnPanel.add(loadBtn);
		btnPanel.add(saveBtn);
		
	
		//add listener here

		
		
	}
	
	
	
	public static void main(String[] args) {
		EditMessage msg = new EditMessage("Edit Message");
		msg.pack();
		msg.setVisible(true);
		msg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
