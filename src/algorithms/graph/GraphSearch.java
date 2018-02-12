package algorithmsAndDataStructures.graph;

/**
 * Created by lujianyu on 4/28/17.
 */
public class GraphSearch {
    public static void main(String[] args) {
        System.out.println(trapRainWater(new int[][]{{12,13,1,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}}));
    }

    private static final int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public static int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0] == null || heightMap[0].length < 3) {
            return 0;
        }
        int m = heightMap.length, n = heightMap[0].length;
        int[] res = new int[1];
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (heightMap[i][j] == -1) { continue;}
                search(heightMap, i, j, m, n, heightMap[i][j], res);
                System.out.println("--res: " + res[0] + " i:" + i + " j:" + j);
            }
        }
        return res[0];
    }
    private static int search(int[][] heightMap, int i, int j, int m, int n, int target, int[] res) {
        heightMap[i][j] = -1;
        int surround = Integer.MAX_VALUE;
        for (int[] direction : directions) {
            int newi = i + direction[0];
            int newj = j + direction[1];
            if (newi < 0 || newi >= m || newj < 0 || newj >= n || heightMap[newi][newj] == -1) { continue;}
            if (heightMap[newi][newj] > target) {
                surround = Math.min(heightMap[newi][newj], surround);
            } else {
                if (newi <= 0 || newi >= m - 1 || newj <= 0 || newj >= n - 1 || heightMap[newi][newj] == -1) { continue;}
                surround = Math.min(surround, search(heightMap, newi, newj, m, n, heightMap[newi][newj], res));
            }
        }
        if (surround != Integer.MAX_VALUE) {
            System.out.println("surround: " + surround + " i:" + i + " j:" + j);
            res[0] += surround - target;
        }
        System.out.println("res: " + res[0] + " i:" + i + " j:" + j);
        return surround;
    }
}
