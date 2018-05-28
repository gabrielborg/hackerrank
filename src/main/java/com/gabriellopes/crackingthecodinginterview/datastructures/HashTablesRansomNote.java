package com.gabriellopes.crackingthecodinginterview.datastructures;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by glopes in May 2018.
 */
public class HashTablesRansomNote {

  private static Boolean solve(String[] magazine, String[] ransom) {

    Map<String, Long> groupedMagazineWords = Arrays.stream(magazine)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    Boolean result = false;

    for(String ransomWord : ransom) {

      if(groupedMagazineWords.containsKey(ransomWord)) {

        Long value = groupedMagazineWords.get(ransomWord);

        if(value <= 0) {

          result = false;
          break;
        }

        groupedMagazineWords.put(ransomWord, --value);
        result = true;

      } else {

        result = false;
        break;
      }

    }
    return result;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    String[] mn = scanner.nextLine().split(" ");

    int m = Integer.parseInt(mn[0]);

    int n = Integer.parseInt(mn[1]);

    String[] magazine = new String[m];

    String[] magazineItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      String magazineItem = magazineItems[i];
      magazine[i] = magazineItem;
    }

    String[] ransom = new String[n];

    String[] ransomItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      String ransomItem = ransomItems[i];
      ransom[i] = ransomItem;
    }

    final String NO = "No";
    final String YES = "Yes";

    System.out.println(solve(magazine, ransom) ? YES : NO);

    scanner.close();
  }
}
