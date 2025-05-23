package hot100and150.双指针;

/**
 * @author hxg
 * @description: 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 * @date 2025/2/12 10:36
 */
public class 呈最多水的容器 {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0,right=n-1;
        int area=0;
        while (left<right){
            int areaHeight=Math.min(height[left],height[right]);
            area=Math.max(area,areaHeight*(right-left));
            if(height[left]<height[right]){
                left++;
            }else {
                right--;
            }
        }

        return area;
    }
}
