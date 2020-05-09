package com.gabriellopes.crackingthecodinginterview.datastructures;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by glopes in May 2018.
 *
 * Algorithm Explained (from https://medium.com/@eranda/running-median-with-heaps-829522330e8a)
 * One of the most effective way of solving this is heap data structure.
 * In that we will maintain two heaps, min-heap and a max heap. When a number comes we will
 * first compare it with the current median and put it to the appropriate heap.
 *
 * If the new integer value is less than the current median, we put it in to the max-heap else
 * we put it to the min-heap. Then we will make sure min and max heap properties are preserved.
 * (general heap properties + min/max at the top of each heap)
 *
 * Next is to check whether the size difference between two heaps are more than one. If it is, we
 * will take the top one out of the large heap and put it to the other. (to make the size difference
 * between two heaps 0 or 1) Then again we have to make sure the two heaps are preserving their
 * heap properties. (general heap properties + min/max at the top of each heap)
 *
 * At the end we will calculate the median, if the two heaps are in same size the median should be
 * the (top value of minHeap + top value of maxHeap)/2. If the two heaps are unbalanced, the median
 * should be the top value of the large heap.
 *
 * Than we will move on to the next number in the stream.
 *
 * https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem?h_r=internal-search
 */
public class HeapsFindTheRunningMedian {

  private static class HeapSolution {

    private final PriorityQueue<Double> minHeap;
    private final PriorityQueue<Double> maxHeap;
    private Double currentMedian;

    public HeapSolution(int capacity) {

      int optimalCapacity;

      if (capacity % 2 == 0) {

        optimalCapacity = capacity / 2;
      } else {

        optimalCapacity = ((capacity - 1) / 2) + 1;
      }

      this.minHeap = new PriorityQueue<>(optimalCapacity);
      this.maxHeap = new PriorityQueue<>(optimalCapacity, Comparator.reverseOrder());
      this.currentMedian = 0.0;
    }

    public void add(Double item) {

      if (item < currentMedian) {

        this.maxHeap.offer(item);
      } else {

        this.minHeap.offer(item);
      }

      fixSizeDifference();
      calculateMedian();
    }

    private void fixSizeDifference() {

      int minHeapSize = minHeap.size();
      int maxHeapSize = maxHeap.size();

      if (Math.abs(minHeapSize - maxHeapSize) > 1) {

        if (minHeapSize > maxHeapSize) {

          maxHeap.offer(minHeap.poll());
        } else {

          minHeap.offer(maxHeap.poll());
        }
      }
    }

    public Double getMedian() {

      return this.currentMedian;
    }

    private void calculateMedian() {

      int minHeapSize = minHeap.size();
      int maxHeapSize = maxHeap.size();

      if (minHeapSize == maxHeapSize) {

        this.currentMedian = (this.minHeap.peek() + this.maxHeap.peek()) / 2;
      } else if (minHeapSize > maxHeapSize) {

        this.currentMedian = this.minHeap.peek();
      } else {

        this.currentMedian = this.maxHeap.peek();
      }
    }
  }

  public static void main(String[] args) {
    int n = 6; // size of the input.

    int[] a = new int[] {12, 4, 5, 3, 8, 7};

    HeapSolution heapSolution = new HeapSolution(n);
    DecimalFormat decimalFormat = new DecimalFormat("#.0");

    for (Integer value : a) {

      heapSolution.add(Double.valueOf(value));
      System.out.println(decimalFormat.format(heapSolution.getMedian()));
    }
  }
}
