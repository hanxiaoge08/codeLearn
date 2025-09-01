package hot100_3;

/**
 * @author 12293
 * @description: TODO
 * @date 2025/9/1 21:10
 */
public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val==0){
            return l2;
        }else if(l2.val==0){
            return l1;
        }
        int add=0;
        ListNode ptr1=l1,ptr2=l2;
        while (ptr1!=null||ptr2!=null){
            ptr1.val=ptr1.val+ptr2.val+add;
            add=0;
            if(ptr1.val>9){
                ptr1.val-=10;
                add=1;
            }
            if(ptr1.next==null&&ptr2.next!=null){
                ptr1.next=new ListNode(0);
            }
            if(ptr2.next==null&&ptr1.next!=null){
                ptr2.next=new ListNode(0);
            }
            if(add==1&&ptr1.next==null){
                ptr1.next=new ListNode(1);
                break;
            }
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return l1;
    }
}
