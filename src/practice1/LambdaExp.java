package practice1;

import java.util.Comparator;

public class LambdaExp {
    public static void main (String[] args) {
        Comparator <Integer> result = (a, b) -> ((Integer) Math.abs(a)).compareTo((Integer)Math.abs(b));
        System.out.println(result.compare(4, 5));
        System.out.println(result.compare(-4, 3));
        System.out.println(result.compare(4, 4));
    }
}