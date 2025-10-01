package hot100_3;

public class 合并K个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }
    public ListNode mergeTwoList(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode();
        ListNode curr=dummy;
        while (list1!=null&&list2!=null){
            if(list1.val<list2.val){
                curr.next=list1;
                list1=list1.next;
            }else {
                curr.next=list2;
                list2=list2.next;
            }
            curr=curr.next;
        }
        curr.next=list1==null?list2:list1;
        return dummy.next;
    }
    public ListNode merge(ListNode[] lists,int start,int end){
        if(start==end){
            return lists[start];
        }
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        return mergeTwoList(merge(lists,start,mid),merge(lists,mid+1,end));
    }
}
