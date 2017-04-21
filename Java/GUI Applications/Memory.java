import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;
/**
 * Write a description of class Memory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Memory extends JFrame implements ActionListener
{
    private JButton[] buttons; 
    private JButton[] buttons1;
    private JButton start; 
    private JButton avslutt; 
    
    public Memory()
    {
        setTitle("Memory");
        JPanel panelcenter = new JPanel(new GridLayout(6,6)); 
        JPanel panelsouth = new JPanel(new GridLayout(1,2));
        buttons = new JButton[18];
        buttons1 = new JButton[18]; 
        
        for (int i = 0; i < 18; i++)
        {
            
            buttons[i] = new JButton(String.valueOf(i));
           
            buttons[i].setForeground(Color.WHITE);
            buttons[i].addActionListener(this);
            panelcenter.add(buttons[i]);
        }
        
        
        for(int i = 0; i < 18; i++)
        {
            buttons1[i] = new JButton(String.valueOf(i));
            buttons1[i].setBackground(Color.WHITE);
            buttons1[i].setForeground(Color.WHITE);
            
            buttons1[i].addActionListener(this);
            panelcenter.add(buttons1[i]);
        
        }
        add(panelcenter, BorderLayout.CENTER);
        
        start = new JButton("Start på nytt"); 
        avslutt = new JButton("Avslutt"); 
        
        panelsouth.add(start); 
        panelsouth.add(avslutt); 
        add(panelsouth, BorderLayout.SOUTH); 
        
        
        
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
      Object click = e.getSource();
      
      if (click == buttons[0] )
      {
          buttons[0].setForeground(Color.BLACK); 
          if (click == buttons1[0])
          {
              buttons1[0].setForeground(Color.BLACK);
          }
   
      }
    
      else{
          buttons[0].setForeground(Color.WHITE); buttons1[0].setForeground(Color.WHITE);
        }
       
      
      
     
    }
}
