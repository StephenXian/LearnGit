import com.google.common.util.concurrent.RateLimiter;

import java.util.List;
import java.util.concurrent.Executor;

public class Test {

       final RateLimiter rateLimiter = RateLimiter.create(2.0); // rate is "2 permits per second"
       void submitTasks(List<Runnable> tasks, Executor executor) {
         for (Runnable task : tasks) {
           rateLimiter.acquire(); // may wait
           executor.execute(task);
         }
       }

}
