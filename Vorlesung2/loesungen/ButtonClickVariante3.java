package loesungen;


import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author Stephanie Böhning
 * @version v1.0
 * 
 * modified: 21.03.2016
 */
public class ButtonClickVariante3 extends JFrame{


	private static final long serialVersionUID = 1L;
	
	/**
	 * This contructor creates a frame with a button
	 */	
	public ButtonClickVariante3() {
		JButton button = new JButton("klick mich");

		//the shortest way of using an listener is to use the lambda expression. 
		//The lambda expression will only work with one statement.
		button.addActionListener(listener -> button.setText("ich wurde geklickt"));
		
		add (button);
		
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new ButtonClickVariante3();


	}

}
