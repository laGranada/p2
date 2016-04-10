package menu;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class ProgrammAMenu extends JFrame{

	public ProgrammAMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		//create a file menu with two menu items
		JMenu menu = new JMenu("Menu");
		JMenuItem menuItem1 = new JMenuItem("A simple menu item");
		JMenuItem menuItem2 = new JMenuItem("Menu Item with Accelerator");
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));	//add short key ctrl + A
		menuItem2.setMnemonic(KeyEvent.VK_A);	//the A of Accelerator is underlined
		JMenuItem menuItem3 = new JMenuItem("another menu item");

		menuBar.add(menu);
		menu.add(menuItem1);
		menu.add(menuItem2);
		menu.add(menuItem3);
		
		setSize(200, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public static void main(String[] args) {
		new ProgrammAMenu();
	}
	
}
