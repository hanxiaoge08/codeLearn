package hot100and150.二分查找;
/*给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。*/
public class 寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1,int[] nums2){
        int length1=nums1.length,length2=nums2.length;
        int totalLength=length1+length2;
        if(totalLength%2==1){
            int midIndex=totalLength/2;
            double median=getKthElement(nums1,nums2,midIndex+1);
            return median;
        }else {
            int midIndex1=totalLength/2-1,midIndex2=totalLength/2-1;
            double median=(getKthElement(nums1,nums2,midIndex1+1)+getKthElement(nums1,nums2,midIndex2+1))/2.0;
            return median;
        }
    }
    public int getKthElement(int[] nums1,int[] nums2,int k){
        int length1=nums1.length,length2=nums2.length;
        int index1=0,index2=0;
        int kthElement=0;

        while(true){
            if(index1==length1){
                return nums2[index2+k-1];
            }
            if(index2==length2){
                return nums1[index1+k-1];
            }
            if(k==1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half=k/2;
            int newIndex1=Math.min(index1+half,length1)-1;
            int newIndex2=Math.min(index2+half,length2)-1;
            int pivot1=nums1[newIndex1],pivot2=nums2[newIndex2];
            if(pivot1<=pivot2){
                k-=newIndex1-index1+1;
                index1=newIndex1+1;
            }else {
                k-=newIndex2-index2+1;
                index2=newIndex2+1;
            }
        }
    }
}
