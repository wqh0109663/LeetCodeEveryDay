package year2019.non_decreasing_array;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 19-7-5 下午8:15
 */
public class Solution {

    public static boolean checkPossibility(int[] nums) {
        if (nums == null) {
            return false;
        }
        int times = 0;
        for (int i = 0; i <= nums.length - 2; i++) {
            if (nums[i] > nums[i + 1]) {
                times += 1;
                if (times > 1) {
                    return false;
                }
                if (i == 0 || i == nums.length - 2) {
                    continue;
                }
                if (nums[i-1] + 1> nums[i+1]) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        boolean b2 = checkPossibility(new int[]{-1,4,2,3});
        boolean b = checkPossibility(new int[]{2,3,3,2,4});
        boolean b1 = checkPossibility(new int[]{4,2,1});
        System.out.println(b1);

    }

}
