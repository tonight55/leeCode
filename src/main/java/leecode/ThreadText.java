package leecode;

import java.sql.SQLOutput;
import java.util.Timer;

/**
 * 　　* @author lee
 * 　　* @date 2022/6/6 9:30
 */
public class ThreadText {
    public static void main(String[] args) {
       new TimeTask(()-> System.out.println("time"),3000).start();
    }
}

class TimeTask{
   Runnable runnable;
   long time;

    public TimeTask(Runnable runnable, long time) {
        this.runnable = runnable;
        this.time = time;
    }
    public void start(){
        new Thread(()->{
            try {
                Thread.sleep(time);
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
