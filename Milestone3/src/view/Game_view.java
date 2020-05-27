package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import controller.CommandCenter;
import exceptions.BuildingAlreadyCollapsedException;
import exceptions.CannotTreatException;
import exceptions.CitizenAlreadyDeadException;
import exceptions.IncompatibleTargetException;
import model.disasters.Collapse;
import model.events.SOSListener;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.people.CitizenState;
import model.units.Evacuator;
import model.units.Unit;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulator;

public class Game_view extends JFrame implements ActionListener, SOSListener {

	JPanel mina;

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();

	JButton startC = new JButton();

	JButton amb = new JButton("Ambulance");
	JButton dcu = new JButton("Disease Control Unit");
	JButton eva = new JButton("Evacuator");
	JButton frk = new JButton("Fire Truck");
	JButton gcu = new JButton("Gas Control Unit");

	JTextArea info;
	JTextArea unitInfo;
	JTextArea current;
	JTextArea Disasterr;

	int x;
	int y;

	// JComboBox<String> unitChoices;
	// JLabel trial = new JLabel();

	Simulator Game;

	CommandCenter GAME;

	boolean buttonSelected = false;
	int selectedItemX;
	int selectedItemY;
	Rescuable r;

	public Game_view() throws Exception {

		super();

		mina = new JPanel();

		Game = new Simulator(this);
		GAME = new CommandCenter();

		amb.setVisible(false);
		amb.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				unitInfo.setText("");
//				mapbutton b;
				String text = "";
				String id = "";
				String type = "";
				String location = "";
				String spc = "";
				String target = "";
				String state = "";

				id = ((Game.getEmergencyUnits().get(0)).getUnitID());
				type = ((Game.getEmergencyUnits().get(0)).getClass().getSimpleName());
				location = ((Game.getEmergencyUnits().get(0)).getLocation()) + "";
				spc = ((Game.getEmergencyUnits().get(0)).getStepsPerCycle()) + "";
				target = ((Game.getEmergencyUnits().get(0)).getTarget()) + "";
				state = ((Game.getEmergencyUnits().get(0)).getState()) + "";
				text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
						+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state + "\n"
						+ "---------------" + "\n";
				unitInfo.append(text);

				// panel2.add(unitInfo, BorderLayout.SOUTH);
				// panel2.setSize(new Dimension(250, 150));

				// ((Unit) Ambulance).respond(( ((Unit) Ambulance).getTarget()));
//				if (((Unit) Ambulance).getTarget().getLocation().getX() == b.x
//						&& ((Unit) Ambulance).getTarget().getLocation().getY() == b.y) {
//					((Unit) Ambulance).respond(((Unit) Ambulance).getTarget());
//				}

				if (buttonSelected == true) {
					Address a = new Address(selectedItemX, selectedItemY);
					Game.getEmergencyUnits().get(0).setLocation(a);

					try {
						Game.getEmergencyUnits().get(0).respond(r);
					} catch (IncompatibleTargetException e1) {
						JOptionPane.showMessageDialog(null, "Ambulance cannot respond to Building");
						// e1.printStackTrace();
					} catch (CannotTreatException e1) {
						JOptionPane.showMessageDialog(null, "Ambulane cannot treat this Citizen, The Citizen is safe");
						// e1.printStackTrace();
					}

				}

				repaint();
				revalidate();

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		dcu.setVisible(false);
		dcu.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				unitInfo.setText("");
				String text = "";
				String id = "";
				String type = "";
				String location = "";
				String spc = "";
				String target = "";
				String state = "";

				id = ((Game.getEmergencyUnits().get(1)).getUnitID());
				type = ((Game.getEmergencyUnits().get(1)).getClass().getSimpleName());
				location = ((Game.getEmergencyUnits().get(1)).getLocation()) + "";
				spc = ((Game.getEmergencyUnits().get(1)).getStepsPerCycle()) + "";
				target = ((Game.getEmergencyUnits().get(1)).getTarget()) + "";
				state = ((Game.getEmergencyUnits().get(1)).getState()) + "";
				text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
						+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state + "\n"
						+ "---------------" + "\n";
				unitInfo.append(text);
				panel2.add(unitInfo, BorderLayout.SOUTH);
//				panel2.setSize(new Dimension(250, 150));

				if (buttonSelected == true) {
					Address a = new Address(selectedItemX, selectedItemY);
					Game.getEmergencyUnits().get(1).setLocation(a);
//					map();

					try {
						Game.getEmergencyUnits().get(1).respond(r);
					} catch (IncompatibleTargetException e1) {
						JOptionPane.showMessageDialog(null, "Diseace Control Unit cannot respond to Building");
						// e1.printStackTrace();
					} catch (CannotTreatException e1) {
						JOptionPane.showMessageDialog(null,
								"Disease Control Unit cannot treat this Citizen, The Citizen is safe");
						// e1.printStackTrace();
					}

				}

				repaint();
				revalidate();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		eva.setVisible(false);

		eva.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				unitInfo.setText("");
				String text = "";
				String id = "";
				String type = "";
				String location = "";
				String spc = "";
				String target = "";
				String state = "";
				String numPass = "";
				String infoPass = "Passengers:";

				id = ((Game.getEmergencyUnits().get(2)).getUnitID());
				type = ((Game.getEmergencyUnits().get(2)).getClass().getSimpleName());
				location = ((Game.getEmergencyUnits().get(2)).getLocation()) + "";
				spc = ((Game.getEmergencyUnits().get(2)).getStepsPerCycle()) + "";
				target = ((Game.getEmergencyUnits().get(2)).getTarget()) + "";
				state = ((Game.getEmergencyUnits().get(2)).getState()) + "";
				text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
						+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state;

				numPass = ((Evacuator) Game.getEmergencyUnits().get(2)).getPassengers().size() + "" + "/"
						+ ((Evacuator) Game.getEmergencyUnits().get(2)).getMaxCapacity() + "";

				for (int j = 0; j < ((Evacuator) Game.getEmergencyUnits().get(2)).getPassengers().size(); j++) {
					text = "";

					Citizen c = (Citizen) ((Evacuator) Game.getEmergencyUnits().get(2)).getPassengers().get(j);
					String name = "Name: " + c.getName();
					String age = "Age: " + c.getAge();
					String idC = "National ID: " + c.getNationalID();
					String hp = "Hp: " + c.getHp();
					String bloodLoss = "Blood Loss: " + c.getBloodLoss();
					String toxi = "Toxicity: " + c.getToxicity();
					String state2 = "Citizen State: " + c.getState();
					infoPass = name + "\n" + age + "\n" + idC + "\n" + hp + "\n" + bloodLoss + "\n" + toxi + "\n"
							+ state2;
					text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
							+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state + "\n"
							+ "Evacuator Info: " + "\n" + "Number Of Passengers: " + numPass + "\n"
							+ "Passengers Info: " + infoPass;
				}
				// unitInfo = new JTextArea();
				unitInfo.append(text);
				TitledBorder infoo = BorderFactory.createTitledBorder("Unit Information");
				unitInfo.setBorder(infoo);
				JScrollPane blablabla = new JScrollPane(unitInfo);
				panel5.add(blablabla, BorderLayout.CENTER);

				// info.setSize(20, 100);
				// info.setPreferredSize(new Dimension(200, 50));

				unitInfo.setEditable(false);
				unitInfo.setLineWrap(true);

				panel2.add(unitInfo);
//				panel2.setSize(new Dimension(250, 150));

				if (buttonSelected == true) {
					Address a = new Address(selectedItemX, selectedItemY);
					Game.getEmergencyUnits().get(2).setLocation(a);
//					map();

					try {
						Game.getEmergencyUnits().get(2).respond(r);
					} catch (IncompatibleTargetException e1) {
						JOptionPane.showMessageDialog(null, "Evacuator cannot respond to a Citizen");
						// e1.printStackTrace();
					} catch (CannotTreatException e1) {
						JOptionPane.showMessageDialog(null,
								"Evacuator cannot respond to this Building, The Building must be Collpased to use the Evacuator");
						// e1.printStackTrace();
					}

				}

				repaint();
				revalidate();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		frk.setVisible(false);

		frk.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				unitInfo.setText("");
				String text = "";
				String id = "";
				String type = "";
				String location = "";
				String spc = "";
				String target = "";
				String state = "";
//				String numPass = "";
//				String infoPass = "Passengers:";
//				Address a = b.adress;

				id = ((Game.getEmergencyUnits().get(3)).getUnitID());
				type = ((Game.getEmergencyUnits().get(3)).getClass().getSimpleName());
				location = ((Game.getEmergencyUnits().get(3)).getLocation()) + "";
				spc = ((Game.getEmergencyUnits().get(3)).getStepsPerCycle()) + "";
				target = ((Game.getEmergencyUnits().get(3)).getTarget()) + "";
				state = ((Game.getEmergencyUnits().get(3)).getState()) + "";
				text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
						+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state + "\n"
						+ "---------------" + "\n";
				unitInfo.append(text);
				panel2.add(unitInfo, BorderLayout.SOUTH);
				panel2.setSize(new Dimension(250, 150));

				if (buttonSelected == true) {
					Address a = new Address(selectedItemX, selectedItemY);
					Game.getEmergencyUnits().get(3).setLocation(a);
//					map();

					try {
						Game.getEmergencyUnits().get(3).respond(r);
					} catch (IncompatibleTargetException e1) {
						JOptionPane.showMessageDialog(null, "Fire Truck cannot respond to a Citizen");
						// e1.printStackTrace();
					} catch (CannotTreatException e1) {
						JOptionPane.showMessageDialog(null,
								"Fire Truck cannot respond to this Building, The Building has no FIRE as Disaster");
						// e1.printStackTrace();

					}

				}

				repaint();
				revalidate();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		gcu.setVisible(false);
		gcu.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				unitInfo.setText("");
				String text = "";
				String id = "";
				String type = "";
				String location = "";
				String spc = "";
				String target = "";
				String state = "";
//				String numPass = "";
//				String infoPass = "Passengers:";
//				Address a = b.adress;

				id = ((Game.getEmergencyUnits().get(4)).getUnitID());
				type = ((Game.getEmergencyUnits().get(4)).getClass().getSimpleName());
				location = ((Game.getEmergencyUnits().get(4)).getLocation()) + "";
				spc = ((Game.getEmergencyUnits().get(4)).getStepsPerCycle()) + "";
				target = ((Game.getEmergencyUnits().get(4)).getTarget()) + "";
				state = ((Game.getEmergencyUnits().get(4)).getState()) + "";
				text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
						+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state + "\n"
						+ "---------------" + "\n";

				unitInfo.append(text);
				panel2.add(unitInfo, BorderLayout.SOUTH);
//				panel2.setSize(new Dimension(250, 150));
				if (buttonSelected == true) {
					Address a = new Address(selectedItemX, selectedItemY);
					Game.getEmergencyUnits().get(4).setLocation(a);
//					map();

					try {
						Game.getEmergencyUnits().get(4).respond(r);
					} catch (IncompatibleTargetException e1) {
						JOptionPane.showMessageDialog(null, "Gas Control Unit cannot respond to a Citizen");
						// e1.printStackTrace();
					} catch (CannotTreatException e1) {
						JOptionPane.showMessageDialog(null,
								"Gas Control Unit cannot respond this Building, The Building has no GAS LEAK as Disaster");
						// e1.printStackTrace();
					}

				}
				repaint();
				revalidate();
				buttonSelected = false;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		startC.setText("Next Cycle");
		startC.setVisible(true);
		startC.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				if (Game.checkGameOver()) {
					JOptionPane.showMessageDialog(null,
							"Game Over" + "\n" + "Your Score Is: " + Game.calculateCasualties(), "INFO",
							JOptionPane.INFORMATION_MESSAGE);
					startC.setEnabled(false);
					System.exit(0);
				} else
					try {
						Game.nextCycle();
						current();
					} catch (CannotTreatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (CitizenAlreadyDeadException e1) {
						JOptionPane.showMessageDialog(null, "The target citizen already dead");
						// e1.printStackTrace();
					} catch (BuildingAlreadyCollapsedException e1) {
						JOptionPane.showMessageDialog(null, "The target building already collapsed");
						// e1.printStackTrace();
					} catch (IncompatibleTargetException e1) {

						e1.printStackTrace();
					}
				System.out.println("Mina");

				addDisaters();
				panel3.removeAll();
				mina.remove(panel3);
				// current();
				createMap();
				repaint();
				revalidate();

			}
		});

		panel2.add(startC);
		panel4.add(amb);
		panel4.add(dcu);
		panel4.add(eva);
		panel4.add(frk);
		panel4.add(gcu);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		panel3.setSize(new Dimension(500, 500));

		this.setTitle("Game View");

		mina.setBackground(Color.white);
		mina.setLayout(new BorderLayout());

		panel1.setVisible(true);
		panel1.setLayout(new BorderLayout());

		info = new JTextArea();
		TitledBorder bla = BorderFactory.createTitledBorder("Information Panel");
		info.setBorder(bla);
		JScrollPane blabla = new JScrollPane(info);

		// info.setSize(20, 100);
		info.setPreferredSize(new Dimension(200, 50));

		info.setEditable(false);
		info.setLineWrap(true);
		// info.setLayout(new BorderLayout());
		// panel1.add(info);
		mina.add(blabla, BorderLayout.WEST);

		// this.setContentPane(mina);

		// mina.add(panel3);
		createMap();

		panel2.setPreferredSize(new Dimension(250, 100));
		panel2.setLayout(new GridLayout(5, 7));
		// panel2.setBackground(Color.magenta);
		panel2.setVisible(true);

		// panel2.setLayout(new GridLayout(5, 4));
		// panel2.setLayout(new GridLayout(1, 3));
		unitInfo = new JTextArea();
		TitledBorder infoo = BorderFactory.createTitledBorder("Unit Information");
		unitInfo.setBorder(infoo);
//		JScrollPane blablabla = new JScrollPane(unitInfo);
//		panel5.add(blablabla, BorderLayout.CENTER);
		unitInfo.setEditable(false);
		unitInfo.setLineWrap(true);
		unitInfo.setVisible(true);

		// panel2.add(unitInfo);

		panel4.setVisible(true);
		panel4.setLayout(new GridLayout(5, 7));
		panel2.add(panel4, BorderLayout.CENTER);

		panel5.setVisible(true);
		panel5.setLayout(new BorderLayout());
		panel2.add(panel5, BorderLayout.SOUTH);

		mina.add(panel2, BorderLayout.EAST);
		this.setContentPane(mina);
		repaint();
		revalidate();
	}

//								pizza hut 5578857
	@Override
	public void receiveSOSCall(Rescuable r) {
		// TODO Auto-generated method stub

	}

	public void createMap() {
		// JPanel panel3 = new JPanel();
		// panel3.setPreferredSize(new Dimension(200, 200));
		panel3.setBackground(Color.blue);
		panel3.setVisible(true);
		panel3.setLayout(new GridLayout(10, 10));
		for (int i = 0; i < 100; i++) {

			int col = i % 10;
			int row = i / 10;

			mapbutton x = new mapbutton(col, row);
			x.setVisible(true);
			x.setOpaque(true);
			panel3.add(x);

			for (int z = 0; z < Game.getCitizens().size(); z++) {

				if ((((Address) (((Citizen) (Game.getCitizens().get(z))).getLocation())).getX() == col)
						&& (((Address) (((Citizen) (Game.getCitizens().get(z))).getLocation())).getY() == row)) {
					x.setText("Citizen");
					if (((Citizen) (Game.getCitizens().get(z))).getState() == (CitizenState.DECEASED)) {
						x.setText("Died Cit.");
					}

					x.r = (Citizen) (Game.getCitizens().get(z));
					x.setVisible(true);
					x.setOpaque(true);
					panel3.add(x);
					x.addActionListener(this);
				}
			}

			for (int z = 0; z < Game.getBuildings().size(); z++) {
				if ((((Address) (((ResidentialBuilding) (Game.getBuildings().get(z))).getLocation())).getX() == col)
						&& (((Address) (((ResidentialBuilding) (Game.getBuildings().get(z))).getLocation()))
								.getY() == row)) {

					x.setText("Building");

					if (((ResidentialBuilding) (Game.getBuildings().get(z))).getDisaster() instanceof Collapse) {
						x.setText("Collapsed B");
					}

					x.r = (ResidentialBuilding) (Game.getBuildings().get(z));
					x.setVisible(true);
					x.setOpaque(true);
					panel3.add(x);
					// x.setIcon(new ImageIcon("Building.jpeg"));

					// text+= "\n"+"Building";
					x.addActionListener(this);

				}
			}

			for (int z = 0; z < Game.getEmergencyUnits().size(); z++) {
				if ((((Address) (((Unit) (Game.getEmergencyUnits().get(z))).getLocation())).getX() == col)
						&& (((Address) (((Unit) (Game.getEmergencyUnits().get(z))).getLocation())).getY() == row)) {

					x.setText("Unit");
				}
//					
//					if (Game.getEmergencyUnits().get(0).getUnitID().equals("1")) {
//						if (selectedItemX == col && selectedItemY == row) {
//							x.setText("AMB");
//							panel3.add(x);
//						}
//
//					}
//
//					else if (Game.getEmergencyUnits().get(1).getUnitID().equals("2")) {
//						if (selectedItemX == col && selectedItemY == row) {
//							x.setText("DCU");
//							panel3.add(x);
//
//						}
//					}
//
//					else if (Game.getEmergencyUnits().get(2).getUnitID().equals("3")) {
//						if (selectedItemX == col && selectedItemY == row) {
//							x.setText("EVA");
//							panel3.add(x);
//
//						}
//					}
//
//					else if (Game.getEmergencyUnits().get(3).getUnitID().equals("4")) {
//						if (selectedItemX == col && selectedItemY == row) {
//							x.setText("FRK");
//							panel3.add(x);
//
//						}
//					}
//
//					else if (Game.getEmergencyUnits().get(4).getUnitID().equals("5")) {
//						if (selectedItemX == col && selectedItemY == row) {
//							x.setText("GCU");
//							panel3.add(x);
//
//						}
//					}

				x.addActionListener(this);

			}
			// x.setText(text);
			for (int z = 0; z < Game.getExecutedDisasters().size(); z++) {
				if ((((Address) (((Rescuable) ((Game.getExecutedDisasters().get(z)).getTarget())).getLocation()))
						.getX() == col)
						&& (((((Address) (((Rescuable) ((Game.getExecutedDisasters().get(z)).getTarget()))
								.getLocation())).getY() == row)))) {
					x.setBackground(Color.RED);

				}
			}

//			addDisaters();
			mina.add(panel3, BorderLayout.CENTER);
			repaint();
			revalidate();
			// this.setContentPane(mina);
		}

//		mina.add(panel2, BorderLayout.EAST);
//		mina.add(panel1, BorderLayout.NORTH);
//		this.setContentPane(mina);
//		this.add(mina);

		repaint();
		revalidate();
	}

	public void updatePanel1(Rescuable r) {
		// System.out.print("1");
		info.setText("");
		// info.setPreferredSize(new Dimension(1, 100));
		// panel2.removeAll();

		String text = "";
		String location = "";
		String structuralIntegrity = "";
		String fireDamage = "";
		String gasLvl = "";
		String numOcc = "";
		String infoOcc = "";
		String infoDisaster = "";

		String hp = "";
		String bloodLoss = "";
		String toxicity = "";
		String state = "";
		String disaster = "";
		String locationC;

		if (r instanceof ResidentialBuilding) {

			ResidentialBuilding b = (ResidentialBuilding) r;

			location = "" + b.getLocation().getX() + " x " + b.getLocation().getY() + "";
			structuralIntegrity = b.getStructuralIntegrity() + "";
			fireDamage = b.getFireDamage() + "";
			gasLvl = b.getGasLevel() + "";
			numOcc = b.getOccupants().size() + "";

			for (int i = 0; i < b.getOccupants().size(); i++) {
				infoOcc = infoOcc + "\n" + "Name:" + ((Citizen) b.getOccupants().get(i)).getName() + "\n" + " Age: "
						+ ((Citizen) b.getOccupants().get(i)).getAge() + "\n" + " ID: "
						+ ((Citizen) b.getOccupants().get(i)).getNationalID() + "\n" + " HP: "
						+ ((Citizen) b.getOccupants().get(i)).getHp() + "\n" + " bloodLoss: "
						+ ((Citizen) b.getOccupants().get(i)).getBloodLoss() + "\n" + " Toxicity: "
						+ ((Citizen) b.getOccupants().get(i)).getToxicity() + "\n" + " Citizen State: "
						+ ((Citizen) b.getOccupants().get(i)).getState() + "\n";

			}

			if (b.getDisaster() != null)
				infoDisaster = b.getDisaster().getClass().getSimpleName();

			text = "Location: " + location + "\n" + "Structural Integrity: " + structuralIntegrity + "\n"
					+ "Fire Damage: " + fireDamage + "\n" + "Gas Level: " + gasLvl + "\n" + "Number Of Occupants: "
					+ numOcc + "\n" + "\n" + "\n" + "Info Of Occupents: " + infoOcc + "\n" + "\n" + "\n"
					+ "Info Of Disaster: " + infoDisaster;

		}

		if (r instanceof Citizen) {

			// System.out.print("citizen sa7");
			Citizen c = (Citizen) r;

			locationC = "" + c.getLocation().getX() + " x " + c.getLocation().getY() + "";
			hp = c.getHp() + "";
			bloodLoss = c.getBloodLoss() + "";
			toxicity = c.getToxicity() + "";
			state = c.getState() + "";

			if (c.getDisaster() != null)
				disaster = c.getDisaster().getClass().getSimpleName();

			text = "Citizen Location: " + locationC + "\n" + "Hp: " + hp + "\n" + "Blood Loss: " + bloodLoss + "\n"
					+ "Toxicity: " + toxicity + "\n" + "Citizen State: " + state + "\n" + "Disaster: " + disaster;

		}

		info.append(text);

		// this.setContentPane(mina);
		// info.setText(text);
		// info.setPreferredSize(new Dimension(200,200));

		repaint();
		revalidate();

	}

	// Units
	public void updatePanel2(mapbutton b) {
		System.out.print("Panel2 Action test" + "\n");
		unitInfo.setText("");
		String text = "";
		String id = "";
		String type = "";
		String location = "";
		String spc = "";
		String target = "";
		String state = "";
		String numPass = "";
		String infoPass = "Passengers:";
		// Address a = b.adress;

		if (Game.getEmergencyUnits().get(0).getUnitID().equals("1")) {
			if (Game.getEmergencyUnits().get(0).getLocation().getX() == b.x
					&& Game.getEmergencyUnits().get(0).getLocation().getY() == b.y) {

				id = ((Game.getEmergencyUnits().get(0)).getUnitID());
				type = ((Game.getEmergencyUnits().get(0)).getClass().getSimpleName());
				location = ((Game.getEmergencyUnits().get(0)).getLocation()) + "";
				spc = ((Game.getEmergencyUnits().get(0)).getStepsPerCycle()) + "";
				target = ((Game.getEmergencyUnits().get(0)).getTarget()) + "";
				state = ((Game.getEmergencyUnits().get(0)).getState()) + "";
				text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
						+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state + "\n"
						+ "---------------" + "\n";

			}

		}

		else if (Game.getEmergencyUnits().get(1).getUnitID().equals("2")) {
			if (Game.getEmergencyUnits().get(1).getLocation().getX() == b.x
					&& Game.getEmergencyUnits().get(1).getLocation().getY() == b.y) {

				id = ((Game.getEmergencyUnits().get(1)).getUnitID());
				type = ((Game.getEmergencyUnits().get(1)).getClass().getSimpleName());
				location = ((Game.getEmergencyUnits().get(1)).getLocation()) + "";
				spc = ((Game.getEmergencyUnits().get(1)).getStepsPerCycle()) + "";
				target = ((Game.getEmergencyUnits().get(1)).getTarget()) + "";
				state = ((Game.getEmergencyUnits().get(1)).getState()) + "";
				text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
						+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state + "\n"
						+ "---------------" + "\n";

			}
		}

		else if (Game.getEmergencyUnits().get(2).getUnitID().equals("3")) {
			if (Game.getEmergencyUnits().get(2).getLocation().getX() == b.x
					&& Game.getEmergencyUnits().get(2).getLocation().getY() == b.y) {

				id = ((Game.getEmergencyUnits().get(2)).getUnitID());
				type = ((Game.getEmergencyUnits().get(2)).getClass().getSimpleName());
				location = ((Game.getEmergencyUnits().get(2)).getLocation()) + "";
				spc = ((Game.getEmergencyUnits().get(2)).getStepsPerCycle()) + "";
				target = ((Game.getEmergencyUnits().get(2)).getTarget()) + "";
				state = ((Game.getEmergencyUnits().get(2)).getState()) + "";
				text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
						+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state;

				numPass = ((Evacuator) Game.getEmergencyUnits().get(2)).getPassengers().size() + "" + "/"
						+ ((Evacuator) Game.getEmergencyUnits().get(2)).getMaxCapacity() + "";

				for (int j = 0; j < ((Evacuator) Game.getEmergencyUnits().get(2)).getPassengers().size(); j++) {
					text = "";
					Citizen c = (Citizen) ((Evacuator) Game.getEmergencyUnits().get(2)).getPassengers().get(j);
					String name = "Name: " + c.getName();
					String age = "Age: " + c.getAge();
					String idC = "National ID: " + c.getNationalID();
					String hp = "Hp: " + c.getHp();
					String bloodLoss = "Blood Loss: " + c.getBloodLoss();
					String toxi = "Toxicity: " + c.getToxicity();
					String state2 = "Citizen State: " + c.getState();
					infoPass = name + "\n" + age + "\n" + idC + "\n" + hp + "\n" + bloodLoss + "\n" + toxi + "\n"
							+ state2;
					text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
							+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state + "\n"
							+ "Evacuator Info: " + "\n" + "Number Of Passengers: " + numPass + "\n"
							+ "Passengers Info: " + infoPass;
				}
				// unitInfo = new JTextArea();

			}
		}

		else if (Game.getEmergencyUnits().get(3).getUnitID().equals("4")) {
			if (Game.getEmergencyUnits().get(3).getLocation().getX() == b.x
					&& Game.getEmergencyUnits().get(3).getLocation().getY() == b.y) {

				id = ((Game.getEmergencyUnits().get(3)).getUnitID());
				type = ((Game.getEmergencyUnits().get(3)).getClass().getSimpleName());
				location = ((Game.getEmergencyUnits().get(3)).getLocation()) + "";
				spc = ((Game.getEmergencyUnits().get(3)).getStepsPerCycle()) + "";
				target = ((Game.getEmergencyUnits().get(3)).getTarget()) + "";
				state = ((Game.getEmergencyUnits().get(3)).getState()) + "";
				text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
						+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state + "\n"
						+ "---------------" + "\n";

			}
		}

		else if (Game.getEmergencyUnits().get(4).getUnitID().equals("5")) {
			if (Game.getEmergencyUnits().get(4).getLocation().getX() == b.x
					&& Game.getEmergencyUnits().get(4).getLocation().getY() == b.y) {

				id = ((Game.getEmergencyUnits().get(4)).getUnitID());
				type = ((Game.getEmergencyUnits().get(4)).getClass().getSimpleName());
				location = ((Game.getEmergencyUnits().get(4)).getLocation()) + "";
				spc = ((Game.getEmergencyUnits().get(4)).getStepsPerCycle()) + "";
				target = ((Game.getEmergencyUnits().get(4)).getTarget()) + "";
				state = ((Game.getEmergencyUnits().get(4)).getState()) + "";
				text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
						+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state + "\n"
						+ "---------------" + "\n";

			}
		}

		unitInfo.append(text);

		panel2.add(unitInfo, BorderLayout.SOUTH);
		repaint();
		revalidate();

//				id = ((Game.getEmergencyUnits().get(i)).getUnitID());
//				type = ((Game.getEmergencyUnits().get(i)).getClass().getSimpleName());
//				location = ((Game.getEmergencyUnits().get(i)).getLocation()) + "";
//				spc = ((Game.getEmergencyUnits().get(i)).getStepsPerCycle()) + "";
//				target = ((Game.getEmergencyUnits().get(i)).getTarget()) + "";
//				state = ((Game.getEmergencyUnits().get(i)).getState()) + "";
//				text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
//						+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state + "\n"
//						+ "---------------" + "\n";
//
//				if (Game.getEmergencyUnits().get(i) instanceof Evacuator) {
//					numPass = ((Evacuator) Game.getEmergencyUnits().get(i)).getPassengers().size() + "" + "/"
//							+ ((Evacuator) Game.getEmergencyUnits().get(i)).getMaxCapacity() + "";
//
//					for (int j = 0; j < ((Evacuator) Game.getEmergencyUnits().get(i)).getPassengers().size(); j++) {
//						text = "";
//						Citizen c = (Citizen) ((Evacuator) Game.getEmergencyUnits().get(i)).getPassengers().get(j);
//						String name = "Name: " + c.getName();
//						String age = "Age: " + c.getAge();
//						String idC = "National ID: " + c.getNationalID();
//						String hp = "Hp: " + c.getHp();
//						String bloodLoss = "Blood Loss: " + c.getBloodLoss();
//						String toxi = "Toxicity: " + c.getToxicity();
//						String state2 = "Citizen State: " + c.getState();
//						infoPass = name + "\n" + age + "\n" + idC + "\n" + hp + "\n" + bloodLoss + "\n" + toxi + "\n"
//								+ state2;
//						text = text + "Unit_ID: " + id + "\n" + "Type: " + type + "\n" + "Location: " + location + "\n"
//								+ "Steps Per Cycle: " + spc + "\n" + "Target: " + target + "\n" + "State: " + state
//								+ "\n" + "Evacuator Info: " + "\n" + "Number Of Passengers: " + numPass + "\n"
//								+ "Passengers Info: " + infoPass;
//					}
//				}
//			

		// Testing the text in console

//		unitInfo.append(text);

		// TODO: TEST and to added again after testing
		// panel2.add(unitInfo);
//		panel2.add(unitInfo, BorderLayout.SOUTH);
//		panel2.setSize(new Dimension(30,100));

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (((mapbutton) e.getSource()).getText().equals("Unit")) {
			// updatePanel2((mapbutton) e.getSource());
			amb.setVisible(true);
			dcu.setVisible(true);
			eva.setVisible(true);
			frk.setVisible(true);
			gcu.setVisible(true);
		}

		if (((mapbutton) e.getSource()).getText().equals("Building")) {
			buttonSelected = true;
			selectedItemX = ((mapbutton) e.getSource()).x;
			selectedItemY = ((mapbutton) e.getSource()).y;
			r = ((mapbutton) e.getSource()).r;
		}

		if (((mapbutton) e.getSource()).getText().equals("Citizen")) {
			buttonSelected = true;
			selectedItemX = ((mapbutton) e.getSource()).x;
			selectedItemY = ((mapbutton) e.getSource()).y;
			r = ((mapbutton) e.getSource()).r;
		}

		addDisaters();

		updatePanel1(((mapbutton) e.getSource()).r);

	}

	public void addDisaters() {
		// TODO!!!!!!!!!!!!!!!!!!!!!!!!
		// add to text area in Panel 2 and call it when we call next cycle

		Disasterr = new JTextArea();
		Disasterr.setPreferredSize(new Dimension(250, 100));

		Disasterr.setEditable(false);
		TitledBorder blab = BorderFactory.createTitledBorder("Disaster Info");
		Disasterr.setBorder(blab);
		JScrollPane blablab = new JScrollPane(Disasterr);

		for (int i = 0; i < Game.getExecutedDisasters().size(); i++) {
			Disasterr.append("Disaster: " + Game.getExecutedDisasters().get(i).getClass().getSimpleName() + " "
					+ "Target: " + Game.getExecutedDisasters().get(i).getTarget().getClass().getSimpleName() + "\n");
		}
		panel5.add(blablab, BorderLayout.NORTH);
		// System.out.print(d);
		repaint();
		revalidate();

	}

	public void current() {
		current = new JTextArea();

		current.append("Current Cycle:  " + Game.getCurrentCycle() + "" + "\n" + "Number Of Casualties:  "
				+ Game.calculateCasualties());

		panel5.add(current, BorderLayout.SOUTH);

	}
}
