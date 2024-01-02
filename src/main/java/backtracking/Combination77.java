package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 *
 * @author tenji
 * @date 2024-01-03
 */
public class Combination77 {

    public static void main(String[] args) {

        int n = 4, k = 2;
        // 输入：n = 4, k = 2
//        输出：
//        [
//          [2,4],
//          [3,4],
//          [2,3],
//          [1,2],
//          [1,3],
//          [1,4],
//        ]

//        int n = 1, k = 1;
        // 输入：n = 1, k = 1
        // 输出：[[1]]

        System.out.println(new Combination77().combine(n, k));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        /*
        组合问题，使用回溯算法处理
         */

        // 记录“路径”
        LinkedList<Integer> track = new LinkedList<>();
        // 记录选过的元素，避免重复使用，配合 n 充当“选择列表”作用
        LinkedList<Integer> used = new LinkedList<>();
        backtrack(n, k, track, used);

        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：[1, n] 中不存在于 track 中，且比 track 最后一个元素大的的那些元素
    // 结束条件：track 中元素的个数为 k
    private void backtrack(int n, int k, LinkedList<Integer> track, LinkedList<Integer> used) {
        // 满足结束条件
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 1; i <= n; i++) {
            // 排除不合法的选择
            if (used.contains(i) || (!used.isEmpty() && i <= used.peekLast())) {
                // 已经在“路径”中，或者比“路径”中的元素小，跳过
                continue;
            }

            // 做选择
            track.add(i);
            used.add(i);
            // 进入下一层决策树
            backtrack(n, k, track, used);
            // 撤销选择
            track.removeLast();
            used.removeLast();
        }
    }
}
