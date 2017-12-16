import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 11007122 on 16.12.2017.
 */
public class ExecutionManagerImpl implements ExecutionManager {
    @Override
    public Context execute(Runnable callback, Runnable... tasks) {

        int taskAmount = 0;
        for (Runnable task: tasks) {
            taskAmount++;
        }

        Context context = new ContextImpl(taskAmount, callback, tasks) ;

        return context;
    }
}
