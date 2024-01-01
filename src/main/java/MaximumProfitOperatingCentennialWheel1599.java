/**
 * 1599. 经营摩天轮的最大利润
 *
 * @author tenji
 */
public class MaximumProfitOperatingCentennialWheel1599 {

    public static void main(String[] args) {

//        int[] customers = new int[]{8, 3};
//        int boardingCost = 5, runningCost = 6;
        // 输入：customers = [8,3], boardingCost = 5, runningCost = 6
        // 输出：3

//        int[] customers = new int[]{10, 9, 6};
//        int boardingCost = 6, runningCost = 4;
        // 输入：customers = [10,9,6], boardingCost = 6, runningCost = 4
        // 输出：7

//        int[] customers = new int[]{3, 4, 0, 5, 1};
//        int boardingCost = 1, runningCost = 92;
        // 输入：customers = [3,4,0,5,1], boardingCost = 1, runningCost = 92
        // 输出：-1

        int[] customers = new int[]{2};
        int boardingCost = 2, runningCost = 4;
        // 输入：customers = [2], boardingCost = 2, runningCost = 4
        // 输出：-1

        System.out.println(new MaximumProfitOperatingCentennialWheel1599().minOperationsMaxProfit(customers, boardingCost, runningCost));
    }

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        /*
        1、遍历游客信息，计算每一次登舱的利润，并记录每一次登舱利润的最大值
        2、返回登舱利润的最大值
         */

        int max = Integer.MIN_VALUE, maxCount = 0;
        // 等待登舱人数
        int left = 0;
        // 总共登舱人数
        int totalAboard = 0;
        for (int i = 0; i < customers.length; i++) {
            left += customers[i];
            // 此次登舱人数
            int board = left > 4 ? 4 : left;
            totalAboard += board;
            left -= board;
            int benefit = totalAboard * boardingCost - runningCost * (i + 1);
            if (benefit > max) {
                max = benefit;
                maxCount = i + 1;
            }
        }

        int count = customers.length;
        // 如果还有等待登舱的人
        while (left > 0) {
            // 此次登舱人数
            int board = left > 4 ? 4 : left;
            totalAboard += board;
            left -= board;

            count++;
            int benefit = totalAboard * boardingCost - runningCost * count;
            if (benefit > max) {
                max = benefit;
                maxCount = count;
            }
        }

        return max > 0 ? maxCount : -1;
    }
}
