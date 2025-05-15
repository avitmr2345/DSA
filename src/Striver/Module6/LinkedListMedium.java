package Striver.Module6;

import java.util.List;

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

}
