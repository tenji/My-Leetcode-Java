package hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * @author tenji
 * @date 2024-08-27
 */
public class LongestConsecutiveSeq128 {

    public static void main(String[] args) {

        int[] nums = {100, 4, 200, 1, 3, 2};
        // 输入：nums = [100,4,200,1,3,2]
        // 输出:4
        // 解释:最长连续序列是 [1, 2, 3, 4]，它的长度为 4。

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        // 输入：nums = [0,3,7,2,5,8,4,6,0,1]
        // 输出:9
        // 解释:最长连续序列是 [0, 3, 7, 8, 4, 5, 6]，它的长度为 9。

        System.out.println(new LongestConsecutiveSeq128().longestConsecutiveOptimized(nums));
    }

    public int longestConsecutive(int[] nums) {
        /*
        1、先对数组排序；
        2、遍历数组：
            1）如果满足 nums[i] - nums[i - 1] == 1，则长度加一；
            2）如果满足 nums[i] - nums[i - 1] == 0，则长度不变；
            3）其它情况下，长度重置为一
        3、返回中间保存的最大长度即可

        时间复杂度：O(nlogn)，也就是排序的时间复杂度，不满足题目要求的 O(n) 复杂度。
         */

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        Arrays.sort(nums);
        int max = 1, count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 0) {
                continue;
            }

            if (nums[i] - nums[i - 1] == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }

        return max;
    }

    public int longestConsecutiveOptimized(int[] nums) {
        /*
        哈希表。

        1、将全部元素放入哈希表；
        2、计算以 nums[i] - 1 不存在的 nums[i] 开头的数字连续的最长序列。

        时间复杂度：O(n)
         */

        int max = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1)) {
                // 存在 nums[i] - 1，说明最长序列一定不是以这个数字开头，跳过即可
                continue;
            }

            int count = 1;
            int tmp = nums[i] + 1;
            while (set.contains(tmp)) {
                count++;
                tmp++;
            }
            max = Math.max(max, count);
        }

        return max;
    }
}
