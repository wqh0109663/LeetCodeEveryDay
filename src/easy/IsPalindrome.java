package easy;

/**
 * 回文数
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


