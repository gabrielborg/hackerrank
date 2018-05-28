package com.gabriellopes.crackingthecodinginterview.datastructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by glopes in May 2018.
 */
public class ArraysLeftRotation {

  // Complete the solve function below.
  static int[] solve(int[] a, int d) {

    int[] result = a;

    for(int i = 0; i < d; i++) {

      result = doRotation(result);
    }

    return result;
  }

  private static int[] doRotation(int[] a) {

    int arraySize = a.length;

    int firstElement = a[0];

    int[] result = new int[arraySize];

    System.arraycopy(a, 1, result, 0, arraySize - 1);

    result[arraySize - 1] = firstElement;

    return result;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

      String[] nd = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nd[0]);

      int d = Integer.parseInt(nd[1]);

      int[] a = new int[n];

      String[] aItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < n; i++) {
        int aItem = Integer.parseInt(aItems[i]);
        a[i] = aItem;
      }

      int[] result = solve(a, d);

      for (int i = 0; i < result.length; i++) {
        bufferedWriter.write(String.valueOf(result[i]));

        if (i != result.length - 1) {
          bufferedWriter.write(" ");
        }
      }

      bufferedWriter.newLine();
    }

    scanner.close();
  }
}
