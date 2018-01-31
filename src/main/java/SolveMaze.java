import edu.illinois.cs.cs125.lib.mazemaker.Maze;

/**
 * Solve a randomly-generated maze.
 *
 * @see <a href="https://github.com/cs125-illinois/mazemaker">Mazemaker on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/mazemaker/">Mazemaker Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/2/#maze">Lab 2 Writeup</a>
 */
@SuppressWarnings("checkstyle:emptyblock")
public class SolveMaze {

    /**
     * Implement your maze solving algorithm in the main method below.
     *
     * @param unused unused input arguments
     */

    public static void main(final String[] unused) {

        int total = 0; int successes = 0; int average = 0; int steps = 0;
        while(total<50){
            steps = 0;

            /*
             * Create a new 10 x 10 maze. Feel free to change these values.
             */
            //System.out.println("Generating Maze...");
            Maze maze = new Maze(10, 10);

            /*
             * Pick (0, 0), the bottom left corner, as the starting point.
             * Put the end in the top right corner.
             */
            maze.startAtZero();
            maze.endAtTopRight();

            /*
             * You should be able to solve a 10 x 10 maze in (far fewer than) 1000 steps.
             * Feel free to adjust this number if you experiment with other mazes.
             */
            System.out.println("Running...");
            for (int step = 0; step < 10000 && maze.isFinished()==false; step++) {
                // Implement your maze solving algorithm here
            steps++;

                maze.move();
                maze.turnLeft();
                while(!maze.canMove()) {
                    maze.turnRight();
                }


            }

            if (maze.isFinished()) {
                System.out.println("Success");
                successes++;
            } else {
                System.out.println("Failed");
            }
            // Updates the average.
            average += steps;
            total++;
        }
        average /= total;
        System.out.println("\n\nSucceeded " + successes + "/" + total + ".");
        System.out.println("Average completion time is " + average + " steps.");
    }
}
