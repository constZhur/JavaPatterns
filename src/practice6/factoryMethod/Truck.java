package practice6.factoryMethod;

public class Truck implements Transport{
    @Override
    public void deliver() {
        System.out.println("Грузовик доставил товар!");
    }
}
