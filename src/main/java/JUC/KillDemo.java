package JUC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * 秒杀合并demo
 */
public class KillDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        ArrayList<Future<Result>> futures = new ArrayList<>();
        KillDemo killDemo = new KillDemo();
        killDemo.mergeJob();
        Thread.sleep(2000);
        for (int i = 0; i < 100; i++) {
            final Long orderId=i+100L;
            final Long userId= Long.valueOf(i) ;
            Future<Result> submit = executorService.submit(() -> {
               countDownLatch.countDown();
                if(userId==0){
                    time=System.currentTimeMillis();
                }
                return killDemo.operate(new UserRequest(orderId, userId, 1));
            });
            futures.add(submit);
        }

        futures.forEach(future->{
            try {
                Result result = future.get(300, TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName()+"请求响应"+result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(System.currentTimeMillis()-time);
        System.out.println(stock);
    }

    /**
     * 设置库存
     */
    private static Long time = null;
    private static Integer stock = 500;
    private static BlockingQueue<RequestPromise> bQ = new LinkedBlockingQueue<>(40);


    /**
     *  请求合并
     */
    public void mergeJob(){
        new Thread(()->{List<RequestPromise> list = new ArrayList<>();
           while (true){
               if (bQ.isEmpty()){
                   try {
                       Thread.sleep(10);
                       continue;
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
               list.clear();
               while (bQ.peek()!=null){
                   list.add(bQ.poll());
               }
               System.out.println(Thread.currentThread().getName()+"合并扣减库存"+list);
               int sum=list.stream().mapToInt(r->r.getUserRequest().getCount()).sum();
               System.out.println(Thread.currentThread().getName()+"合并扣减库存"+sum);
               //请求总数
               if(sum<=stock){
                   stock-=sum;
                   list.forEach(requestPromise -> {
                       requestPromise.setResult(new Result(true,"ok"));
                       synchronized (requestPromise){
                           requestPromise.notify();
                       }
                   });
                   continue;
               }else {
                   for (RequestPromise requestPromise: list) {
                       Integer count = requestPromise.getUserRequest().getCount();
                       if (count<=stock){
                           stock-=count;
                           requestPromise.setResult(new Result(true,"ok"));
                           synchronized (requestPromise){
                               requestPromise.notify();
                           }
                       }else {
                           requestPromise.setResult(new Result(false,"库存不足"));;
                       }
                   }
               }
           }
        }
        ,"mergeThread").start();
    }

    /**
     * 用户库存扣减
     */
    public Result operate(UserRequest userRequest) throws InterruptedException {
        // TODO 阈值判断
        // TODO 队列的创建
        RequestPromise requestPromise = new RequestPromise(userRequest);
        boolean offer = bQ.offer(requestPromise, 1000, TimeUnit.MILLISECONDS);
        if (!offer){
            return new Result(false,"系统繁忙");
        }
        synchronized (requestPromise){
            try{
                requestPromise.wait(200);
            }catch (InterruptedException e){
                return new Result(false,"等待超时");
            }
        }
        return requestPromise.getResult();
    }
}

class RequestPromise {
    @Override
    public String toString() {
        return "RequestPromise{" +
                "userRequest=" + userRequest +
                ", result=" + result +
                '}';
    }

    private UserRequest userRequest;
    private Result result;

    public RequestPromise(UserRequest userRequest) {
        this.userRequest = userRequest;
    }

    public RequestPromise(UserRequest userRequest, Result result) {
        this.userRequest = userRequest;
        this.result = result;
    }

    public UserRequest getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(UserRequest userRequest) {
        this.userRequest = userRequest;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}


