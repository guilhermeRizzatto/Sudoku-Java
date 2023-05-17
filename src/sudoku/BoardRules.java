package sudoku;

import model.BoardItem;

public class BoardRules {
	
	private Board boardSudoku;
	private BoardItem[][] boardSolve;
	
	public BoardRules(Board board) {
		this.boardSudoku = board;
		boardSolve = board.getBoard();
	}
	
	public int solveBoard() {
		int lines = 0;
		
		for(int i = 0; i < boardSolve.length; i++) {
			for(int j = 0; j < boardSolve.length; j++) {
				if(boardSolve[i][j] != null) {
					BoardItem number = boardSolve[i][j]; 
					if(numberInVerticalSolve(j) || numberInHorizontalSolve(i)){			 
						lines ++;
					}
					if(boardSudoku.hasBox(i, j, number)) {
						lines ++;
					}	
					if(emptySpaces()) {
						lines ++;
					}
				}
			}
		}
		return lines;
	}
	
	

	public boolean numberInVerticalSolve(int column) {
		byte count = 0;
		for (int i = 0; i < boardSolve.length; i++) {
			if (boardSolve[i][column] != null) {	
						BoardItem currentNumber = boardSolve[i][column];
						for(int j = i + 1; j < boardSolve.length; j++) {
							if (boardSolve[j][column] != null && boardSolve[j][column].getNumber() != null ) {	
								if(boardSolve[j][column].getNumber() == currentNumber.getNumber()) {
									count++;
								}
							}
						}
					}	
				}
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	public boolean numberInHorizontalSolve(int row) {
		byte count = 0;
		for (int i = 0; i < boardSolve.length; i++) {
			if (boardSolve[row][i] != null) {	
						BoardItem currentNumber = boardSolve[row][i];
						for(int j = i + 1; j < boardSolve.length; j++) {
							if (boardSolve[row][j] != null && boardSolve[row][j].getNumber() != null) {	
								if(boardSolve[row][j].getNumber() == currentNumber.getNumber()) {
									count++;
								}
							}
						}
					}	
				}
		if(count > 0) {
			return true;
		}
		return false;
	}
	
	public boolean emptySpaces() {
		for(int i = 0; i < boardSolve.length; i++) {
			for(int j = 0; j < boardSolve.length; j++) {
				if(boardSolve[i][j] == null) {
					return true;
				}
			}
		}
		return false;
	}
	
	

}
