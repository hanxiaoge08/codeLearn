package hot100and150.数组;
//给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
//
//
//
//示例 1:
//
//输入: nums = [1,2,3,4,5,6,7], k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右轮转 1 步: [7,1,2,3,4,5,6]
//向右轮转 2 步: [6,7,1,2,3,4,5]
//向右轮转 3 步: [5,6,7,1,2,3,4]
//示例 2:
//
//输入：nums = [-1,-100,3,99], k = 2
//输出：[3,99,-1,-100]
//解释:
//向右轮转 1 步: [99,-1,-100,3]
//向右轮转 2 步: [3,99,-1,-100]
//
//
//提示：
//
//        1 <= nums.length <= 105
//        -231 <= nums[i] <= 231 - 1
//        0 <= k <= 105
//
//
//进阶：
//
//尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
//你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
public class 轮转数组 {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverseArray(nums,0,nums.length-1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,nums.length-1);
    }
    public void reverseArray(int[] arrays,int left,int right){
        int temp=0;
        while(left<right){
            temp=arrays[left];
            arrays[left++]=arrays[right];
            arrays[right--]=temp;
        }
    }
    public void rotate2(int[] nums,int k){
        int temp=0,n=nums.length;
        int count=gcd(n,k);
        for(int start=0;start<count;start++){
            int current=start;
            int prev=nums[start];
            do {
                int next=(start+k)%n;
                temp=nums[next];
                nums[next]=prev;
                prev=temp;
                current=next;
            }while (current!=start);
        }
    }

    public int gcd(int x,int y){
        return y>0?gcd(y,x%y):x;
    }



























}
