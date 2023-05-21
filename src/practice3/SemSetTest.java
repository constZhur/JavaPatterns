package practice3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SemSetTest {
    public static void main(String[] args) {
        Set <Integer> set = new HashSet<>();
        Set <Integer> mySet = new SemaphoreSet<>();

        Thread one = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                set.add(i);
                mySet.add(i);
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                set.add(i);
                mySet.add(i);
            }
        });

        one.start();
        two.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(mySet.size());
        System.out.println(set.size());
    }
}
