import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Task extends Thread{

    int number;
    public Task(int number){
        this.number = number;
    }

    public void run(){
        System.out.println("\n Task "+number+" Started");

        for(int i=number*100; i<=(number*100)+99; i++){
            System.out.print(i+" ");
        }
        System.out.println("\n Task "+number+" Done");
    }
}

public class ThreadExecutorService {

    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(new Task(1));
        executorService.execute(new Task(2));
        executorService.execute(new Task(3));
        executorService.execute(new Task(4));
        executorService.execute(new Task(5));
        executorService.execute(new Task(6));

        executorService.shutdown();
    }
}
