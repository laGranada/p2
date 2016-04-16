package loesungen;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * This class is a color chooser. This class inherit from MyColor from exercise 2
 * 
 * @author Stephi
 * @version
 *
 * last modified: 12.04.2016
 */
public class ColorChooserWithMenu extends MyColor {

	private static final long serialVersionUID = 1L;

	/**
	 * This constructor creates a window in which you can choose a color by menu, by slider or by value.
	 */
	public ColorChooserWithMenu() {
		//create menu components
		JMenuBar menuBar = new JMenuBar();
		JMenu farbe = new JMenu("Farbe");
		JMenuItem red = new JMenuItem("red");	
		JMenuItem green = new JMenuItem("green");	
		JMenuItem blue = new JMenuItem("blue");	
		JMenuItem other = new JMenuItem("other Color");	
		
		setJMenuBar(menuBar);
		menuBar.add(farbe);
		
		//add items to menu
		farbe.add(red);
		farbe.add(green);
		farbe.add(blue);
		farbe.addSeparator();
		farbe.add(other);

		//setListener
		red.addActionListener(listener -> super.setColor(Color.red));
		green.addActionListener(listener -> super.setColor(Color.green));
		blue.addActionListener(listener -> super.setColor(Color.blue));
		other.addActionListener(listener -> setOtherColor());

		setVisible(true);
		
	}

	/**
	 * This method shows a dialog in which the user can select many colors
	 */
	private void setOtherColor() {
		
		Color color = JColorChooser.showDialog(null, "bla", Color.red);
		if (color != null)
			super.setColor(color);
	}

	
	public static void main(String[] args) {

		new ColorChooserWithMenu();
	}

}
