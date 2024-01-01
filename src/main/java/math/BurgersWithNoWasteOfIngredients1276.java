package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1276. 不浪费原料的汉堡制作方案
 *
 * @author tenji
 */
public class BurgersWithNoWasteOfIngredients1276 {

    public static void main(String[] args) {

//        int tomatoSlices = 16, cheeseSlices = 7;
        // 输入：tomatoSlices = 16, cheeseSlices = 7
        // 输出：[1,6]

//        int tomatoSlices = 17, cheeseSlices = 4;
        // 输入：tomatoSlices = 17, cheeseSlices = 4
        // 输出：[]

//        int tomatoSlices = 0, cheeseSlices = 0;
        // 输入：tomatoSlices = 0, cheeseSlices = 0
        // 输出：[0,0]

//        int tomatoSlices = 2, cheeseSlices = 1;
        // 输入：tomatoSlices = 2, cheeseSlices = 1
        // 输出：[0,1]

        int tomatoSlices = 3962, cheeseSlices = 1205;
        // 输入：tomatoSlices = 3962, cheeseSlices = 1205
        // 输出：[776,429]

        System.out.println(new BurgersWithNoWasteOfIngredients1276().numOfBurgers(tomatoSlices, cheeseSlices));
    }

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

        // 如果全部制作巨无霸还有番茄剩余，或者全部制作小皇堡番茄还是不够，那么说明没有恰当的方案
        if (4 * cheeseSlices < tomatoSlices || 2 * cheeseSlices > tomatoSlices) {
            return new ArrayList<>();
        }

        List<Integer> list = Arrays.asList(1, 2);

        if (4 * cheeseSlices == tomatoSlices) {
            return Arrays.asList(cheeseSlices, 0);
        }

        if (2 * cheeseSlices == tomatoSlices) {
            return Arrays.asList(0, cheeseSlices);
        }

        // 遍历
        int bigNum = 1;
        while (bigNum < cheeseSlices) {
            if (4 * bigNum > tomatoSlices) {
                break;
            }

            if (4 * bigNum + (cheeseSlices - bigNum) * 2 == tomatoSlices) {
                return Arrays.asList(bigNum, (cheeseSlices - bigNum));
            }

            bigNum++;
        }

        return new ArrayList<>();
    }

    public List<Integer> numOfBurgersOptimized(int tomatoSlices, int cheeseSlices) {
        /*
        二元一次方程：4x + 2y = tomatoSlices, x + y = cheeseSlices
         */
        if (tomatoSlices % 2 != 0 || tomatoSlices < cheeseSlices * 2 || cheeseSlices * 4 < tomatoSlices) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(tomatoSlices / 2 - cheeseSlices);
        ans.add(cheeseSlices * 2 - tomatoSlices / 2);

        return ans;
    }
}
