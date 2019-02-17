package Bubble_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Complexity O(n^2), stable, space O(1)
public class BubbleSort {
  public static void main(String[] args) throws IOException {
    List<String> input = readInput();
    bubbleSort(input);
    print(input);
  }

  private static List<String> readInput() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    List<String> input = Arrays.stream(reader.readLine()
            .split("\\s+"))
            .collect(Collectors.toList());

    return input;
  }

  private static <T> void swap(List<T> input, int currentIndex, int nextIndex) {
    T temp = input.get(currentIndex);
    input.set(currentIndex, input.get(nextIndex));
    input.set(nextIndex, temp);
  }

  private static <T extends Comparable<T>> void bubbleSort(List<T> input) {
    boolean swapped = true;

    do {
      swapped = false;

      for (int i = 0; i < input.size() - 1; i++) {
        int currentIndex = i;
        int nextIndex = i + 1;

        if (input.get(currentIndex).compareTo(input.get(nextIndex)) > 0) {
          swap(input, currentIndex, nextIndex);
          swapped = true;
        }
      }
    }
    while (swapped);
  }

  private static <T> void print(List<T> input) {
    for (T value : input) {
      System.out.printf("%s ", value);
    }
  }
}
