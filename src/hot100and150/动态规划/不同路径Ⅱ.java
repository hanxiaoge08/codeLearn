package hot100and150.动态规划;

/**
 * @author 12293
 * @description: 给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
 *
 * 返回机器人能够到达右下角的不同路径数量。
 *
 * 测试用例保证答案小于等于 2 * 109。
 * @date 2025/3/4 11:33
 */
public class 不同路径Ⅱ {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows=obstacleGrid.length,columns=obstacleGrid[0].length;
        int[][] dp=new int[rows][columns];
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                }else if(i==0&&j==0){
                    dp[i][j]=1;
                }else if(i==0&&j>0){
                    dp[i][j]=dp[i][j-1];
                }else if(j==0&&i>0){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[rows-1][columns-1];
    }
}
