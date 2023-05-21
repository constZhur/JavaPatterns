package practice6.factoryMethod;

public class Plane implements Transport{
    @Override
    public void deliver() {
        System.out.println("Самолет доставил товар!");
    }
}
