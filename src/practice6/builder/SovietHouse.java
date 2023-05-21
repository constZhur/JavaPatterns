package practice6.builder;

public class SovietHouse {

    private String type;
    private String address;
    private double square;
    private int roomsNumber;

    public SovietHouse() {
        type = "";
        address = "";
        square = 0.0;
        roomsNumber = 0;
    }

    public SovietHouse(String type, String address, double square, int roomsNumber) {
        this.type = type;
        this.address = address;
        this.square = square;
        this.roomsNumber = roomsNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public int getRoomNumbers() {
        return roomsNumber;
    }

    public void setRoomNumbers(int roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public boolean isAssembled(){
        return (type != null && type.trim().isEmpty()) || (address != null && address.trim().isEmpty())
                || square != 0.0 || roomsNumber != 0;
    }

    @Override
    public String toString() {
        return "SovietHouse{" +
                "type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", square=" + square +
                ", roomsNumber=" + roomsNumber +
                '}';
    }
}
