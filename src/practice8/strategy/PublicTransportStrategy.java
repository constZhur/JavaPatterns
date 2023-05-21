package practice8.strategy;

public class PublicTransportStrategy implements RouteStrategy{
    @Override
    public void buildRoute(char a, char b) {
        System.out.println("Маршрут " + a + " -> " + b + " на общественном транспорте построен");
    }
}
