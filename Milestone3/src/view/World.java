package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import simulation.Address;

public class World extends JFrame implements ActionListener {

	
	//private Cell[][] mmm;
	Address [][] map = new Address [10][10];
	
	public World() {
	super();
	this.setLayout(new GridLayout(10,10));
	for (int i = 0; i < map.length; i++) {
		for (int j = 0; j < map[i].length; j++) {
			map[i][j] = new Address(i,j);
			//this.add(map[i][j]);
		}
		
	}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
