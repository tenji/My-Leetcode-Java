package hashtable;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author tenji
 * @date 2024-08-27
 */
public class GroupAnagrams49 {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        // 输入：strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        // 输出:
        // [
        //   ["ate","eat","tea"],
        //   ["nat","tan"],
        //   ["bat"]
        // ]

        String[] strs2 = {};
        // 输入:strs = []
        // 输出:[[]]


        String[] strs3 = {"a"};
        // 输入:strs = ["a"]
        // 输出:[[a]]

        System.out.println(new GroupAnagrams49().groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        1、遍历字符数组，字符排序后（这样保证字母异位词的 key 是相同的）逐个加入哈希表；（哈希）
        2、将哈希表的值输出即可；
         */

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);

            List<String> tmp = map.getOrDefault(String.copyValueOf(charArr), new ArrayList<>());
            tmp.add(String.copyValueOf(strs[i].toCharArray()));
            map.put(String.copyValueOf(charArr), tmp);
        }

        return new ArrayList<>(map.values());
    }
}
