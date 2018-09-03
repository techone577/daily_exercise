package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadInOrder {
    private static Object flag = false;

    public static void showInOrder () throws Exception {
        Thread thread = new Thread() {
            @Override
            public void run () {
                synchronized (flag) {
                    for (int i = 0; i < 26; i++) {
                        System.out.print(i);
                        try {
                            flag.wait();
                            flag.notify();
                        } catch (InterruptedException e) {

                        }

                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run () {
                synchronized (flag) {
                    for (int i = 0; i < 26; i++) {
                        try {
                            System.out.print((char) (i + 'A'));
                            flag.notify();
                            flag.wait();
                        } catch (Exception e) {

                        }

                    }
                }
            }
        };
        thread.start();
        //保证启动顺序
        Thread.sleep(10);
        thread2.start();
    }


    public static void main (String[] args) throws Exception {
        ThreadInOrder.showInOrder();
    }

}
