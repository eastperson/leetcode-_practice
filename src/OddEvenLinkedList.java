public class OddEvenLinkedList {
    public static void main(String[] args) {
        OddEvenLinkedListSolution solution = new OddEvenLinkedListSolution();
        int[] d = {2,2,3,3};
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(2, new ListNode(1))));


        System.out.println(solution.oddEvenList(head));
    }
}

class OddEvenLinkedListSolution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();

        ListNode evenHead = even;
        ListNode oddHead = odd;
        boolean isEven = false;
        while(head != null){
            if(isEven) {
                even = even.next = new ListNode();
                even.val = head.val;
                isEven = false;
            } else {
                odd = odd.next = new ListNode();
                odd.val = head.val;
                isEven = true;
            }
            head = head.next;
        }
        odd.next = evenHead.next;
        return oddHead.next;
    }
}

