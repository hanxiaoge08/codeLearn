package hot100and150.数组;

/**
 * @author hxg
 * @description: n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * @date 2025/2/9 11:10
 */
public class 分发糖果 {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int ans=0;
        int[] left=new int[n];
        for(int i=0;i<n;i++){
            if(i>0&&ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }else {
                left[i]=1;
            }
        }
        int right=0;
        for(int i=n-1;i>=0;i--){
            if(i<n-1&&ratings[i]>ratings[i+1]){
                right++;
            }else {
                right=1;
            }
            ans+=Math.max(right,left[i]);
        }
        return ans;
    }
    public int candy1(int[] ratings){
        int n= ratings.length;
        int ans=1;
        int prev=1;
        int inc=1,dec=0;
        for(int i=1;i<n;i++){
            if(ratings[i]>=ratings[i-1]){
                dec=0;
                prev=ratings[i]==ratings[i-1]?1:prev+1;
                ans+=prev;
                inc=prev;
            }else {
                dec++;
                if(dec==inc){
                    dec++;
                }
                ans+=dec;
                prev=1;
            }
        }
        return ans;
    }
}
