package dynamicprogramming;

/**
 * 2645. 构造有效字符串的最少插入数
 *
 * @author tenji
 * @date 2024-01-12
 */
public class MinimumAdditionsToMakeValidString2645 {

    public static void main(String[] args) {
//        String word = "b";
        // 输入：word = "b"
        // 输出：2

        String word = "aaa";
        // 输入：word = "aaa"
        // 输出：6

        System.out.println(new MinimumAdditionsToMakeValidString2645().addMinimum(word));
    }

    public int addMinimum(String word) {
        /*
        动态规划。

        1、定义状态（定义子问题）：dp[i] 表示字符串截取前 i 位时，返回使 word 有效需要插入的最少字母数
        2、状态转移方程：第 i 位不跟前一位组成 abc 时，dp[i] = dp[i - 1] + 2；第 i 位 跟前一位组成 abc 时，如果
        word[i] > word[i - 1]，那么 dp[i] = dp[i - 1] - 1，否则，dp[i] = dp[i - 1] + 2
         */

        int[] dp = new int[word.length() + 1];
        dp[0] = 0;
        dp[1] = 2;
        for (int i = 2; i <= word.length(); i++) {
            if (word.charAt(i - 1) > word.charAt(i - 2)) {
                dp[i] = dp[i - 1] - 1;
            }  else {
                dp[i] = dp[i - 1] + 2;
            }
        }

        return dp[word.length()];
    }
}
