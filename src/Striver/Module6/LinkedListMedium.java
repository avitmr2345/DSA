package Striver.Module6;

public class LinkedListMedium {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // https://leetcode.com/problems/middle-of-the-linked-list/
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        for (int i = 0; i < length / 2; i++) {
            head = head.next;
        }

        return head;

        // you can also solve this using fast (2 steps move) and slow (move 1 step
        // ahead) pointer

        // ListNode f = head;
        // ListNode s = head;

        // while (f != null && f.next != null) {
        // s = s.next;
        // f = f.next.next;
        // }
        // return s;
    }

    // https://leetcode.com/problems/reverse-linked-list/
    // recursive reverse singly LL
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // iterative reverse
    public ListNode reverseListIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }

        head = prev;
        return head;
    }
}
