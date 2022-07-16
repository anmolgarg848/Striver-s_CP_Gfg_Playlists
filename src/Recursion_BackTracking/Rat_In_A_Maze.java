package Recursion_BackTracking;

import java.util.Arrays;
import java.util.Random;

public class Rat_In_A_Maze {
    public static void main(String[] args) {
        //generate all the paths to go from (0,0) to (n-1,n-1)
        int[][] arr = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 1, 1}};

        //DLRU  --> Down Left Right Up
        // 1 --> Empty
        // 0 --> Road Block
        int n = arr.length;
        int m = arr[0].length;
        int[][] vis = new int[n][m];
        System.out.println(Rat_Maze(arr, vis, 0, 0, "", n, m));

        System.out.println("=========================================================");
        int[] dir_row = {+1, 0, 0, -1}; //Direction Of row
        int[] dir_col = {0, +1, -1, 0}; //Direction of Column
        Rat_Maze_1(arr, vis, 0, 0, "", n, m, dir_row, dir_col);
    }

    //Count Ways and Print Direction
    private static int Rat_Maze(int[][] arr, int[][] vis, int r, int c, String ans, int n, int m) {
        //Base Case
        if (r == n - 1 && c == m - 1) {
            System.out.println(ans);
            return 1;
        }

        int down = 0, left = 0, up = 0, right = 0;
        //Moves

        //DownWard
        if (r + 1 < n && vis[r + 1][c] == 0 && arr[r + 1][c] == 1) {
            vis[r + 1][c] = 1;//mark Visited
            down = Rat_Maze(arr, vis, r + 1, c, ans + "D", n, m);
            vis[r + 1][c] = 0;//mark Visited

        }
        //Left
        if (c - 1 >= 0 && vis[r][c - 1] == 0 && arr[r][c - 1] == 1) {
            vis[r][c - 1] = 1;//mark Visited
            left = Rat_Maze(arr, vis, r, c - 1, ans + "L", n, m);
            vis[r][c - 1] = 0;//mark Visited

        }
        //Right
        if (c + 1 < m && vis[r][c + 1] == 0 && arr[r][c + 1] == 1) {
            vis[r][c + 1] = 1;//mark Visited
            right = Rat_Maze(arr, vis, r, c + 1, ans + "R", n, m);
            vis[r][c + 1] = 0;//mark Visited

        }
        //Up
        if (r - 1 >= 0 && vis[r - 1][c] == 0 && arr[r - 1][c] == 1) {
            vis[r - 1][c] = 1;//mark Visited
            up = Rat_Maze(arr, vis, r - 1, c, ans + "U", n, m);
            vis[r - 1][c] = 0;//mark Visited

        }

        return down + up + left + right;
    }


    //Clean Code --> Suppose Rat Can Move in all 8 direction's so to Avoid 8 if Conditions we use
    private static int Rat_Maze_1(int[][] arr, int[][] vis, int r, int c, String ans, int n, int m, int[] dir_row,
                                  int[] dir_col) {
        //Base Case
        if (r == n - 1 && c == m - 1) {
            System.out.println(ans);
            return 1;
        }

        int down = 0, left = 0, up = 0, right = 0;
        String dir = "DRLU";
        //For Each Cell we Check For Four Directions
        for (int i = 0; i < 4; i++) {
            int next_row = r + dir_row[i];
            int next_col = c + dir_col[i];
            //Corner Condition check
            if (next_row < n && next_col < m && next_row >= 0 && next_col >= 0 && vis[next_row][next_col] == 0 && arr[next_row][next_col] == 1) {
                vis[next_row][next_col] = 1;
                Rat_Maze_1(arr, vis, next_row, next_col, ans + dir.charAt(i), n, m, dir_row, dir_col);
                vis[next_row][next_col] = 0;
            }

        }
        return down + up + left + right;
    }
}
