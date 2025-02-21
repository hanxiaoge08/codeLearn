package hot100and150.二叉树;

/**
 * @author hxg
 * @description: 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 * @date 2025/2/21 10:30
 */
public class 求根节点到叶节点数字之和 {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int prevSum){
        if(root==null){
            return 0;
        }
        int sum=prevSum*10+root.val;
        if(root.left==null&&root.right==null){
            return sum;
        }else{
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }
}
