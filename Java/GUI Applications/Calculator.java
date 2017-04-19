import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;

/**
 * Write a description of class Calculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calculator extends JFrame implements ActionListener
{
    private JTextField box;
    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16;
    
    private int num1; 
    private int num2; 
    private double sum; 
    
    public Calculator()
    {
        setTitle("Kalkluator");
        setSize(250, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        JPanel paneltext = new JPanel(new GridLayout(1,0)); 
        JPanel panelnr = new JPanel(new GridLayout(4,3)); 
        JPanel panelside = new JPanel(new GridLayout(4,0));
        
        
        
        box = new JTextField();
        box.setPreferredSize( new Dimension(50, 50));
        paneltext.add(box);
        add(paneltext, BorderLayout.NORTH); 
        
        
        
        b1 = new JButton("0");
        b2 = new JButton("1");
        b3 = new JButton("2");
        b4 = new JButton("3");
        b5 = new JButton("4");
        b6 = new JButton("5");
        b7 = new JButton("6");
        b8 = new JButton("7");
        b9 = new JButton("8");
        b10 = new JButton("9");
        b11 = new JButton("C");
        b12 = new JButton("=");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        
        panelnr.add(b1);
        panelnr.add(b2);
        panelnr.add(b3);
        panelnr.add(b4);
        panelnr.add(b5);
        panelnr.add(b6);
        panelnr.add(b7);
        panelnr.add(b8);
        panelnr.add(b9);
        panelnr.add(b10);
        panelnr.add(b11);
        panelnr.add(b12);
        
        add(panelnr, BorderLayout.CENTER);
        
        b13 = new JButton("+");
        b14 = new JButton("-");
        b15 = new JButton("*");
        b16 = new JButton("/");
        
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        b16.addActionListener(this);
        
        
        
        panelside.add(b13);
        panelside.add(b14);
        panelside.add(b15);
        panelside.add(b16);
        
        add(panelside, BorderLayout.EAST);
        
        
        setVisible(true);
        
    
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String click = e.getActionCommand();
        switch(click)
        {
            
        
        
        }
    
    }
}