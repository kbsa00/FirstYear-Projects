import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.*;

/**
 * Write a description of class Valutakalkulator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Valutakalkulator extends JFrame implements ActionListener
{
    private JPanel north;
    private JPanel center;
    private JPanel south;
    private JLabel nok;
    private JLabel other;
    private JTextField nokField;
    private JTextField otherField;
    private double nokGbp = 0.09;
    private double nokEur = 0.11;
    private double nokUsd = 0.12;
    private double nokSek = 1.05;
    private double gbpNok = 11.03;
    private double eurNok = 9.23;
    private double usdNok = 8.62;
    private double sekNok = 0.96;
    private double nokTemp;
    private double otherTemp;
    private JButton gbpBtn, eurBtn, usdBtn, sekBtn, cleanNokBtn, cleanOtherBtn, cleanBtn, endBtn;

    public Valutakalkulator() {
        setTitle("Valutakalkulator");

        north = new JPanel(new GridLayout(1,2));
        add(north, BorderLayout.NORTH);
        center = new JPanel(new GridLayout(2,2));
        add(center, BorderLayout.CENTER);
        south = new JPanel(new GridLayout(1,2));
        add(south, BorderLayout.SOUTH);

        gbpBtn = new JButton("GBP");
        center.add(gbpBtn);
        eurBtn = new JButton("EUR");
        center.add(eurBtn);
        usdBtn = new JButton("USD");
        center.add(usdBtn);
        sekBtn = new JButton("SEK");
        center.add(sekBtn);
        cleanNokBtn = new JButton("Rens NOK");
        south.add(cleanNokBtn);
        cleanOtherBtn = new JButton("Rens OTHER");
        south.add(cleanOtherBtn);
        cleanBtn = new JButton("Rens");
        south.add(cleanBtn);
        endBtn = new JButton("Avslutt");
        south.add(endBtn);

        nok = new JLabel("NOK");
        nokField = new JTextField();
        north.add(nok);
        north.add(nokField);

        other = new JLabel("Other");
        otherField = new JTextField();
        north.add(other);
        north.add(otherField);

        gbpBtn.addActionListener(this);
        eurBtn.addActionListener(this);
        usdBtn.addActionListener(this);
        sekBtn.addActionListener(this);
        cleanNokBtn.addActionListener(this);
        cleanOtherBtn.addActionListener(this);
        cleanBtn.addActionListener(this);
        endBtn.addActionListener(this);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String click = e.getActionCommand();
        nokTemp = Double.parseDouble(nokField.getText());
        otherTemp = Double.parseDouble(otherField.getText());
        try {
            if(nokField.getText(nokTemp)) {
                switch(click) {
                    case "GBP":
                    otherField.setText(String.valueOf(nokTemp * nokGbp));
                    other.setText("GBP");
                    break;
                    case "EUR":
                    otherField.setText(String.valueOf(nokTemp * nokEur));
                    other.setText("EUR");
                    break;
                    case "USD":
                    otherField.setText(String.valueOf(nokTemp * nokUsd));
                    other.setText("USD");
                    break;
                    case "SEK":
                    otherField.setText(String.valueOf((nokTemp * nokSek)));
                    other.setText("SEK");
                }
            }
            if(otherTemp) {
                switch(click) {
                    case "GBP":
                    nokField.setText(String.valueOf(gbpNok * otherTemp));
                    other.setText("GBP");
                    break;
                    case "EUR":
                    otherField.setText(String.valueOf(eurNok * otherTemp));
                    other.setText("EUR");
                    break;
                    case "USD":
                    otherField.setText(String.valueOf(usdNok * otherTemp));
                    other.setText("USD");
                    break;
                    case "SEK":
                    otherField.setText(String.valueOf((sekNok * otherTemp)));
                    other.setText("SEK");
                }
            }
        }catch (Exception ex) {
            if(click.equals("Avslutt")) {
                System.exit(1);
            }
            else if (click.equals("Rens NOK")) {
                nokField.setText("");
            }
            else if(click.equals("Rens OTHER")) {
                otherField.setText("");
                other.setText("Other");
            }
            else if (click.equals("Rens")) {
                otherField.setText("");
                nokField.setText("");
                other.setText("Other");
            }
        }
    }
}