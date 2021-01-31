package genetic;
/*
 * This class is written solely by Ahmad Salahuddin
 */
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) 
	{
		//set the foundOptimal solution flag to false
		boolean foundOptimal = false;

		//threshold is the number of losses, until the strategy is said to be evolved to pretty good
		Fitness.setThreshhold(18000);

		Strategy optimal = null;

		//this is the score used to write to a new file which has the eveolved strategy's details.
		StringBuilder score = new StringBuilder();
		score.append("Generation,Lost,Won,Total\n");

		//create a new pool of strategies
		StrategyPool sp = new StrategyPool();
		//createa new pool our of thin air. (makes up strategies that are made by selecting moves randomly)
		sp.createPool();
		//set the desired size of the strategy pool
		sp.sizeOfPool = 20;

		// can choose to print strategies that are created.
		//		sp.printStrategies();

		//copy strategy (to later test if evolved strategy was better than the 0 generation)
		StrategyPool sp1 = sp.copy();


		int generation = 0;
		//while the strategy is not found which meets the threshold requirement, keep doing this
		while(!foundOptimal)
		{
			//print the number of generation
			System.out.println("Generation: " + generation);

			//calculate the fitness of strategies by playing every strategy with every other strategy in the pool
			Fitness.calculateFitness(sp);

			//find the two best strategies from the pool
			ArrayList <Strategy> twoBest = Fitness.getTwoBestStrategies(sp);
			double totalGames= 0;
			//			if(twoBest.size()>0)
			{

				System.out.println("The best strategy has lost : " +twoBest.get(0).lostCount + " out of " + (2000*sp.sizeOfPool*(sp.sizeOfPool-1))+ " games");
				System.out.println("The best strategy has won : " +twoBest.get(0).winCount + " out of " + (2000*sp.sizeOfPool*(sp.sizeOfPool-1))+ " games");
				//				totalGames = 2000*sp.sizeOfPool*(sp.sizeOfPool-1);
				//					double percentage = twoBest.get(0).lostCount*100/totalGames;
				//					System.out.println("The best strategy has lost the percentage of  : " +percentage+ "% games");
			}

			//write to stringbuilder to later write to a file.
			score.append(generation+","+twoBest.get(0).lostCount+","+twoBest.get(0).winCount+","+totalGames+"\n");

			//look for an optimal strategy, and set the flag to true if found
			if(Fitness.getOptimalStrategy(sp) != null)
			{
				System.out.println("Optimal Strategy is found");
				foundOptimal = true;
				//get that optimal strategy (to play with some random strategies for demo)
				optimal = Fitness.getOptimalStrategy(sp);
			}

			//evolve, and get the new pool of strategies from the new population
			Evolution e = new Evolution();
			e.setNewPoolSize(sp.sizeOfPool);
			sp = e.getNextGen(twoBest);
			generation++;

		}
		
		//if the optimal strategy was found, create a new file and store the data in it. (to make a graph later)
		FileManager fm = new FileManager();
		fm.writeFile(score);
		
		
		//below is for demo. use the optimal strategy and play with a randomly selected strategy. Play as player one and as player 2.
		Game g = new Game();
		System.out.println("Game 1");
		Strategy [] testStrategies = sp1.getTwoStrategies();
		int winner = g.playSingleGame(optimal, testStrategies[0]);
		System.out.println("winner is : " + winner);

		System.out.println();
		System.out.println("Game 2");
		g = new Game();
		winner = g.playSingleGame(testStrategies[0], optimal);
		System.out.println("winner is : " + winner);
	}

}
