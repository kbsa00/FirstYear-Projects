import javax.swing.*; 
import java.awt.event.*; 
import java.awt.*;
import static javax.swing.JOptionPane.*;
import java.lang.Math; 
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
    
    private double sum, num, num2;
 
    private double dollar = 0.12; 
    private double pund = 0.09; 
    private double euro = 0.11;
    private double svensk = 1.05;
    
    private double nokUSD = 8.62; 
    private double nokGBP = 11.04;
    private double nokEUR = 9.25; 
    private double nokSEK = 0.96;
    public Valuta()
    {
        setTitle("Valutakalkulator");
        setSize(500,150);
        setResizable(false);
        JPanel panelnorth = new JPanel(new GridLayout(1,1)); 
        JPanel panelcenter = new JPanel(new GridLayout(2,2)); 
        JPanel panelsouth = new JPanel(new GridLayout(1,3));
        
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
          
        pack();
        setVisible(true); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
   public boolean Method1()
    {
        return box2.getText().equals("");
    }
    
   public boolean Method2()
    {
        return box1.getText().equals("") && box2.getText().equals(""); 
    }
    
   public boolean Method3()
    {
        return box1.getText().equals(num) && box1.getText().equals(num2);
    
    }
    
    
    public void actionPerformed(ActionEvent e)
   {
     Object click = e.getSource();
        
     if(click == gbp)
        {
            if(Method2())
            {
             showMessageDialog(null, "Du må skrive ett beløp!");
           }
          
           if(Method1()){
            num = Double.parseDouble(box1.getText());
            sum = num * pund; 
            box2.setText(Double.toString(sum)); 
            other.setText("GBP");
           }
           else{
            num2 = Double.parseDouble(box2.getText()); 
            sum = num2 * pund / 100; 
            box1.setText(Double.toString(sum)); 
            other.setText("GBP");
            }
       }
       
        else if(click == eur)
        {         
            if(Method2())
            {
             showMessageDialog(null, "Du må skrive ett beløp!");
           } 
            
            if(Method1()){
            num = Double.parseDouble(box1.getText());
            sum = num * euro; 
            box2.setText(Double.toString(sum)); 
            other.setText("EUR");
           }
           else
           {
            num2 = Double.parseDouble(box2.getText()); 
            sum = num2 * euro / 100; 
            box1.setText(Double.toString(sum)); 
            other.setText("EUR");   
           }
        }
        else if (click == usd)
        {   
             if(Method2())
            {
             showMessageDialog(null, "Du må skrive ett beløp!");
            }
           
            if(Method1()){
                num = Double.parseDouble(box1.getText()); 
                sum = num * dollar; 
                box2.setText(Double.toString(sum));
                other.setText("USD"); 
            } 
            else
            {
                num2 = Double.parseDouble(box2.getText()); 
                sum = num2 * dollar / 100; 
                box1.setText(Double.toString(sum)); 
                other.setText("USD");
            }
       }
        else if (click == sek)
        {
           if(Method2())
           {
             showMessageDialog(null, "Du må skrive ett beløp!");
           }
           
            if(Method1()){
                num = Double.parseDouble(box1.getText()); 
                sum = num * svensk; 
                box2.setText(Double.toString(sum)); 
                other.setText("SEK");  
            }
           else
           {
               num2 = Double.parseDouble(box2.getText()); 
               double sum = Math.round(num2 / svensk);
               
               box1.setText(Double.toString(sum)); 
               other.setText("SEK");
           }
       }
        
        else if (click == rensNO)
        {
            box1.setText("");
        }
        else if (click == rensOther)
        {
            box2.setText("");
            other.setText("Annen valuta");
        }
        else if (click == rens)
        {
            box1.setText(""); 
            box2.setText("");
            other.setText("Annen valuta");
        }
     
        else 
        {
            System.exit(0);
        }
    }
    }