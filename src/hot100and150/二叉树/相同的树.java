package hot100and150.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/2/19 09:48
 */
public class 相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null){
            return false;
        }else if(p.val!=q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }

    }
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p==null&&q==null){
            return true;
        }else if(p==null||q==null) {
            return false;
        }
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty()&&!queue2.isEmpty()){
            TreeNode node1=queue1.poll();
            TreeNode node2=queue2.poll();
            if(node1.val!=node2.val){
                return false;
            }
            TreeNode left1=node1.left,right1=node1.right,left2=node2.left,right2=node2.right;
            if(left1==null^left2==null){
                return false;
            }
            if(right1==null^right2==null){
                return false;
            }
            if(left1!=null){
                queue1.offer(left1);
            }
            if(right1!=null){
                queue1.offer(right1);
            }
            if(left2!=null){
                queue2.offer(left2);
            }
            if(right2!=null){
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}
