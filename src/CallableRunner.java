import java.util.concurrent.*;

class CallableTask implements Callable<String> {

    private String name;

    public CallableTask(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello "+name;
    }
}

public class CallableRunner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // we have to use submit for callable as it is returning value
        Future<String> greetings = executorService.submit(new CallableTask("Mohan"));

        //get() will wait until we get the result since we are using Future promise.
        System.out.println(greetings.get());

        System.out.println("\nMain is completed");

        executorService.shutdown();
    }
}
