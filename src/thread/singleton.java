package thread;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class singleton {
    private static volatile singleton single;

    private singleton () {
    }

    public static singleton getInstance () {
        if (single == null) {
            synchronized (singleton.class) {
                if (single == null)
                    single = new singleton();
            }
        }
        return single;
    }

    public static void main (String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 20, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> System.out.println(singleton.getInstance()));
        }

    }
}
