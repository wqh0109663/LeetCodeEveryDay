package easy;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * 7.反转整数
 * 我的思路是：
 * 直接在整数后面加上小数点，
 * 通过移动小数点的位置，
 * 获得小数点后面第一个数，
 * 再连接起来
 * <p>
 * 官方的做法是直接用类似于压栈的思想，再弹栈
 *
 * @author 吴启欢
 * @version 1.0
 * @date 2018-11-14 8:18
 */
public class ReversalNum {

    public static void main(String[] args) {
        UserStackToReversal userStackToReversal = new UserStackToReversal();
        int reverse1 = userStackToReversal.reverse(-2147483648);
        System.out.println(reverse1);
        int reverse2 = new ReversalNum().reverse(-2147483648);
        System.out.println(reverse2);

    }

    /**
     * 反转整数
     *
     * @param x 要反转的整数
     * @return 反转后的整数
     */
    public int reverse(int x) {
        boolean isNegativeNum = false;
        long xTemp = x;
        if (x < 0) {
            xTemp = -xTemp;
            isNegativeNum = true;
        }
        String value = String.valueOf(xTemp);
        StringBuilder sb = new StringBuilder();
        int length = value.length();
        for (int i = 1; i <= length; i++) {
            BigDecimal temp = movePointForward(Double.parseDouble(value), i);
            int lastNum = getDecimal(temp);
            sb.append(lastNum);
        }
        int result = 0;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            long resultLong = Long.parseLong(sb.toString());
            if (resultLong > Integer.MAX_VALUE) {
                return 0;
            }
        }
        if (isNegativeNum) {
            return -result;
        }
        return result;
    }

    /**
     * 将小数点向前移动
     *
     * @param strNum 要移动的数
     * @param time   移动几位
     * @return 移动n位之后的数
     */
    public BigDecimal movePointForward(double strNum, int time) {
        if (time < 0) {
            throw new IllegalArgumentException("参数不合法" + time);
        }
        BigDecimal divisor = new BigDecimal(10);
        divisor = divisor.pow(time);
        return new BigDecimal(strNum).divide(divisor);
    }

    /**
     * 判断是否含有小数点
     *
     * @param strNum 字符串
     * @return 如果包含返回真，否则假
     */
    public static boolean containsPoints(String strNum) {
        final String point = ".";
        return strNum.contains(new StringBuilder(point));
    }

    /**
     * 获得小数点之后的第一位小数
     *
     * @param doubleNum doubleNum
     * @return 返回小数点之后的第一位数，不包含小树带你返回0
     */
    public int getDecimal(BigDecimal doubleNum) {

        String strNum = String.valueOf(doubleNum);
        if (containsPoints(strNum)) {
            int indexOfPoint = strNum.indexOf('.');
            String sub = strNum.substring(indexOfPoint + 1, indexOfPoint + 2);
            return Integer.valueOf(sub);
        } else {
            return 0;
        }


    }

}

/**
 * 官方做法
 */
class ReversalNumSolution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}

/**
 * 第二种做法
 * 思路是将x转换为字符串,
 * 依次获取第一个第二个数乃至后面的数,
 * 依次压入栈中，最后弹栈，获得反转数
 */
class UserStackToReversal {

    public int reverse(int x) {
        boolean isNegativeNum = false;
        long temp = x;
        if (x < 0) {
            temp = -temp;
            isNegativeNum = true;
        }
        Stack<String> stack = new Stack<>();
        String s = String.valueOf(temp);
        for (int i = 0; i < s.length(); i++) {
            String substring = s.substring(i, i + 1);
            stack.push(substring);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {

            sb.append(stack.pop());
        }
        int result = 0;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            long l = Long.parseLong(sb.toString());
            if (l > Integer.MAX_VALUE) {
                return 0;
            }
        }
        if (isNegativeNum) {
            return -result;
        }
        return result;
    }

}
