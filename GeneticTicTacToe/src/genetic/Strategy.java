package genetic;
/*
 * This class is written solely by Ahmad Salahuddin
 */
import java.util.ArrayList;
/*
 * this class depics the DNA in genetic algorithm. It contains move objects which represent chromosomes
 */
public class Strategy 
{
	//initialize member variables
	public int lostCount = 0;
	public int winCount = 0;
	public int drawCount = 0;
	public int player = 0;
	public ArrayList <Move> moves = new ArrayList<Move>();
	int index = -1;

	//add moves to the strategy
	public void addMoves(ArrayList<Move> moves)
	{
		this.moves = moves;
	}

	//call the get method and return the corresponding board position to play the move at.
	public int playNextMove(Board board)
	{
		if(index < 9)
		{
			index++;
			index++;
			return this.moves.get(this.index).get(board,this.player);
		}
		else
		{
			return -1;
		}
	}

	//return the immediate next object of the next move
	public Move nextMoveObject()
	{
		if(index < 9)
		{
			index++;
			return this.moves.get(this.index);
		}
		else
		{
			return null;
		}
	}

	//set the player number of this strategy. If i'm player 1 play moves 1,3,5 and 9, else if i'm player 2 play moves 2,4,6 and 8
	public boolean setPlayer(int player)
	{
		if(player != 1 && player != 2)
			return false;
		else
		{
			if(player ==1)
			{
				this.index = -2;
				this.player = 1;
			}
			else
			{
				this.index = -1;
				this.player = 2;
			}

			return true;
		}	
	}

	//return the moves
	public ArrayList<Move> getMoves()
	{
		return this.moves;
	}

	//increment the number of wins if i win
	public void addWinCount()
	{
		this.winCount++;
	}

	//increment the number of loses if i lose
	public void addLostCount()
	{
		this.lostCount++;
	}

	//increment the number of draws if i draw
	public void addDrawCount()
	{
		this.drawCount++;
	}

}
