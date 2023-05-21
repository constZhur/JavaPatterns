package practice4;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int threadsNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество потоков:\n> ");
        threadsNumber = scanner.nextInt();
        MyExecutorService service = new MyExecutorService(threadsNumber);
        for (int i = 0; i < threadsNumber*5; i++) {
            service.execute(() -> System.out.println(Thread.currentThread().getName())); //передача задачи в ThreadPool
        }
        service.shutdown(); //потоков больше не будет
        try {
            service.awaitTermination(1, TimeUnit.SECONDS); //остановка потока, в котором был вызван метод
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("thread 'main' is ended");
    }
}
