import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int width = 69;
		int height = 69;

		boolean[][] maze = new boolean[width][height];

		// Set all cells to false (wall)
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				maze[i][j] = false;
			}
		}

		Random rand = new Random();

		int x = rand.nextInt(width);
		int y = rand.nextInt(height);

		maze[x][y] = true; // Set starting cell to true (path)

		List<int[]> frontier = new ArrayList<>();

		// Directions up, down, left, and right
		int[][] directions = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0}
		};

		for (int[] dir : directions) {
			int nx = x + dir[0];
			int ny = y + dir[1];

			if (nx > 0 && nx < width - 1 
				&& ny > 0 && ny < height - 1) {
				
				frontier.add(new int[]{nx, ny});

			}
		}

		while (!frontier.isEmpty()) {
			// Pick a random frontier cell
			int randIndex = rand.nextInt(frontier.size());
			int[] current = frontier.remove(randIndex);
			int cx = current[0];
			int cy = current[1];

			/* The first four lines of the main method's body in Main.java set up the maze's dimensions and initialize the grid:

int width = 69;: Declares and sets the width of the maze grid to 69 cells.
int height = 69;: Declares and sets the height of the maze grid to 69 cells.
boolean[][] maze = new boolean[width][height];: Creates a 2D boolean array (maze) with dimensions width by height, where each cell defaults to false (representing a wall).
// Set all cells to false (wall): A comment explaining the purpose of the following loop, which explicitly sets every cell in the array to false for clarity (though it's redundant since booleans default to false). */
		}
	}
}