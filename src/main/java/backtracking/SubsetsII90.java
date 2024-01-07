package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 90. 子集 II
 *
 * @author tenji
 * @date 2024-01-07
 */
public class SubsetsII90 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        // 输入：nums = [1,2,2]
        // 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]

        System.out.println(new SubsetsII90().subsetsWithDup(nums));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /*
        子集问题（元素可重不可复选），使用回溯算法处理
         */

        // 先排序，保证相同元素挨在一起
        Arrays.sort(nums);
        // 记录“路径”
        LinkedList<Integer> track = new LinkedList<>();
        // nums 和 start 充当“选择列表”作用
        backtrack(nums, track, 0);

        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, int start) {
        // 每个节点的值都是一个子集
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {

            // 剪枝逻辑，重复元素不选
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            track.add(nums[i]);
            backtrack(nums, track, i + 1);
            track.removeLast();
        }
    }
}
