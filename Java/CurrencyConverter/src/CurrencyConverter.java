import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 * Created by Khalid B. Said on 4/27/17.
 *
 * This is a simple Currency Converter with a nice and friendly interface. You can check how much the Norwegian Currency
 * is too EURO, USD, SEK and GBP. You are also able to check how much the foreign currency is to the Norwegian Currency.;)
 *
 */

public class CurrencyConverter extends JFrame implements ActionListener {
    private JButton gbp, usd, eur, sek, exit, cleanNOK, cleanOther, cleanBoth;
    private JTextField box1, box2;

    private JLabel other;
    private double sum, num;

    /**
     * Here is the constructer of the class CurrencyConverter. In here I'm creating everything from frame size, buttons
     * textfield and then put them in their right positions.
     */

    public CurrencyConverter() {
        setTitle("Currency Converter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 150);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel pnlnorth = new JPanel(new GridLayout(1, 3));
        JPanel pnlcenter = new JPanel(new GridLayout(2, 2));
        JPanel pnlsouth = new JPanel(new GridLayout(1, 4));

        JLabel nok = new JLabel("NOK");
        box1 = new JTextField();
        pnlnorth.add(nok);
        pnlnorth.add(box1);


        JLabel other = new JLabel("Other value");
        box2 = new JTextField();
        pnlnorth.add(other);
        pnlnorth.add(box2);

        add(pnlnorth, BorderLayout.NORTH);

        gbp = new JButton("GBP");
        usd = new JButton("USD");
        eur = new JButton("EUR");
        sek = new JButton("SEK");

        gbp.addActionListener(this);
        usd.addActionListener(this);
        eur.addActionListener(this);
        sek.addActionListener(this);

        pnlcenter.add(gbp);
        pnlcenter.add(eur);
        pnlcenter.add(usd);
        pnlcenter.add(sek);
        add(pnlcenter, BorderLayout.CENTER);


        exit = new JButton("EXIT");
        cleanNOK = new JButton("CLEAN NOK");
        cleanOther = new JButton("CLEAN OTHER");
        cleanBoth = new JButton("CLEAN BOTH");

        exit.addActionListener(this);
        cleanNOK.addActionListener(this);
        cleanOther.addActionListener(this);
        cleanBoth.addActionListener(this);

        pnlsouth.add(cleanNOK);
        pnlsouth.add(cleanOther);
        pnlsouth.add(cleanBoth);
        pnlsouth.add(exit);

        add(pnlsouth, BorderLayout.SOUTH);


        setVisible(true);
    }

    /**
     * Method to reverse the calculations of the currency. This method allows the user to check the currency from
     * GBP, USD, EURO and SEK to the Norwegian currency.
     */

    public boolean methodForCurrency() {
        return box2.getText().equals("");
    }


    /**
     * In the method of actionPerfomed i'm simply telling what each of the buttons are supposed to do when
     * you click on them. I'm also putting in all of their own calculations for the user to find out the currency.
     * I've also created Error Messages if two textfields are empty or if the user write into two textfields
     * instead of only one.
     */

    public void actionPerformed(ActionEvent e) {
        String click = e.getActionCommand();

        try {
            switch (click) {
                case "GBP":
                    if (!box1.getText().equals("") && !box2.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "You cant write two numbers. Please only write one");
                    } else if (methodForCurrency()) {
                        num = Double.parseDouble(box1.getText());
                        sum = num * 0.09;
                        box2.setText(Double.toString(sum));
                        other.setText("GBP");

                    } else {
                        num = Double.parseDouble(box2.getText());
                        sum = num * 11.04;
                        box1.setText(Double.toString(sum));
                        other.setText("GBP");
                    }
                    break;
                case "EUR":

                    if (!box1.getText().equals("") && !box2.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "You cant write two numbers. Please only write one");
                    } else if (methodForCurrency()) {
                        num = Double.parseDouble(box1.getText());
                        sum = num * 0.11;
                        box2.setText(Double.toString(sum));
                        other.setText("EUR");
                    } else {
                        num = Double.parseDouble(box2.getText());
                        sum = num * 9.32;
                        box2.setText(Double.toString(sum));
                        other.setText("EUR");
                    }
                    break;

                case "USD":

                    if (!box1.getText().equals("") && !box2.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "You can't write two numbers. Please only write one");
                    } else if (methodForCurrency()) {
                        num = Double.parseDouble(box1.getText());
                        sum = num * 0.12;
                        box2.setText(Double.toString(sum));
                        other.setText("USD");
                    } else {
                        num = Double.parseDouble(box2.getText());
                        sum = num * 8.56;
                        box1.setText(Double.toString(sum));
                        other.setText("USD");
                    }

                    break;

                case "SEK":

                    if (!box1.getText().equals("") && !box2.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "You cant write two numbers. Please only write one.");
                    } else if (methodForCurrency()) {
                        num = Double.parseDouble(box1.getText());
                        sum = num * 1.03;
                        box2.setText(Double.toString(sum));
                        other.setText("SEK");
                    } else {
                        num = Double.parseDouble(box2.getText());
                        sum = num * 0.97;
                        box1.setText(Double.toString(sum));
                        other.setText("SEK");
                    }
                    break;

                case "CLEAN BOTH":
                    box1.setText("");
                    box2.setText("");

                    break;

                case "CLEAN NOK":
                    box1.setText("");

                    break;


                case "EXIT":
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?");

                    if (choice == YES_OPTION) {
                        System.exit(0);
                    }

                    break;

                case "CLEAN OTHER":
                    box2.setText("");

                    break;

            }
        } catch (Exception ex) {
            if (box1.getText().equals("") && box2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "The boxes are empty, Please write a number.");
            }
        }
    }


    public static void main(String[] args) {
        CurrencyConverter c = new CurrencyConverter();
    }
}







