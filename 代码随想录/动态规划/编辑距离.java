package 代码随想录.动态规划;
//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
//
//你可以对一个单词进行如下三种操作：
//
//插入一个字符
//        删除一个字符
//替换一个字符
//
//
//示例 1：
//
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
//示例 2：
//
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
//
//
//提示：
//
//        0 <= word1.length, word2.length <= 500
//word1 和 word2 由小写英文字母组成
public class 编辑距离 {
    public int minDistance(String word1,String word2){
        int m=word1.length(),n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        //word1转换为word2
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    //i-1变化为j再删i、i变化为j-1再加j、i-1变化为j-1并且ij不变
                    dp[i][j]=1+Math.max(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1]-1));
                }else{
                    //区别在于i-1变化为j-1并且i变为j
                    dp[i][j]=1+Math.max(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }
        return dp[m][n];
    }
}
