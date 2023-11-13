package Default;

import java.awt.Point;
import java.util.Random;

public class Orcs extends Characters {
	private static int nrO = 0;

	public Orcs() {
		
		nrO++;
		name = "Orc" + nrO;
	}

	public static Orcs Orc() {
		Orcs orc = new Orcs();
		orc.generateRandomAttributes();
		
		return orc;
	}

	
	private void generateRandomAttributes() {
		Random random = new Random();
		setAge(random.nextInt(500) + 1);
		setSize(3);

		String[] abilities = { "Cleave", "Incinerate", "Strom Strike" };
		setAbilities(abilities[random.nextInt(abilities.length)]);

		setAtributes("BloodRage");
		do {
			this.xCoordinate = random.nextInt(boardLength);
			this.yCoordinate = random.nextInt(boardWidth);
		} while (isOccupiedLocation());
		occupiedLocations.add(new Point(xCoordinate, yCoordinate));

	}

	
	public void displayAttributes() {
		System.out.println(name + " (" + getAge() + "," + xCoordinate + " " + yCoordinate + "," + getAbilities() + ","
				+ getAtributes() + ")");
		System.out.println(); 
	}

	public char getSymbol() {
		return 'O';
	}
}
