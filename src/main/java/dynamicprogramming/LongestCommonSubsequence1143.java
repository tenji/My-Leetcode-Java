package dynamicprogramming;

/**
 * 1143. 最长公共子序列
 *
 * @author tenji
 * @date 2024-08-09
 */
public class LongestCommonSubsequence1143 {

    public static void main(String[] args) {

        String text1 = "abcde";
        String text2 = "ace";
        // 输入:text1 = "abcde", text2 = "ace"
        // 输出:3
        // 解释:最长公共子序列是 "ace",它的长度为 3。

//        String text1 = "abc";
//        String text2 = "def";
        // 输入:text1 = "abc", text2 = "def"
        // 输出:0
        // 解释:两个字符串没有公共子序列，因此返回 0。

        System.out.println(new LongestCommonSubsequence1143().longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        /*
        最长公共子序列问题，二维动态规划。

        1、定义状态（定义子问题）：dp[i][j] 表示字符 text1.substring(0, i) 和 text2.substring(0, j) 的最长公共子序列；
        2、状态转移方程：
            1）text1[i] == text2[j] 时，dp[i][j] = dp[i - 1][j - 1] + 1
            2）text1[i] != text2[j] 时，dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
         */

        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
