package loesungen;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 * @author Stephanie B�hning
 * @version v1.0
 * 
 * modified: 21.03.2016
 */
public class MyColor extends JFrame{
	private static final long serialVersionUID = 1L;

	//this components have to be created here because they are used in the listener or in methods
	private JPanel northPanel = new JPanel();

	//the values for each color		
	private int green = 100;
	private int red = 100;
	private int blue = 100;
	private Color color = new Color(red, green, blue);

	/**
	 * 
	 */
	public MyColor() {
		//create components

		//the slider for each color
		JSlider redSlider = new JSlider(0, 255, color.getRed());
		JSlider greenSlider = new JSlider(0, 255, color.getGreen());
		JSlider blueSlider = new JSlider(0, 255, color.getBlue());
		
		//the panel for each color
		JPanel redPanel = new JPanel();
		JPanel greenPanel = new JPanel();
		JPanel bluePanel = new JPanel();
		//this panel contains the color panels
		JPanel southPanel = new JPanel(); 

		//the labels for each color		
		JLabel redLabel = new JLabel ("red:");
		JLabel greenLabel = new JLabel ("green:");
		JLabel blueLabel = new JLabel ("blue:");

		//the textfiels for each color		
		JTextField redField = new JTextField ("" + redSlider.getValue(), 5);
		JTextField greenField = new JTextField ("" + greenSlider.getValue(), 5);
		JTextField blueField = new JTextField ("" + blueSlider.getValue(), 5);


		northPanel.setBackground(color);
		
		add(northPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		southPanel.setLayout(new GridLayout(3, 1));
		southPanel.add(redPanel);
		southPanel.add(greenPanel);
		southPanel.add(bluePanel);
		
		redPanel.setLayout(new FlowLayout());
		redPanel.add(redLabel);
		redPanel.add(redSlider);
		redPanel.add(redField);
		
		greenPanel.setLayout(new FlowLayout());
		greenPanel.add(greenLabel);
		greenPanel.add(greenSlider);
		greenPanel.add(greenField);

		bluePanel.setLayout(new FlowLayout());
		bluePanel.add(blueLabel);
		bluePanel.add(blueSlider);
		bluePanel.add(blueField);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
		
		//if the value of the slider is change the color and the value in the text field should also change
		redSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				red = redSlider.getValue();
				redField.setText("" + red);
				repaintPanel();
			}
		});
		
		//if the value of the slider is changed the color and the value in the text field should also change
		greenSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				green = greenSlider.getValue();
				greenField.setText("" + green);
				repaintPanel();
			}
		});

		//if the value of the slider is changed the color and the value in the text field should also change
		blueSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				blue = blueSlider.getValue();
				blueField.setText("" +blue);
				repaintPanel();
			}
		});
		
		
		//if the value of the field is changed the color and the value of the slider should also change
		redField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				red = Integer.valueOf(redField.getText());
				redSlider.setValue(red);
				repaintPanel();
			}
		});

		//if the value of the field is changed the color and the value of the slider should also change
		greenField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				green = Integer.valueOf(greenField.getText());
				greenSlider.setValue(green);
				repaintPanel();
			}
		});

		//if the value of the field is changed the color and the value of the slider should also change
		blueField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				blue = Integer.valueOf(blueField.getText());
				blueSlider.setValue(blue);
				repaintPanel();
			}
		});

		
	}
	
	/**
	 * This method repaints the color at the top of the frame
	 */
	private void repaintPanel () {
		northPanel.setBackground(new Color(red, green, blue));
		
	}
	
	public static void main(String[] args) {
		new MyColor();

	}

}