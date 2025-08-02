public class LC141_LinkedListCycle{
    public boolean hasCycle(ListNode head) {
        /* Using HashSet 
        HashSet<ListNode> seen = new HashSet<>();
        ListNode tmp = head;
        while(tmp!=null) {
            if(seen.contains(tmp)) return true;
            seen.add(tmp);
            tmp = tmp.next;
        }
        return false;
        */
        /* Using Floyd's Tortoise and Hare Algorithm  */
       
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;

    }
}
