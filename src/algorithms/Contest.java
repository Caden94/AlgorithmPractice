package algorithmsAndDataStructures;

import java.util.*;

public class Contest {

    public static void main(String[] args) {
//        int n = 2;
//        String[] broad = new String[]{".K",".K"};
//        System.out.println(solve(broad, n));

        String secret = "aca";
        String[] board = new String[]{  "bacabbbb",
                                        "bbabbbbb",
                                        "bbbbbbbb",
                                        "bbbbbbbb",
                                        "bbbbbbbb",
                                        "bbbbbbbb",
                                        "bbbbbbbb",
                                        "bbbbbbbb"};

        long res = solve(secret, board);
        System.out.println(res);
    }

    private static long solve(String secret, String[] board) {
        char[] s = secret.toCharArray();
        int N = 8, K = s.length;

        int res = 0;
        boolean[][] visited = new boolean[N][N];
        Integer[][][] f = new Integer[N][N][K];
        int[][][] d = new int[N][N][K];
        for (int i = 0; i < N; i++) { // O(N^2)
            for (int j = 0; j < N; j++) {
                if (board[i].charAt(j) == s[0]) {
                    res += search(i, j, 0, board, s, N, visited, f, d);
                }
            }
        }
        print(f);
        return res;
    }
    private static final int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    private static int search(int i, int j, int k, String[] b, char[] s, int N, boolean[][] visited, Integer[][][] f, int[][][] d) {
        if (i < 0 || i >= N || j < 0 || j >= N) { return 0; } // invalid
        if (f[i][j][k] != null) { return f[i][j][k]; }
        boolean recal = false;
        if (visited[i][j]) {
            recal = true;
        }
        if (i == 0 && j == 1 && k == 0) {
            System.out.print(i + ": " + j);
        }
        f[i][j][k] = 0;
        if (k == s.length - 1) { // last
            if (b[i].charAt(j) == s[k]) {
                f[i][j][k]++;
            }
        } else {
            // base case
            visited[i][j] = true;
            if (b[i].charAt(j) == s[k]) {
                for (int[] direction : directions) {
                    f[i][j][k] += search(i + direction[0], j + direction[1], k + 1, b, s, N, visited, f, d);
                }
            }
            visited[i][j] = false;
        }



        if (recal) {
            for (int p = k - 1; p >= 0; p--) {
                if (s[p] == s[k]) {
                    d[i][j][p] -= f[i][j][k];
                    break;
                }
            }
        }
        f[i][j][k] += d[i][j][k];
        return f[i][j][k];
    }

    private static void print(Integer[][][] f){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(f[i][j][0] + " ");
            }
            System.out.println();
        }
    }

}
