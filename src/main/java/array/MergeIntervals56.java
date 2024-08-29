package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @author tenji
 * @date 2024-08-30
 */
public class MergeIntervals56 {

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        // 输出：[[1,6],[8,10],[15,18]]
        // 解释:区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

        int[][] intervals2 = {{1, 4}, {4, 5}};
        // 输入：intervals = [[1,4],[4,5]]
        // 输出：[[1,5]]
        // 解释:区间 [1,4] 和 [4,5] 可被合并为 [1,5].

        System.out.println(Arrays.deepToString(new MergeIntervals56().merge(intervals)));
    }

    public int[][] merge(int[][] intervals) {
        /*
        1、先将数组按照 int[i][0] 的值升序排序；
        2、遍历数组，如果满足 int[i][1] <= int[i + 1][0]，则合并区间；否则的话，添加到返回列表中。

        合并区间的时候需要注意的是，int[i][1] 是有可能大于 int[i + 1][1] 的
         */

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        List<int[]> mergedList = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] < intervals[i + 1][0]) {
                // intervals[i] 和 intervals[i + 1] 没有重叠区间
                mergedList.add(intervals[i]);
                continue;
            }

            intervals[i + 1][0] = intervals[i][0];
            intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
        }
        mergedList.add(intervals[intervals.length - 1]);

        return mergedList.toArray(new int[mergedList.size()][]);
    }
}
