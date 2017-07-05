package graph;

/**
 * Created by lujianyu on 4/30/17.
 */
public class Matrix2D {
    /*
     * directions could be 4 ways, 8 ways or others.
     */
    private final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    /*
     * No back tracking
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length, count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                count++;
                search(grid, i, j, m, n);
            }
        }
        return count;
    }

    private void search(char[][] grid, int i, int j, int m, int n) {
        // Boundary
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        // Visited
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        // Search
        for (int[] direction : directions) {
            search(grid, i + direction[0], j + direction[1], m, n);
        }
    }
}
