package hot100.子串;

import java.util.HashMap;
import java.util.Map;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//
//子数组是数组中元素的连续非空序列。
//
//
//
//示例 1：
//
//输入：nums = [1,1,1], k = 2
//输出：2
//示例 2：
//
//输入：nums = [1,2,3], k = 3
//输出：2
//
//
//提示：
//
//        1 <= nums.length <= 2 * 104
//        -1000 <= nums[i] <= 1000
//        -107 <= k <= 107
public class 和为k的子数组 {
    public int subarraySum(int[] nums,int k){
        int sum=0;
        Map<Integer,Integer> map=new HashMap<>();
        int pre=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                sum+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return sum;
    }
}
