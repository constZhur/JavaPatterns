package practice6.builder;

public interface SovietHouseBuilder {

    public SovietHouseBuilder fixType();

    public SovietHouseBuilder fixAddress();

    public SovietHouseBuilder fixSquare();

    public SovietHouseBuilder fixRoomsNumbers();

    public SovietHouse buildHouse();
}
