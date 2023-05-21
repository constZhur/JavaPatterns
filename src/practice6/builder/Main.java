package practice6.builder;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int year;
        System.out.print("Введите год постройки дома: ");
        Scanner scanner = new Scanner(System.in);
        year = scanner.nextInt();
//        System.out.println(year);
        SovietHouseBuilder builder;
        if (year > 1925 && year < 1955)
            builder = new StalinkaBuilder();
        else if (year >= 1955 && year < 1970)
            builder = new KhrushchevkaBuilder();
        else if (year >= 1970 && year < 1985)
            builder = new BrezhnevkaBuilder();
        else {
            System.out.println("В этот год Советские дома не строились!");
            return;
        }
//        CentalComitteUSSR comitte = new CentalComitteUSSR(builder);
        SovietHouse house = new CentalComitteUSSR(builder).manufactureSovietHouse();
        if (house != null) System.out.println("Был создан дом со следующими параметрами:\nТип дома: " + house.getType() +
                "\nАдрес: " + house.getAddress() + "\nПлощадь: " + house.getSquare() + "\nКол-во комнат: " + house.getRoomNumbers());
    }
}
