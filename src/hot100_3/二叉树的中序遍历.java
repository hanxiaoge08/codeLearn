package hot100_3;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        inorder(ans,root);
        return ans;
    }
    public void inorder(List<Integer> ans,TreeNode root){
        if(root==null){
            return;
        }
        inorder(ans,root.left);
        ans.add(root.val);
        inorder(ans,root.right);
    }
}
