package 	loesungen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * 
 * @author Stephanie Böhning
 * @version v1.1
 * 
 * modified: 31.03.2016
 */
public class AddSongDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	//create components
	private Song song;

	private JLabel titleLabel = new JLabel("Enter Song title");
	private JLabel lengthLabel = new JLabel("Enter Song length");
	
	private JTextField titleField = new JTextField(10);
	private JTextField lengthField = new JTextField(10);
	
	private JButton okBtn = new JButton("Ok");
	
	
	/**
	 * This constructor can be called from a JFrame object and creates a dialog window which requested a song title and the duration of a song.
	 * 
	 * @param parent JFrame object which create this object
	 * @param title is the title of the Dialog window
	 * @param modal set the behavior if the dialog window is just accessible or also the JFrame window which creates this window
	 */
	public AddSongDialog(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);

		createWindow();
	}
	
	/**
	 * This constructor can be called from a JDialog object and creates another dialog window which requested a song title and the duration of a song.
	 *
	 * @param parent JDialog object which create this object
	 * @param title is the title of this Dialog window
	 * @param modal set the behavior if this dialog window is just accessible or also the JDialog window which creates this window
	 */
	public AddSongDialog(JDialog parent, String title, boolean modal) {
		super(parent, title, modal);
		createWindow();
	}
	
	
	/**
	 * This method creates the windows and request a song title and a duration of a song.
	 */
	private void createWindow () {
		JPanel northPanel = new JPanel();	//for song title
		JPanel centerPanel = new JPanel();	//for song length
		
		//set layouts
		setLayout(new BorderLayout());
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));

		//insert a ok button to finish the entering of data
		add(okBtn, BorderLayout.SOUTH);
		okBtn.setHorizontalAlignment(SwingConstants.CENTER);

		//order the song title components
		northPanel.add(titleLabel);
		northPanel.add(titleField);
		
		//order the song length components
		centerPanel.add(lengthLabel);
		centerPanel.add(lengthField);
		

		//if the ok button is pressed the text is printed at console
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					song = new Song(titleField.getText(), Integer.valueOf(lengthField.getText()));				
					System.out.println(song.toString());
					dispose();									
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,  "Please insert the song length in seconds e.g. 330 for 3:30 minutes.", "Wrong input", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		setSize(200, 100);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	/**
	 * Getter for the attribute song.
	 * @return a inserted song object.
	 */
	public Song getSong() {
		return song;
	}

}
