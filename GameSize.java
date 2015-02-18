public class GameSize {
	int row;
	int column;
	
	public GameSize(int row, int column){
		this.row = row;
		this.column = column;
	}
	
	public int rowFull(){
		if (row == 1){
			return 4;
		}
		else if (row == 3){
			return 0;
		}
		else{
			return 2;
		}
	}
	
	public int columnFull(){
		if (column == 1){
			return 0;
		}
		else if (column == 3){
			return 4;
		}
		else{
			return 2;
		}
	}
}