package dynamicprogramming;

/**
 * 53. 最大子数组和
 *
 * @author tenji
 */
public class MaximumSubarray53 {

    public static void main(String[] args) {

//        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        // 输出：6

        int[] nums = new int[]{1, -1, -2};
        // 输入：nums = [1,-1,-2]
        // 输出：1

        System.out.println(new MaximumSubarray53().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        /*
        动态规划。

        定义状态（定义子问题）：dp[i] 表示以数组第 i 个元素结尾的连续数组最大和
        状态转移方程：dp[i - 1] < 0 时，dp[i] = Math.max(nums[i], dp[i - 1])；否则，dp[i] = dp[i - 1] + nums[i]；
         */

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];

        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = Math.max(nums[i], dp[i - 1]);
                res = Math.max(res, dp[i]);
                continue;
            }

            dp[i] = dp[i - 1] + nums[i];
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
