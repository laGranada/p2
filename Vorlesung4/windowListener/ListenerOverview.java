package windowListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

import liveProgramming.EditMessage;

public class ListenerOverview {

	
	public ListenerOverview() {
		JFrame frame = new EditMessage ("Edit Message");
		
		frame.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("windowOpened");
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				System.out.println("windowIconified");
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				System.out.println("windowDeiconified");
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				System.out.println("windowDeactivated");
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("windowClosed");
				//needs a dispose
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				System.out.println("windowActivated");
			}
		});
		
		
	}
	
	
	public static void main(String[] args) {

		new ListenerOverview();
	}

}
