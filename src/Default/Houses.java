package Default;

import java.awt.Point;
import java.util.Random;


public class Houses extends Characters {
	private static int nrHouses = 0;
	public int width;
	public int length;

	public Houses() {
		nrHouses++;
		name = "House" + nrHouses;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public static Houses House() {
		Houses house = new Houses();
		house.generateRandomAttributes();
		return house;
	}

	private void generateRandomAttributes() {
		Random random = new Random();
		
		setWidth(random.nextInt(4) + 2); 
		setLength(random.nextInt(4) + 2); 

		
		this.xCoordinate = random.nextInt(boardLength - getWidth() + 1);
		this.yCoordinate = random.nextInt(boardWidth - getLength() + 1);

		// umple cu X langa casa
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getLength(); j++) {
				occupiedLocations.add(new Point(xCoordinate + i, yCoordinate + j));
				Characters tempCharacter = new Characters() {
					@Override
					public char getSymbol() {
						return 'X';
					}
				};
				tempCharacter.setxCoordinate(xCoordinate + i);
				tempCharacter.setyCoordinate(yCoordinate + j);
				charactersList.add(tempCharacter);

			}
		}
	}

	public void displayAttributes() {
		System.out.println(name + "(" + getWidth() + "x" + getLength() + "," + xCoordinate + " " + yCoordinate + ")");

	}

	public void renderGrid(char[][] grid) {
		for (Point point : occupiedLocations) {
			int x = (int) point.getX();
			int y = (int) point.getY();
			grid[y][x] = 'X';
		}
	}

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return 0;
	}
}


