
import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*;
/**
 * Write a description of class Valuta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Valuta extends JFrame implements ActionListener
{
    private JButton gbp;
    private JButton usd; 
    private JButton sek; 
    private JButton eur; 
    private JButton rensNO; 
    private JButton rensOther; 
    private JButton rens; 
    private JButton avslutt; 
    private JTextField box1; 
    private JTextField box2;
    private JLabel other; 
    private int sum;
    private int num;
    private int dollar = 4; 
    private int pund = 3; 
    private int euro = 2; 
    private int svensk = 2;  
    
    public Valuta()
    {
        setTitle("Valutakalkulator");
        setSize(500,150);
        setResizable(false);
        JPanel panelnorth = new JPanel(new GridLayout(1,1)); 
        JPanel panelcenter = new JPanel(new GridLayout(2,2)); 
        JPanel panelsouth = new JPanel(new GridLayout(1,3));
        //panelcenter.setLayout(new GridLayout(3,1,-12,-12));
        //panelsouth.setLayout(new GridLayout(1,7,-12,-12));
        
        JLabel nok = new JLabel("NOK"); 
        box1 = new JTextField();
        panelnorth.add(nok);
        panelnorth.add(box1); 
        
        other = new JLabel("Other"); 
        box2 = new JTextField(); 
        panelnorth.add(other); 
        panelnorth.add(box2); 
        add(panelnorth, BorderLayout.NORTH); 
        
        gbp = new JButton("GBP"); 
        eur = new JButton("EUR"); 
        usd = new JButton("USD"); 
        sek = new JButton("SEK"); 
        
        gbp.addActionListener(this);
        eur.addActionListener(this); 
        usd.addActionListener(this); 
        sek.addActionListener(this); 
        
        
        
        panelcenter.add(gbp); 
        panelcenter.add(eur);
        panelcenter.add(usd); 
        panelcenter.add(sek); 
        add(panelcenter, BorderLayout.CENTER); 
        
        rensNO = new JButton("Rens NOK"); 
        rensOther = new JButton("Rens Other"); 
        rens = new JButton("Rens"); 
        avslutt = new JButton("Avslutt");
        
        rensNO.addActionListener(this);
        rensOther.addActionListener(this);
        rens.addActionListener(this);
        avslutt.addActionListener(this); 
        
        
        panelsouth.add(rensNO); 
        panelsouth.add(rensOther);
        panelsouth.add(rens); 
        panelsouth.add(avslutt); 
        add(panelsouth, BorderLayout.SOUTH);
        
        
        
        
    
        pack();
        setVisible(true); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object click = e.getSource();
        if(click == gbp)
        {
            String number1 = box1.getText(); 
            int num = Integer.parseInt(number1); 
            int sum = num * pund; 
            
            box2.setText(Integer.toString(sum));
            other.setText("GBP");
        
        }
        else if(click == eur)
        {
            String number1 = box2.getText();
            int num = Integer.parseInt(number1);
            int sum = num * euro; 
            box2.setText(Integer.toString(sum)); 
            other.setText("EUR"); 
            
        }
        else if (click == usd)
        {
            String number1 = box2.getText(); 
            int num = Integer.parseInt(number1); 
            int sum = num * dollar; 
            box2.setText(Integer.toString(sum));
            other.setText("USD"); 
        }
        else if (click == sek)
        {
            String number1 = box2.getText(); 
            int num = Integer.parseInt(number1); 
            int sum = num * svensk; 
            box2.setText(Integer.toString(sum)); 
            other.setText("SEK");
        }
        else if (click == rensNO)
        {
            box1.setText("");
        }
        else if (click == rensOther)
        {
            box2.setText("");
        }
        else if (click == rens)
        {
            box1.setText(""); 
            box2.setText(""); 
        }
        else 
        {
            System.exit(0);
        }
        
    }
}
