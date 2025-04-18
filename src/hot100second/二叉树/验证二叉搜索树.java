package hot100second.二叉树;

/**
 * @author hxg
 * @description: TODO
 * @date 2025/3/18 00:19
 */
public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root,long left,long right){
        if(root==null){
            return true;
        }
        if(root.val<=left||root.val>=right){
            return false;
        }
        return isValid(root.left,left,root.val)&&isValid(root.right,root.val,right);
    }
}
