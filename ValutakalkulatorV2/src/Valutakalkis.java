import clojure.lang.IFn;
import clojure.lang.Obj;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import static javax.swing.JOptionPane.YES_OPTION;

/**
 * Created by khalidsaid on 02.05.17.
 */
public class Valutakalkis extends JFrame {



    private pnlnorth north;
    private pnlcenter center;
    private pnlsouth south;

    private class pnlnorth extends JPanel {
        private JLabel nok;
        private JLabel other;

        private JTextField noktxt;
        private JTextField othertxt;
        private JPanel panelnorth;


        public pnlnorth() {
            panelnorth = new JPanel(new GridLayout(1, 3));

            nok = new JLabel("NOK");
            noktxt = new JTextField();
            panelnorth.add(nok);
            panelnorth.add(noktxt);

            other = new JLabel("Other Value");
            othertxt = new JTextField();
            panelnorth.add(other);
            panelnorth.add(othertxt);


        }

        public JPanel getPanelnorth() {
            return panelnorth;
        }

        public JTextField getNoktxt() {
            return noktxt;
        }

        public void setNoktxt(JTextField noktxt) {
            this.noktxt = noktxt;
        }

        public JTextField getOthertxt() {
            return othertxt;
        }

        public void setOthertxt(JTextField othertxt) {
            this.othertxt = othertxt;
        }

        public JLabel getNok() {
            return nok;
        }

        public void setNok(JLabel nok) {
            this.nok = nok;
        }

        public JLabel getOther() {
            return other;
        }

        public void setOther(JLabel other) {
            this.other = other;
        }
    }

    private class pnlcenter implements ActionListener {

        private JButton gbp, usd, eur, sek;
        private double num, sum;
        private JPanel panelcenter;


        public pnlcenter() {
            panelcenter = new JPanel(new GridLayout(2, 2));

            gbp = new JButton("GBP");
            usd = new JButton("USD");
            eur = new JButton("EUR");
            sek = new JButton("SEK");

            gbp.addActionListener(this);
            usd.addActionListener(this);
            eur.addActionListener(this);
            sek.addActionListener(this);

            panelcenter.add(gbp);
            panelcenter.add(usd);
            panelcenter.add(eur);
            panelcenter.add(sek);


        }

        public JPanel getPanelcenter() {
            return panelcenter;
        }

        public boolean methodforCurrency() {
            return north.getOthertxt().getText().equals("");

        }


        public void actionPerformed(ActionEvent e) {
            String click = e.getActionCommand();
            try {
                switch (click) {
                    case "GBP":

                        if (!north.getOthertxt().getText().equals("") && !north.getNoktxt().equals("")) {
                            JOptionPane.showMessageDialog(null, "The both boxes are full..");
                        }
                        else if (methodforCurrency()) {
                            num = Double.parseDouble(north.getNoktxt().getText());
                            sum = num * 0.09;
                            north.getOthertxt().setText(Double.toString(sum));
                            north.getOther().setText("GBP");
                        } else {
                            num = Double.parseDouble(north.getOthertxt().getText());
                            sum = num * 11.04;
                            north.getNoktxt().setText(Double.toString(sum));
                            north.getOther().setText("GBP");
                        }
                        break;


                    case "USD":

                        if (!north.getOthertxt().getText().equals("") && !north.getNoktxt().equals("")) {
                            JOptionPane.showMessageDialog(null, "The boxes are full");
                        } else if (methodforCurrency()) {
                            num = Double.parseDouble(north.getNoktxt().getText());
                            sum = num * 0.12;
                            north.getOthertxt().setText(Double.toString(sum));
                            north.getOther().setText("USD");
                        } else {
                            num = Double.parseDouble(north.getOthertxt().getText());
                            sum = num * 8.56;
                            north.getNoktxt().setText(Double.toString(sum));
                            north.getOther().setText("USD");
                        }
                        break;

                    case "EUR":

                        if (!north.getOthertxt().getText().equals("") && !north.getNoktxt().equals("")) {
                            JOptionPane.showMessageDialog(null, "The boxes are full");
                        } else if (methodforCurrency()) {
                            num = Double.parseDouble(north.getNoktxt().getText());
                            sum = num * 0.11;
                            north.getOthertxt().setText(Double.toString(sum));
                        } else {
                            num = Double.parseDouble(north.getOthertxt().getText());
                            sum = num * 9.32;
                            north.getNoktxt().setText(Double.toString(sum));
                            north.getOther().setText("EUR");
                        }
                        break;

                    case "SEK":

                        if (!north.getNoktxt().getText().equals("") && !north.getOthertxt().equals("")) {
                            JOptionPane.showMessageDialog(null, "The boxes are full");

                        } else if (methodforCurrency()) {
                            num = Double.parseDouble(north.getNoktxt().getText());
                            sum = num * 1.03;
                            north.getOthertxt().setText(Double.toString(sum));
                            north.getOther().setText("SEK");
                        } else {
                            num = Double.parseDouble(north.getOthertxt().getText());
                            sum = num * 0.97;
                            north.getNoktxt().setText(Double.toString(sum));
                            north.getOther().setText("SEK");
                        }
                        break;
                }
            } catch (Exception ex) {
                if (north.getNoktxt().getText().equals("") && north.getOthertxt().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "The boxes are empty, Please write a number");

                }


            }


        }

    }


    private class pnlsouth implements ActionListener {

        private JButton clearNOK, cleanOther, cleanBoth, exit;
        private JPanel panelsouth;

        public pnlsouth() {
            panelsouth = new JPanel(new GridLayout(1, 3));

            clearNOK = new JButton("Clear NOK");
            cleanOther = new JButton("Clean Other Value");
            cleanBoth = new JButton("Clean Both");
            exit = new JButton("Exit");

            clearNOK.addActionListener(this);
            cleanOther.addActionListener(this);
            cleanBoth.addActionListener(this);
            exit.addActionListener(this);

            panelsouth.add(clearNOK);
            panelsouth.add(cleanOther);
            panelsouth.add(cleanBoth);
            panelsouth.add(exit);


        }

        public JPanel getPanelsouth() {
            return panelsouth;
        }

        public void actionPerformed(ActionEvent event) {
            String click = event.getActionCommand();

            switch (click) {
                case "Clear NOK":
                    north.getNoktxt().setText("");
                    break;

                case "Clean Other Value":
                    north.getOthertxt().setText("");
                    break;

                case "Clean Both":
                    north.getNoktxt().setText("");
                    north.getOthertxt().setText("");
                    break;

                case "Exit":
                    int choice = JOptionPane.showConfirmDialog(null, "Are you sure that you want to close the program?");
                    if (choice == YES_OPTION)
                    {
                        System.exit(0);
                    }

                    break;


            }

        }
    }


    public Valutakalkis()
    {
     setTitle("Currency Converter");
     setSize(480,180);
      setLocationRelativeTo(null);
      north = new pnlnorth();
      south = new pnlsouth();
      center = new pnlcenter();


     add(north.getPanelnorth(), BorderLayout.NORTH);
     add(center.getPanelcenter(), BorderLayout.CENTER);
     add(south.getPanelsouth(), BorderLayout.SOUTH);


     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);
    }

    public static void main(String[] args) {
        Valutakalkis v = new Valutakalkis();
    }
}
