package Default;

import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the board width: ");
		int boardWidth = scanner.nextInt();

		System.out.print("Enter the board length: ");
		int boardLength = scanner.nextInt();

		Characters.setBoardSize(boardWidth, boardLength);
		
		System.out.print("Number of houses: ");
		int numberOfHouses = scanner.nextInt();

		
		for (int i = 0; i < numberOfHouses; i++) {
			Houses house = Houses.House();
			house.displayAttributes();
		}

		
		Characters.renderGrid();

		
		scanner.close();
//		 	Humans human1 = Humans.Human();
//	        human1.displayAttributes();
//	        Elves elf1 = Elves.Elf();
//	        elf1.displayAttributes();
//	        Orcs orc1 = Orcs.Orc();
//	        orc1.displayAttributes();

	}

}
