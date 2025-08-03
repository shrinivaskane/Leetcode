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
class LC2_Add2NumbersLinkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1!=null || l2 != null || carry!=0) {
            int val1 = l1 != null? l1.val: 0;
            int val2 = l2 != null? l2.val: 0;
            int val = val1 + val2 + carry;
            carry = val/10;
            val = val%10;
            ListNode node = new ListNode(val);
            curr.next = node;
            curr = curr.next;
            if(l1!= null) l1 = l1.next;
            if(l2!= null) l2 = l2.next;
        }
        return dummy.next;
    }
}
