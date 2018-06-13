package com.gabriellopes.crackingthecodinginterview.algorithms;

/** Created by glopes in Jun 2018. */
public class SortingBubbleSort {

  private static int numSwaps;
  private static int firstElement;
  private static int lastElement;

  // Complete the countSwaps function below.
  static void countSwaps(int[] a) {
    int arraysSize = a.length;

    for (int i = 0; i < arraysSize; i++) {

      for (int j = 0; j < arraysSize - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
          swap(a, j, j+1);
          numSwaps++;
        }
      }
    }

    firstElement = a[0];
    lastElement = a[a.length - 1];
  }

  static void countSwapsOptimized(int[] a) {
    boolean isSorted = false;
    int lengthUnsorted = a.length - 1;

    while(!isSorted) {
      isSorted = true;

      for(int i = 0; i < lengthUnsorted; i++) {

        if(a[i] > a[i+1]) {
          swap(a, i, i+1);
          numSwaps++;
          isSorted = false;
        }
      }
      --lengthUnsorted;
    }

    firstElement = a[0];
    lastElement = a[a.length - 1];
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static void main(String[] args) {
    int[] a = new int[] {3, 2, 1};

    countSwapsOptimized(a);

    System.out.println("Array is sorted in "+numSwaps+" swaps.");
    System.out.println("First Element: " + firstElement);
    System.out.println("Last Element: " + lastElement);
  }
}
