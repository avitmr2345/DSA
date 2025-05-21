package Striver.Module6;

public class DoublyLinkedListMedium {

    public class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next, ListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public ListNode deleteAllOccurrences(ListNode head, int target) {
        while (head != null && head.val == target) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }

        if (head == null) {
            return null;
        }

        ListNode curr = head;

        while (curr != null) {
            if (curr.val == target) {

                if (curr.prev != null) {
                    curr.prev.next = curr.next;
                }

                if (curr.next != null) {
                    curr.next.prev = curr.prev;
                }

            }
            curr = curr.next;
        }

        return head;
    }

    public ListNode removeDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {
                ListNode nextNode = curr.next.next;
                curr.next = nextNode;

                if (nextNode != null) {
                    nextNode.prev = curr;
                }
            }

            curr = curr.next;
        }

        return head;
    }
}
