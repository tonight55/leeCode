package leecode.javaSE;

import java.util.Arrays;

/**
 * 　　* @author lee
 * 　　* @date 2022/6/1 18:04
 */
public class SortTest {
    static int[] w = {2, 3, 4, 5};
    static int[] v = {3, 4, 5, 6};

    public static void main(String[] args) {
        int capacity = 8;
        System.out.println(test(5, 8));
    }

    public static int test(int index, int capacity) {
        int[][] arr = new int[index][capacity + 1];
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (w[i - 1] <= j) {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - w[i - 1]] + v[i - 1]);
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }
        return arr[index - 1][capacity];
    }

    public static void bubbleSort(int[] arr) {
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
            boolean isTrue = true;
            for (int i = 1; i < arr.length - j; i++) {
                if (arr[i - 1] > arr[i]) {
                    isTrue = false;
                    int n = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = n;
                }
            }
            if (isTrue) break;
            count++;
            System.out.println(Arrays.toString(arr) + "-----" + count);
        }
    }

    public static void insertSort(int[] arr) {
        int num = 0;
        for (int i = 1; i < arr.length; i++) {
            int count = i - 1;
            int temp = arr[i];
            while (count >= 0 && temp < arr[count]) {
                arr[count + 1] = arr[count];
                count--;
            }
            arr[count + 1] = temp;
        }
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int num = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    num = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[num] = temp;
        }
    }

    public static void fastSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);
            fastSort(arr, left, index - 1);
            fastSort(arr, left + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[pivot] > arr[i]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, index - 1, pivot);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
