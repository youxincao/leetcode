package com.leetcode;

/**
 * Created by weilun on 2015/5/6.
 */
public class NumberIslands {

    private char[][] mGrid = null;

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        this.mGrid = grid;
        int width = grid[0].length;
        int height = grid.length;
        int count = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] != '0') {
                    visitorElement(i, j);
                    printGrid(mGrid);
                    count++;
                }
            }

        }
        return count;
    }

    private void visitorElement(int i, int j) {
        mGrid[i][j] = '0';
        int width = mGrid[0].length;
        int height = mGrid.length;

        if ((j + 1) < width && mGrid[i][j + 1] == '1')
            visitorElement(i, j + 1);
        if ((i + 1) < height && mGrid[i + 1][j] == '1')
            visitorElement(i + 1, j);
        if ((j - 1) >= 0 && mGrid[i][j - 1] == '1')
            visitorElement(i, j - 1);
        if ((i - 1) >= 0 && mGrid[i - 1][j] == '1') {
            visitorElement(i - 1, j);
        }
    }


    private static void printGrid(char[][] grid) {
        int width = grid[0].length;
        int height = grid.length;

        System.out.println("---------------------------------");

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(" " + grid[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        char[][] grid2 = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        char[][] grid3 = {{'1', '1', '1'},
                {'0', '1', '1'},
                {'1', '1', '1'}};


//        printGrid(grid);
//
//        visitorElement(grid, 0, 0);
//
//
//        printGrid(grid);

        NumberIslands nl = new NumberIslands();
//        System.out.println(nl.numIslands(grid));
//        System.out.println(nl.numIslands(grid2));
        System.out.println(nl.numIslands(grid3));
    }
}
