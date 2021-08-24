public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedListSolution solution = new ReverseLinkedListSolution();
        int[] d = {2,2,3,3};
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2, new ListNode(1))));


        System.out.println(solution.reverseList(head));
    }
}

class ReverseLinkedListSolution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode reversedHead = new ListNode(0,new ListNode(head.val));
        ListNode reversed = reversedHead;
        ListNode node = head;
        while(node != null) {
            if(node.next != null) reversed.val = node.next.val;
            if(node.next != null) reversed = new ListNode(0,reversed);
            node = node.next;
        }
        reversedHead = reversed.next;
        return reversedHead;
    }
}