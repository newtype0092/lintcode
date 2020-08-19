import java.util.ArrayList;

public class Solution944 extends Solution {

    public Solution944() {
        intputs = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(new int[][] {
                        {0,-2,-7,0},
                        {9,2,-6,2},
                        {-4,1,-4,1},
                        {-1,8,0,-2},
                });
            }});
        }};

        outputs = new ArrayList<>() {{
            add(15);
        }};
    }

    private int maxSubarray(int[] array) {
        int max = 0;
        int tmp = 0;
        for (int v: array) {
            tmp = Math.max(tmp + v, v);
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    public int maxSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows < 1) { return 0; }
        int cols = matrix[0].length;
        if (cols < 1) { return 0; }

        for (int row = 1; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] += matrix[row - 1][col];
            }
        }

        int max = 0;
        int[] tmpRow = new int[cols];
        for (int top = 0; top < rows; top++) {
            for (int bottom = top; bottom < rows; bottom++) {
                if (top == 0) {
                    max = Math.max(max, this.maxSubarray(matrix[bottom]));
                } else {
                    int diffRowIdx = (top - 1);
                    for (int i = 0; i < cols; i++) {
                        tmpRow[i] = matrix[bottom][i] - matrix[diffRowIdx][i];
                    }
                    max = Math.max(max, this.maxSubarray(tmpRow));
                }
            }
        }

        return max;
    }
}
