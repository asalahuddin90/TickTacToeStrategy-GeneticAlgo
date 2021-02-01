# TickTacToeStrategy-GeneticAlgo


## Code Description
The r script generates the graph for the results of the java code.
Please use RStudio to run the R script to generate the graph.

*Need to use the file output directory of the java file the same as the working directory of the R code to create the file and make a graph*

# Details of the project

## Classes
Board 				Represents the board of a TTT game
Game				Represents a single game b/w two players
Evolution			Responsible for all evolution related methods
FileManager		Used to write the score of best strategy to a file
Fitness				Evaluates fitness of strategies
Move				Represents a single move by a player
Strategy				Represents the order of moves of a player
StrategyPool		Contains many strategies in generations
Main				Starts the program

## Design
![alt text](https://github.com/asalahuddin90/TickTacToeStrategy-GeneticAlgo/blob/main/Architecture.jpg?raw=true)

## Characteristics of the Program
- 45 different (basic) moves
- Every generation strategy pool has 20 strategies
- To evaluate fitness, twenty thousand games are played between strategies (a strategy plays 20x19x20000 games) – Threshold is 18000
- The fitness is measured by the least number of total losses
- Two best strategies have moves cross overs to make children

## An example of a game
![alt text](https://github.com/asalahuddin90/TickTacToeStrategy-GeneticAlgo/blob/main/Game%20Example.jpg?raw=true)

## Strategy Evolution Example
![alt text](https://github.com/asalahuddin90/TickTacToeStrategy-GeneticAlgo/blob/main/StrategyEvolutionExample.jpg?raw=true)

## Factors that influence the performance
- The size of the pool of strategies in each generation
- The number of moves used to build strategies
- Sometimes its just luck (too much randomness)
- Player number can influence the strategy
- The quality of moves selected to build a strategy  - (most important)

## Enjoy!
