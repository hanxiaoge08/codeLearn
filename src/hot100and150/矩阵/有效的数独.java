package hot100and150.矩阵;

/**
 * @author hxg
 * @description: 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * @date 2025/2/13 13:30
 */
public class 有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows=new int[9][9];
        int[][] columns=new int[9][9];
        int[][][] boxes=new int[3][3][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char c=board[i][j];
                int index=c-'0'-1;
                if(c!='-'){
                    rows[i][index]++;
                    columns[j][index]++;
                    boxes[i/3][j/3][index]++;
                    if(rows[i][index]>1&&columns[j][index]>1&&boxes[i/3][j/3][index]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
