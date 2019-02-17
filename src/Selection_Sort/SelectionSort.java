package Selection_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Complexity O(n^2), not stable, space O(1)
public class SelectionSort {
  public static void main(String[] args) throws IOException {
    List<Integer> input = readInput();
    selectionSort(input);
    print(input);
  }

  public static List<Integer> readInput() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    List<Integer> nums = Arrays.stream(reader.readLine()
            .split("\\s+"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    return nums;
  }

  private static <T> void swap(List<T> input, int firstIndex, int secondIndex) {
    T temp = input.get(firstIndex);
    input.set(firstIndex, input.get(secondIndex));
    input.set(secondIndex, temp);
  }

  public static <T extends Comparable<T>> void selectionSort(List<T> input) {
    for (int i = 0; i < input.size() - 1; i++) {
      int index = i;
      for (int j = i + 1; j < input.size(); j++) {
        if (input.get(index).compareTo(input.get(j)) > 0) {
          index = j;

          swap(input, i, j);
        }
      }
    }
  }

  private static <T> void print(List<T> input) {
    for (T value : input) {
      System.out.printf("%s ", value);
    }
  }
}