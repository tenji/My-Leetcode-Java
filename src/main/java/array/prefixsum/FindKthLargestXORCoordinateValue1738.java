package array.prefixsum;

import java.util.ArrayList;
import java.util.List;

/**
 * 1738. 找出第 K 大的异或坐标值
 *
 * @author tenji
 * @date 2024-05-29
 */
public class FindKthLargestXORCoordinateValue1738 {

    public static void main(String[] args) {

        int[][] matrix = {
                {5, 2},
                {1, 6}
        };
        int k = 1;
        // 输入：matrix = [[5,2],[1,6]], k = 1
        // 输出：7

        System.out.println(new FindKthLargestXORCoordinateValue1738().kthLargestValue(matrix, k));
    }

    public int kthLargestValue(int[][] matrix, int k) {
        /*
        1、计算每个坐标的目标值 target[i][j]，target[i][j] = target[i - 1][j] ^ target[i][0] ^ ... ^ target[i][j]，并将目标值放入 ArrayList；
        2、对 ArrayList 中的元素进行排序，返回第 K 大的值
         */

        int[][] target = new int[matrix.length][matrix[0].length];
        List<Integer> valueList = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int tmp = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    tmp = matrix[i][0];
                } else {
                    tmp ^= matrix[i][j];
                }

                target[i][j] = i == 0 ? tmp : tmp ^ target[i - 1][j];
                valueList.add(target[i][j]);
            }
        }

        valueList.sort((o1, o2) -> o2 - o1);

        return valueList.get(k - 1);
    }

    public int kthLargestValueOptimized(int[][] matrix, int k) {

        /*
        二维前缀和 + 排序。

        时间复杂度：O(mnlog(mn))
        空间复杂度：O(mn)
         */

        int[][] target = new int[matrix.length][matrix[0].length];
        List<Integer> valueList = new ArrayList<>();

        return valueList.get(k - 1);
    }
}
