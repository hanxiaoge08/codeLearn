package hot100_3;

public class K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node=head;
        int len=0;
        while (node!=null){
            len++;
            node=node.next;
        }
        int round=len/k;
        ListNode dummyHead=new ListNode(0,head);
        node=dummyHead;
        for(int i=0;i<round;i++){
            ListNode last=node.next,prev=null,curr=node.next;
            ListNode next=null;
            for(int j=0;j<k;j++){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            node.next.next=curr;
            next=node.next;
            node.next=prev;
            node=next;
        }
        return dummyHead.next;
    }
}
