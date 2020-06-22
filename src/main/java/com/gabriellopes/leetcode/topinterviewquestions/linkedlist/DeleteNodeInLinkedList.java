package com.gabriellopes.leetcode.topinterviewquestions.linkedlist;


public class DeleteNodeInLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public void setNext(ListNode node) {
            next = node;
        }
    }

    // obs: node cannot be the tail.
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        deleteNode(b);

        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
