package hot100_3;

public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead=new ListNode(0,head);
        ListNode node=head,prev=dummyHead;
        while (node!=null&&node.next!=null){
            ListNode next=node.next.next;
            prev.next=node.next;
            node.next.next=node;
            node.next=next;
            prev=node;
            node=next;
        }
        return dummyHead.next;
    }
}
