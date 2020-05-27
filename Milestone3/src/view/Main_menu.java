package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main_menu extends JFrame implements ActionListener {

	String player1;
	
	JLabel player1name;

	JTextField player1nametext;
	
	JButton start;
	JPanel first;
	JButton newGame;
	
	public Main_menu() {
		super();
		
		setSize(1000, 1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		newGame = new JButton("Start New Game");
		this.add(newGame);
		newGame.addActionListener(this);
		newGame.setActionCommand("Start New Game");

		player1name = new JLabel();
		player1name.setBackground(Color.WHITE);
		player1name.setVisible(false);
		player1name.setText("Please enter your name:    ");
		player1name.setForeground(Color.WHITE);

		player1nametext = new JTextField();
		player1nametext.setBackground(Color.WHITE);
		player1nametext.setVisible(false);

		start = new JButton("Start");
		start.setBackground(Color.WHITE);
		start.setVisible(false);
		start.addActionListener(this);

		first = new JPanel();
		first.setBackground(Color.MAGENTA);
		first.setVisible(true);
		first.setLayout(new GridLayout(4, 1));

		this.add(first);
		first.add(newGame);
		first.add(player1name);
		first.add(player1nametext);
		first.add(start);

		this.setTitle("Main Menu");

		repaint();
		revalidate();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start New Game")) {
			player1name.setVisible(true);
			player1nametext.setVisible(true);
			start.setVisible(true);
			newGame.setVisible(false);

			
		} else if (e.getActionCommand().equals("Start")) {
		
				start.setVisible(true);
			if (!(player1nametext.getText().equals(""))) {
				
				try {
					Game_view m = new Game_view();
					this.setContentPane(m.mina);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				repaint();
				revalidate();
			} else {
				JOptionPane.showMessageDialog(null, "Please Enter a name!");
			}
		}
		

	}

	public static void main(String[] args) throws Exception {
		Main_menu x = new Main_menu();
		// Simulator game = new Simulator();
	}
}
