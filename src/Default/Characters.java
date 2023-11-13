package Default;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public abstract class Characters {
	public static List<Characters> charactersList = new ArrayList<>();
	protected static List<Point> occupiedLocations = new ArrayList<>();
	protected static int boardWidth; 
    protected static int boardLength; 

	protected String name;
	private int age;
	protected int xCoordinate;
	protected int yCoordinate;
	private int size;
	private String abilities;
	private String atributes;
	
	public static void setBoardSize(int width, int length) {
        boardWidth = width;
        boardLength = length;
    }

	public Characters() {
		// adauga caractere la lista de caractere care va fi folosita sa faca display pe grid
		charactersList.add(this);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getAbilities() {
		return abilities;
	}

	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}

	public String getAtributes() {
		return atributes;
	}

	public void setAtributes(String atributes) {
		this.atributes = atributes;
	}

	public static void renderGrid() {
		char[][] grid = new char[boardLength][boardWidth];;

		//"Desenam" gridu da nush dc inaltimea ramana la 100 totimpu
		 for (int i = 0; i < boardLength; i++) {
	            for (int j = 0; j < boardWidth; j++) {
	                if (i == 0 || i == boardLength - 1) {
	                    grid[i][j] = '_';
	                } else if (j == 0 || j == boardWidth - 1) {
	                    grid[i][j] = '|';
	                }
	            }
	        }

		// Plasam ce este in caracter list pe grid
		for (Characters character : charactersList) {
			int x = character.getxCoordinate();
			int y = character.getyCoordinate();
			char symbol = character.getSymbol();

			
			 if (x > 0 && x < boardWidth - 1 && y > 0 && y < boardLength - 1) {
	                grid[y][x] = symbol;
	            }
		}

		
		 for (int i = 0; i < boardLength; i++) {
	            for (int j = 0; j < boardWidth; j++) {
	                System.out.print(grid[i][j]);
	            }
	            System.out.println();
	        }
	    }

	public abstract char getSymbol();
// aici se verifica pozitiile ocupate
	protected boolean isOccupiedLocation() {
		Point newLocation = new Point(xCoordinate, yCoordinate);
		return occupiedLocations.contains(newLocation);
	}
}
