package sudoku;

import java.util.Arrays;
import java.util.Random;

import model.BoardItem;

public class Board {
	
	private int rows;
	private int columns;
	private BoardItem[][] board;
	
	public Board(int rows, int columns) {	
		this.rows = rows;
		this.columns = columns;
		if(rows <= 8 || columns <= 8) {
			throw new BoardException("Error: Unable to create Board, rows and columns must have number equal 9");
		}
		board = new BoardItem[this.rows][this.columns];
		generateBoard();
		generateNumbers();
	}

	public BoardItem[][] getBoard() {	
		return board;
	}


	private void generateBoard() {
		for (int i = 0; i < board.length; i++) {
			Arrays.fill(board[i], null);
		}
	}
	
	private void generateNumbers() {
		for (int k = 0; k < 30;) {
			int row = new Random().nextInt(board.length - 1);
			int column = new Random().nextInt(board.length - 1);
			int o = new Random().nextInt(9) + 1;
			if (putNumber(row, column, new BoardItem(o, true))) {
				k++;
			}
		}
	}
	
	private boolean putNumber(int row, int column, BoardItem o) {
		if (!numberInHorizontal(row, o) 
				&& !hasBox(row, column, o)
				&& !numberInVertical(column, o)) {
			board[row][column] = o;
			return true;
		}
		return false;
	}
	
	private boolean numberInVertical(int column, BoardItem o) {
		for (int i = 0; i < board.length; i++) {
			if (board[i][column] != null) {	
						if (board[i][column].getNumber() == o.getNumber()) {
							return true;
						}
					}	
				}	
		return false;
	}
	
	private boolean numberInHorizontal(int row, BoardItem o) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] != null) {		
						if (board[row][i].getNumber() == o.getNumber()) {
							return true;
						}
					}
				}			
		return false;
	}
	
	public boolean hasBox(int row, int column, BoardItem o) {
		int boxRow = row - row % 3;
		int boxColumn = column - column % 3;
		int count = 0;
		
			for (int i = boxRow; i < boxRow + 3; i++) {
				for (int j = boxColumn; j < boxColumn + 3; j++) {
					if (board[i][j] != null && (i != row || j != column)) {
						if (board[i][j].getNumber() == o.getNumber()) {
							count++;
						}
					}					
				}
			}
		if(count > 0) {
			return true;
		}
		return false;
	}
	
}
