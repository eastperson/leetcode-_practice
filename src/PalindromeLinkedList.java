public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedListSolution solution = new PalindromeLinkedListSolution();
        int[] d = {2,2,3,3};
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2, new ListNode(1))));


        System.out.println(solution.isPalindrome(head));
    }
}

class PalindromeLinkedListSolution {
    public boolean isPalindrome(ListNode head) {
        ListNode reversedHead = new ListNode(0,new ListNode(head.val));
        ListNode reversed = reversedHead;
        ListNode node = head;
        while(node != null) {
            if(node.next != null) reversed.val = node.next.val;
            if(node.next != null) reversed = new ListNode(0,reversed);
            node = node.next;
        }
        node = head;
        reversedHead = reversed.next;
        reversed = reversedHead;
        while(node != null) {
            if(node.val != reversed.val) return false;
            node = node.next;
            reversed = reversed.next;
        }
        return true;
    }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}