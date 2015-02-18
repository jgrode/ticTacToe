public class Ai {
	char[][] board;
	int randomColumn;
	int row = 0;
	int column = 0;
	boolean offenseCompleted = false;
	
	public Ai(char[][] board) {
		this.board = board;
	}
	
	public int getRowOffense(){
		RowOffense();
		if (row != 0 || column != 0 || board[0][0] == ' '){
			//System.out.println("offense row: " + row);
			return row;
		}
		//System.out.println("offense default row: " + row);
		return row;
	}
	
	public int getColumnOffense(){
		ColumnOffense();
		if (row != 0 || column != 0 || board[0][0] == ' '){
			//System.out.println("offense column: " + column);
			return column;
		}
		//System.out.println("offense default c: " + column);
		return column;
	}
	
	public void RowOffense(){
		//System.out.println("offense began");
		for (int i = 0; i < 5; i += 2){
			for (int j = 0; j < 5; j += 2){
				if (board[i][j] == 'O'){
					if (i - 2 >= 0 && board[i - 2][j] == ' '){
						//System.out.println("nested if of row offense reached");
						row = i - 2;
						column = j;
						offenseCompleted = true;
						return;
					}
					else if (i + 2 <= 5 && board[i + 2][j] == ' '){
						//System.out.println("nested elseif of row offense reached");
						row = i + 2;
						column = j;
						offenseCompleted = true;
						return;
					}
				}
				else if (board[2][2] == ' ' || board[i][j] == ' '){
					if (board[2][2] == ' '){
						row = 2;
						column = 2;
						offenseCompleted = true;
						return;
					}
					
					//System.out.println("(default) elseif of row offense reached");
					row = i;
					column = j;
					offenseCompleted = true;
				}
			}
		}
	}
	
	public void ColumnOffense(){
		if (offenseCompleted){
			return;
		}
		for (int i = 0; i < 5; i += 2){
			for (int j = 0; j < 5; j += 2){
				if (board[i][j] == 'O'){
					if (j - 2 >= 0 && board[i][j - 2] == ' '){
						//System.out.println("nested if of c offense reached");
						column = j - 2;
						row = i;
					}
					else if (j + 2 <= 5 && board[i][j + 2] == ' '){
						//System.out.println("nested elseif of c offense reached");
						column = j + 2;
						row = i;
					}
					//else if (board[i][j])
				}
			}
		}
	}
}