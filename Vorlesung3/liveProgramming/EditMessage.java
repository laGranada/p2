package liveProgramming;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Stephanie Böhning
 * @version v1.0
 * 
 * modified: 21.03.2016
 */
public class EditMessage extends JFrame{


	private static final long serialVersionUID = 1L;
	//this check boxes are for setting the font italic and/or bold
	private JCheckBox italicBox = new JCheckBox("italic");
	private JCheckBox boldBox = new JCheckBox("bold");
	//the text of this text area should be saved and loaded
	private JTextArea field = new JTextArea();

	public EditMessage(String title) {
		super (title);

		//create components
		//buttons to save and load the text
		JButton saveBtn = new JButton("Save");
		JButton loadBtn = new JButton("Load");
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
		panel.add (field);
		panel.add(Box.createVerticalStrut(20));
		panel.add(fontPanel);
		panel.add(Box.createVerticalStrut(20));
		panel.add(btnPanel);
		panel.add(Box.createVerticalStrut(10));
		
		//set size of the text area
		field.setRows(10);
		field.setColumns(20);
		
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
		sizeSpinner.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				float size = (Float)sizeSpinner.getValue();
//				String sizeStr = sizeSpinner.getValue().toString();
//				float sizeFl = Float.parseFloat(sizeStr);
				Font oldFont = field.getFont();
				field.setFont(oldFont.deriveFont(size));
				
			}
		});
		
		italicBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeFontStyle();
			}
		});
		boldBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeFontStyle();
				
			}
		});
		
//		saveBtn.addActionListener (listener -> );
		saveBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = null;
				//JFileChooser erstellen
				//Date auswählen
				JFileChooser save = new JFileChooser();
				int state = save.showSaveDialog(null);
				if (state == save.APPROVE_OPTION) {
					 file = save.getSelectedFile();

					 try {
							FileWriter fw = new FileWriter(file, true);
							BufferedWriter bufwr = new BufferedWriter(fw);
							
							bufwr.write(field.getText());
							bufwr.newLine();
							
							
							bufwr.close();
							fw.close();
							
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}
		});
	}
	
	private void changeFontStyle () {
		int font = 0;
		if (italicBox.isSelected()) {
			font += Font.ITALIC;
		}
		if (boldBox.isSelected()) {
			font += Font.BOLD;
		}
		Font oldFont = field.getFont();
		field.setFont(oldFont.deriveFont(font));
	}
	
	public static void main(String[] args) {
		EditMessage msg = new EditMessage("Edit Message");
		msg.pack();
		msg.setVisible(true);
		msg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
