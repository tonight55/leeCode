package leecode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10};
        int i = solution.maxProfit(nums, 9);
        System.out.println(i);
    }


    static final int chu = (int) (Math.pow(10, 9) + 7);

    public int maxProfit(int[] inventory, int orders) {
        int num = 0;
        if (inventory.length == 1) {
            return inventory[0] + (orders - 1);
        }
        while (true) {
            Arrays.sort(inventory);
            int k = inventory.length - 1;
            int count = 1;
            if (inventory[k] == inventory[k - 1]) {
                k--;
                count++;
            }
            int i = inventory[k] - inventory[k - 1];
            if (orders > i * count) {
                num = (inventory[k] + i - 1) * count;
                inventory[k] = inventory[k - 1];
            }

            return num;
        }
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        if (!(finalSum % 2 == 0)) {
            return null;
        }
        List<Long> longs = new ArrayList<>();
        long num = 2;
        long pivot = finalSum;
        while (num <= pivot) {
            pivot = pivot - num;
            longs.add(num);
            num += 2;
        }
        if (pivot != 0) {
            Long aLong = longs.get(longs.size() - 1);
            longs.remove(longs.size() - 1);
            longs.add(aLong + pivot);
        }
        return longs;
    }
}
