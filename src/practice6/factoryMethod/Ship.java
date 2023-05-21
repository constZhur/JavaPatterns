package practice6.factoryMethod;

public class Ship implements Transport{
    @Override
    public void deliver() {
        System.out.println("Корабль доставил товар!");
    }
}
