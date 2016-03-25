package loesungen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 * 
 * @author Stephanie Böhning
 * @version v1.0
 * 
 * modified: 21.03.2016
 */
public class ButtonClick extends JFrame{


	private static final long serialVersionUID = 1L;
	private JButton button = new JButton("klick mich");		// This button needs to be created here it is used in the intern class MouseClickListener

	//The internal class ButtonIsClicked implements the method of the Interface ActionListener
	private class ButtonIsClicked implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			button.setText("ich wurde geklickt");
		}
	}
	
	/**
	 * This contructor creates a frame with a button
	 */
	public ButtonClick() {
		//the method addActionListener gets an object from your class ButtonIsClicked
		button.addActionListener(new ButtonIsClicked());
		add (button);
		
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		new ButtonClick();


	}

}
