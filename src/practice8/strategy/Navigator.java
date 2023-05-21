package practice8.strategy;

public class Navigator {
    private RouteStrategy routeStrategy;
    char a, b;
    public Navigator(char a, char b){
        this.a = a;
        this.b = b;
    }

    public void buildRoute(int distance){
        if (distance <= 0)
            throw new IllegalArgumentException("Дистанция не может быть меньше нуля");
        if (distance <= 4)
            routeStrategy = new WalkingStrategy();
        else if (distance < 15)
            routeStrategy = new PublicTransportStrategy();
        else routeStrategy = new RoadStrategy();
        routeStrategy.buildRoute(a, b);
    }
}
