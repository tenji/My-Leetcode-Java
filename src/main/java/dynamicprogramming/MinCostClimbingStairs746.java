package dynamicprogramming;

/**
 * 746. 使用最小花费爬楼梯
 *
 * @author tenji
 */
public class MinCostClimbingStairs746 {

    public static void main(String[] args) {

        int[] cost = new int[]{10, 15, 20};
        // 输入：cost = [10,15,20]
        // 输出：15

//        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        // 输入：cost = [1,100,1,1,1,100,1,1,100,1]
        // 输出：6

        System.out.println(new MinCostClimbingStairs746().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        /*
        动态规划，dp[i] 表示到达第 i 个台阶需要支付的费用，dp[0] = 0, dp[1] = 0，因为可以从第 0 或者第 1 台阶开始爬楼梯
         */

        if (cost.length == 1) {
            return cost[0];
        }

        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = Math.min(cost[0], cost[1]);

        for (int i = 3; i <= cost.length; i++) {
            if (i == cost.length) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], (dp[i - 2] + cost[i - 2]));
                break;
            }

            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[cost.length];
    }
}
