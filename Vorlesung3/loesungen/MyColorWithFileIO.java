package loesungen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MyColorWithFileIO extends MyColor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyColorWithFileIO() {
		JButton load = new JButton("Load");
		JButton save = new JButton("Save");
		JPanel btnPanel = new JPanel();
		
		add (btnPanel, BorderLayout.NORTH);
		
		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
		btnPanel.add(Box.createHorizontalStrut(5));
		btnPanel.add(load);
		btnPanel.add(Box.createHorizontalStrut(3));
		btnPanel.add(save);
		btnPanel.add(Box.createHorizontalStrut(5));
		
		save.addActionListener(listener -> save());
		load.addActionListener(listener -> load());
	}
	
	private void save() {
		File file = new File("ColorSettings.txt");
		try {
			FileWriter writer = new FileWriter(file);
			PrintWriter printer = new PrintWriter(writer);
			
			printer.println(super.getColor().getRed());
			printer.println(super.getColor().getGreen());
			printer.println(super.getColor().getBlue());
			System.out.println(super.getColor().getRed() + "\t" + super.getColor().getGreen() + "\t" + super.getColor().getBlue());
			
			printer.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void load () {
		File file = new File("ColorSettings.txt");
		try {
			Scanner scan = new Scanner(file);
			
			if (scan.hasNextInt())				
				super.setColor(new Color(scan.nextInt(), scan.nextInt(), scan.nextInt()));

			scan.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new MyColorWithFileIO ();

	}

}
