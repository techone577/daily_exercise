package thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,20,TimeUnit.SECONDS,new LinkedBlockingDeque<>(10));
    public static void run() {
        threadPoolExecutor.execute(() -> System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()));
        try{Thread.currentThread().join();}
        catch(Exception e){}
    }

    public static void main(String []args){
        for(int i=0;i<10;i++){
                Thread thread = new Thread(() -> ThreadPool.run(), String.valueOf(i));
                thread.start();
        }

    }

}
