package hot100and150.动态规划;
/*给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。*/
public class 最小路径和 {
    public int minPathSum(int[][] grid){
        int row=grid.length,column=grid[0].length;
        int[][] dp=new int[row][column];
        dp[0][0]=grid[0][0];
        for(int i=1;i<row;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<column;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<row;i++){
            for (int j=1;j<column;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[row-1][column-1];
    }
}
