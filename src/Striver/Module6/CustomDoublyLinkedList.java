package Striver.Module6;

public class CustomDoublyLinkedList {
    private static Node head;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;

        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public void insert(int after, int val) {
        Node p = find(after);

        if (p == null) {
            System.out.println("Value does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void display() {
        Node node = head;
        Node last = null;
        while (node != null) {
            System.out.print(node.val + " -> ");
            last = node;
            node = node.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse");
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
        System.out.println();
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        CustomDoublyLinkedList list = new CustomDoublyLinkedList();
        // list.insertFirst(4);
        // list.insertFirst(3);
        // list.insertFirst(2);
        // list.insertFirst(1);
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(4);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(1);
        list.insertLast(1);
        list.insertLast(1);
        // list.insert(5, 65);
        list.display();
        head = list.deleteAllOccurrences(head, 1);
        if (head != null) {
            list.display();
        }
    }

    public Node deleteAllOccurrences(Node head, int target) {
        while (head != null && head.val == target) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }

        if (head == null) {
            return null;
        }

        Node curr = head;

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
}
