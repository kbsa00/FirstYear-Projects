import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.*; 
import static javax.swing.JOptionPane.*;
import java.io.*;
/**
 * Write a description of class Vote here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vote extends JFrame implements ActionListener
{
    private JTextField boxJa; 
    private JTextField boxNei; 
    private JButton ja,nei,lagre,hent,avslutt; 
    private int numJa = 0;
    private int numNei = 0; 
    
    
    public Vote()
    {
        setTitle("Stemmeopptelling"); 
        setSize(300,300);
        setResizable(false);
        JPanel panelnorth = new JPanel(new GridLayout(1,4));
        JPanel panelsouth = new JPanel(new GridLayout(2,2)); 
        
        ja = new JButton("Ja"); 
        nei = new JButton("Nei"); 
        lagre = new JButton("Lagre"); 
        hent = new JButton("Hent"); 
        avslutt = new JButton("Avslutt");
        
        ja.addActionListener(this);
        nei.addActionListener(this);
        lagre.addActionListener(this);
        hent.addActionListener(this);
        avslutt.addActionListener(this);
        
        panelnorth.add(ja);
        panelnorth.add(nei);
        panelnorth.add(lagre); 
        panelnorth.add(hent); 
        panelnorth.add(avslutt);
        add(panelnorth, BorderLayout.NORTH); 
        
        JLabel Ja = new JLabel("JA-stemmer"); 
        boxJa = new JTextField();
        panelsouth.add(Ja);
        panelsouth.add(boxJa);
        
        JLabel Nei = new JLabel("NEI-stemmer"); 
        boxNei = new JTextField(); 
        panelsouth.add(Nei); 
        panelsouth.add(boxNei);
        add(panelsouth, BorderLayout.SOUTH);
        
        
        pack(); 
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object click = e.getSource();
        
        if(click == ja)
        {
            numJa++;
            boxJa.setText(String.valueOf(numJa));        
        }
        else if(click == nei)
        {
            numNei++; 
            boxNei.setText(String.valueOf(numNei));
        }
        else if(click == hent)
        {
            boxJa.setText(""); 
            boxNei.setText(""); 
            try
            {
                String filename = showInputDialog(null, "Filnavn");
                Scanner fileIn = new Scanner(new File(filename));
                while(fileIn.hasNext())
                {
                    String data = fileIn.nextLine(); 
                    System.out.println("Antall Ja-Stemmer: " + numJa + "\nAntall Nei-Stemmer " + numNei);
                }
                fileIn.close();
            }
            catch (IOException ioex)
            {
                JOptionPane.showMessageDialog(Vote.this, "IO.feil: " + ioex.getMessage()); 
            }
            numJa = 0; 
            numNei = 0;
        }
        else if(click == lagre)
        {
            try{
                String filename = showInputDialog(null, "Filnavn"); 
                PrintWriter fileout = new PrintWriter(new File(filename));
                fileout.println(boxJa.getText() + boxNei.getText());
                fileout.close();
            }
            
            catch(IOException ioex)
            {
                JOptionPane.showMessageDialog(Vote.this, "IO-Feil: " + ioex.getMessage()); 
                
            }
        }
        else if (click == avslutt)
        {
            System.exit(0);
        }
        
    }
}
