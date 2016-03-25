package liveProgramming;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Stephanie Böhning
 * @version v1.1
 * 
 *          modified: 23.03.2016
 */
public class EditMessage extends JFrame {

	private static final long serialVersionUID = 1L;
	// this check boxes are for setting the font italic and/or bold
	private JCheckBox italicBox = new JCheckBox("italic");
	private JCheckBox boldBox = new JCheckBox("bold");
	// the text of this text area should be saved and loaded
	private JTextArea field = new JTextArea();

	public EditMessage(String title) {
		super(title);

		// create components
		// buttons to save and load the text
		JButton saveBtn = new JButton("Save");
		JButton loadBtn = new JButton("Load");
		JLabel fontTypeLabel = new JLabel("Font Type:");
		JLabel fontSizeLabel = new JLabel("Font Size:");
		// this spinner is for changing the text size
		JSpinner sizeSpinner = new JSpinner();

		JPanel panel = new JPanel();
		JPanel fontPanel = new JPanel();
		JPanel btnPanel = new JPanel();

		// create layout of frame
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(field);
		panel.add(Box.createVerticalStrut(20));
		panel.add(fontPanel);
		panel.add(Box.createVerticalStrut(20));
		panel.add(btnPanel);
		panel.add(Box.createVerticalStrut(10));

		// set size of the text area
		field.setRows(10);
		field.setColumns(20);

		// create layout of fontpanel
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

		// create layout of button panel
		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
		btnPanel.add(loadBtn);
		btnPanel.add(saveBtn);

		
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		// here comes the listener

		// the size spinner should resize the font size of the text
		sizeSpinner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				float size = Float.valueOf(sizeSpinner.getValue().toString());
				// String sizeStr = sizeSpinner.getValue().toString();
				// //Variante 2 um casting probleme zu umgehen
				// float size = Float.parseFloat(sizeStr);

				Font oldFont = field.getFont();
				field.setFont(oldFont.deriveFont(size));

			}
		});

		// the italic and bold checkbox should change the font style of the text
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

		
		// saveBtn.addActionListener (listener -> save ());	// this is another way to connect an listener to a component
		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		
		loadBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});
	
	}

	
	private void open () {
		File file = null;
		// JFileChooser erstellen und Date auswählen
		JFileChooser save = new JFileChooser("C:\\Data\\Eclipse Workspace\\");
		int state = save.showOpenDialog(null);

		// wenn die eingabe gültig ist
		if (state == save.APPROVE_OPTION) {

			// öffne bzw erstelle die gewählte Datei
			file = save.getSelectedFile();

			try {
				//Schreibe den Text aus field in die Datei
				FileReader reader = new FileReader(file);
				BufferedReader bufRead = new BufferedReader(reader);
				String line = bufRead.readLine();
				field.setText("");
				
				while (line != null) {
					field.setText(field.getText() + line);
					line = bufRead.readLine();
				}

				bufRead.close();
				reader.close();

			} catch (IOException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is an error occured while reading the file. You lost all data", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	
	/**
	 * This method saves the text of the text area in to a file which a user can choose.
	 */
	private void save() {

		File file = null;
		// JFileChooser erstellen und Date auswählen
		JFileChooser save = new JFileChooser();
		int state = save.showSaveDialog(null);

		// wenn die eingabe gültig ist
		if (state == save.APPROVE_OPTION) {

			// öffne bzw erstelle die gewählte Datei
			file = save.getSelectedFile();

			try {
				//Schreibe den Text aus field in die Datei
				FileWriter writer = new FileWriter(file, true);
				BufferedWriter bufWrite = new BufferedWriter(writer);

				bufWrite.write(field.getText());
				bufWrite.newLine();

				bufWrite.close();
				writer.close();

			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "There is an error occured while writing the file. No data are written!", "Error", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
		}
	}

	/**
	 * This method changes the font style of the text depending on the italic and bold check box
	 */
	private void changeFontStyle() {
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
		new EditMessage("Edit Message");
	}
}
