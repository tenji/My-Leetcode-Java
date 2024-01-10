package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 2707. 字符串中的额外字符
 *
 * @author tenji
 * @date 2024-01-10
 */
public class ExtraCharactersInAString277 {

    public static void main(String[] args) {
//        String s = "leetscode";
//        String[] dictionary = new String[]{"leet", "code", "leetcode"};
        // 输入：s = "leetscode", dictionary = ["leet","code","leetcode"]
        // 输出：1

        String s = "sayhelloworld";
        String[] dictionary = new String[]{"hello", "world"};
        // 输入：s = "sayhelloworld", dictionary = ["hello","world"]
        // 输出：3

        System.out.println(new ExtraCharactersInAString277().minExtraChar(s, dictionary));
    }

    public int minExtraChar(String s, String[] dictionary) {
        /*
        动态规划。

        1、定义状态（定义子问题）：dp[i] 表示字符串 s 截取前 i 位时使用最优策略分割，剩下的最少字符
        2、状态转移方程：第 i 位是额外字符时，dp[i] = dp[i - 1] + 1；第 i 位不是额外字符时，往前找第 j 位，
        满足 s.substring(j, i) 是 dictionary 的子字符串，那么 dp[i] = dp[j]；最终 dp[i] 取两者较小值
         */

        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < dictionary.length; i++) {
            count.put(dictionary[i], count.getOrDefault(dictionary[i], 0) + 1);
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = count.containsKey(s.substring(0, 1)) ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            // 第 i 位是额外字符时
            dp[i] = dp[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                // 第 i 位不是额外字符时
                if (count.containsKey(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }

        return dp[s.length()];
    }
}
