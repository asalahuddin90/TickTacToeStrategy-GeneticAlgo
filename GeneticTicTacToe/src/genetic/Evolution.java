package genetic;
/*
 * This class is written solely by Ahmad Salahuddin
 */
import java.util.ArrayList;
import java.util.Random;
/*
 * this class depicts the evolution of a new generation.
 */
public class Evolution 
{
	int newPoolSize = 21;
	//this function uses the two best strategies to create many different strategies to include in the new generation
	public StrategyPool getNextGen(ArrayList<Strategy> twoBest)
	{

		Strategy s1 = new Strategy();
		Strategy s2 = new Strategy();

		s1.addMoves(twoBest.get(0).moves);
		s2.addMoves(twoBest.get(1).moves);

		StrategyPool sp = new StrategyPool();
		sp.sizeOfPool = newPoolSize;
		sp.addToPool(s1);
		sp.addToPool(s2);

		ArrayList<Strategy> newPool = reproduce(s1,s2);
		sp.pool = newPool;

		return sp;
	}

	//the previous function calls this method to do the cross over.
	//this method randomly selects the chromosomes of best strategies and does the crossover.
	private ArrayList<Strategy> reproduce(Strategy s1, Strategy s2) 
	{
		ArrayList <Strategy> generation = new ArrayList<Strategy>();

		for(int j = 0; j < this.newPoolSize; j++)
		{
			Strategy s = new Strategy();
			Move move = null;
			Random rand = new Random();
			for(int i = 0; i<9; i++)
			{
				int stratNumber = rand.nextInt(2)+1;
				if(stratNumber == 1)
				{
					move = s1.moves.get(rand.nextInt(9));
				}
				else if (stratNumber == 2)
				{
					move = s2.moves.get(rand.nextInt(9));
				}

				s.moves.add(move);
			}


			generation.add(s);
		}

		return generation;
	}

	//sets the size of the new pool.
	public void setNewPoolSize(int i) 
	{
		this.newPoolSize = i;

	}

}
