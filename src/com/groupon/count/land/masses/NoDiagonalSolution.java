package com.groupon.count.land.masses;

public class NoDiagonalSolution {

    public int countLandMasses(int[][] map) {
        int result = 0;

        if (map == null || map.length == 0 || map[0].length == 0) {
            return result;
        }

        int numRows = map.length;
        int numColumns = map[0].length;

        for (int row = 0; row < numRows; row++) {
            for (int column = 0; column < numColumns; column++) {
                if (map[row][column] == 1) {
                    result++;
                    sink(map, row, numRows, column, numColumns);
                }
            }
        }

        return result;
    }

    private void sink(int[][] map, int row, int numRows, int column, int numColumns) {
        if (row < 0 || row == numRows
            || column < 0 || column == numColumns
            || map[row][column] == 0) {
            return;
        }

        map[row][column] = 0;

        sink(map, row - 1, numRows, column, numColumns);
        sink(map, row + 1, numRows, column, numColumns);
        sink(map, row, numRows, column - 1, numColumns);
        sink(map, row, numRows, column + 1, numColumns);
    }
}
