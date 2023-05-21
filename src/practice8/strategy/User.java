package practice8.strategy;

import java.io.IOException;
import java.util.Scanner;

public class User {
    public static void main(String[] args){
        char a, b;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите изначальную точку: ");
        a  = scanner.next().charAt(0);
        System.out.print("Введите точку назначения: ");
        b  = scanner.next().charAt(0);
        System.out.print("Введите расстояние до пункта: ");
        int distance = scanner.nextInt();
        Navigator navigator = new Navigator(a, b);
        navigator.buildRoute(distance);
    }
}
