package model;

import java.util.Scanner;

public class UserInput {
	
	public static void userInput(BoardItem[][] board,Scanner sc) {
		System.out.print("position: ");
		int row = sc.nextInt();
		if(row < 0 || row > 8) {
			throw new UserInputException("Error: Row must be between 0 and 8");
		}
		char column = sc.next().charAt(0);		
		if(column < 'a' || column > 'i') {
			throw new UserInputException("Error: Column must be between A and I");
		}
		System.out.print("number: ");
		int number = sc.nextInt();
		if(number <= 0 || number > 9) {
			throw new UserInputException("Error: Number must be between 1 and 9");
		}
		putUserNumbers(board,row,column,number);
	}
	
	private static void putUserNumbers(BoardItem[][] board,int row, char column, int number) {
		int rowBoard = row;
		int columnBoard = column - 'a';
		BoardItem numberUser = new BoardItem(number, false);
		
		if (board[rowBoard][columnBoard] == null || !board[rowBoard][columnBoard].isFix()) {		
			board[rowBoard][columnBoard] = numberUser;
		}
		
	}

}
