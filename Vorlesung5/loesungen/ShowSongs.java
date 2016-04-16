package loesungen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 * 
 * This is an example for using JList in Combination with Objects like Song. Song overrides the toString()-Method, 
 * so the toString()-Method determines how the Objects are represented in the JList.
 * 
 * @author Stephi
 * @version 1.0
 * 
 * last modified: 15.04.2016
 *
 */
public class ShowSongs extends JFrame{

	
	public ShowSongs() {		
		//create JList with Songs!
		DefaultListModel<Song> songsModel = new DefaultListModel<Song>();
		JList<Song> list = new JList<Song>(songsModel);
		
		JButton addBtn = new JButton("add");
		
		add(list, BorderLayout.CENTER);
		add(addBtn, BorderLayout.SOUTH);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 400);
		
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//use the dialog from Excercise 3 to get a song
				AddSongDialog dialog = new AddSongDialog(ShowSongs.this, "Add Songs", true);
				Song song = dialog.getSong();

				//add a song to the JList
				songsModel.addElement(song);
				list.setModel(songsModel);
			}
		});
	}
	
	public static void main(String[] args) {
		new ShowSongs();
	}

}
