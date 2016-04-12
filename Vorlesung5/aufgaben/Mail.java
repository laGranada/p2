package aufgaben;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This frame class creates a mail window. 
 * 
 * @author Stephi
 * @version 1.0
 * 
 * 12.04.2016
 */
public class Mail extends JFrame{

	/**
	 * This constrctor creates a mail frame. You can set a receiver, a subject and type a text.
	 */
	public Mail() {
		//create components
		JLabel receiverLabel = new JLabel("Empfänger:");
		JLabel subjectLabel = new JLabel("Subject:");
		JTextField receiver = new JTextField(30);
		JTextField subject = new JTextField(30);
		JTextArea text = new JTextArea();
		JPanel receiverPanel = new JPanel();
		JPanel subjectPanel = new JPanel();
		JPanel textPanel = new JPanel();
		JPanel sendPanel = new JPanel();
		JButton sendBtn = new JButton("Send");
		
		//give the label the same size
		receiverLabel.setPreferredSize(new Dimension(80, receiverLabel.getHeight()));
		subjectLabel.setPreferredSize(new Dimension(80, subjectLabel.getHeight()));
		text.setPreferredSize(new Dimension(200, 200));
		
		setTitle("Send Mail");
		
		//set layouts
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(receiverPanel);
		receiverPanel.setLayout(new BoxLayout(receiverPanel, BoxLayout.X_AXIS));
		add(subjectPanel);
		subjectPanel.setLayout(new BoxLayout(subjectPanel, BoxLayout.X_AXIS));
		add(textPanel);
		textPanel.setLayout(new BorderLayout());
		add(sendPanel);
//		sendPanel.setLayout(new FlowLayout()); //now BorderLayout is used

		//arrange receiver and subject text field
		receiverPanel.add(receiverLabel);
		receiverPanel.add(receiver);
		subjectPanel.add(subjectLabel);
		subjectPanel.add(subject);

		//arrange text area and send button
		textPanel.add(text, BorderLayout.CENTER);
		sendPanel.add(sendBtn);

		//set Window settings
		setVisible(true);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	/**
	 * Starts the Mail application
	 * @param args is not used here
	 */
	public static void main(String[] args) {
		new Mail();
	}
}
