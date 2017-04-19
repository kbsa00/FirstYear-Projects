import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*;
import static javax.swing.JOptionPane.*;
import java.util.Random; 
/**
 * Write a description of class SecretNumber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SecretNumber extends JFrame implements ActionListener
{
    private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    
    public SecretNumber()
    {
       setTitle("Tipp det Hemmelige tallet"); 
       setSize(100,300);
       setResizable(false);
       JPanel panelnorth = new JPanel(new GridLayout(1,9));
       JPanel panelsouth = new JPanel(new GridLayout(1,0));
       JPanel paneltext = new JPanel(new GridLayout(1,0));
       
       b0 = new JButton("0");
       b1 = new JButton("1");
       b2 = new JButton("2");
       b3 = new JButton("3");
       b4 = new JButton("4");
       b5 = new JButton("5");
       b6 = new JButton("6");
       b7 = new JButton("7");
       b8 = new JButton("8");
       b9 = new JButton("9");
       
       panelnorth.add(b0);
       panelnorth.add(b1);
       panelnorth.add(b2);
       panelnorth.add(b3);
       panelnorth.add(b4);
       panelnorth.add(b5);
       panelnorth.add(b6);
       panelnorth.add(b7);
       panelnorth.add(b8);
       panelnorth.add(b9);
       
       add(panelnorth, BorderLayout.NORTH);
       
       b10 = new JButton("Klikk her for å starte på ny"); 
       panelsouth.add(b10); 
       add(panelsouth, BorderLayout.CENTER);
       
       JLabel text = new JLabel("Ikke søkt = hvit. Riktig = grønt. Feil = rød");
       paneltext.add(text); 
       add(paneltext, BorderLayout.SOUTH);
       
       
       
       
       
       pack(); 
       setVisible(true); 
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e)
    {
       Object click = e.getSource();
       Random rnd = new Random();
       
    }
    
}
