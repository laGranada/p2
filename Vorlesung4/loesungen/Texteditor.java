package loesungen;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 * This class is a simple text editor
 * 
 * @author Stephi
 * @version 1.0
 * 
 * last modified: 12.04.2016
 */
public class Texteditor extends JFrame {

	//create components
	private JTextArea text = new JTextArea(200, 300);
	private File file = null;
	private String defaultPath = "C:\\Data\\eclipse Workspace\\Programmieren2\\Vorlesung4\\loesungen\\";
	private JMenuItem saveItem = new JMenuItem("Save");
	private JMenuItem saveAsItem = new JMenuItem("Save as");
	private String zwischenAblage = "";
	private JMenuItem cutItem = new JMenuItem("Cut");
	private JMenuItem copyItem = new JMenuItem("Copy");
	private JMenuItem pasteItem = new JMenuItem("Paste");

	/**
	 * This constructor creates a simple text editor in which you can save and load a text. You can also copy and paste a text.
	 */
	public Texteditor() {
		add(text);
		text.setText("");
		
		//create Menus
		JMenuBar menuBar = new JMenuBar();
		createMenuFile(menuBar);
		createMenuEdit(menuBar);
		
		//if you type something the save menu is enabled
		text.addKeyListener(new KeyAdapter() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
				if (!text.getText().equals(""))
					saveItem.setEnabled(true);
				else 
					saveItem.setEnabled(false);
			}
		});
		
		//if a text is marked you can copy and cut it
		text.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent e) {

/*			    //you can check if a text is marked this way
				//Get the location in the text
			    int dot = e.getDot();
			    int mark = e.getMark();
			    
			    if (dot != mark) {
			    	copyItem.setEnabled(true);
			    	cutItem.setEnabled(true);
			    }
			    else {
			    	if (text.getSelectedText().equals("")) {
				    	copyItem.setEnabled(false);
				    	cutItem.setEnabled(false);
			    	}
			    }
*/		    
				//this is another method to check for an marked text
		    	if (text.getSelectedText()==null) {
			    	copyItem.setEnabled(false);
			    	cutItem.setEnabled(false);
		    	}
		    	else {
			    	copyItem.setEnabled(true);
			    	cutItem.setEnabled(true);		    		
		    	}
			}
		});

		//if you want to close this window another dialog appears if there is something to save
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosed(e);
				close();
			}
		});

		//set window settings
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
		
	}

	/**
	 * This function creates the menu Edit with the items copy, cut and paste.
	 * @param menuBar The menubar on which the menus is pinned.
	 */
	private void createMenuEdit (JMenuBar menuBar) {
		JMenu editMenu = new JMenu("Edit");
		
		setJMenuBar(menuBar);
		menuBar.add(editMenu);
		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		
    	copyItem.setEnabled(false);
    	cutItem.setEnabled(false);
		
		pasteItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_MASK));		
		copyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));		
		cutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));		
		
		cutItem.addActionListener(listener -> cut());
		copyItem.addActionListener(listener -> copy());
		pasteItem.addActionListener(listener -> paste());
		
	}	

	/**
	 * This function cut the selected text and saves it into a clip board.
	 */
	private void cut () {
		zwischenAblage = text.getSelectedText();
		String oldText = text.getText();
		String newText = oldText.replace(zwischenAblage, "");
		text.setText(newText);
	}

	/**
	 * This function copy the selected text and saves it into a clip board.
	 */	
	private void copy () {
		zwischenAblage = text.getSelectedText();
		pasteItem.setEnabled(true);
	}

	/**
	 * This function paste the text from a clip board to the position where the mouse pointer is.
	 */
	private void paste () {
		String oldText = text.getText();
		int start = text.getSelectionStart();
		String newText = oldText.substring(0, start) + zwischenAblage  + oldText.substring(start);
	
		text.setText(newText);
		pasteItem.setEnabled(true);
	}
	
	/**
	 * This method creates a file menu with the items save, save as, open and close.	
	 * @param menuBar The menubar on which the menu is pinned
	 */
	private void createMenuFile (JMenuBar menuBar) {
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem closeItem = new JMenuItem("Close");
		
		setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(saveItem);
		fileMenu.add(saveAsItem);
		fileMenu.add(openItem);
		fileMenu.add(closeItem);

		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));		
		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));		
		
		saveItem.setEnabled(false);
		
		openItem.addActionListener(listener -> open());
		saveItem.addActionListener(listener -> save(false));
		saveAsItem.addActionListener(listener -> save(true));
		closeItem.addActionListener(listener -> close());
		
	}
	
	/**
	 * This method ask the user to save the text before closing
	 */
	private void close () {
			String [] names = {"Yes", "No", "Cancel"};
			
			int option = JOptionPane.showOptionDialog(null, "Do you want to save the text?", "save file", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, names, 0);
			
			if (option == JOptionPane.YES_OPTION) {
				save(false);
				System.exit(0);
			} else if (option == JOptionPane.NO_OPTION) {
				dispose();
			} else if (option == JOptionPane.CLOSED_OPTION || option == JOptionPane.CANCEL_OPTION) {
				//do nothing
			}
			
	}
	
	/**
	 * This method always asks the user where to save the file and saves the file in file Object.
	 */
	private void saveAs () {
		JFileChooser fileChooser = new JFileChooser(defaultPath);
		int ret = fileChooser.showSaveDialog(null);

		if (ret == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
		}
	}
	
	/**
	 * This method saves the text. If this is the first time to save, the user is asked where to save the text. Else if depends on the parameter save as.
	 * @param saveAs determines if the user is asked where to save the file
	 */
	private void save (boolean saveAs) {

		if (file == null || saveAs) {
			saveAs();
		}

		if (file != null) {
			try {
			
				FileWriter writer = new FileWriter(file);
				BufferedWriter bufWrite = new BufferedWriter(writer);

				bufWrite.write(text.getText());
				
				bufWrite.close();
				writer.close();
				
								
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				//File reader
				JOptionPane.showMessageDialog(null, "The file could not be found.", "File not found", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e2) {
				e2.printStackTrace();
				//readLine
				JOptionPane.showMessageDialog(null, "An error occoured while writing the file.", "Can not write", JOptionPane.ERROR_MESSAGE);
			}
		}			
		
		saveItem.setEnabled(false);
	}
	
	/**
	 * This method opens a file which is choosed by a user.
	 */
	private void open () {
		JFileChooser fileChooser = new JFileChooser(defaultPath);
		int ret = fileChooser.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			FileReader reader = null;
			String line = "";
			
			//read the text from a file, clear the data from text area and write the read data into it.
			try {
			
				reader = new FileReader(file);
				BufferedReader bufRead = new BufferedReader(reader);
				
				text.setText("");
				line = bufRead.readLine();
				
				while (line != null) {
					text.setText(text.getText() + line + "\n");
					line = bufRead.readLine();
					
				}
				
				bufRead.close();
				reader.close();

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				//File reader
				JOptionPane.showMessageDialog(null, "The file could not be found.", "File not found", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e2) {
				e2.printStackTrace();
				//readLine
				JOptionPane.showMessageDialog(null, "An error occoured while reading the file.", "Can not read", JOptionPane.ERROR_MESSAGE);
			}	
		}
	}
	
	/**
	 * This method creates an object from class TextEditor
	 * @param args is not used
	 */
	public static void main(String[] args) {
		new Texteditor();

	}

}
