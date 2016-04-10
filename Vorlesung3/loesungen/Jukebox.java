package loesungen;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * 
 * @author Stephanie Böhning
 * @version v1.1
 * 
 * modified: 31.03.2016
 */
public class Jukebox extends JFrame{

	//create components
	private static final long serialVersionUID = 1L;
	private final DefaultListModel<Object> songsModel = new DefaultListModel<>();
	private final JList<Object> songList = new JList<>(songsModel);
	private JButton add = new JButton("Add");
	private JButton load = new JButton("Load");
	private JButton save = new JButton("Save");

	/**
	 * This constructor creates a window in which you can add songs, save them or load songs.
	 */
	public Jukebox() {
		JPanel center = new JPanel();	//list of songs
		JPanel east = new JPanel();		//button panel
		
		//set layouts
		add (center, BorderLayout.CENTER);
		add (east, BorderLayout.EAST);
		east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));

		//organize song list
		songList.setPreferredSize(new Dimension(200, 300));
		center.add(songList);

		//order button at east panel
		east.add(add);
		east.add(load);
		east.add(save);
		
		setTitle("Songs");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();

		
		//if the add button is used a JDialog should appear and demand for a song title and the song length
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				AddSongDialog addSong = new AddSongDialog(Jukebox.this, "Add Song", true);

				//if the dialog window is closed that mean the user finish the request, the song data should be saved here
				addSong.addWindowListener(new WindowAdapter() {
					
					@Override
					public void windowClosed(WindowEvent e) {
						super.windowClosed(e);
						songsModel.addElement(addSong.getSong().toString());						
						songList.setListData(songsModel.toArray());
						songList.repaint();
					}
				});				
			}
		});
		
		//reads the song data from file
		load.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = new File ("Songs.txt");
				Scanner scan = null;
								
				try {
					scan = new Scanner(file);
					String line = "";
					songsModel.removeAllElements();
					
					//read as long as all data are read
					while (scan.hasNext()) {
						line = scan.nextLine();
						songsModel.addElement((Object) line);
					}

					scan.close();
					
					//insert data to JList
					songList.setListData(songsModel.toArray());
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//write the song data to a file
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				File file = new File ("Songs.txt");
				FileWriter writer = null;
				PrintWriter printer = null;
								
				try {
					writer = new FileWriter(file);
					printer = new PrintWriter(writer);

					//write all data to file
					for (int i = 0; i < songsModel.size(); i++) {
						printer.println(songsModel.getElementAt(i).toString());
					}
					
					printer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

	}
	
	
	public static void main(String[] args) {
		new Jukebox();
	}
}
