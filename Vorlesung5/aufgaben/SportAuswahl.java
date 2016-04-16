package aufgaben;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This is a class to select sports 
 * 
 * @author Stephi
 * @version 1.0
 * 
 * last modified: 12.04.2016
 */
public class SportAuswahl extends JFrame {

	//this variable is for saving the sports
	private String data = "";

	/**
	 * This constructor creates a window in which you can choose sports, these sports will be saved in a file.
	 */
	public SportAuswahl() {
		String [] sportArray = {"Basketball", "Fussball", "Hockey", "Kampfsport", "Laufen", "Schwimmen", "Volleyball", "Yoga"};
		JList<String> auswahl = new JList<String> (sportArray); 
		
		add(auswahl);
		
		//
		auswahl.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {

				data = "";

				//you can get the choosen elements this way
				List <String> selected = auswahl.getSelectedValuesList();
				for (int i = 0;  i < selected.size(); i++){
					data += selected.get(i) + "\n";
				}

				print(data);
//				System.out.println(data);

			}
		});
		
		//set window settings
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (200,200);
	}
	
	/**
	 * This method writes the String data to a file
	 * @param data
	 */
	private void print (String data) {

		File file = new File ("data.txt");
		FileWriter out;
		try {
			out = new FileWriter(file);
			
			PrintWriter writer = new PrintWriter(out);
			writer.write(data);
			writer.flush();		//you dont need this flush here
			
			writer.close();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This main creates an object from SportAuswahl.
	 * 
	 * @param args is not used
	 */
	public static void main(String[] args) {

		new SportAuswahl(); 
	}

}
