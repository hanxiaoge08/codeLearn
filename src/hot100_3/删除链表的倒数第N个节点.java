package hot100_3;

public class 删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead=new ListNode(0,head);
        ListNode slow=dummyHead,fast=dummyHead;
        for(int i=0;i<n;i++){
            if(fast.next!=null){
                fast=fast.next;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummyHead.next;
    }
}
