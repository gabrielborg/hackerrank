package com.gabriellopes.crackingthecodinginterview.datastructures;

import java.util.LinkedList;
import java.util.List;

/** Created by glopes in May 2018. */
public class TreesIsThisABinarySearchTree {

  private static class Node {

    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {

      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  private static final List<Integer> inOrderValues = new LinkedList<>();

  private static void getInOrderValues(Node root) {

    if (root == null)
      return;

    /* first recur on left child */
    getInOrderValues(root.left);

    /* then add the data of node into inOrderValues list. */
    inOrderValues.add(root.data);

    /* now recur on right child */
    getInOrderValues(root.right);
  }

  static boolean checkBST(Node root) {

    if(root == null) return false;

    getInOrderValues(root);

    Integer prev = -1;

    for(Integer value : inOrderValues) {

      if(value > prev) {

        prev = value;
      } else {

        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {

    System.out.println(checkBST(getTree()));
  }

  private static Node getTree() {

    Node seventeen = new Node(17, null, null);
    Node fourteen = new Node(14, null, null);
    Node seven = new Node(7, null, null);
    Node nine = new Node(9, null, null);

    Node eight = new Node(8, seven, nine);

    Node sixteen = new Node(16, null, seventeen);
    Node fifteen = new Node(15, fourteen, sixteen);

    Node root = new Node(10, eight, fifteen);

    return root;
  }
}
