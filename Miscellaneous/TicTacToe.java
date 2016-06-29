import acm.program.*;

public class TicTacToe extends ConsoleProgram{
	public void run(){
		println("This program tests the isWinningPosition method.");
		println("Enter the state of the board, row by row.\n");
		for(int i=0;i<3;i++){
			String s=readLine("");
			for(int j=0;j<3;j++){
				board[i][j]=s.charAt(j);
			}
		}
		println();
		if(isWinningPosition(board,'X')){
			println("X has WON.");
		}
		else if(isWinningPosition(board,'O')){
			println("O has WON.");
		}
		else{
			println("DRAW.");
		}
	}
	
	private boolean isWinningPosition(char[][] board,char player){
		boolean res=false;
		//primary diagonal
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(board[i][j]==player && i==j)
					res=true;
				if(board[i][j]!=player && i==j){
					res=false;
					break;
				}
			}
		}
		
		//checking rows
		for(int i=0;i<3;i++){
			int j=0;
			if(board[i][j]==player){
				if(board[i][j+1]==player){
					if(board[i][j+2]==player){
						return true;
					}
				}
			}
		}
		
		//checking columns
		for(int j=0;j<3;j++){
			int i=0;
				if(board[i][j]==player){
					if(board[i+1][j]==player){
						if(board[i+2][j]==player){
							return true;
						}
					}
				}
		}
		
		//anti-diagonal
		for(int i=2;i>=0;i--){
			for(int j=0;j<3;j++){
				if(board[i][j]==player && (i+j==2)){
					res=true;
				}
				if(board[i][j]!=player && (i+j==2)){
					res=false;
					break;
				}
			}
		}
		
		return res;
	}
	
	private char[][] board=new char[3][3];
}
