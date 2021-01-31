package genetic;
/*
 * This class is written solely by Ahmad Salahuddin
 */
public class Game 
{
	Board board;
	String winner;
	
	//create a new board on creation
	public Game()
	{
		board = new Board();
	}
	
	//this method plays a game between two strategies. Player 1 moves first.
	public int play(Strategy player1, Strategy player2)
	{
		//set the player numbers in the respective strategies.
		if(!(player1.setPlayer(1) && player2.setPlayer(2))) return -1;
		
		board.state[player1.playNextMove(board)] = 1;
		board.state[player2.playNextMove(board)] = 2;
		board.state[player1.playNextMove(board)] = 1;
		board.state[player2.playNextMove(board)] = 2;
		board.state[player1.playNextMove(board)] = 1;
		if(gameEnd()) return winner();
		board.state[player2.playNextMove(board)] = 2;
		if(gameEnd()) return winner();
		board.state[player1.playNextMove(board)] = 1;
		if(gameEnd()) return winner();
		board.state[player2.playNextMove(board)] = 2;
		if(gameEnd()) return winner();
		board.state[player1.playNextMove(board)] = 1;
		if(gameEnd()) return winner();
		
		return -1;
	}
	
	//this is exactly like the previous method, only it prints the state of the board on the console at every move.
	//used for demonstration of the best startegy.
	public int playSingleGame(Strategy player1, Strategy player2)
	{
		if(!(player1.setPlayer(1) && player2.setPlayer(2))) return -1;
		
		board.state[player1.playNextMove(board)] = 1;
		printBoard();
		board.state[player2.playNextMove(board)] = 2;
		printBoard();
		board.state[player1.playNextMove(board)] = 1;
		printBoard();
		board.state[player2.playNextMove(board)] = 2;
		printBoard();
		board.state[player1.playNextMove(board)] = 1;
		printBoard();
		if(gameEnd()) return winner();
		board.state[player2.playNextMove(board)] = 2;
		printBoard();
		if(gameEnd()) return winner();
		board.state[player1.playNextMove(board)] = 1;
		printBoard();
		if(gameEnd()) return winner();
		board.state[player2.playNextMove(board)] = 2;
		printBoard();
		if(gameEnd()) return winner();
		board.state[player1.playNextMove(board)] = 1;
		printBoard();
		if(gameEnd()) return winner();
		printBoard();
		
		return -1;
	}
	
	//get the player number who won, else return 0 inc ase of a draw
	private int winner() 
	{
		if(checkWinner(1))
			return 1;
		if(checkWinner(2))
			return 2;
		
		return 0;
	}
	
	//check to see if a game ended.
	public boolean gameEnd()
	{
		int countEmpty = 0;
		for(int i = 0; i<9;i++)
		{
			if(board.state[i] == -1)
				{
					countEmpty++;
				}
		}
		if(countEmpty == 0)return true;
		if(checkWinner(1)) return true;
		if(checkWinner(2)) return true;
		
		return false;
	}
	
	//check if someone won the game by comparing rows, columns and diagonals.
	private boolean checkWinner(int player) 
	{
		if(board.state[0] == player && board.state[1] == player && board.state[2] == player)
			return true;
		if(board.state[3] == player && board.state[4] == player && board.state[5] == player)
			return true;
		if(board.state[6] == player && board.state[7] == player && board.state[8] == player)
			return true;
		if(board.state[0] == player && board.state[3] == player && board.state[6] == player)
			return true;
		if(board.state[1] == player && board.state[4] == player && board.state[7] == player)
			return true;
		if(board.state[2] == player && board.state[5] == player && board.state[8] == player)
			return true;
		if(board.state[0] == player && board.state[4] == player && board.state[8] == player)
			return true;
		if(board.state[6] == player && board.state[4] == player && board.state[2] == player)
			return true;
		return false;
	}
	
	//print the state of the board replacing 1 (player) with x and 2 (player) with o
	public void printBoard()
	{
		char [] charBoard = new char[9];
		for(int i = 0;i<9;i++)
		{
			if(board.state[i] == 1) charBoard[i] = 'x';
			else if(board.state[i] == 2) charBoard[i] = 'o';
			else if(board.state[i] == -1) charBoard[i] = '-';
			
		}
		
		System.out.println("\nCurrent state of the board is : ");
		
		System.out.println(charBoard[0]+ "\t" + charBoard[1]+ "\t" + charBoard[2]);
		System.out.println(charBoard[3]+ "\t" + charBoard[4]+ "\t" + charBoard[5]);
		System.out.println(charBoard[6]+ "\t" + charBoard[7]+ "\t" + charBoard[8]);
	}
}
