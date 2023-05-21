package practice8.strategy;

public class RoadStrategy implements  RouteStrategy{
    @Override
    public void buildRoute(char a, char b) {
        System.out.println("Маршрут " + a + " -> " + b + " на персональном автомобиле построен");
    }
}
