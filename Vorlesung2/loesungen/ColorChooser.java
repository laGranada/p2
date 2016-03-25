package loesungen;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * 
 * @author Stephanie Böhning
 * @version v1.0
 * 
 * modified: 21.03.2016
 */
public class ColorChooser extends JFrame {


	private static final long serialVersionUID = 1L;

	public ColorChooser() {
		
		String[] colorNames = { "Black", "Blue", "Cyan", "Dark Grey", "Green", "Grey", "Orange", "Red", "White",
		"Yellow" };
		DefaultListModel<String> choosedColorNames = new DefaultListModel<>();
		JList<String> choosedColors;
		JList<String> colors = new JList<>(colorNames);
		JButton copyBtn = new JButton("copy >>>");
		JScrollPane scollpane = new JScrollPane(colors);

		setLayout(new FlowLayout());
		choosedColors = new JList<>(choosedColorNames);
		choosedColors.setPreferredSize(new Dimension(100, 150));

		add(scollpane);
		add(copyBtn);
		add(choosedColors);

		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		//if the copy button is clicked all choosed colors should be copied from the left list to the right
		copyBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<String> values = colors.getSelectedValuesList();
				
				for (String value : values)
					if (!choosedColorNames.contains(value)) {
						choosedColorNames.addElement(value);
				}

				//Variante 1
				Object [] objects = choosedColorNames.toArray();
				String [] choosedNames = new String [choosedColorNames.toArray().length];
				for (int i = 0; i < choosedNames.length; i++) {
					choosedNames[i] = (String) objects[i];
				}

				choosedColors.setListData(choosedNames);					

				//Variante 2 - kann eine ClassCastException werfen
//				choosedColors.setListData((String[])choosedColorNames.toArray());					

				choosedColors.repaint();

			}
		});
	}

	public static void main(String[] args) {
		new ColorChooser();

	}

}
