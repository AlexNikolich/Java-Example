
public class TicTac {

	public static void main(String[] args) {

		char[][] board = new char[3][3];
		initBoard(board);
		board[1][1] = 'X';
		printBoard(board);
		boolean b = isBoardFull(board);
		if (!b) {
			System.out.println("Igra je pocela!!!!");
		}

	}

	public static void initBoard(char[][] board) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';

			}
		}
	}

	public static void printBoard(char[][] board) {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	public static boolean isBoardFull(char[][] board) {
		boolean isFull = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != ' ') {
					isFull = false;
					return false;
				}
			}
		}
		return isFull;

	}

}
