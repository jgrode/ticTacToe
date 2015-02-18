import java.util.Scanner;

public class ticTacToe {
	public static void main(String[] args){
		char[][] board = new char[5][5];
		int player = 1;
		String winner = null;
		Scanner input = new Scanner(System.in);
		GameSize convert = null;
		IndependentAi compMove = null;
		String choice;
		
		System.out.println("Welcome to Jordan's Tic Tac Toe! Select the slot to which you would like to place your X/O by (x, y) coords, with the origin in the bottom left off-screen, just like a Cartesian\n plane. For example, the 'X' below is (3, 3)");
		board[0][4] = 'X';
		boardSet(board);
		board[0][4] = ' ';
		
		//documentation further
		
		do {
			System.out.print("\nWould you like to play singleplayer or multiplayer?: ");
			choice = input.nextLine();
		} while (! (choice.substring(0,1).equalsIgnoreCase("m") || choice.substring(0,1).equalsIgnoreCase("s")));
	
		while (gameStatus(board) != 0 && gameStatus(board) != 1){
			int row = 0; 
			int column = 0;
			if (player == 3){
				player = 1;
			}
			
			if(player == 1 || choice.substring(0,1).equalsIgnoreCase("m")){
				do {
					System.out.print("\nPlayer" + player + ", enter the number of column of the slot to which you would like to move: ");
					column = input.nextInt();
			
					if (gameStatus(board) == 0 && gameStatus(board) == 1){
						break;
					}
					
					System.out.print("\nPlayer" + player + ", enter the number of row of the slot to which you would like to move: ");
					row = input.nextInt();
					
					convert = new GameSize(row, column);
					} while (board[convert.rowFull()][convert.columnFull()] != ' ');
			}
			else {
				//System.out.println("passing to comp");
				compMove = new IndependentAi(board); //Computer is passed the board
				//System.out.println("passed to comp");
			}
			
			if (player == 1){
				board[convert.rowFull()][convert.columnFull()] = 'X';
				winner = "Player1";
			}
			else if (choice.substring(0,1).equalsIgnoreCase("m") && player == 2){
				board[convert.rowFull()][convert.columnFull()] = 'O';
				winner = "Player2";
			}
			else {
				System.out.println("\n\nThe computer went. Now it's your turn! Row: " + compMove.getRow() + " Column: " + compMove.getColumn());
				board[compMove.getRow()][compMove.getColumn()] = 'O';
				winner = "the Computer";
			}
			boardSet(board);
			player++;
		}
		
		if (gameStatus(board) == 0){
			System.out.println("\nThe winner is " + winner + "!");
		}
		else if (gameStatus(board) == 1){
			System.out.println("\nIt's a tie. In a way, you're both losers!");
		}
	}
	
	public static char[][] boardSet(char[][] board){
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				if (j % 2 != 0){
					board[i][j] = '|';
				}
				else if (i % 2 != 0){
					board[i][j] = '-';
				}
				else if (board[i][j] == (char) 0){
					board[i][j] = ' ';
				}
			}
		}
		
		System.out.println("\n");
		for (int k = 0; k < 5; k++){
			for (int l = 0; l < 5; l++){
				System.out.print(board[k][l]);
			}
			System.out.print("\n");
		}
		return board;
	}

	public static int gameStatus(char[][] board){
		for (int i = 0; i < 5; i += 2){
			if (board[i][0] != ' ' && board[i][0] == board[i][2] && board[i][2] == board[i][4]){
				return 0; //won
			}
			else if (board[0][i] != ' ' && board[0][i] == board[2][i] && board[2][i] == board[4][i]){
				return 0; //won
			}
			else if((board[0][0] != ' ' && board[0][0] == board[2][2] && board[2][2] == board[4][4]) || (board[0][4] != ' ' && board[0][4] == board[2][2] && board[2][2] == board[4][0])){

				return 0; //won
			}
		}

		for (int k = 0; k < 5; k++){
			for (int l = 0; l < 5; l++){
				if (board[k][l] == ' '){
					return 2; //not won
				}
			}
		}
		return 1; //tie
	}
}