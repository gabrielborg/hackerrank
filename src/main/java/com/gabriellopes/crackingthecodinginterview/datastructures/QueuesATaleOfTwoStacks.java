package com.gabriellopes.crackingthecodinginterview.datastructures;

import java.util.Scanner;
import java.util.Stack;

/** Created by glopes in May 2018. */
public class QueuesATaleOfTwoStacks {

  private static class MyQueue<T> {

    private final Stack<T> storage;
    private final Stack<T> aux;

    public MyQueue() {

      this.storage = new Stack<>();
      this.aux = new Stack<>();
    }

    public T enqueue(T value) {

      return this.storage.push(value);
    }

    public T dequeue() {

      if (this.aux.isEmpty()) moveElements(this.storage, this.aux);

      return this.aux.isEmpty() ? null : this.aux.pop();
    }

    public T peek() {

      if (this.aux.isEmpty()) moveElements(this.storage, this.aux);

      return this.aux.isEmpty() ? null : this.aux.peek();
    }

    private void moveElements(Stack from, Stack to) {

      while (!from.isEmpty()) {

        to.push(from.pop());
      }
    }
  }

  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      if (operation == 1) { // enqueue
        queue.enqueue(scan.nextInt());
      } else if (operation == 2) { // dequeue
        queue.dequeue();
      } else if (operation == 3) { // print/peek
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }
}
