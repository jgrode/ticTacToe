public class IndependentAi{
	int column;
	int row;
	char[][] board;
	Ai offense;
	boolean defenseCompleted = false;
	
	public IndependentAi(char[][] board){
		this.board = board;
		offense = new Ai(board);
	}
	public int getRow(){
		//System.out.println("getRow reached");
		Row();
		return row;
	}
	public int getColumn(){
		Column();
		return column;
	}
	
	public void Row(){
		for (int i = 0; i < 5; i += 2){
			if (board[i][2] == ' ' && ' ' != board[i][0] && board[i][0] == board[i][4]){ //row gap
				//System.out.println("defense row: " + i);
				row = i;
				column = 2;
				defenseCompleted = true;
				return;
			}
			else if (board[2][i] == ' ' && (' ' != board[0][i] && board[0][i] == board[4][i])){ //column gap
				//System.out.println("defense row set to 2: 2; and i is: " + i);
				row = 2;
				column = i;
				defenseCompleted = true;
				return;
			}
			else if (board[2][2] == ' ' && (' ' != board[0][4] && board[0][4] == board[4][0]) || (' ' != board[0][0] && board[0][0] == board[4][4])){
				//System.out.println("defense row set to 2 #2: 2");
				row = 2;
				column = 2;
				defenseCompleted = true;
				return;
			}
			else if (board[2][2] == 'X' && ((board[0][0] == ' ' && board[2][2] == board[4][4]) || (board[4][4] == ' ' && board[2][2] == board[0][0]) || (board[0][4] == ' ' && board[2][2] == board[4][0]) || (board[4][0] == ' ' && board[2][2] == board[0][4]))){
				//System.out.println("Partial diag reached");
				if (board[0][0] == ' ' && board[2][2] == board[4][4]){
					//System.out.println("1");
					row = 0;
					column = 0;
				}
				else if(board[4][4] == ' ' && board[2][2] == board[0][0]){
					//System.out.println("2");
					row = 4;
					column = 4;
				}
				else if(board[0][4] == ' ' && board[2][2] == board[4][0]){
					//System.out.println("3");
					row = 0;
					column = 4;
				}
				else{
					//System.out.println("4");
					row = 4;
					column = 0;
				}
				defenseCompleted = true;
				return;
			}
			else if (Partial('O')){
				return;
			}
			else if (Partial('X')){
				return;
			}
			row = offense.getRowOffense();	
		}
	}
	
	
	public void Column(){
		if (defenseCompleted){
			return;
		}
		column = offense.getColumnOffense();
	}
	public boolean Partial(char piece){
		for (int i = 0; i < 5; i += 2){
			if ((board[i][4] == ' ' && board[i][0] == piece && board[i][0] == board[i][2]) || (board[i][0] == ' ' && board[i][2] == piece && board[i][2] == board[i][4]) || (board[0][i] == ' ' && board[2][i] == piece && board[2][i] == board[4][i]) || (board[4][i] == ' ' && board[2][i] == piece && board[2][i] == board[0][i])){
				//System.out.println("partial reached");
				if (board[i][4] == ' ' && board[i][0] == piece && board[i][0] == board[i][2]){
					row = i;
					column = 4;
				}
				else if (board[i][0] == ' ' && board[i][2] == piece && board[i][2] == board[i][4]){
					row = i;
					column = 0;
				}
				else if (board[0][i] == ' ' && board[2][i] == piece && board[2][i] == board[4][i]){
					row = 0;
					column = i;
				}
				else {
					row = 4;
					column = i;
				}
				return defenseCompleted = true;
			}
		}
		return defenseCompleted = false;
	}
}