package loesungen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
public class ShowSongsFuerFortgeschrittene extends JFrame{

	
	public ShowSongsFuerFortgeschrittene() {		
		//create components
		DefaultListModel<Song> songsModel = new DefaultListModel<Song>();
		JList<Song> list = new JList<Song>(songsModel);		
		JButton addBtn = new JButton("add");
		JLabel titleLabel = new JLabel("Song title:");
		JTextField titleField = new JTextField(20);
		JScrollPane pane = new JScrollPane(list);
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
	
		add(pane);
		add(addBtn);
		add(titleLabel);
		add(titleField);
				
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//use the dialog from Excercise 3 to get a song
				AddSongDialog dialog = new AddSongDialog(ShowSongsFuerFortgeschrittene.this, "Add Songs", true);
				Song song = dialog.getSong();

				//add a song to the JList
				songsModel.addElement(song);
				list.setModel(songsModel);
			}
		});

		
		//wenn ein Song in der JList ausgewählt ist und man woanders hinklickt, soll das Element nicht mehr ausgewählt sein
		list.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				super.focusLost(e);
				//mit getOppositeComponent bekommt man die Komponente, die nun den Focus hat.
				//klickt man allerdings ein anderes Fenster an, bekommt man nun null
				if (e.getOppositeComponent() != null) {
					list.clearSelection();
				}
			}
		});
		
		//da ich hier keine zusätzlichen Panel habe, füge ich den MouseListener dem Fenster hinzu.
		//bei euch müsst ihr den Mouselistener euren Panels hinzufügen
		getContentPane().addMouseListener(new MouseAdapter() {

			//wenn irgendwo in das fenster geklickt wird, wird die mouseClicked ausgeführt
			//wird auf eine Komponente (z.B. TextFeld) geklickt,  bekommt es dieser mouseListener nicht mit.
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				list.clearSelection();				
			}
		});
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
	}
	
	public static void main(String[] args) {
		new ShowSongsFuerFortgeschrittene();
	}

}
