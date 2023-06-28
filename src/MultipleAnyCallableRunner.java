import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleAnyCallableRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<CallableTask> tasks = List.of(new CallableTask("Mohan"),
                new CallableTask("Sajjan"),
                new CallableTask("Nannivala"));

        String greetings = executorService.invokeAny(tasks);

        System.out.println(greetings);

        executorService.shutdown();
    }
}
