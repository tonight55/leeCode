package leecode.javaSE;

/**
 * 　　* @author lee
 * 　　* @date 2022/6/2 17:47
 */
public class Half {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 6, 7, 10, 12, 14, 20, 22, 26};
        System.out.println(test(arr, 14));
    }

    public static int test(int[] arr, int target) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (target > arr[mid]) {
                min = mid + 1;
            } else if (target < arr[mid]) {
                max = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
