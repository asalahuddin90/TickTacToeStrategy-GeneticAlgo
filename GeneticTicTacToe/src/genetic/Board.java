package genetic;
/*
 * This class is written solely by Ahmad Salahuddin
 */
public class Board 
{
	public int [] state;
	//create a new board and set the state of all positions -1(empty)
	public Board()
	{
		this.state = new int[9];
		for(int i =0; i < state.length; i++)
		{
			this.state[i] = -1;
		}
	}
	
	
	
	
}
