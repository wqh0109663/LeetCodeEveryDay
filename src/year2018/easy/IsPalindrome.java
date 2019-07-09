package year2018.easy;

/**
 * 9. 回文数
 * 思路是:
 * 转换为字符串
 * 从中间分割
 * 比较两边的字符串是否一样的
 *
 * @author 吴启欢
 * @version 1.0
 * @date 2018-11-16 8:00
 */
public class IsPalindrome {
    /**
     * 待判断的回文数
     *
     * @param x 整数
     * @return 是回文数为真, 否则为假
     */
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        final int two = 2;
        String str = String.valueOf(x);
        int length = str.length();
        if (length % two == 0) {
            String sub1 = str.substring(0, length / 2);
            String sub2 = str.substring(length / 2);
            return compareStringAndReversalString(sub1, sub2);
        } else {
            int subLen = length - 1;
            String sub1 = str.substring(0, length / 2);
            String sub2 = str.substring(length / 2 + 1);
            return compareStringAndReversalString(sub1, sub2);
        }
    }

    /**
     * 根据两个字符串比较首尾是否一一对应
     *
     * @param sub1 首字符串
     * @param sub2 尾字符串
     *             <p>
     *             "123"与"321" 为真
     *             </p>
     * @return 首尾一致为真否则假
     */
    public boolean compareStringAndReversalString(String sub1, String sub2) {
        if (sub1.length() != sub2.length()) {
            return false;
        }
        int subLen = sub1.length();
        for (int i = 0; i < subLen; i++) {
            if (sub1.charAt(i) != sub2.charAt(subLen - (i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = new IsPalindrome().isPalindrome(1321);
        System.out.println(result);
    }

}

/**
 * 官方解答
 */
class IsPalindromeSolution {
    public boolean IsPalindrome(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}


