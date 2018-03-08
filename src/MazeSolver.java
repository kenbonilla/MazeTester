import java.util.*;

/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class MazeSolver
{
    static Maze maze;
    
    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }
    
    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse(int aX, int aY, int zX, int zY)
    {
        boolean done = false;

        Position pos = new Position(aX, aY);
        Deque<Position> stack = new LinkedList<Position>();
        stack.push(pos);
        
        
        while (!(done) && !stack.isEmpty())
        {
        	pos = stack.pop();
            maze.tryPosition(pos.getx(),pos.gety());  // this cell has been tried
            if (pos.getx() == zX && pos.gety() == zY) 
                done = true;  // the maze is solved
            else
            {
                
            	push_new_pos(pos.getx() - 1,pos.gety(), stack); 
                push_new_pos(pos.getx() + 1,pos.gety(), stack);
                push_new_pos(pos.getx(),pos.gety() - 1, stack);
                push_new_pos(pos.getx(),pos.gety() + 1, stack); 
 
                }
            }
            
        
        

        return done;
    }
    
    /**
     * Push a new attempted move onto the stack
     * @param x represents x coordinate
     * @param y represents y coordinate
     * @param stack the working stack of moves within the grid
     * @return stack of moves within the grid
     */
    private boolean push_new_pos(int x, int y, 
                                         Deque<Position> stack)
    {
        Position npos = new Position();
        npos.setx(x);
        npos.sety(y);
        if (maze.validPosition(x,y)){
            stack.push(npos);
            return true;
        }
        return false;
    }
    

    
    public void Flips(int aX, int aY){
    	

    	maze.markPath(aX, aY);
    	maze.markPath(MazeTester.endx, MazeTester.endy);
    	
    	int rows = MazeSolver.maze.getRows();
    	int cols = MazeSolver.maze.getColumns();
    	boolean validBridge = false;
    	boolean flipToTwo = true;
    	
    	do{
    		flipToTwo = false;
    		for(int row = aX; row < rows; row++){
        		for(int col = aY; col < cols; col++){
        			if(MazeSolver.maze.getElement(row, col) == 3){
	        			validBridge = CheckFlow(row, col);
	        			if(!validBridge){
	        				if(maze.hasThree(row, col));
	        				MazeSolver.maze.tryPosition(row, col);
	        				flipToTwo = true;
	        				}
        			}
        		}
        	}
    	}while(flipToTwo);
    	 

    	
    }
    
    public boolean CheckFlow(int x, int y){
    	int changeCounter = 0;
		changeCounter += checkBorder(x-1,y  );//left
    	changeCounter += checkBorder(x  ,y-1);//up
    	changeCounter += checkBorder(x+1,y  );//right
    	changeCounter += checkBorder(x  ,y+1);//down
    	if( x == MazeTester.endx && y == MazeTester.endy) changeCounter++;
    	if( x == MazeTester.startx && y == MazeTester.starty) changeCounter++;

    	if (changeCounter >= 2) return true;
    	return false;

    }
    
    public int checkBorder(int x, int y){
    	if(MazeTester.startx == x && MazeTester.starty == y)
    		return 1;
    	else if(MazeTester.endx == x && MazeTester.endy == y)
    		return 1;
    	else if(x>=0 && y>=0){
    		if(x<MazeSolver.maze.getRows() && y<MazeSolver.maze.getColumns()){
    			if(MazeSolver.maze.hasThree(x, y)) return 1; // checks if contains a 3
    		}
    	}
    	return 0;
    }
    



}
