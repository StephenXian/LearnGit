package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ThreadExcutorPool {
    public static void main(String[] args) {
        //
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorService executorService1 = Executors.newCachedThreadPool();
        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
    }
}
