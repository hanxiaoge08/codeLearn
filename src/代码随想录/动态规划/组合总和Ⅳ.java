package 代码随想录.动态规划;
/*给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。

题目数据保证答案符合 32 位整数范围。



示例 1：

输入：nums = [1,2,3], target = 4
输出：7
解释：
所有可能的组合为：
        (1, 1, 1, 1)
        (1, 1, 2)
        (1, 2, 1)
        (1, 3)
        (2, 1, 1)
        (2, 2)
        (3, 1)
请注意，顺序不同的序列被视作不同的组合。
示例 2：

输入：nums = [9], target = 3
输出：0


提示：

        1 <= nums.length <= 200
        1 <= nums[i] <= 1000
nums 中的所有元素 互不相同
1 <= target <= 1000*/
public class 组合总和Ⅳ {
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=1;j<=n;j++){
                if(i>=nums[j-1]){
                    dp[i]+=dp[i-nums[j-1]];
                }
            }
        }
        return dp[target];
    }
}
