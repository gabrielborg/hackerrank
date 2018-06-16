package com.gabriellopes.crackingthecodinginterview.datastructures;

import java.util.Scanner;
import java.util.Stack;

/** Created by glopes in May 2018. */
public class StacksBalancedBrackets {

  private static final int OPENING_SQUARE_BRACKET = '[';
  private static final int CLOSING_SQUARE_BRACKET = ']';
  private static final int OPENING_CURLY_BRACE = '{';
  private static final int CLOSING_CURLY_BRACE = '}';
  private static final int OPENING_PARENTHESIS = '(';
  private static final int CLOSING_PARENTHESIS = ')';

  private static boolean isBalanced(String expression) {

    if (expression.length() % 2 != 0) return false;

    final Stack<Integer> stack = new Stack<>();

    for (int bracket : expression.toCharArray()) {

      if (bracket == OPENING_SQUARE_BRACKET
          || bracket == OPENING_CURLY_BRACE
          || bracket == OPENING_PARENTHESIS) {

        stack.push(bracket);
      } else {

        if (stack.isEmpty() || !isEnclosing(stack.pop(), bracket)) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  private static boolean isEnclosing(int bracketA, int bracketB) {

    boolean result = false;
    switch (bracketA) {
      case OPENING_SQUARE_BRACKET:
        result = bracketB == CLOSING_SQUARE_BRACKET;
        break;
      case OPENING_CURLY_BRACE:
        result = bracketB == CLOSING_CURLY_BRACE;
        break;
      case OPENING_PARENTHESIS:
        result = bracketB == CLOSING_PARENTHESIS;
        break;
    }
    return result;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      String expression = scanner.nextLine();

      System.out.println(isBalanced(expression) ? "YES" : "NO");
    }

    scanner.close();
  }
}
