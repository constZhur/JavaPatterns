package practice6.builder;

public class StalinkaBuilder implements SovietHouseBuilder {

    private String type;
    private String address;
    private double square;
    private int roomsNumber;

    public StalinkaBuilder(){
        super();
    }

    @Override
    public SovietHouseBuilder fixType() {
        this.type = "Кирпичный тип";
        return this;
    }

    @Override
    public SovietHouseBuilder fixAddress() {
        this.address = "Улица им. Сталина, д. " + (int)(Math.random() % 50 * 100);;
        return this;
    }

    @Override
    public SovietHouseBuilder fixSquare() {
        this.square = 102.3;
        return this;
    }

    @Override
    public SovietHouseBuilder fixRoomsNumbers() {
        this.roomsNumber = 4;
        return this;
    }

    @Override
    public SovietHouse buildHouse() {
        SovietHouse house = new SovietHouse(type, address, square, roomsNumber);
        if (house.isAssembled()) return house;
        else System.out.println("Дом недостроен");
        return null;
    }
}
