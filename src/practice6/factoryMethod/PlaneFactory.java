package practice6.factoryMethod;

public class PlaneFactory implements TransportFactory{

    @Override
    public Transport createTransport() {
        return new Plane();
    }
}
