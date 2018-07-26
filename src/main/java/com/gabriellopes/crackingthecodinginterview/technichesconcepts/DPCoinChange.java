package com.gabriellopes.crackingthecodinginterview.technichesconcepts;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** Created by glopes in Jul 2018. */
public class DPCoinChange {

  // Complete the ways function below.
  static long ways(int n, int[] coins) {

    long[] combinations = new long[n + 1];
    combinations[0] = 1L;

    for (int coin : coins) {

      for (int i = coin; i < combinations.length; i++) {

        combinations[i] += combinations[i - coin];
      }
    }

    return combinations[n];
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    try (BufferedWriter bufferedWriter =
        new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

      String[] nm = scanner.nextLine().split(" ");

      int n = Integer.parseInt(nm[0]);

      int m = Integer.parseInt(nm[1]);

      int[] coins = new int[m];

      String[] coinsItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int i = 0; i < m; i++) {
        int coinsItem = Integer.parseInt(coinsItems[i]);
        coins[i] = coinsItem;
      }

      long res = ways(n, coins);

      bufferedWriter.write(String.valueOf(res));
      bufferedWriter.newLine();
    }

    scanner.close();
  }
}
