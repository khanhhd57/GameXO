
public class Board {
	private Cell[][] board;
	private final int rows = 3;
	private final int cols = 3;
	
	public Board() {
		this.board = new Cell[rows][cols];
		setUp();
	}
	
	public void setUp() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = Cell.EMPTY;
			}											
		}
	}
	
	public void show() {
		System.out.println("Current Board:");

        System.out.println("   1   2   3\n" +
                           "1  "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]+"\n" +
                           "  -----------\n" +
                           "2  "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]+"\n" +
                           "  -----------\n" +
                           "3  "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+"");
	}
	
	 public boolean placeCell(int row, int col, int player) {
		 row--;
	     col--;
	     if (board[row][col] == Cell.EMPTY) {
	         if (player == 1) {
	             board[row][col] = Cell.CROSS;
	             return true;
	         } else {
	             board[row][col] = Cell.NOUGHT;
	             return true;
	         }
	     } else {
	         System.out.println("Invalid move!");
	         return false;
	     }
	 }
	 
	 public boolean checkVictory(int player) {
		 boolean win = false;
		 switch(player) {
		 
		 case 1:
			 win = checkAllWinStates(Cell.CROSS);
			 break;
		 case 2:
			 win = checkAllWinStates(Cell.NOUGHT);
			 break;
		 default:
			 System.out.println("Error!");
		 }
		 
		 return win;
	 }
	 
	private boolean checkAllWinStates(Cell cell) {
		for (int i = 0; i < rows; i++) {
			if (board[i][0].equals(cell) && board[i][1].equals(cell) && board[i][2].equals(cell)) {
				return true;
			}
			
		}
		
		for (int j = 0; j < cols; j++) {
			if (board[0][j].equals(cell) && board[1][j].equals(cell) && board[2][j].equals(cell)) {
				return true;
			}			
		}
		
		if (board[1][1].equals(cell)) {
			if(board[0][0].equals(cell) && board[2][2].equals(cell)) {
				return true;
			}
			if (board[0][2].equals(cell) && board[2][0].equals(cell)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkFull() {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j].equals(Cell.EMPTY)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}