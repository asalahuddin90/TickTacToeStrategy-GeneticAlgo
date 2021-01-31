package genetic;
/*
 * This class is written solely by Ahmad Salahuddin
 */
import java.util.ArrayList;
import java.util.Random;
/* This class depicts the move object which is the chromosome in the genetic algorithm
 * 9 collection of moves are used to create strategies
 */
public class Move 
{

	Board board;
	int moveType;
	Random rand = new Random();
	
	//when creating a move object, select the type of move (type indicates how the move with response to the state of the board)
	public Move(int type)
	{

		this.moveType = type;
	}
	
	//a method which finds all the empty positions in a board.
	private ArrayList<Integer> getEmptyPositions(Board board) 
	{
		ArrayList<Integer> emptyPositions = new ArrayList<Integer>();
		for(int i = 0; i<9 ; i++)
		{
			if(board.state[i] == -1)
			{
				emptyPositions.add(i);
			}
		}
		return emptyPositions;
	}

	//gets the response of the move depending on the type when initialized.
	//contains 45 different basic rules that I (Ahmad Salahuddin) came up with on my own and encoded.
	public int get(Board board, int player)
	{
		ArrayList<Integer> emptyPositions = getEmptyPositions(board);
		ArrayList<Integer> corners = getCorners(board);
		ArrayList<Integer> edges = getEdges(board);
		
		ArrayList<Integer> firstRow = getFirstRow(board);
		ArrayList<Integer> secondRow = getSecondRow(board);
		ArrayList<Integer> thirdRow = getThirdRow(board);
		
		ArrayList<Integer> firstColumn = getFirstColumn(board);
		ArrayList<Integer> secondColumn = getSecondColumn(board);
		ArrayList<Integer> thirdColumn = getThirdColumn(board);
		
		int nEmpty = emptyPositions.size();
		int temp;
		if(nEmpty == 0)
		{
			return -1;
		}
		else if(nEmpty == 1)
		{
			return emptyPositions.get(0);
		}
		else
		{
	        switch (this.moveType) 
	        {
            case 1:  
            	 if(nEmpty>0)
            	 {
            		 if(emptyPositions.contains(4))
            		 {
            			 return 4;
            		 }
            		 else if(board.state[4] != player && board.state[4] != -1)
            		 {
            			 if(emptyPositions.contains(8))
            				 return 8;
            			 else if(emptyPositions.contains(0))
            				 return 0;	 
            		 }
            	 }
        		 return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            	 
            case 2:  
            	if(corners.size()>0)
            	{
            		temp = rand.nextInt(corners.size());
            		return emptyPositions.get(temp);
            	}
               	return emptyPositions.get(rand.nextInt(nEmpty));
            	
            	 
            case 3:
            	if(edges.size()>0)
            	{
            		temp = rand.nextInt(edges.size());
            		return emptyPositions.get(temp);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 4:
            	if(emptyPositions.contains(4))
            	{
            		return 4;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 5:
            	if(corners.size()>0)
            	{
            		return corners.get(0);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 6:
            	if(corners.size()>0)
            	{
            		return corners.get(corners.size()-1);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 7:
            	if(firstRow.size()>0)
            	{
            		return firstRow.get(0);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 8:
            	if(firstRow.size()>0)
            	{
            		return firstRow.get(firstRow.size()-1);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 9:
            	if(secondRow.size()>0)
            	{
            		return secondRow.get(0);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 10:
            	if(secondRow.size()>0)
            	{
            		return secondRow.get(secondRow.size()-1);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 11:
            	if(thirdRow.size()>0)
            	{
            		return thirdRow.get(0);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 12:
            	if(thirdRow.size()>0)
            	{
            		return thirdRow.get(thirdRow.size()-1);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 13:
            	if(firstColumn.size()>0)
            	{
            		return firstColumn.get(0);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 14:
            	if(firstColumn.size()>0)
            	{
            		return firstColumn.get(firstColumn.size()-1);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 15:
            	if(secondColumn.size()>0)
            	{
            		return secondColumn.get(0);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 16:
            	if(secondColumn.size()>0)
            	{
            		return secondColumn.get(secondColumn.size()-1);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 17:
            	if(thirdColumn.size()>0)
            	{
            		return thirdColumn.get(0);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 18:
            	if(thirdColumn.size()>0)
            	{
            		return thirdColumn.get(thirdColumn.size()-1);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 19:
            	if(nEmpty>0)
            	{
            		return emptyPositions.get(1);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	 
            case 20:
            	if(nEmpty>0)
            	{
            		return emptyPositions.get(nEmpty-1);
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 21:
            	if(nEmpty>0)
            	{
            		if(board.state[0] == player || board.state[8] == player || board.state[6] == player ||board.state[2] == player)
            		{
            			if(emptyPositions.contains(4))
            				return 4;
            			else
            				return emptyPositions.get(rand.nextInt(nEmpty));
            		}
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 22:
            	if(nEmpty>0)
            	{
            		if(board.state[0] == player && emptyPositions.contains(1))
            			return 1;
            		else if(board.state[2] == player && emptyPositions.contains(5))
            			return 5;
            		else if(board.state[8] == player && emptyPositions.contains(7))
        				return 7;
            		else if(board.state[6] == player && emptyPositions.contains(3))
        				return 3;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 23:
            	if(nEmpty>0)
            	{
            		if(board.state[0] == player && emptyPositions.contains(3))
            			return 3;
            		else if(board.state[2] == player && emptyPositions.contains(1))
            			return 1;
            		else if(board.state[8] == player && emptyPositions.contains(5))
        				return 5;
            		else if(board.state[6] == player && emptyPositions.contains(7))
        				return 7;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 24:
            	if(nEmpty>0)
            	{
            		if(board.state[6] == player && emptyPositions.contains(4))
            			return 4;
            		else if(board.state[2] == player && emptyPositions.contains(4))
            			return 4;
            		else if(board.state[0] == player && emptyPositions.contains(4))
            			return 4;
            		else if(board.state[8] == player && emptyPositions.contains(4))
            			return 4;
            		
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 25:
            	if(nEmpty>0)
            	{
            		if(board.state[4] == player && emptyPositions.contains(6))
            			return 6;
            		else if(board.state[4] == player && emptyPositions.contains(2))
            			return 2;
            		else if(board.state[4] == player && emptyPositions.contains(0))
        				return 0;
            		else if(board.state[4] == player && emptyPositions.contains(8))
        				return 8;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 26:
            	if(nEmpty>0)
            	{
            		if(board.state[4] == player && emptyPositions.contains(3))
            			return 3;
            		else if(board.state[4] == player && emptyPositions.contains(1))
            			return 1;
            		else if(board.state[4] == player && emptyPositions.contains(5))
        				return 5;
            		else if(board.state[4] == player && emptyPositions.contains(7))
        				return 7;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 27:
            	if(nEmpty>0)
            	{
            		if(board.state[5] == player && emptyPositions.contains(4))
            			return 4;
            		else if(board.state[3] == player && emptyPositions.contains(4))
            			return 4;
            		else if(board.state[1] == player && emptyPositions.contains(4))
        				return 4;
            		else if(board.state[7] == player && emptyPositions.contains(4))
        				return 4;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 28:
            	if(nEmpty>0)
            	{
            		if(board.state[5] == player && emptyPositions.contains(3))
            			return 3;
            		else if(board.state[5] == player && emptyPositions.contains(7))
            			return 7;
            		else if(board.state[5] == player && emptyPositions.contains(1))
        				return 1;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 29:
            	if(nEmpty>0)
            	{
            		if(board.state[3] == player && emptyPositions.contains(5))
            			return 5;
            		else if(board.state[3] == player && emptyPositions.contains(7))
            			return 7;
            		else if(board.state[3] == player && emptyPositions.contains(1))
        				return 1;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 30:
            	if(nEmpty>0)
            	{
            		if(board.state[1] == player && emptyPositions.contains(5))
            			return 5;
            		else if(board.state[1] == player && emptyPositions.contains(7))
            			return 7;
            		else if(board.state[1] == player && emptyPositions.contains(3))
        				return 3;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 31:
            	if(nEmpty>0)
            	{
            		if(board.state[7] == player && emptyPositions.contains(5))
            			return 5;
            		else if(board.state[7] == player && emptyPositions.contains(1))
            			return 1;
            		else if(board.state[7] == player && emptyPositions.contains(3))
        				return 3;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            	
            case 32:
            	if(nEmpty>0)
            	{
            		if(board.state[0] == player && emptyPositions.contains(8))
            			return 8;
            		else if(board.state[8] == player && emptyPositions.contains(0))
            			return 0;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 33:
            	if(nEmpty>0)
            	{
            		if(board.state[2] == player && emptyPositions.contains(6))
            			return 6;
            		else if(board.state[6] == player && emptyPositions.contains(2))
            			return 2;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 34:
            	if(nEmpty>0)
            	{
            		if(board.state[1] == player && emptyPositions.contains(2))
            			return 2;
            		else if(board.state[5] == player && emptyPositions.contains(8))
            			return 8;
            		else if(board.state[7] == player && emptyPositions.contains(6))
            			return 6;
            		else if(board.state[3] == player && emptyPositions.contains(0))
            			return 0;	
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 35:
            	if(nEmpty>0)
            	{
            		if(board.state[1] == player && emptyPositions.contains(0))
            			return 0;
            		else if(board.state[5] == player && emptyPositions.contains(2))
            			return 2;
            		else if(board.state[7] == player && emptyPositions.contains(8))
            			return 8;
            		else if(board.state[3] == player && emptyPositions.contains(6))
            			return 6;	
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 36:
            	if(nEmpty>0)
            	{
            		if(board.state[0] == player && board.state[4] == player  && emptyPositions.contains(8))
            			return 8;
            		else if(board.state[0] == player && board.state[8] == player  && emptyPositions.contains(4))
            			return 4;
            		else if(board.state[4] == player && board.state[8] == player  && emptyPositions.contains(0))
            			return 0;	
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 37:
            	if(nEmpty>0)
            	{
            		if(board.state[2] == player && board.state[4] == player  && emptyPositions.contains(6))
            			return 6;
            		else if(board.state[2] == player && board.state[6] == player  && emptyPositions.contains(4))
            			return 4;
            		else if(board.state[4] == player && board.state[6] == player  && emptyPositions.contains(2))
            			return 2;	
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 38:
            	if(nEmpty>0)
            	{
            		if(board.state[0] == player && board.state[1] == player  && emptyPositions.contains(2))
            			return 2;
            		else if(board.state[0] == player && board.state[2] == player  && emptyPositions.contains(1))
            			return 1;
            		else if(board.state[1] == player && board.state[2] == player  && emptyPositions.contains(0))
            			return 0;	
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 39:
            	if(nEmpty>0)
            	{
            		if(board.state[3] == player && board.state[4] == player  && emptyPositions.contains(5))
            			return 5;
            		else if(board.state[3] == player && board.state[5] == player  && emptyPositions.contains(4))
            			return 4;
            		else if(board.state[4] == player && board.state[5] == player  && emptyPositions.contains(3))
            			return 3;	
            	}
            case 40:
            	if(nEmpty>0)
            	{
            		if(board.state[6] == player && board.state[7] == player  && emptyPositions.contains(8))
            			return 8;
            		else if(board.state[6] == player && board.state[8] == player  && emptyPositions.contains(7))
            			return 7;
            		else if(board.state[7] == player && board.state[8] == player  && emptyPositions.contains(6))
            			return 6;	
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 41:
            	if(nEmpty>0)
            	{
            		if(board.state[0] == player && board.state[3] == player  && emptyPositions.contains(6))
            			return 6;
            		else if(board.state[0] == player && board.state[6] == player  && emptyPositions.contains(3))
            			return 3;
            		else if(board.state[3] == player && board.state[6] == player  && emptyPositions.contains(0))
            			return 0;	
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 42:
            	if(nEmpty>0)
            	{
            		if(board.state[1] == player && board.state[4] == player  && emptyPositions.contains(7))
            			return 7;
            		else if(board.state[1] == player && board.state[7] == player  && emptyPositions.contains(4))
            			return 4;
            		else if(board.state[7] == player && board.state[4] == player  && emptyPositions.contains(1))
            			return 1;	
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 43:
            	if(nEmpty>0)
            	{
            		if(board.state[2] == player && board.state[5] == player  && emptyPositions.contains(8))
            			return 8;
            		else if(board.state[2] == player && board.state[8] == player  && emptyPositions.contains(5))
            			return 5;
            		else if(board.state[5] == player && board.state[8] == player  && emptyPositions.contains(2))
            			return 2;	
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 44:
            	if(nEmpty>0)
            	{
            		if(board.state[0] == -1)
            			return 0;
            		else if(board.state[2] == -1)
            			return 2;
            		else if(board.state[6] == -1)
            			return 6;
            		else if(board.state[8] == -1)
            			return 8;
            	}
            	return emptyPositions.get(rand.nextInt(nEmpty));
            case 45:
            	return emptyPositions.get(rand.nextInt(nEmpty));

            default:
            		return -1;
	        }
		}
	}

	//get the emtpy positions only in the first row of the board.
	private ArrayList<Integer> getFirstRow(Board board) 
	{
		ArrayList<Integer> firstRow = new ArrayList<Integer>();
		if(board.state[0] == -1)
			firstRow.add(0);
		if(board.state[1] == -1)
			firstRow.add(1);
		if(board.state[2] == -1)
			firstRow.add(2);
		
		return firstRow;
	}

	//get the emtpy positions only in the second row of the board.
	private ArrayList<Integer> getSecondRow(Board board) 
	{
		ArrayList<Integer> secondRow = new ArrayList<Integer>();
		if(board.state[3] == -1)
			secondRow.add(3);
		if(board.state[4] == -1)
			secondRow.add(4);
		if(board.state[5] == -1)
			secondRow.add(5);
		
		return secondRow;
	}

	//get the emtpy positions only in the third row of the board.
	private ArrayList<Integer> getThirdRow(Board board) 
	{
		ArrayList<Integer> thirdRow = new ArrayList<Integer>();
		if(board.state[6] == -1)
			thirdRow.add(6);
		if(board.state[7] == -1)
			thirdRow.add(7);
		if(board.state[8] == -1)
			thirdRow.add(8);
		
		return thirdRow;
	}

	//get the emtpy positions only in the first column of the board.
	private ArrayList<Integer> getFirstColumn(Board board) 
	{
		ArrayList<Integer> firstColumn = new ArrayList<Integer>();
		if(board.state[0] == -1)
			firstColumn.add(0);
		if(board.state[3] == -1)
			firstColumn.add(3);
		if(board.state[6] == -1)
			firstColumn.add(6);
		
		return firstColumn;
	}

	//get the emtpy positions only in the second column of the board.
	private ArrayList<Integer> getSecondColumn(Board board) 
	{
		ArrayList<Integer> secondColumn = new ArrayList<Integer>();
		if(board.state[1] == -1)
			secondColumn.add(1);
		if(board.state[4] == -1)
			secondColumn.add(4);
		if(board.state[7] == -1)
			secondColumn.add(7);
		
		return secondColumn;
	}

	//get the emtpy positions only in the third column of the board.
	private ArrayList<Integer> getThirdColumn(Board board) 
	{
		ArrayList<Integer> thirdColumn = new ArrayList<Integer>();
		if(board.state[2] == -1)
			thirdColumn.add(2);
		if(board.state[5] == -1)
			thirdColumn.add(5);
		if(board.state[8] == -1)
			thirdColumn.add(8);
		
		return thirdColumn;
	}

	//get the edges of the board (positions 1, 3, 5, 7). These are not corners.
	private ArrayList<Integer> getEdges(Board board) 
	{
		ArrayList<Integer> edges = new ArrayList<Integer>();
		if(board.state[1] == -1)
			edges.add(1);
		if(board.state[3] == -1)
			edges.add(3);
		if(board.state[5] == -1)
			edges.add(5);
		if(board.state[7] == -1)
			edges.add(7);
		
		return edges;
	}

	//get the emtpy positions only in the corners of the board.
	private ArrayList<Integer> getCorners(Board board) 
	{
		ArrayList<Integer> edges = new ArrayList<Integer>();
		if(board.state[0] == -1)
			edges.add(0);
		if(board.state[2] == -1)
			edges.add(2);
		if(board.state[6] == -1)
			edges.add(6);
		if(board.state[8] == -1)
			edges.add(8);
		return edges;
	}
}
