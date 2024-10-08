package 代码随想录.链表;
/*
给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
*/
public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head){
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode temp=dummyHead;
        while (temp.next!=null&&temp.next.next!=null){
            ListNode node1=temp.next;
            ListNode node2=temp.next.next;
            temp.next=node2;
            node1.next=node2.next;
            node2.next=node1;
            temp=node1;
        }
        return dummyHead.next;
    }
    public ListNode swapPairs1(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        head.next.next=swapPairs1(head.next.next);
        ListNode node=head.next;
        head.next=node.next;
        node.next=head;
        head=node;
        return head;
    }
}
