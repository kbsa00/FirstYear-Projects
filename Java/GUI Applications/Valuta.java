import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*;
import static javax.swing.JOptionPane.*;
/**
 * Write a description of class Valuta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Valuta extends JFrame implements ActionListener
{
    private JButton gbp, usd, sek, eur, rensNO, rensOther, rens, avslutt;
    private JTextField box1,box2; 
    private JLabel other; 
    
    private int sum, num, num2;
    private int bytt = 1;
    private int dollar = 4; 
    private int pund = 3; 
    private int euro = 5; 
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
        
        other = new JLabel("Annen valuta"); 
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
        
        rensNO = new JButton("Fjern NOK"); 
        rensOther = new JButton("Fjern Annen Valuta"); 
        rens = new JButton("Fjern begge"); 
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
        
        
        box2.addActionListener(this);
        
    
        pack();
        setVisible(true); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    //public boolean checkCond() 
    //{
      //  return box1.getText().equals("") && box2.getText().equals("");
    
    //}
    
    public boolean run()
    {
       return box1.getText().equals("") && box2.getText().equals(""); 
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object click = e.getSource();
        String number1 = box1.getText();
        String number2 = box2.getText();
        
        if(click == gbp)
        {
            num = Integer.parseInt(number1);
            sum = num * pund; 
            box2.setText(Integer.toString(sum)); 
            other.setText("GBP");
        }
       
       
       
        else if(click == eur)
        {
            num = Integer.parseInt(number1);
            sum = num * euro; 
            box2.setText(Integer.toString(sum)); 
            other.setText("EUR");   
        }
        else if (click == usd)
        {   
            num = Integer.parseInt(number1); 
            sum = num * dollar; 
            box2.setText(Integer.toString(sum));
            other.setText("USD"); 
        }
        else if (click == sek)
        {
            num = Integer.parseInt(number1); 
            sum = num * svensk; 
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
