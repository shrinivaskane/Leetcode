class LC304_2dSumPrefix {
    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        sumMatrix = new int[rows + 1][cols + 1];
        for (int r = 0; r < rows; r++) {
            int prefix = 0;
            for (int c = 0; c < cols; c++) {
                prefix += matrix[r][c];
                int above = sumMatrix[r][c + 1];
                sumMatrix[r + 1][c + 1] = prefix + above;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        row2++;
        col1++;
        col2++;

        int current = sumMatrix[row2][col2];
        int top = sumMatrix[row1 - 1][col2];
        int left = sumMatrix[row2][col1 - 1];
        int topleft = sumMatrix[row1 - 1][col1 - 1];
        return current - top - left + topleft;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
