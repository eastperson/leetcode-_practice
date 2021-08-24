public class ReverseLinkedListII {
    public static void main(String[] args) {
        ReverseLinkedListIISolution solution = new ReverseLinkedListIISolution();
        int[] d = {2,2,3,3};
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3, new ListNode(4,new ListNode(5)))));


        System.out.println(solution.reverseBetween(head,2,4));
    }
}

class ReverseLinkedListIISolution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftList = new ListNode();
        ListNode leftHead = leftList;
        ListNode leftTail = leftList;
        ListNode midList = new ListNode();
        ListNode midHead = midList;
        ListNode midTail = midList;
        ListNode rightList = new ListNode();
        ListNode rightHead = rightList;
        ListNode rightTail = rightList;
        boolean l = false;
        boolean r = false;
        int count = 0;
        while(head != null){
            count++;
            if(count < left) {
                l = true;
                leftList.val = head.val;
                leftTail = leftList;
                leftList = leftList.next = new ListNode();
            }
            if(left <= count && count <= right) {
                midList.val = head.val;
                midTail = midList;
                midList = midList.next = new ListNode();
            }
            if(right < count){
                r = true;
                rightList.val = head.val;
                rightTail = rightList;
                rightList = rightList.next = new ListNode();
            }
            head = head.next;
        }
        rightTail.next = null;
        ListNode reversed;
        if(r) reversed = reverse(midHead,rightHead);
        else reversed = reverse(midHead,null);
        if(l) leftTail.next = reversed.next;
        else leftHead = reversed.next;
        return leftHead;
    }
    ListNode reverse(ListNode n, ListNode r) {
        if(n == null) return null;
        ListNode reversedHead = new ListNode(0,new ListNode(n.val,r));
        ListNode reversed = reversedHead;
        ListNode node = n;

        while(node != null) {
            if(node.next != null) reversed.val = node.next.val;
            if(node.next != null) reversed = new ListNode(0,reversed);
            node = node.next;
        }
        reversedHead = reversed.next;
        return reversedHead;
    }
}
