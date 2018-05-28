package com.gabriellopes.crackingthecodinginterview;

import java.util.Scanner;

/**
 * Created by glopes in May 2018.
 */
public class StringsMakingAnagrams {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String a = scanner.nextLine();

    String b = scanner.nextLine();

    final int ALPHABET_LETTERS_NUM = 26;
    final int FIRST_LETTER = 'a';

    int lettersFreq1[] = new int[ALPHABET_LETTERS_NUM];
    int lettersFreq2[] = new int[ALPHABET_LETTERS_NUM];

    for (int i = 0; i < a.length(); i++) {
      lettersFreq1[a.charAt(i) - FIRST_LETTER]++;
    }

    for(int i = 0; i < b.length(); i++) {
      lettersFreq2[b.charAt(i) - FIRST_LETTER]++;
    }

    int result = 0;

    for(int i = 0; i < ALPHABET_LETTERS_NUM; i++) {

      result += Math.abs(lettersFreq1[i] - lettersFreq2[i]);
    }

    System.out.println(result);

    scanner.close();
  }
}
