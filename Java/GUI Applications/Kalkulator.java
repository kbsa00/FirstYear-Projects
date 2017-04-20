import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
/**
 * Write a description of class Kalkulator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kalkulator extends JFrame implements ActionListener
{
    private JTextField box1; 
    private JTextField box2; 
    private JTextField box3;
    private JButton plus; 
    private JButton minus; 
    private JButton times; 
    private JButton divide; 
    private JButton exit;
    
    private int num1; 
    private int num2;
    private int sum; 
    
    public Kalkulator()
    {
        setTitle("Kalkulator");
        
        JPanel panelcenter = new JPanel(new GridLayout(3,2)); 
        JPanel panelsouth = new JPanel(new GridLayout(1,5));
        
        JLabel first = new JLabel("Tall1"); 
        box1 = new JTextField(num1);
        panelcenter.add(first); 
        panelcenter.add(box1); 
        
        JLabel second = new JLabel("Tall 2"); 
        box2 = new JTextField(num2); 
        panelcenter.add(second);
        panelcenter.add(box2); 
        
        JLabel result = new JLabel("Result");
        box3 = new JTextField(sum);
        box3.setEditable(false);
        panelcenter.add(result);
        panelcenter.add(box3);
        
        add(panelcenter, BorderLayout.CENTER);
        
        
        
        plus = new JButton("+"); 
        minus = new JButton("-"); 
        times = new JButton("*"); 
        divide = new JButton("/");
        exit = new JButton("Avslutt");
        
        plus.addActionListener(this);
        minus.addActionListener(this);
        times.addActionListener(this);
        divide.addActionListener(this);
        exit.addActionListener(this); 
        panelsouth.add(plus);
        panelsouth.add(minus);
        panelsouth.add(times);
        panelsouth.add(divide);
        panelsouth.add(exit);
        add(panelsouth, BorderLayout.SOUTH);
        pack();
        
         
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        
        
    
    
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object click = e.getSource();
       
        if(click == plus)
        {
           String number1 = box1.getText(); 
           String number2 = box2.getText(); 
           
           int num1 = Integer.parseInt(number1); 
           int num2 = Integer.parseInt(number2); 
           
           int sum = num1 + num2; 
           
           box3.setText(Integer.toString(sum));
        }
        else if(click == minus)
        {
           String number1 = box1.getText();
           String number2= box2.getText(); 
           
           int num1 = Integer.parseInt(number1); 
           int num2 = Integer.parseInt(number2); 
           
           int sum = num1 - num2; 
           box3.setText(Integer.toString(sum)); 
        }
        else if(click == divide)
        {
           String number1 = box1.getText();
           String number2= box2.getText(); 
           
           int num1 = Integer.parseInt(number1); 
           int num2 = Integer.parseInt(number2); 
           
           int sum = num1 / num2; 
           box3.setText(Integer.toString(sum)); 
        }
        else if(click == times)
        {
           String number1 = box1.getText();
           String number2= box2.getText(); 
           
           int num1 = Integer.parseInt(number1); 
           int num2 = Integer.parseInt(number2); 
           
           int sum = num1 * num2; 
           box3.setText(Integer.toString(sum)); 
        }
        else if(click == exit)
        {
           System.exit(0);
        }
    }
}
