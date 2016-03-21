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
public class ButtonClickVariante2 extends JFrame{


	private static final long serialVersionUID = 1L;
	
	/**
	 * This contructor creates a frame with a button
	 */
	public ButtonClickVariante2() {
		JButton button = new JButton("klick mich");

		//you could use the interface ActionListener as an anonymous class
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				button.setText("ich wurde geklickt");
			}
		});
		
		add (button);
		
		
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new ButtonClickVariante2();


	}
}
