package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2696. 删除子串后的字符串最小长度
 *
 * @author tenji
 * @date 2024-01-10
 */
public class MinimumStringLength2696 {

    public static void main(String[] args) {
        String s = "ABFCACDB";
        // 输入：s = "ABFCACDB"
        // 输出：2

        System.out.println(new MinimumStringLength2696().minLengthOptimized(s));
    }

    public int minLength(String s) {
        /*
        1、重复执行删除字符 AB 和 CD 的动作
        2、如果执行完之后，字符长度没有变化，说明已经是可以获得的最小长度

        时间复杂度：O(n^2)
        空间复杂度：O(n)
         */

        while (true) {
            int beforeLen = s.length();
            s = s.replace("AB", "").replace("CD", "");

            // 操作之后，字符长度没有变化，说明已经是可以获得的最小长度
            if (beforeLen == s.length()) {
                break;
            }
        }

        return s.length();
    }

    public int minLengthOptimized(String s) {
        /*
        使用栈来实现：
        1、挨个字符入栈，当前元素为 B，栈顶元素为 A，或者当前元素为 D，栈顶元素为 C，则出栈
        2、剩下的栈中的元素个数，也就是可以获得的最小长度

        时间复杂度：O(n)，每个元素需要入栈一次，最多出栈一次
         */

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);

            if (tmp == 'B' && !stack.isEmpty()) {
                // 当前元素为 B，且栈顶元素为 A，出栈
                if (stack.peek() == 'A') {
                    stack.pop();
                    continue;
                }
            }

            if (tmp == 'D' && !stack.isEmpty()) {
                // 当前元素为 D，且栈顶元素为 C，出栈
                if (stack.peek() == 'C') {
                    stack.pop();
                    continue;
                }
            }

            // 其它场景直接入栈
            stack.push(tmp);
        }

        return stack.size();
    }
}
