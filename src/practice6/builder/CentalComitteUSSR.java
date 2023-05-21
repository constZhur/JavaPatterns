package practice6.builder;

public class CentalComitteUSSR {
    private SovietHouseBuilder builder;

    public CentalComitteUSSR(SovietHouseBuilder builder){
        this.builder = builder;
        if (this.builder == null)
            throw new IllegalArgumentException("This house can't be released because it's unfinished");
    }

    public SovietHouse manufactureSovietHouse(){
        return builder.fixType().fixAddress().fixSquare().fixRoomsNumbers().buildHouse();
    }
}
