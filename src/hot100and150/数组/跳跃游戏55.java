package hot100and150.数组;

/**
 * @author hxg
 * @description: 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * @date 2025/2/8 16:41
 */
public class 跳跃游戏55 {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int side=0;
        for(int i=0;i<=side;i++){
            side=Math.max(side,i+nums[i]);
            if(side>=n-1){
                return true;
            }
        }
        return false;
    }
}
