package Default;

import java.awt.Point;
import java.util.Random;

public class Humans<occupiedLocations> extends Characters {

	private static int nrH = 0;

	public Humans() {

		nrH++;
		name = "Human" + nrH;
	}

	public static Humans Human() {
		Humans human = new Humans();
		human.generateRandomAttributes();

		return human;
	}

	private void generateRandomAttributes() {
		Random random = new Random();
		setAge(random.nextInt(100) + 1);
		setSize(2);

		String[] abilities = { "Heroic Strike", "Sinister Strike", "Fireball" };
		setAbilities(abilities[random.nextInt(abilities.length)]);

		setAtributes("Every man for hymself");
		do {
			this.xCoordinate = random.nextInt(boardLength);
			this.yCoordinate = random.nextInt(boardWidth);
		} while (isOccupiedLocation());
		occupiedLocations.add(new Point(xCoordinate, yCoordinate));
	}

	public void displayAttributes() {
		System.out.println(name + "(" + getAge() + "," + xCoordinate + " " + yCoordinate + "," + getAbilities() + ","
				+ getAtributes() + ")");
		System.out.println();
	}

	public char getSymbol() {
		return 'H';
	}
}
