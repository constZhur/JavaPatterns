package practice6.factoryMethod;

public class ShipFactory implements TransportFactory {

    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
