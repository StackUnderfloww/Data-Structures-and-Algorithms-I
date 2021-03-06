package main.java.Heap;

import java.util.PriorityQueue;

public class SortKSortedList {
    public static Node mergeKSortedLists(Node oldHead, int k) {
        Node head = null, last = null;
        Node current = oldHead;

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(current);
            current = current.next;
        }


        while (current.next != null && !pq.isEmpty()) {
            Node top = pq.poll();

            pq.add(current.next);
            current = current.next;
            if (head == null) {
                head = top;
            } else {
                last.next = top;
            }
            last = top;
        }
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String args[]) {
        int k = 3;

        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(7);

        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next.next = new Node(8);


        Node newHead = mergeKSortedLists(head, k);
        printList(newHead);
    }
}

