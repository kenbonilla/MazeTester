# MazeTester
Finds the optimal route in a maze
Maze Tester
Kenneth Bonilla

Given a recursive solution that takes 2D-Array mazes, where 0 is a wall and 1 is a potential path, solutions were found and given a value of 2. From this there were the addition of multiple functions.
The first function was to collect the coordinates of a valid solution and display them as ordered pairs. In order to do this, the 2s were converted into 3s, for actual solution path. Then a function was introduced that walked through the solutions and discarded branches that did not have 2 or more viable neighbors, or a viable neighbor and lay upon a border. This function was stepped through until no more 3s were converted back to 2s. This produced a map of 0 for wall, 1 for unchecked paths, 2, for checked paths, and 3 for viable paths.
After this was implemented, functionality to allow the user to choose alternate starting and ending coordinates were given. After some modification of the previous functions to allow for this addition, the units were tested. For testing purposes the given files were used: 1 (testfile.txt) and 3 (testfile3.txt). 1 was tested against the default coordinates.

 
 
Further algorithms will be needed to trim down solved path to least moves possible, but for now it does show paths explored and valid solutions while trimming away dead ends and hence fulfilling the requires. Again, the requirements were to find a solution path and display them as ordered pairs, trim away dead ends from solution path, and to allow the user to input various starting and ending coordinates.
