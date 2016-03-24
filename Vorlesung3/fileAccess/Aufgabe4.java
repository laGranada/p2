package fileAccess;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class creates a dialog which in which the user should enter personal data. That data are saved in a file.
 * 
 * @author Stephanie Böhning
 * @version 1.0
 * 
 * modified: 18.03.2016
 * 
 */
public class Aufgabe4 extends JDialog{

	public Aufgabe4() {
		
		//create components
		JLabel lastname = new JLabel("Nachname:");
		JLabel givenname = new JLabel("Vorname:");
		JTextField lastnameField = new JTextField(10);
		JTextField givennameField = new JTextField(10);
		JButton save = new JButton("Save");
		JPanel north = new JPanel();
		setTitle("A Simple Form");
		
		//set layout
		north.setLayout(new GridLayout(3, 2));
		add (north, BorderLayout.NORTH);

		//add components
		north.add (lastname);
		north.add (lastnameField);
		north.add (givenname);
		north.add (givennameField);
		add (save, BorderLayout.EAST);
		
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		pack();
		setVisible(true);

		//if the save button is pressed the data will be saved in a file
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = new File ("Aufgabe4Data.txt");
				FileWriter out;
				try {
					out = new FileWriter(file);
					PrintWriter pw = new PrintWriter(out);

					pw.println(lastname.getText() + " " + lastnameField.getText());
					pw.println(givenname.getText() + " " + givennameField.getText());
					
					pw.close();
					out.close();
					
				
				} catch (IOException e1) {
					e1.printStackTrace();
					//tell the user that there is an error 
					JOptionPane.showMessageDialog(null, "An error occured while writing to a file.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Aufgabe4();
		
	}

}
