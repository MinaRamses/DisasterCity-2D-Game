package view;

import javax.swing.JButton;

import simulation.Address;
import simulation.Rescuable;

public class mapbutton extends JButton {

Address adress;
int x;
int y;
Rescuable r;
public mapbutton(int x,int y, Rescuable r) {
	super();
	this.x=x;
	this.y=y;
	this.adress= new Address(x,y);
	this.r= r;
}
public mapbutton(int x,int y) {
	super();
	this.x=x;
	this.y=y;
	this.adress= new Address(x,y);
	//this.r= r;
}

}
