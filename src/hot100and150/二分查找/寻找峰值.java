package hot100and150.二分查找;

/**
 * @author 12293
 * @description: 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 *
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * @date 2025/2/26 10:12
 */
public class 寻找峰值 {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int left=0,right=n-1,ans=-1;
        while (left<=right){
            int mid=(left+right)/2;
            if(compare(nums,mid-1,mid)<0&&compare(nums,mid,mid+1)>0){
                ans=mid;
                break;
            }
            if(compare(nums,mid,mid+1)<0){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return ans;
    }
    public int[] get(int[] nums,int idx){
        if(idx==-1 ||idx==nums.length){
            return new int[]{0,0};
        }
        return new int[]{1,nums[idx]};
    }
    public int compare(int[] nums,int idx1,int idx2){
        int[] num1=get(nums,idx1);
        int[] num2=get(nums,idx2);
        if(num1[0]!=num2[0]){
            return num1[0]>num2[0]?1:-1;
        }
        if(num1[1]==num2[1]){
            return 0;
        }
        return num1[1]>num2[1]?1:-1;

    }
}
