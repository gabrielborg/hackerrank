package com.gabriellopes.crackingthecodinginterview.datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by glopes in Jun 2018.
 */
public class TriesContacts {

  public static class Node {
    int occurrences;
    Map<Character, Node> children = new HashMap<>();

    public Node() {
      occurrences = 1;
    }
  }

  public static class Trie {
    Node root;

    public Trie() {
      root = new Node();
    }
    public void addName(String s) {
      Node current = root;
      for(int i = 0; i < s.length(); i++) {
        if(current.children.containsKey(s.charAt(i))) {
          current = current.children.get(s.charAt(i));
          current.occurrences++;
        } else {
          Node newNode = new Node();
          current.children.put(s.charAt(i), newNode);
          current = newNode;
        }
      }
    }
    public int findPartial(String s) {
      Node current = root;
      for(int i = 0; i < s.length(); i++) {
        if(!current.children.containsKey(s.charAt(i))) {
          return 0;
        } else {
          current = current.children.get(s.charAt(i));
        }
      }
      return current.occurrences;
    }
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    Trie trie = new Trie();

    for (int nItr = 0; nItr < n; nItr++) {
      String[] opContact = scanner.nextLine().split(" ");

      String op = opContact[0];

      String contact = opContact[1];

      if(op.equals("add")) {

        trie.addName(contact);
      } else {

        System.out.println(trie.findPartial(contact));
      }
    }

    scanner.close();
  }
}
