import java.util.Arrays;
import java.util.List;

/**
 * 2828. 判别首字母缩略词
 *
 * @author tenji
 */
public class CheckIfAStringIsAnAcronymOfWords2828 {

    public static void main(String[] args) {

        String[] words = new String[]{"alice", "bob", "charlie"};
        String s = "abc";
        // 输入：words = ["alice","bob","charlie"], s = "abc"
        // 输出：true

        System.out.println(new CheckIfAStringIsAnAcronymOfWords2828().isAcronym(Arrays.asList(words), s));
    }

    public boolean isAcronym(List<String> words, String s) {

        if (words.size() != s.length()) {
            return false;
        }

        boolean res = true;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }

        return res;
    }
}
