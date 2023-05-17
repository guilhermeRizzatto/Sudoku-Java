
package aplication;


import java.util.InputMismatchException;
import java.util.Scanner;

import model.UserInput;
import model.UserInputException;
import sudoku.Board;
import sudoku.BoardRules;

public class Program {


	public static void main(String[] args) {
		
		Board board = new Board(9,9);
		Scanner sc = new Scanner(System.in);
		
		int validate;
		int round = 0;
		
		UI.printIntrutions(sc);

		while(true) { 			
			try {
			UI.printBoard(board.getBoard());
			if(round > 0) {
				System.out.println("For validate your game press |1|: ");
				validate = sc.nextInt();			
				if(validate == 1) {
					BoardRules boardRules = new BoardRules(board);
					if(boardRules.solveBoard() == 0) {
						System.out.println("Sudoku complete, congratulations!!!");
						sc.nextLine();
						break;
					}
					else {
						System.out.println("Sudoku incomplete, try again ");
						sc.nextLine();
					}
				}
			}
			UserInput.userInput(board.getBoard(),sc);
			round++;
			}catch(InputMismatchException e) {
				System.out.println("Error: Input Mismatch");
				sc.nextLine();				
			}catch(UserInputException e) {
				System.out.println(e.getMessage());
				sc.nextLine();				
			}	
		 }		
	}
	
}
