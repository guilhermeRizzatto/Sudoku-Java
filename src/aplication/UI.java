package aplication;

import java.io.IOException;
import java.util.Scanner;

import model.BoardItem;

public class UI {
	
	public static void clr(){
		 try {
	            if (System.getProperty("os.name").contains("Windows")) {
	                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	            }
	            else {
	                System.out.print("\033\143");
	            }
	        } catch (IOException | InterruptedException ex) {}
    }
	
	public static void printBoard(BoardItem[][] board) {
		System.out.println(" \n    ------------------------------- ");
		for (int i = 0; i < board.length; i++) {
			System.out.print(i + " - |");
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == null) {
					System.out.print(" . ");
				} else {
					System.out.print(" " + board[i][j].getNumber() + " ");
				}
				if ((j + 1) % 3 == 0) {
					System.out.print("|");
				}
			}
			if ((i + 1) % 3 == 0) {
				System.out.print(" \n    ------------------------------- ");
			}
			System.out.println();
		}
		System.out.print("      A  B  C   D  E  F   G  H  I");
		System.out.println();
		System.out.println();
	}

	public static void printIntrutions(Scanner sc) {
		clr();
		System.out.println("Welcome to Sudoku");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("When playing, type the row you want and after a space the column");
		System.out.println("Exemple: 4 e");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("After this, type number you want");
		System.out.println("Remember: the number must be bettewen 1 and 9");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("finally");
		System.out.println("If you want verify and validate your game, type 1");
		System.out.println("If you DON´T want verify and validate, type a number different than 1");
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Press enter for skip");
		sc.nextLine();
		clr();
	}
}
