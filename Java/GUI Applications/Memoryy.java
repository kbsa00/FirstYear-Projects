import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Memoryy extends JFrame implements ActionListener {
	private final int ROWS, COLS, SIZE;
	// must be boxed as Integer (not just int), to enable Collections.shuffle later
	private Integer[] hiddenNumbers;
	private JButton[] gridButtons;
	private ArrayList<Integer> clickHistory;
	
	/*
	 * Setup GUI and start game
	 */
	public Memoryy(int rows, int cols){
		super("MEMORY");
		ROWS = rows;
		COLS = cols;
		SIZE = ROWS * COLS;
		clickHistory = new ArrayList<Integer>(2);
		gridButtons = new JButton[SIZE];
		hiddenNumbers = new Integer[SIZE];
		
		// Create grid-panel with X*Y buttons
		JPanel pnlNumbers = new JPanel(new GridLayout(ROWS, COLS));
		for(int i = 0; i < gridButtons.length; i++){
			JButton button = new JButton();
			button.addActionListener(this);
			gridButtons[i] = button;
			pnlNumbers.add(button);
		}

		// Create menu panel
		JPanel pnlMenu = new JPanel(new GridLayout(1, 2));
		JButton btnRestart = new JButton("Start på nytt");
		btnRestart.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				initialize();
			}
		});
		JButton btnQuit = new JButton("Avslutt");
		btnQuit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		pnlMenu.add(btnRestart);
		pnlMenu.add(btnQuit);
		
		// Finalize GUI and start game
		add(pnlNumbers, BorderLayout.CENTER);
		add(pnlMenu, BorderLayout.SOUTH);
		
		initialize();
		
		setSize(75 * ROWS, 75 * COLS); // 75*4 = 300
		setLocationRelativeTo(null); // center window on screen
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/*
	 * Prepares for a new round by randomizing numbers and resetting buttons
	 */
	public void initialize() {
		// Generate number pairs (0-0, 1-1 .. (n-1)-(n-1)) and shuffle these
		int midWayIndex = hiddenNumbers.length/2;
		for(int i = 0; i < midWayIndex; i++){
			hiddenNumbers[i] = i;
			hiddenNumbers[midWayIndex + i] = i;
		}
		Collections.shuffle(Arrays.asList(hiddenNumbers));
		
		// Prepare buttons
		for(JButton button : gridButtons){
			resetButton(button);
		}
		clickHistory.clear();
	}
	
	private void resetButton(JButton button) {
		button.setEnabled(true);
		button.setText("");
	}
	
	/*
	 * Handle button-clicks and check if the last two locations have equal
	 * numbers
	 */
	public void actionPerformed(ActionEvent event) {
		// Find clicked button, add it's index to click-stack and update GUI
		JButton source = (JButton) event.getSource();
		for(int i = 0; i < gridButtons.length; i++) {
			if(source == gridButtons[i]) {
				clickHistory.add(i);
				source.setText(hiddenNumbers[i] + "");
				source.setEnabled(false);
			}
		}
		
		// Determine when three buttons have been clicked, and then:
		// If number of button 1 equals number of button 2, let them stay on screen. 
		// If different, flip these buttons back (reset) and let the user try again.
		if(clickHistory.size() == 3) {
			int firstIndex = clickHistory.get(0);
			int secondIndex = clickHistory.get(1);
			
			if(hiddenNumbers[firstIndex] != hiddenNumbers[secondIndex]){
				resetButton(gridButtons[firstIndex]);
				resetButton(gridButtons[secondIndex]);
			}
			
			clickHistory.subList(0, 2).clear();
		}
	}
}