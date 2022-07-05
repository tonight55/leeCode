package leecode.code;

import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set timeNum = getTimeNum();
        System.out.println(timeNum.size());
        System.out.println("**************");
        for (Object o : timeNum) {
            System.out.println(o);
        }
    }

    public static Set getTimeNum() {

        Set<Integer> set = new HashSet<>();
        //第一轮
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                //第二轮
                for (int k = 1; k < 9; k++) {
                    if (i != j && j != k && i != k) {
                        int[] nums = new int[3];
                        nums[0] = i;
                        nums[1] = j;
                        nums[2] = k;
                        Arrays.sort(nums);
                        int n = nums[0] * 100 + nums[1] * 10 + nums[2];
                        set.add(n);
                    }
                }
            }
        }
        return set;
    }


}


