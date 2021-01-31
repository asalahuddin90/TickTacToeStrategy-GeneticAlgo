package genetic;
/*
 * This class is written solely by Ahmad Salahuddin
 */
import java.util.ArrayList;
import java.util.Random;
/* 
 * This class depicts the population of generation in the evolution process
 * this contains strategies in an ArrayList
 */
public class StrategyPool 
{
	//initialize member variables
	ArrayList <Strategy> pool = new ArrayList<Strategy>();
	Random rand = new Random();
	int sizeOfPool = 21;
	int movesCount = 45;
	
	//create a new pool of strategies (Making strategies by randomly selecting moves)
	public void createPool()
	{
		for(int j = 0; j<this.sizeOfPool ; j++)
		{
			pool.add(getRandomStrategy());
		}
	}
	
	//print the list of strategies showing the move type objects that they contain
	public void printStrategies()
	{
		for(int i = 0; i<pool.size(); i++ )
		{
			String temp = "";
			for(int j = 0; j<9; j++)
			{
				temp = temp + " " + this.pool.get(i).nextMoveObject().moveType;
			}
			System.out.println("Strategy "+ i + " has moves "+temp);
		}
	}

	//create 9 move objects selecting their types randomly
	public Strategy getRandomStrategy() 
	{
		ArrayList <Move> moves = new ArrayList<Move> () ;
		for(int i =0; i<9; i++)
		{
			moves.add(createMoves());
		}
		
		Strategy s = new Strategy();
		s.addMoves(moves);
		
		return s;
	}

	//randomly create a new move
	public Move createMoves()
	{
		return new Move(rand.nextInt(movesCount) + 1);
	}
	
	//returns two strategies randomly selected from the pool
	public Strategy [] getTwoStrategies()
	{
		if(this.pool.size() == this.sizeOfPool)
		{
			int indexA = rand.nextInt(sizeOfPool);
			int indexB = rand.nextInt(sizeOfPool);
			
			return new Strategy[]{this.pool.get(indexA),this.pool.get(indexB)};
		}
		
		return null;
	}
	
	//add a strategy to the pool
	public void addToPool(Strategy s)
	{
		this.pool.add(s);
	}
	
	//copy the strategy pool and return the copied pool reference
	public StrategyPool copy()
	{
		StrategyPool newSP = new StrategyPool();
		for(int i = 0; i<this.pool.size();i++)
		{
			newSP.addToPool(pool.get(i));
		}
		
		return newSP;
		
	}
	
}
