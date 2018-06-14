package com.gabriellopes.crackingthecodinginterview.algorithms;

import java.util.Comparator;

/** Created by glopes in Jun 2018. */
public class SortingComparator implements Comparator<Player> {

  @Override
  public int compare(Player o1, Player o2) {

    if (o1.score == o2.score) {

      return o1.name.compareToIgnoreCase(o2.name);

    } else if (o1.score < o2.score) {

      return 1;
    } else {

      return -1;
    }
  }
}

class Player {
  String name;
  int score;

  Player(String name, int score) {
    this.name = name;
    this.score = score;
  }
}
