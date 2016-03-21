package loesungen;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Stephanie Böhning
 * @version v1.0
 * 
 * modified: 21.03.2016
 */
public class Ratespiel extends JFrame{


	private static final long serialVersionUID = 1L;
	
	//This variables are used in the listener
	//this label gives information about the guessed number 
	private JLabel ergLabel = new JLabel("Gib eine Zahl ein:");	
	//this field is to type the guessed number
	private JTextField numberField = new JTextField(3);
	//the right number
	private int number = 0;
	//the guessed number from the user
	private int tipp = 0;
	
	public Ratespiel() {
		JPanel northPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JButton stimmtBtn = new JButton("stimmts?");
		JButton neueZahlBtn = new JButton("neue Zahl");

		
		//init number
		Random rand = new Random();
		number = rand.nextInt(100);

		
		//set layouts
		setLayout(new GridLayout(3, 1));
		add (northPanel);
		add (centerPanel);
		add (southPanel);

		//north panel
		northPanel.setLayout(new FlowLayout());
		northPanel.add (ergLabel);

		//center panel
		centerPanel.setLayout(new FlowLayout());
		centerPanel.add (numberField);
		centerPanel.add (stimmtBtn);
		
		//south panel
		southPanel.setLayout(new FlowLayout());
		southPanel.add(neueZahlBtn);
		
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//if the user click the button stimmts the erglabel should give an information about the guessed number
		stimmtBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tmp = numberField.getText();

				tipp = Integer.valueOf(tmp);
				if (tipp > number){
					ergLabel.setText("" + tipp + " is too big");
				}
				else if (tipp < number) {
					ergLabel.setText("" + tipp + " is too small");
				}
				else {
					ergLabel.setText("" + tipp + " is right");
				}
						
			}
		});
		
		//if the user click the button neueZahl a new number is created
		neueZahlBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Random rand = new Random();
				number = rand.nextInt(100);
				ergLabel.setText("Gib eine Zahl ein:");
				numberField.setText("");
			}
		});
	}
	
	
	public static void main(String[] args) {
		new Ratespiel();

	}

}
