package com.gabriellopes.crackingthecodinginterview.technichesconcepts;

import java.util.stream.IntStream;

/**
 * Created by glopes in Jun 2018.
 *
 * <p>A great real time application of Fibonacci series that’s used mostly these days as an unknown
 * fact are the mile to kilometer conversion & Kilometer to mile conversion…..
 *
 * <p>Let’s now see the Fibonacci series :
 *
 * <p>0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,…
 *
 * <p>For example :
 *
 * <p>Mile to kilometer conversion : If we take a number from Fibonacci series i.e., 8 then the
 * kilometer value will be 12.874752 by formulae, which is nearly 13 by rounding.
 *
 * <p>Kilometer to mile conversion : If we take a number from Fibonacci series i.e., 89 as kilometer
 * value then mile value will be 55.30203610912272 by formulae, which could be considered as 55 by
 * rounding.
 */
public class RecursionFibonacciNumbers {

  /**
   * O(2^n) time complexity space complexity O(n)
   *
   * <p>fibonacci(5) = fibonacci(4) + fibonacci(3)
   *
   * <p>fibonacci(4) = fibonacci(3) + fibonacci(2)
   *
   * <p>fibonacci(3) = fibonacci(2) + fibonacci(1)
   *
   * <p>fibonacci(2) = fibonacci(1) + fibonacci(0)
   *
   * <p>Inefficient because it calculates the same sub-problems over and over
   *
   * @param n
   * @return
   */
  public static int fibonacci(int n) {

    if (n <= 0) return 0;
    if (n == 1) return 1;

    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  /**
   * O(n) time complexity
   *
   * <p>space complexity O(n(stack) + n (memo)) witch is O(n)
   *
   * <p>One way to make a recursive program optimized is using some kind of memorization in order to
   * do not calculate same sub-problems over and over.
   *
   * @param n
   * @param memo
   * @return
   */
  public static int optimizedFibonacci(int n, int[] memo) {

    if (n <= 0) {

      return 0;
    } else if (n == 1) {

      return 1;
    } else if (memo[n] == 0) {

      memo[n] = optimizedFibonacci(n - 1, memo) + optimizedFibonacci(n - 2, memo);
    }

    //    IntStream.of(memo).forEach(System.out::println);
    //    System.out.println();

    return memo[n];
  }

  public static int dynamicProgrammingFibonacci(int n) {

    if(n <= 0) {

      return 0;
    } else if(n == 1) {

      return 1;
    }

    int n1 = 0;
    int n2 = 1;
    int n3 = 0;

    for (int i = 2; i <= n; i++) {

      n3 = n1 + n2;
      n1 = n2;
      n2 = n3;
    }

    return n3;
  }

  public static void main(String[] args) {
    //    Scanner scanner = new Scanner(System.in);
    //    int n = scanner.nextInt();
    //    scanner.close();
    //    System.out.println(fibonacci(4));

    int n = 6;
    int[] memo = new int[n + 1];

    System.out.println(optimizedFibonacci(n, memo));

    //    IntStream.of(memo).forEach(System.out::println);

    System.out.println(dynamicProgrammingFibonacci(n));
  }
}
