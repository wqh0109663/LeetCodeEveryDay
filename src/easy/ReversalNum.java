package easy;

import java.math.BigDecimal;

/**
 * 反转整数
 * 我的思路是：
 * 直接在整数后面加上小数点，
 * 通过移动小数点的位置，
 * 获得小数点后面第一个数，
 * 再连接起来
 *
 * @author 吴启欢
 * @version 1.0
 * @date 2018-11-14 8:18
 */
public class ReversalNum {

    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println(reverse);

    }

    /**
     * 反转整数
     *
     * @param x 要反转的整数
     * @return 反转后的整数
     */
    private static int reverse(int x) {
        boolean isNegativeNum = false;
        if (x < 0) {
            x = -x;
            isNegativeNum = true;
        }
        String value = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        int length = value.length();
        for (int i = 1; i <= length; i++) {
            BigDecimal temp = movePointForward(Double.parseDouble(value), i);
            int lastNum = getDecimal(temp);
            sb.append(lastNum);
        }
        int result  = 0;
        try {

            result = Integer.parseInt(sb.toString());
        }catch (NumberFormatException e){
            long resultLong = Long.parseLong(sb.toString());
            if (resultLong > Integer.MAX_VALUE){
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
    private static BigDecimal movePointForward(double strNum, int time) {
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
    private static boolean containsPoints(String strNum) {
        final String point = ".";
        return strNum.contains(new StringBuilder(point));
    }

    /**
     * 获得小数点之后的第一位小数
     *
     * @param doubleNum doubleNum
     * @return 返回小数点之后的第一位数，不包含小树带你返回0
     */
    private static int getDecimal(BigDecimal doubleNum) {

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
