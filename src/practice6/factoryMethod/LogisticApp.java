package practice6.factoryMethod;

import java.util.Scanner;

public class LogisticApp {
    public static void main(String[] args) {
        int goodNumber, choice;
        TransportFactory transportFactory;
        Transport transport;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество, которое необходимо доставить: ");
        goodNumber = scanner.nextByte();
        if (goodNumber < 1) throw new IllegalArgumentException("Некорректный ввод. Кол-во товаров введено неверно!");
        for (int i = 0; i < goodNumber; i++) {
            System.out.print("Введите каким способом вы хотите доставить товар:\n1 - наземный транспорт\n" +
                    "2 - водный транспорт\n3 - воздушный траспорт\n> ");
            choice = scanner.nextByte();
            transportFactory = sendTransportByChoice(choice);
            transport = transportFactory.createTransport();
            transport.deliver();
        }
        System.out.println("Все заказы выполнены!");
    }

    public static TransportFactory sendTransportByChoice(int choice){
        if (choice == 1)
            return new TruckFactory();
        else if (choice == 2)
            return new ShipFactory();
        else if (choice == 3)
            return new PlaneFactory();
        else throw new IllegalArgumentException("Некорректный ввод. Данный способ доставки недоступен!");
    }
}
