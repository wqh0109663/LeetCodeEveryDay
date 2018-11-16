package easy;

/**1. 两数之和
 * @author wqh
 * @date 18-11-16
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=1+i;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }

        }
        return null;

    }
}
