package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. 赎金信
 *
 * @author tenji
 * @date 2024-01-07
 */
public class RansomNote383 {

    public static void main(String[] args) {
//        String ransomNote = "aa", magazine = "aab";
        // 输入：ransomNote = "aa", magazine = "aab"
        // 输出：true

        String ransomNote = "aa", magazine = "ab";
        // 输入：ransomNote = "aa", magazine = "ab"
        // 输出：false

        System.out.println(new RansomNote383().canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        /*
        1、使用 HashMap 统计 magazine 所有字符出现的次数
        2、遍历 ransomNote，判断 ransomNote 中所有字符出现的次数是否小于 magazine
         */

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char tmp = magazine.charAt(i);
            int count = countMap.getOrDefault(tmp, 0) + 1;
            countMap.put(tmp, count);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char tmp = ransomNote.charAt(i);
            if (countMap.get(tmp) == null || countMap.get(tmp) == 0) {
                return false;
            } else {
                countMap.put(tmp, countMap.get(tmp) - 1);
            }
        }

        return true;
    }
}
