package array.twopointers;

/**
 * 2697. 字典序最小回文串
 *
 * @author tenji
 */
public class LexicographicallySmallestPalindrome2697 {

    public static void main(String[] args) {

        String s = "egcfe";
        // 输入：s = "egcfe"
        // 输出："efcfe"

        System.out.printf(new LexicographicallySmallestPalindrome2697().makeSmallestPalindrome(s));
    }

    public String makeSmallestPalindrome(String s) {

        if (s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            int left = i, right = s.length() - i - 1;
            if (chars[left] == chars[right]) {
                continue;
            }

            chars[left] = chars[right] = (char) Math.min(chars[left], chars[right]);
        }

        return new String(chars);
    }
}
