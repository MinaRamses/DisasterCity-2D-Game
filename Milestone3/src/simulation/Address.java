package simulation;

import javax.swing.JButton;

public class Address extends JButton {
private int x;
private int y;
Rescuable r;
public Address(int x, int y) {
	this.x = x;
	this.y = y;
	
}

public int getX() {
	return x;
}
public int getY() {
	return y;
}
@Override
	public String toString() {
		return x + " x " + y;
	}
}
