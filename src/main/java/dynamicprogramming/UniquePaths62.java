package dynamicprogramming;

/**
 * 62. 不同路径
 *
 * @author tenji
 * @date 2024-08-07
 */
public class UniquePaths62 {

    public static void main(String[] args) {

        int m = 3, n = 7;
        // 输入：m = 3, n = 7
        // 输出：28

        int m1 = 3, n1 = 2;
        // 输入：m = 3, n = 2
        // 输出：3

        System.out.println(new UniquePaths62().uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        /*
        二维动态规划。

        1、定义状态（定义子问题）：dp[i][j] 表示到达坐标 [i, j] 的路径数量；
        2、状态转移方程：dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
         */

        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }
}
