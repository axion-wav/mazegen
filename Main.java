import java.util.Random;
import java.util.ArrayList;
import java.util.List;

// Interactive Maze Generator (Prim's Algorithm) and Player
public class Main {
	public static void main(String[] args) {
		// Define maze dimensions (odd numbers)
		int width = 69;
		int height = 69;

		// Define entry points connected to the maze entrance (1, 1)
		int[][] entry = {{0, 0}, {0, 1}, {1, 0}};
		// Exit is random
		
		// Create 2D array representing the maze
		boolean[][] maze = new boolean[width][height];

		// Set all cells to false (walls)
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				maze[i][j] = false;
			}
		}

		// Create random instance for use in Prim's algorithm
		Random rand = new Random();

		// Set the cell at starting coordinates (1,1) to true (path)
		int x = 1, y = 1;
		maze[x][y] = true;

		// List to hold "frontier" cells
		List<int[]> frontier = new ArrayList<>();

		// Directions up, down, left, and right
		int[][] directions = {
			{0, -1},
			{0, 1},
			{-1, 0},
			{1, 0}
		};

		// Add neighbors of the starting cell to frontier list
		for (int[] dir : directions) {
			int nx = x + dir[0];
			int ny = y + dir[1];

			if (nx > 0 && nx < width - 1 
				&& ny > 0 && ny < height - 1) {
				
				frontier.add(new int[]{nx, ny});

			}
		}

		// Execute Prim's algorithm in while loop
		while (!frontier.isEmpty()) {
			// Pick a random frontier cell
			int randIndex = rand.nextInt(frontier.size());
			int[] current = frontier.remove(randIndex);

			// Count adjacent path cells
			int cx = current[0];
			int cy = current[1];
			
			int count = 0;
			for (int[] dir : directions) {
				int nx = cx + dir[0];
				int ny = cy + dir[1];

				if (nx > 0 && nx < width - 1 
					&& ny > 0 && ny < height - 1) {
					if( maze[nx][ny]) {
						count++;
					}
				}
			}

			// If only one adjacent path cell, set current cell to path
			if (count == 1) {
				maze[cx][cy] = true; // Set cell to true (path)
			} else {
				continue; // Skip adding neighbors if more than one adjacent path
			}

			// Add neighbors of current cell to frontier list
			for (int[] dir : directions) {
				int nx = cx + dir[0];
				int ny = cy + dir[1];

				if (nx > 0 && nx < width - 1 
					&& ny > 0 && ny < height - 1 && !maze[nx][ny]) {
					
					frontier.add(new int[]{nx, ny});

				}
			}
		}

		int exitX, exitY;
		if (rand.nextBoolean()) {
			// Exit placed at right border
			exitX = width - 2;
			exitY = rand.nextInt(height - 2) + 1;
			maze[exitX][exitY] = true;
			maze[width - 1][exitY] = true; // Ensure exit is open
		} else {
			// Exit placed at bottom border
			exitX = rand.nextInt(width - 2) + 1;
			exitY = height - 2;
			maze[exitX][exitY] = true;
			maze[exitX][height - 1] = true; // Ensure exit is open
		}
		

		for (int[] e : entry) {
			maze[e[0]][e[1]] = true;
		}



		// Print maze
		for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                System.out.print(maze[i][j] ? "  " : "██");
            }
            System.out.println();
        }
    }
}