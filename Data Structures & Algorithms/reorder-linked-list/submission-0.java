/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode left = head, right = null;
        Stack<ListNode> stk = new Stack<>();

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != null) {
            System.out.println("Pushed: "+slow.val);
            stk.push(slow);
            slow = slow.next;
        }

        ListNode next;
        while(!stk.isEmpty()) {
            right = stk.pop();
            System.out.println("Popped: "+right.val);
            System.out.println("Left: "+left.val);
            if(left == right) {
                break;
            }
            next = left.next;
            left.next = right;
            right.next = next;
            left = next;
        }
        left.next = null;
    }
}
