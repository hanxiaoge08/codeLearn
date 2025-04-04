package hot100second.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/3/18 15:40
 */
public class 从前序与中序遍历序列构造二叉树 {
    private Map<Integer,Integer> indexMap;
    public TreeNode myBuildTree(int[] preorder,int[] inorder,int preorder_left,int preorder_right,int inorder_left,int inorder_right){
        if(preorder_left>preorder_right){
            return null;
        }

        int preorder_root=preorder_left;
        int inorder_root=indexMap.get(preorder[preorder_root]);

        TreeNode root=new TreeNode(preorder[preorder_root]);
        int size_left_subtree=inorder_root-inorder_left;
        root.left=myBuildTree(preorder,inorder,preorder_left+1,preorder_left+size_left_subtree,inorder_left,inorder_root-1);
        root.right=myBuildTree(preorder,inorder,preorder_left+size_left_subtree+1,preorder_right,inorder_root+1,inorder_right);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        indexMap=new HashMap<>();
        for(int i=0;i<n;i++){
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder,inorder,0,n-1,0,n-1);
    }
}
