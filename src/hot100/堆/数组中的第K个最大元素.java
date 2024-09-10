package hot100.堆;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。*/
public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums,int k){
        List<Integer> numList=new ArrayList<>();
        for(int num:nums){
            numList.add(num);
        }
        return quickSelect(numList,k);
    }
    int quickSelect(List<Integer> nums, int k){
        Random rand=new Random();
        int pivot=nums.get(rand.nextInt(nums.size()));

        List<Integer> big=new ArrayList<>();
        List<Integer> equal=new ArrayList<>();
        List<Integer> small=new ArrayList<>();

        for(int num:nums){
            if(num>pivot){
                big.add(num);
            }else if(num<pivot){
                small.add(num);
            }else {
                equal.add(num);
            }
        }
        if(k<=big.size()){
            return quickSelect(big,k);
        }
        if(nums.size()-small.size()<k){
            return quickSelect(small,k-nums.size()+small.size());
        }
        return pivot;
    }
}
