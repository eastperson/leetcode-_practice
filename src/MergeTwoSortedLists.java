public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedListsSolution solution = new MergeTwoSortedListsSolution();
        ListNode node1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode node2 = new ListNode(1,new ListNode(3,new ListNode(4)));


        System.out.println(solution.mergeTwoLists(node1,node2));
    }
}


class MergeTwoSortedListsSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode result = new ListNode(-101);
        ListNode resultHead = result;
        while(l1 != null || l2 != null){
            if(l2 == null) {
                if(result.val == -101) resultHead = result = l1;
                else result.next = l1;
                break;
            }
            else if(l1 == null) {
                if(result.val == -101) resultHead = result = l2;
                else result.next = l2;
                break;
            }
            if(l1.val >= l2.val) {
                result.val = l2.val;
                result.next = new ListNode(l1.val);
                l2 = l2.next;
            } else {
                result.val = l1.val;
                result.next = new ListNode(l2.val);
                l1 = l1.next;
            }
            if(l1 != null && l2 != null) result = result.next;
        }
        return resultHead;
    }
}