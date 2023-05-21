package practice2;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List <Human> humans = new ArrayList<>();
        humans.add(new Human(19, "Konstantin", "Zhuravlev", LocalDate.of(2003, 6, 28), 80));
        humans.add(new Human(14, "Artem", "Kovalenko", LocalDate.of(2008, 11, 7), 51));
        humans.add(new Human(25, "Alena", "Kuznechova", LocalDate.of(1997, 1, 23), 58));
        humans.add(new Human(27, "Mikhail", "Ivanov", LocalDate.of(1995, 4, 11), 97));
        humans.add(new Human(37, "Anna", "Sidorova", LocalDate.of(1985, 5, 13), 47));
        humans.add(new Human(66, "Vlad", "Petrov", LocalDate.of(1956, 9, 22), 72));
        humans.add(new Human(11, "Victor", "Bystrov", LocalDate.of(2011, 7, 14), 34));
        humans.add(new Human(32, "Denis", "Maximov", LocalDate.of(1970, 10, 6), 85));
        humans.add(new Human(19, "Nikita", "Suvorov", LocalDate.of(2003, 12, 2), 64));
        humans.add(new Human(22, "Alexey", "Gerasimov", LocalDate.of(2000, 2, 25), 71));
        humans.add(new Human(40, "Sergey", "Gribchenko", LocalDate.of(1982, 3, 27), 104));
        humans.add(new Human(8, "Valeria", "Nikolaeva", LocalDate.of(2016, 8, 17), 26));
        

        System.out.println("Изначальный список:");
        humans.stream().forEach(System.out::println);

        System.out.println("\nВыбор первых пяти:");
        humans.stream().limit(5).forEach(System.out::println);

        System.out.println("\nСортировки по дате:");
        humans.stream().sorted((a, b) -> a.getBirthDate().compareTo(b.getBirthDate())).forEach(System.out::println);

        System.out.println("\nФильтрация по весу меньше 60:");
        humans.stream().filter(a -> a.getWeight() < 60).forEach(System.out::println);

        System.out.println("\nВывод только имени и фамилии:");
        humans.forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }
}
