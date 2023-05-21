package practice3;

import java.util.*;

import static java.lang.Thread.sleep;

public class SyncListTest {
    public static void main(String[] args) {
        List <Integer> list = new SynchronizedArrayList();
        //List <Integer> list = new ArrayList<>();

        Thread one = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
        });

        one.start();
        two.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("SynchronizedList:");
        list.forEach((a) -> System.out.print(a + " "));
    }
}
