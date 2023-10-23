import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player1_turn;
	
	public TicTacToe(){
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(0,100,100));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		textfield.setForeground(new Color(0,0,255));
		textfield.setFont(new Font("Metal Mania", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Tic-Tac-Toe");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3,3));
		button_panel.setBackground(new Color(211,211,211));
		
		for(int i = 0; i<9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].setOpaque(true);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(textfield);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		
		JButton resetButton = new JButton("Reset");
		resetButton.setBackground(new Color(211,211,211));
		resetButton.setForeground(new Color(0,0,255));
		resetButton.setFont(new Font("MV Boli", Font.BOLD, 30));
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetGame();
			}
		});
		title_panel.add(resetButton, BorderLayout.EAST);
		
		resetGame();
		}	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				// Player vs. Player mode
		        if (player1_turn) {
		        	if (buttons[i].getText().isEmpty()) {
		        		buttons[i].setForeground(Color.MAGENTA);
		                buttons[i].setText("X");
		                player1_turn = false;
		                textfield.setText("O Turn");
		                check();
		             }
		        } else {
		        	if (buttons[i].getText().isEmpty()) {
		        		buttons[i].setForeground(new Color(255, 0, 0));
		                buttons[i].setText("O");
		                player1_turn = true;
		                textfield.setText("X Turn");
		                check();
		        		}
		            }
		        }
		    }
		}

	
	public void firstTurn() {
		player1_turn = false;
		textfield.setText("O Turn");
	}
	public void check() {
		boolean draw = true;
		
		if((buttons[0].getText() == "X") && (buttons[1].getText() == "X") && (buttons[2].getText() == "X")) {
			xWins(0,1,2);
			draw = false;
		}
		if((buttons[3].getText() == "X") && (buttons[4].getText() == "X") && (buttons[5].getText() == "X")) {
			xWins(3,4,5);
			draw = false;
		}
		if((buttons[6].getText() == "X") && (buttons[7].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(6,7,8);
			draw = false;
		}
		if((buttons[0].getText() == "X") && (buttons[3].getText() == "X") && (buttons[6].getText() == "X")) {
			xWins(0,3,6);
			draw = false;
		}
		if((buttons[1].getText() == "X") && (buttons[4].getText() == "X") && (buttons[7].getText() == "X")) {
			xWins(1,4,7);
		}
		if((buttons[2].getText() == "X") && (buttons[5].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(2,5,8);
			draw = false;
		}
		if((buttons[0].getText() == "X") && (buttons[4].getText() == "X") && (buttons[8].getText() == "X")) {
			xWins(0,4,8);
			draw = false;
		}
		if((buttons[2].getText() == "X") && (buttons[4].getText() == "X") && (buttons[6].getText() == "X")) {
			xWins(2,4,6);
			draw = false;
		}
		if((buttons[0].getText() == "O") && (buttons[1].getText() == "O") && (buttons[2].getText() == "O")) {
			oWins(0,1,2);
			draw = false;
		}
		if((buttons[3].getText() == "O") && (buttons[4].getText() == "O") && (buttons[5].getText() == "O")) {
			oWins(3,4,5);
			draw = false;
		}
		if((buttons[6].getText() == "O") && (buttons[7].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(6,7,8);
			draw = false;
		}
		if((buttons[0].getText() == "O") && (buttons[3].getText() == "O") && (buttons[6].getText() == "O")) {
			oWins(0,3,6);
			draw = false;
		}
		if((buttons[1].getText() == "O") && (buttons[4].getText() == "O") && (buttons[7].getText() == "O")) {
			oWins(1,4,7);
			draw = false;
		}
		if((buttons[2].getText() == "O") && (buttons[5].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(2,5,8);
			draw = false;
		}
		if((buttons[0].getText() == "O") && (buttons[4].getText() == "O") && (buttons[8].getText() == "O")) {
			oWins(0,4,8);
			draw = false;
		}
		if((buttons[2].getText() == "O") && (buttons[4].getText() == "O") && (buttons[6].getText() == "O")) {
			oWins(2,4,6);
			draw = false;
		}
		if(draw) {
			for(int i = 0; i < 9; i++) {
				if(buttons[i].getText().isEmpty()) {
					draw = false;
					break;
				}
			}
			if(draw) {
				textfield.setText("It's a draw!");
			}
		}
	}
	public void xWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0;i < 9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X Wins");
	}
	public void oWins(int a, int b, int c) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0;i < 9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O Wins");
	}
	public void resetGame() {
		for(int i = 0; i < 9; i++) {
			buttons[i].setText("");
			buttons[i].setBackground(null);
			buttons[i].setEnabled(true);
		}
		firstTurn();
		textfield.setText("Tic-Tac-Toe");
	}
}
