package loesungen;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

/**
 * 
 * @author Stephanie Böhning
 * @version v1.1
 * 
 * modified: 31.03.2016
 */
public class Players extends JDialog {

	private static final long serialVersionUID = 1L;
	private JButton add = new JButton("add");
	private JTextField text = new JTextField(10);
	private ArrayList<Song> songs = new ArrayList<>();
	
	/**
	 * This method creates a window to add a song.
	 */
	public Players() {
		text.setEditable(false);

		add(add, BorderLayout.WEST);
		add(text, BorderLayout.CENTER);

		
		this.setVisible(true);
		this.pack();

		//if the add button is pressed a dialog windows appears which request for song data
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				AddSongDialog addSongs = new AddSongDialog(Players.this, "Add Song", false);
				addSongs.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

				//if the user finished the request the data from dialog window should set in this frame
				addSongs.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						super.windowClosed(e);
						songs.add(addSongs.getSong());
						text.setText(addSongs.getSong().toString());
					}
				});	
			}
		});
	}
	
	
	public static void main(String[] args) {
		new Players();
		
	}
	
}
