import java.util.*;
import java.io.*;

/**
 * MazeTester uses recursion to determine if a maze can be traversed.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class MazeTester
{
    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
	public static int startx;
	public static int starty;
	public static int endx;
	public static int endy;
	
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file containing the maze: ");
        String filename = scan.nextLine();
        
        Maze labyrinth = new Maze(filename);
        
        System.out.print("Enter your starting coordinates seperated by a space: ");
        startx = scan.nextInt();
        starty = scan.nextInt();
        System.out.print("Enter your ending coordinates seperated by a space: ");
        endx = scan.nextInt();
        endy = scan.nextInt();
      
        System.out.println(labyrinth);
        
        MazeSolver solver = new MazeSolver(labyrinth);
        
        boolean tFlag = solver.traverse(startx, starty, endx, endy);
        if (tFlag)
            System.out.println("The maze was successfully traversed!");
        else
            System.out.println("There is no possible path.");

        System.out.println(labyrinth);
        
        if(tFlag){
        	System.out.println("The following includes the solved path");
	        for(int row = 0; row < labyrinth.getRows(); row++){
	        	for(int col = 0; col < labyrinth.getColumns(); col++){
	        		if(labyrinth.getElement(row, col) == 2)
	        			labyrinth.markPath(row, col);
	        	}
	        }
	        
	        solver.Flips(startx, starty);
	        System.out.println(labyrinth);
        
        
        	for(int row = 0; row< labyrinth.getRows(); row++){
        		for(int col =0; col < labyrinth.getColumns(); col++){
        			if(labyrinth.getElement(row, col) == 3){
        				System.out.println("( " + row + ",  " + col + ") ");
        			}
        		}
        	}
        }
    }
    
    
}
