package leecode.text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 　　* @author lee
 * 　　* @date 2022/6/5 16:04
 */
public class IoDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        AtomicInteger atomicInteger2 = new AtomicInteger(0);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger2.get());
        for (int i = 0; i < 10; i++) {
            System.out.println(atomicInteger.incrementAndGet());
        }
        System.out.println(atomicInteger2.getAndAdd(10));

        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger2.get());
    }
}
