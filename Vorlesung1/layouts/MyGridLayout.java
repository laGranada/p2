package layouts;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;


import javax.swing.JButton;

/**
 *
 * @author Niko
 */
public class MyGridLayout extends JFrame{
    
    private JButton btn = new JButton("1");
    private JButton btn2 = new JButton("2");
    private JButton btn3 = new JButton("3");
    private JButton btn4 = new JButton("4");
    private JButton btn5 = new JButton("5");
    private JButton btn6 = new JButton("6");
    
    public MyGridLayout(String title){
        super(title);
        
        setLayout(new GridLayout(3, 2));
        add(btn);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        

        
    }
    
    public static void main(String[] args) {
        
        JFrame frame = new MyGridLayout("Test123");
        frame.setVisible(true);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // TODO code application logic here
    }

    
}