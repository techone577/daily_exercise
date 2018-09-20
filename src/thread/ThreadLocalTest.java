package thread;

public class ThreadLocalTest extends Thread {
    private static ThreadLocal t = new ThreadLocal();

    public ThreadLocalTest () {
        //初始化赋值线程位main线程
    }

    private void set(){
        t.set(Thread.currentThread().getName());
    }
    @Override
    public void run () {
        set();
        System.out.println(Thread.currentThread().getName()+t.get());
    }

    public static void main (String[] args) {
        Thread t = new ThreadLocalTest();
        Thread t2 = new ThreadLocalTest();
        t.start();
        t2.start();
    }
}
