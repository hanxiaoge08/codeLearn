package hot100and150.位运算;

/**
 * @author 12293
 * @description: 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * @date 2025/2/28 14:49
 */
public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            ans^=nums[i];
        }
        return ans;
    }
}
