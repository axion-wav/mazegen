import java.util.Random;

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

		int x = Math.random() * width;
		int y = Math.random() * height;
	}
}
