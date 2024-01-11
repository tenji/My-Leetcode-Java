package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 2085. 统计出现过一次的公共字符串
 *
 * @author tenji
 * @date 2024-01-12
 */
public class CountCommonWordsWithOneOccurrence2085 {

    public static void main(String[] args) {
        String[] words1 = new String[]{"leetcode", "is", "amazing", "as", "is"};
        String[] words2 = new String[]{"amazing", "leetcode", "is"};
        // 输入：words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
        // 输出：2

        System.out.println(new CountCommonWordsWithOneOccurrence2085().countWords(words1, words2));
    }

    public int countWords(String[] words1, String[] words2) {
        /*
        1、遍历 words1，记录每个字符出现的次数，放入 HashMap 中
        2、遍历 words2，字符在 HashMap 中没有出现，或者出现次数 >= 3时，忽略
        3、遍历 HashMap，记录出现次数等于 2 的字符串个数
         */

        int res = 0;

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < words1.length; i++) {
            int count = countMap.getOrDefault(words1[i], 0);
            if (count == 0) {
                countMap.put(words1[i], countMap.getOrDefault(words1[i], 0) + 1);
                continue;
            }

            // 已经存在的字符，+2
            countMap.put(words1[i], countMap.getOrDefault(words1[i], 0) + 2);
        }

        for (int i = 0; i < words2.length; i++) {
            int count = countMap.getOrDefault(words2[i], 0);
            if (count == 0 || count >= 3) {
                continue;
            }

            countMap.put(words2[i], count + 1);
        }

        // 遍历 HashMap，记录出现次数等于 2 的字符串个数
        for (Integer value : countMap.values()) {
            if (value == 2) {
                res++;
            }
        }

        return res;
    }
}
