package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author tenji
 * @date 2024-01-08
 */
public class CombinationSum39 {

    public static void main(String[] args) {

        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        // 输入: candidates = [2,3,5], target = 8
        // 输出: [[2,2,2,2],[2,3,3],[3,5]]

        System.out.println(new CombinationSum39().combinationSum(candidates, target));
    }

    List<List<Integer>> res = new ArrayList<>();

    /**
     * 记录“路径”
     */
    LinkedList<Integer> trace = new LinkedList<>();

    /**
     * 记录 track 中的路径和
     */
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
        1、求子集（元素可重可复选使用回溯算法处理）
        2、子集的和等于 target 则加入返回结果，大于 target 则结束
         */

        // candidates 和 start 充当“选择列表”作用
        backtrace(candidates, target, 0);

        return res;
    }

    private void backtrace(int[] candidates, int target, int start) {
        // 满足结束条件
        // 找到目标和，记录结果
        if (sum == target) {
            res.add(new ArrayList<>(trace));
            return;
        }
        // 超过目标和，停止向下遍历
        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // 做选择
            trace.add(candidates[i]);
            sum += candidates[i];
            // 进入下一层决策树
            backtrace(candidates, target, i);
            // 撤销选择
            sum -= candidates[i];
            trace.removeLast();
        }
    }
}
