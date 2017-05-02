import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;

/**
 * Written by: Khalid B Said..
 *  A Memory list application with a nice interface..
 */

public class MemoryList extends JFrame implements ListSelectionListener, ActionListener
{
    private JList<String> liste;
    private DefaultListModel<String> listedata;
    private JButton btnAdd, btnRemove, btnExit;
    private int selectedIndex = -1;

    public MemoryList()
    {
        setTitle("Huskelapp");
        JPanel pnlButtons = new JPanel(new GridLayout(1,3));
        btnAdd = new JButton("Add");
        btnRemove = new JButton("Remove");
        btnExit = new JButton("Exit");

        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnExit.addActionListener(this);

        pnlButtons.add(btnAdd);
        pnlButtons.add(btnRemove);
        pnlButtons.add(btnExit);

        add(pnlButtons, BorderLayout.SOUTH);

        listedata = new DefaultListModel<String>();
        liste = new JList<String>(listedata);
        liste.addListSelectionListener(this);
        add(liste, BorderLayout.CENTER);
        setSize(500, 200);
        setVisible(true);
    }
    public String removeLine(int index)
    {
        if(index < 0)
        {
            JOptionPane.showMessageDialog(this, "Velg en linje!");
            return null;

        }

        return listedata.remove(index);

    }

    public void actionPerformed(ActionEvent e)
    {
        Object click = e.getSource();
        if(click == btnExit)
        {
            System.exit(0);
        }
        else if (click == btnAdd)
        {
            String data = JOptionPane.showInputDialog(this, "Skriv en linje");
            listedata.addElement(data);
        }
        else if(click == btnRemove)
        {
            String removed = removeLine(selectedIndex);
            JOptionPane.showMessageDialog(this, removed + "er fjernet");



        }
    }

    public void valueChanged(ListSelectionEvent l)
    {
        selectedIndex = liste.getSelectedIndex();
    }


    public static void main(String[] args) {
        MemoryList m1 = new MemoryList();
    }
}