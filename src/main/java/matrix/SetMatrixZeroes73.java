package matrix;

import java.util.Arrays;

/**
 * 73. 矩阵置零
 *
 * @author tenji
 * @date 2024-08-07
 */
public class SetMatrixZeroes73 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        // 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
        // 输出：[[1,0,1],[0,0,0],[1,0,1]]


        new SetMatrixZeroes73().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        /*
        1、第一次遍历，记录每一行，每一列是否需要置零；
        2、第二次遍历，根据第一次遍历记录的信息，将对应的元素置零。
         */

        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        // 第一次遍历
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = cols[j] = 1;
                }
            }
        }

        // 第二次遍历
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
