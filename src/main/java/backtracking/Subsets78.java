package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author tenji
 * @date 2024-01-03
 */
public class Subsets78 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        // 输入：nums = [1,2,3]
        // 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

        System.out.println(new Subsets78().subsets(nums));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        /*
        子集问题（元素无重不可复选），使用回溯算法处理
         */

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

            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}
