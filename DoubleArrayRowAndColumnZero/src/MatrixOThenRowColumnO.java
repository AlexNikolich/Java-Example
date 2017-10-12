public class MatrixOThenRowColumnO {

	public static void main(String[] args) {

		char[][] board = new char[6][6];

		initBoard(board);
		board[0][0] = 'X';

		
		setZeros(board);
		printBoard(board);

	}

	public static void setZeros(char[][] board) {
		int[] rows = new int[board.length];
		int[] columns = new int[board[0].length];

		// checking if there X in board
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					rows[i] = 1;
					columns[j] = 1;
				}
			}
		}

		// change all rows and columns to 0 if they have 'X'
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (rows[x] == 1 || columns[y] == 1) {
					board[x][y] = '0';
				}
			}
		}

	}

	//all board fields change to empty space
	public static void initBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = ' ';

			}
		}
	}

	public static void printBoard(char[][] board) {
		System.out.println("-------------------------");
		for (int i = board.length - 1; i >= 0; i--) {
			System.out.print("| ");
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------------------");
		}
	}

}
