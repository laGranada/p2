package menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class SmallMenu extends JFrame {

	public SmallMenu() {

		//create components

		//if you want to have more than one menu you need a menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		//create a file menu with two menu items
		JMenu file = new JMenu("Save");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		file.add(save);
		file.add(load);
		
		//set short keys for menu items
		save.setMnemonic('S');	//the S of Save is underlined
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));	//add short key ctrl + S
		save.setEnabled(true);				//by default there is nothing to save, this is why save is not enabled
		load.setMnemonic(KeyEvent.VK_O);	//the O of Open is underlined
		load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));	//add short key ctrl + O
		load.setEnabled(true);				//you always can open a file, this is why open is enabled

		//you could give the menu items an icon, please enter the Path to an icon
//		save.setIcon(new ImageIcon("save.png"));	
//		open.setIcon(new ImageIcon("open.png"));

		
		
		//create a edit menu with one menu item to set the color
		JMenu edit = new JMenu("Edit");
		JMenu colors = new JMenu("set Color");
		edit.add(colors);
		
		JRadioButtonMenuItem blue = new JRadioButtonMenuItem ("blue");
		JRadioButtonMenuItem red = new JRadioButtonMenuItem ("red");
		JRadioButtonMenuItem green = new JRadioButtonMenuItem ("green");
		JRadioButtonMenuItem yellow = new JRadioButtonMenuItem ("yellow");

		//create a fun menu with stupid things. Here it is a question you have 
		JMenu fun = new JMenu("Und sonst so???");
		JCheckBoxMenuItem check = new JCheckBoxMenuItem("Bist du gut drauf?");
		check.setSelected(false);
		
		ButtonGroup group = new ButtonGroup();
		group.add(blue);
		group.add(green);
		group.add(red);
		group.add(yellow);

		colors.add(yellow);
		colors.add(blue);
		colors.add(green);
		colors.add(red);
		colors.setEnabled(true);		
		edit.add(colors);
		
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(fun);
		fun.add(check);
				
		setSize(200, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		new SmallMenu();

	}
}
