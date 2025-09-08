package hot100_3;

public class 随机链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node node=head;
        while (node!=null){
            Node next=new Node(node.val);
            next.next=node.next;
            node.next=next;
            node=node.next.next;
        }
        node=head;
        while (node!=null){
            Node random=node.random;
            node.next.random=(random!=null)?random.next:null;
            node=node.next.next;
        }
        Node headNew=head.next;
        for (Node node1 = head; node1 != null; node1 = node1.next) {
            Node nodeNew = node1.next;
            node1.next = node1.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}
