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
class LC143_ReorderLinkedList {
    public void reorderList(ListNode head) {
        /* Brute force  Approach 
         if (head == null) {
            return;
        }

        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int i = 0, j = nodes.size() - 1;
        while (i < j) {
            nodes.get(i).next = nodes.get(j);
            i++;
            if (i >= j) {
                break;
            }
            nodes.get(j).next = nodes.get(i);
            j--;
        }

        nodes.get(i).next = null;
        */

        /* Split the list, reverse second and then change node links */
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        ListNode temp = second;
        while(second != null) {
            temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        second = prev;
        ListNode first = head;
        ListNode temp1 = null;
        ListNode temp2 = null;
        while(second != null) {
            temp1 = first.next;
            temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}
