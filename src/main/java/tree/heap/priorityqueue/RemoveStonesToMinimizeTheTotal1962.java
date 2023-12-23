package tree.heap.priorityqueue;

import java.util.PriorityQueue;

/**
 * 1962. 移除石子使总数最小
 *
 * @author tenji
 */
public class RemoveStonesToMinimizeTheTotal1962 {
    public static void main(String[] args) {

//        int[] piles = new int[]{5, 4, 9};
//        int k = 2;
        // 输入：piles = [5,4,9], k = 2
        // 输出：12

        int[] piles = new int[]{4, 3, 6, 7};
        int k = 3;
        // 输入：piles = [4,3,6,7], k = 3
        // 输出：12

        System.out.println(new RemoveStonesToMinimizeTheTotal1962().minStoneSum(piles, k));
    }

    public int minStoneSum(int[] piles, int k) {
        /*
        1、每次选取 piles 数组中最大的数，移除 floor(piles[i] / 2) 颗石子；（贪心？）
        2、重复执行 K 次，返回结果
         */

        int res = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < piles.length; i++) {
            priorityQueue.add(piles[i]);
        }

        for (int i = 0; i < k; i++) {
            int tmp = priorityQueue.poll();
            tmp = tmp - (int) Math.floor(tmp / 2);

            priorityQueue.add(tmp);
        }

        while (!priorityQueue.isEmpty()) {
            res += priorityQueue.poll();
        }

        return res;
    }
}
