import java.math.BigDecimal;
import java.math.BigInteger;

public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbersSolution solution = new AddTwoNumbersSolution();
        int[] d = {2,2,3,3};
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        ListNode node1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode node2 = new ListNode(5,new ListNode(6,new ListNode(4)));


        System.out.println(solution.addTwoNumbers(node1,node2));
    }
}
class AddTwoNumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String str = reverse(l1).add(reverse(l2)).toString();

        ListNode result = new ListNode();
        result.next = new ListNode();
        ListNode head = result;
        for(char ch : str.toCharArray()) {
            result.next.val = Integer.valueOf(ch - '0');
            result = new ListNode(0,result);
        }
        return result.next.next;
    }
    public BigInteger reverse(ListNode l) {
        String s = "";
        while(l != null) {
            s = String.valueOf(l.val) + s;
            l = l.next;
        }
        return new BigInteger(s);
    }
}
