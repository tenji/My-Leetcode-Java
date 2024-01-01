package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author tenji
 * @date 2024-01-02
 */
public class Permutations46 {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        // 输入：nums = [1,2,3]
        // 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        System.out.println(new Permutations46().permute(nums));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        /*
        排列问题，使用回溯算法处理
         */

        // 记录“路径”
        LinkedList<Integer> track = new LinkedList<>();
        // “路径”中的元素会被标记为 true，避免重复使用，充当“选择列表”作用
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);

        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 满足结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 已经选择过，直接跳过
            if (used[i]) {
                continue;
            }

            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }
}
