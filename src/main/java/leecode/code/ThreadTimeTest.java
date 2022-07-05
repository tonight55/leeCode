package leecode.code;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTimeTest {

    static long n = 0L;


    public static void main(String[] args) throws Exception {
        Thread[] threadTimes = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threadTimes.length);

        long l = System.currentTimeMillis();
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < threadTimes.length; i++) {
            threadTimes[i] = new Thread(() -> {
                for (int j = 0; j < 100000; j++) {
//                    reentrantLock.lock();
//                    try {
//                        n++;
//                    } finally {
//                        reentrantLock.unlock();  //reentrantLock 186ms
//                    }
                    synchronized (ThreadTimeTest.class){     //reentrantLock 472ms
                        n++;
                    }
                }
                countDownLatch.countDown();
            });
        }
        for (Thread threadTime : threadTimes) {
            threadTime.start();
        }
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - l);
        System.out.println(n);
    }
}


