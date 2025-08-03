class LC19_RemoveNthNodeLinkedList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*  brute force  approach
         List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        int removeIndex = nodes.size() - n;
        if (removeIndex == 0) {
            return head.next;
        }

        nodes.get(removeIndex - 1).next = nodes.get(removeIndex).next;
        return head;
        */
        ListNode tmp = head;
        int count = 0;
        while(tmp != null) {
            count++;
            tmp = tmp.next;
        }
        int index = count - n;
        if(index == 0) return head.next;
        tmp = head;
        count = 1;
        while(count < index) {
            count++;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;
    }
}
