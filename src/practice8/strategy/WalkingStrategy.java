package practice8.strategy;

public class WalkingStrategy implements RouteStrategy{
    @Override
    public void buildRoute(char a, char b) {
        System.out.println("Пеший маршрут " + a + " -> " + b + " построен");
    }
}
