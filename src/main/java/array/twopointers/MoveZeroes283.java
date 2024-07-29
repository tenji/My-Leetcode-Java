package array.twopointers;

import java.util.Arrays;

/**
 * 283. 移动零
 *
 * @author tenji
 * @date 2024-07-30
 */
public class MoveZeroes283 {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};
        // 输入: nums = [0,1,0,3,12]
        // 输出: [1,3,12,0,0]

//        int[] nums = {0};
        // 输入: nums = [0]
        // 输出: [0]

        new MoveZeroes283().moveZeroesOptimized(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        /*
        双指针

        遍历数组，左指针右移，遇到零时，将右指针前面的数字逐个前移一位，当前位置的零移动到右指针

        时间复杂度：
         */

        if (nums.length == 1) {
            return;
        }

        int left = 0, right = nums.length - 1;
        for (int i = right; i >= 0; i--) {
            if (nums[right] == 0) {
                right--;
            } else {
                break;
            }
        }

        while (left <= right) {
            if (nums[left] != 0) {
                // 移动左指针
                left++;
                continue;
            }

            for (int j = left; j <= right - 1; j++) {
                nums[j] = nums[j + 1];
            }
            nums[right] = 0;
            // 移动右指针
            right--;
        }
    }


    public void moveZeroesOptimized(int[] nums) {

        /*
        双指针（同向）

        遍历数组，指针一始终指向最左边的零，指针二向右滑动，发现指针二指向的数大于零时，直接交换指针一和指针二对应的数据

        时间复杂度：O(n)
         */

        if (nums.length == 1) {
            return;
        }

        // 指针一
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
}
