package array;

import java.util.Arrays;

/**
 * 189. 轮转数组
 *
 * @author tenji
 * @date 2024-08-30
 */
public class RotateArray189 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        // 输入：nums = [1,2,3,4,5,6,7] k = 3
        // 输出:[5,6,7,1,2,3,4]
        // 解释:
        // 向右轮转 1 步: [7,1,2,3,4,5,6]
        // 向右轮转 2 步: [6,7,1,2,3,4,5]
        // 向右轮转 3 步: [5,6,7,1,2,3,4]

        int[] nums2 = {-1, -100, 3, 99};
        // 输入：nums = [-1,-100,3,99] k = 2

        new RotateArray189().rotateOptimized(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        /*
        1、新增一个数组 newNums，用于存放数组轮转后的数据；
        2、确认老数组和数组轮转后数组的索引对应关系，然后赋值给新数组；
        3、将新数组拷贝给老数组。

        时间复杂度：O(n)
        空间复杂度：O(n)
         */

        if (k == 0) {
            return;
        }

        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i + k) % nums.length] = nums[i];
        }

        System.arraycopy(newNums, 0, nums, 0, nums.length);
    }

    public void rotateOptimized(int[] nums, int k) {
        /*
        通过翻转实现。

        1、先将数组整体翻转；
        2、将数组前 0 ~ k % n 位翻转，然后将数组 k % n ~ n 位翻转，n 是数组的长度；
        3、得到的就是最终的结果。

        时间复杂度：O(n)
        空间复杂度：O(1)
         */

        if (k == 0) {
            return;
        }

        reverse(nums, 0, nums.length);
        reverse(nums, 0, k % nums.length);
        reverse(nums, k % nums.length, nums.length);
    }

    private void reverse(int[] nums, int start, int end) {
        for (int left = start, right = end - 1; left < right; left++, right--) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }
}
