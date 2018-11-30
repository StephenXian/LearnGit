package Thread;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i=0;i<10;i++){

                try {
                    ConcurrentHashMap.KeySetView<Object, Boolean> objects = ConcurrentHashMap.newKeySet();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                executorService.execute(new Runnable(){

                    @Override
                    public void run() {
                        String stringBuilder = new String();
                        stringBuilder=stringBuilder+"i";
                        System.out.println(Thread.currentThread().getName()+"正在被执行"+stringBuilder);
                    }
                });

        }
    }
}
