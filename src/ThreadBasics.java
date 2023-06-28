
/**
 *There are 2 ways to create the thread
 * 1. extends Thread
 * 2. implements Runnable
 *
 * Different states of thread:
 *
 * NEW: Thread is ready but not started, before calling start().
 * RUNNABLE: when the tread is read but waiting for CPU(it turn).
 * BLOCKED/WAITING: Waiting for some other thread or external resource like DB.
 * RUNNING: once the threads are executing.
 * TERMINATED/DEAD: once the threads are completed execution.
 *
 * Important static methods:
 *
 * Thread.sleep(10000) : will make thread sleep for 10000ms
 * Thread.yield() : A hint to the scheduler that the current thread is willing to yield its current use of a processor.
 *
 * synchronized: only one thread can execute on the instance at a time.
 */

//creating the thread using Thread class
class Task1 extends Thread{
    public void run(){

        System.out.println("\n Task1 Started");

        for(int i=101; i<=199; i++){
            System.out.print(i + " ");
        }

        System.out.println("\n Task1 Done");
    }
}

//creating the thread using Runnable interface
class Task2 implements Runnable{

    public void run(){

        System.out.println("\n Task2 Started");

        for(int i=201; i<=299; i++){
            System.out.print(i + " ");
        }

        System.out.println("\n Task2 Done");
    }
}

class Task3 extends Thread{
    public void run(){

        System.out.println("\n Task3 Started");

        for(int i=301; i<=399; i++){
            System.out.print(i + " ");
        }

        System.out.println("\n Task3 Done");
    }
}

public class ThreadBasics {

    public static void main(String[] args) throws InterruptedException {

        //Task1
        Task1 task1 = new Task1();
        task1.setPriority(1);
        task1.start();

        //wait until task1 complete
        task1.join();

        //Task2
        Task2 task2 = new Task2();
        Thread thread = new Thread(task2);
        thread.setPriority(10);
        thread.start();

        //wait until task2 complete
        thread.join();

        //Task3
        Task3 task3 = new Task3();
        task3.start();

        //wait until task3 complete
        task3.join();

        System.out.println("\n Main Done");

    }
}