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

		
	}
}