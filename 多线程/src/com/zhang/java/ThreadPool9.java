package com.zhang.java;

import java.util.concurrent.*;

/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
 *  1.提高响应速度（减少了创建新线程的时间）
 *  2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *  3.便于线程管理
 *    corePoolSize：核心池的大小
 *    maximumPoolSize：最大线程数
 *    keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 * author PC
 * create 2021-01-15-11:04
 */
class RunThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class CallThread implements Callable {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                sum+=i;
            }
        }
        return sum;
    }
}

public class ThreadPool9 {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
        //设置线程池的属性
//        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();

        service.execute(new RunThread());

        Future<Integer> result = service.submit(new CallThread());
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
