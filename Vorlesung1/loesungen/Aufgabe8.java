package loesungen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Aufgabe8 extends JFrame {

	//create all components
	private JButton okBtn = new JButton("Ok");
	private JButton cnzBtn = new JButton("Canzel");
	private JComboBox<String> playMode = new JComboBox<>();
	private JComboBox<String> difficulty = new JComboBox<>();
	private JCheckBox ply1MouseCrtl = new JCheckBox("Player1 Mouse Control");
	private JCheckBox ply2MouseCrtl = new JCheckBox("Player2 Mouse Control");
	private JLabel ply1Label = new JLabel("Player 1");
	private JLabel ply2Label = new JLabel("Player 2");
	private JLabel playModeLabel = new JLabel("Play Mode");
	private JLabel difficutyLabel = new JLabel("Difficulty");
	private JTextField ply1Name = new JTextField(10);
	private JTextField ply2Name = new JTextField(10);
	private JPanel gridPanel = new JPanel();
	private JPanel flowPanel = new JPanel();
	
	public Aufgabe8() {
		
		//set layout
		gridPanel.setLayout(new GridLayout(5, 2));
		flowPanel.setLayout(new FlowLayout());
		
		//add panel to frame
		add(gridPanel, BorderLayout.CENTER);
		add(flowPanel, BorderLayout.SOUTH);
		
		//organize playMode component
		playMode.addItem("Local 1v1");
		playMode.addItem("Local 1vAI");
		playMode.addItem("Network Game (Server Mode)");
		playMode.addItem("Network Game (Client Mode)");
		
		//organize difficulty component
		difficulty.addItem("easy");
		difficulty.addItem("medium");
		difficulty.addItem("hard");
		difficulty.addItem("very hard");

		//add components to panel
		gridPanel.add(playModeLabel);
		gridPanel.add(playMode);
		
		gridPanel.add(ply1Label);
		gridPanel.add(ply1Name);
		gridPanel.add(ply2Label);
		gridPanel.add(ply2Name);
		
		gridPanel.add(ply1MouseCrtl);
		gridPanel.add(ply2MouseCrtl);
		
		gridPanel.add(difficutyLabel);
		gridPanel.add(difficulty);
		
		flowPanel.add(okBtn);
		flowPanel.add(cnzBtn);

	}
	
	public static void main(String[] args) {
		JFrame frame = new Aufgabe8();
		
		frame.setVisible(true);
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

	}

}
