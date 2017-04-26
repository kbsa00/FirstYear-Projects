import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.*;
import java.io.*;
import java.util.Scanner;

public class Note extends JFrame implements ActionListener
{
    private JTextArea txaTextArea;
    private JMenu file;
    private JMenu edit; 
    private JMenu Help; 
    private JMenuBar mnubar; 
    private JMenuItem avslutt;
    private JMenuItem hent;
    private JMenuItem save;
    private JMenuItem size; 
    private JScrollPane scroll; 

    public Note (){
        super("Enkel NotePad");
        JPanel pnlSouth =
            new JPanel(new GridLayout(1, 3));

        txaTextArea = new JTextArea();
        txaTextArea.setLineWrap(true);
        txaTextArea.setWrapStyleWord(true);
        scroll = new JScrollPane(txaTextArea);

        add(txaTextArea, BorderLayout.CENTER);
        add(pnlSouth, BorderLayout.SOUTH);
        setSize(450,300);

        file = new JMenu("File"); 
        edit = new JMenu("Format"); 
        Help = new JMenu("Edit"); 
        avslutt = new JMenuItem("Avslutt");
        hent = new JMenuItem("Hent");
        save = new JMenuItem("Save"); 

        Font f = new Font(Font.MONOSPACED, Font.BOLD, 20);
        txaTextArea.setFont(f);
        

        avslutt.addActionListener(this);
        hent.addActionListener(this); 
        save.addActionListener(this); 
        
       
      
        file.add(avslutt);
        file.add(hent); 
        file.add(save);
        scroll = new JScrollPane(txaTextArea);
        add(scroll, BorderLayout.CENTER);

        JMenuBar mnubar = new JMenuBar();
        mnubar.add(file);
        mnubar.add(edit); 
        mnubar.add(Help);
        setJMenuBar(mnubar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object click = e.getSource();

        if(click == avslutt)
        {
            System.exit(0);
        }
        if (click == hent) {
            txaTextArea.setText("");
            try{
                String fileName =
                    showInputDialog(this, "Filnavn");
                Scanner fileIn =
                    new Scanner(new File(fileName));
                while (fileIn.hasNext()){
                    String data = fileIn.nextLine();
                    txaTextArea.append(data + "\n");
                }
                fileIn.close();
            }catch (IOException ioex){
                JOptionPane.showMessageDialog(
                    this, "IO-feil: "
                    + ioex.getMessage());
            }
        }   else
        if (click == save) {
            try{
                String fileName = 
                    showInputDialog(this, "Filnavn");
                PrintWriter fileOut =
                    new PrintWriter(new File(fileName));
                fileOut.println(txaTextArea.getText());
                fileOut.close();
            }catch (IOException ioex){
                JOptionPane.showMessageDialog(
                    this, "IO-feil: "
                    + ioex.getMessage());
            }
        }
    }
}
