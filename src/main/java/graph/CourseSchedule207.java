package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 207. 课程表
 *
 * @author tenji
 * @date 2024-08-12
 */
public class CourseSchedule207 {

    public static void main(String[] args) {

//        int numCourses = 2;
//        int[][] prerequisites = {
//                {1, 0}
//        };
        // 输入：numCourses = 2, prerequisites = [[1,0]]
        // 输出：true

        int numCourses = 2;
        int[][] prerequisites = {
                {1, 0},
                {0, 1}
        };
        // 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
        // 输出：false

        System.out.println(new CourseSchedule207().canFinish(numCourses, prerequisites));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /*
        拓扑排序。课程表能完成拓扑排序的，说明可以完成所有课程的学习，当前使用广度优先搜索实现。

        1、计算每个课程的入度；
        2、将入度为零的课程入队，同时依赖该课程的课程入度减一；
        3、重复上述步骤，如果所有的课程都可以入队，说明可以完成拓扑排序，也就是说可以完成所有课程的学习。
         */

        // 保存每个课程和依赖它的课程的对应关系及计算每个课程的入度
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
            ++inDegree[prerequisite[0]];
        }

        // 将入度为零的课程入队
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> coursesTaken = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                deque.offer(i);
                coursesTaken.add(i);
            }
        }

        // 重复上述步骤，如果所有的课程都可以入队，说明可以完成拓扑排序，也就是说可以完成所有课程的学习。
        while (!deque.isEmpty()) {
            int course = deque.poll();
            for (Integer v : edges.get(course)) {
                // 完成某个课程后，所有依赖此课程的入度减一
                --inDegree[v];
                // 依赖度为零的课程入队
                if (inDegree[v] == 0) {
                    deque.offer(v);
                    coursesTaken.add(v);
                }
            }
        }

        return coursesTaken.size() == numCourses;
    }
}
