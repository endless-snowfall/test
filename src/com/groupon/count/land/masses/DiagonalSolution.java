package com.groupon.count.land.masses;

public class DiagonalSolution {

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

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                sink(map, r, numRows, c, numColumns);
            }
        }
    }
}
