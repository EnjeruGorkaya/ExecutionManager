import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by 11007122 on 16.12.2017.
 */
public class ContextImpl implements Context {
    private int completedTasks;
    private int failedTasks; //  в рантайме
    private int interruptedTasks;
    private boolean isFinished;
    private ExecutorService pool;
    private List<Future> futures;

    public ContextImpl(int amount, Runnable callback, Runnable... tasks) {
        this.completedTasks = 0;
        this.failedTasks = 0;
        this.interruptedTasks = 0;
        this.isFinished = false;
        futures = new ArrayList<>();
        this.pool = Executors.newFixedThreadPool(amount);
        for(Runnable task: tasks) {
            futures.add(pool.submit(task));
        }
    }

    @Override
    public int getCompletedTaskCount() {
        //pool.submit
        return 0;
    }

    @Override
    public int getFailedTaskCount() {
        return 0;
    }

    @Override
    public int getInterruptedTaskCount() {
        return 0;
    }

    @Override
    public void interrupt() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
