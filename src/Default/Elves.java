package Default;

import java.awt.Point;
import java.util.Random;

public class Elves extends Characters {
	private static int nrE = 0;

	public Elves() {
	
		nrE++;
		name = "Elf" + nrE;
	}


	public static Elves Elf() {
		Elves elf = new Elves();
		elf.generateRandomAttributes();
	
		return elf;
	}

	
	private void generateRandomAttributes() {
		Random random = new Random();
		setAge(random.nextInt(1000) + 1);
		setSize(1);

		String[] abilities = { "Rend", "Steady shot", "Moonfire" };
		setAbilities(abilities[random.nextInt(abilities.length)]);

		setAtributes("Shadowmend");
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
		return 'E';
	}
}
