package easy;

/**
 * 14. 最长公共前缀
 * <p>
 * 思路:
 * 如果字符串数组为空 或者长度为0 直接返回空
 * 如果长度为1直接返回这个数组的第一个元素
 * <p>
 * 正常情况下,先找到位数最短的长度,和这个元素的索引,如果这里面是有空的字符串,直接返回空字符串
 * 如果没有空,比较最少的次数就是最小元素的长度,
 * 然后依次与比较其他元素,
 * 测试如果两个字符串区域是相等的,
 * 如果比较了最少的次数之后还没有结果出来,
 * 那就直接返回长度最小的那个字符串
 * </p>
 *
 * @author 吴启欢
 * @date 18-11-17 上午11:11i
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        if (strings.length == 1) {
            return strings[0];
        }
        /*
         * 找到位数最短的长度
         */
        int minLength = strings[0].length();
        int minIndex = 0;
        for (int i = 0; i < strings.length; i++) {
            int length = strings[i].length();
            if (length <= minLength) {
                minLength = length;
                minIndex = i;
            }
        }
        if (minLength == 0) {
            return "";
        }
        /*
         *只需要比较最少的次数就可以
         */
        for (int i = 0; i < minLength; i++) {
            for (int j = 1; j < strings.length; j++) {
                if (!strings[0].regionMatches(false, 0, strings[j], 0, i + 1)) {
                    return strings[0].substring(0, i);
                }
            }
        }
        return strings[minIndex];

    }

    public static void main(String[] args) {
        String commonPrefix = new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        System.out.println(commonPrefix);

    }
}
