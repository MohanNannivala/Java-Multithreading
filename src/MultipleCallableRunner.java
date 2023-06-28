import java.util.List;
import java.util.concurrent.*;


public class MultipleCallableRunner {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        List<CallableTask> tasks = List.of(new CallableTask("Mohan"),
                new CallableTask("Sajjan"),
                new CallableTask("Nannivala"));

        List<Future<String>> greetings = executorService.invokeAll(tasks);

        for (Future<String> greeting: greetings) {
            System.out.println(greeting.get());
        }

        executorService.shutdown();
    }
}
