package practice6.builder;

public class BrezhnevkaBuilder implements SovietHouseBuilder {

    private String type;
    private String address;
    private double square;
    private int roomsNumber;

    public BrezhnevkaBuilder(){
        super();
    }

    @Override
    public SovietHouseBuilder fixType() {
        this.type = "Блочный тип";
        return this;
    }

    @Override
    public SovietHouseBuilder fixAddress() {
        this.address = "Улица им. Брежнева, д. " + (int)(Math.random() % 50 * 100);;
        return this;
    }

    @Override
    public SovietHouseBuilder fixSquare() {
        this.square = 75.5;
        return this;
    }

    @Override
    public SovietHouseBuilder fixRoomsNumbers() {
        this.roomsNumber = 3;
        return this;
    }

    @Override
    public SovietHouse buildHouse() {
        SovietHouse house = new SovietHouse(type, address, square, roomsNumber);
        if (house.isAssembled())
            return house;
        else
            System.out.println("Дом недостроен");
        return null;
    }
}
