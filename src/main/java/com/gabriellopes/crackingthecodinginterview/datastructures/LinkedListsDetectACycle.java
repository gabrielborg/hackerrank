package com.gabriellopes.crackingthecodinginterview.datastructures;

/** Created by glopes in May 2018. */
public class LinkedListsDetectACycle {

  private static class Node {
    int data;
    Node next;
  }

  public boolean hasCycle(Node head) {

    if (head == null || head.next == null) {

      return false;
    }

    Node current = head.next;
    int count = 2;
    boolean result = false;

    while (current.next != null) {

      current = current.next;
      ++count;
      if (count > 100) {

        result = true;
        break;
      }
    }

    return result;
  }
}
