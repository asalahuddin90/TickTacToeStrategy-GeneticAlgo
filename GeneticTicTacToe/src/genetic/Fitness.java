package genetic;
/*
 * This class is written solely by Ahmad Salahuddin
 */
import java.util.ArrayList;
/*
 * This performs all the operations related to fitness calculation of strategies in a pool (generation)
 */
public class Fitness 
{
	static int threshhold = 18000;
	
	//this method calculates and sets the number of wins, and losses in a pool of by playing against every other strategy in the pool
	//each strategy plays as player 1 one thousand times with every other strategy
	//each strategy player as player 2 another one thousand times with every other strategy
	public static void calculateFitness(StrategyPool sp)
	{
		for(int i = 0; i<sp.pool.size() ; i++)
		{
			for(int j = 0; j <sp.pool.size() ; j++)
			{
				if(i == j)
					; //do nothing
				else
				{
//					System.out.println("Playing Strategy " +i +" against " +j );
					Strategy p1 = sp.pool.get(i);
					Strategy p2 = sp.pool.get(j);
					int winner = 0;
					for(int k = 0; k<1000 ; k++)
						{
							winner = new Game().play(p1,p2);
							if(winner == 0)
							{
								p1.addDrawCount();
								p2.addDrawCount();
							}
							else if(winner == 1)
							{
								p1.addWinCount();
								p2.addLostCount();
							}
							else if(winner ==2)
							{
								p1.addLostCount();
								p2.addWinCount();
							}
						}
					
					//switch positions
					p2 = sp.pool.get(i);
					p1 = sp.pool.get(j);

//					System.out.println("Playing Strategy " +j +" against " +i );
					
					for(int k = 0; k<1000 ; k++)
					{
						winner = new Game().play(p1,p2);
						if(winner == 0)
						{
							p1.addDrawCount();
							p2.addDrawCount();
						}
						else if(winner == 1)
						{
							p1.addWinCount();
							p2.addLostCount();
						}
						else if(winner ==2)
						{
							p1.addLostCount();
							p2.addWinCount();
						}
					}

				}
			}
		}
	}
	
	//returns the top two strategies in a pool depending on their number of losses
	public static ArrayList<Strategy> getTwoBestStrategies(StrategyPool sp)
	{
		ArrayList <Strategy> twoBest = new ArrayList<Strategy>();
		Strategy best = null;
		Strategy secondBest = null;
		
		int minLost = Integer.MAX_VALUE;
		int minSecondLost = Integer.MAX_VALUE;
		
		for(int i = 0; i<sp.pool.size(); i++)
		{
			Strategy temp = sp.pool.get(i);
			if(temp.lostCount < minLost)
			{
				minLost = temp.lostCount;
				best  = temp;
			}
		}
		
		for(int i = 0; i< sp.pool.size(); i++)
		{
			Strategy temp = sp.pool.get(i);
			if(temp.lostCount < minSecondLost && temp.lostCount > minLost)
			{
				minSecondLost = temp.lostCount;
				secondBest = temp;
			}
		}
		
		if(best != null)
		{
			twoBest.add(best);
		}
		if(best != null)
		{
			twoBest.add(secondBest);
		}
		
		return twoBest;
	}
	
	//compare each strategy's fitness with the threshold to see if a great strategy has evolved.
	public static Strategy getOptimalStrategy(StrategyPool sp)
	{
		Strategy optimalStrat = null;
		for(int i = 0; i< sp.pool.size(); i++)
		{
			Strategy temp = sp.pool.get(i);
			if(temp.lostCount <= threshhold)
			{
				optimalStrat = temp;
			}
		}
		return optimalStrat;
	}
	
	//set the threshold
	public static void setThreshhold(int t)
	{
		threshhold = t;
	}
}
