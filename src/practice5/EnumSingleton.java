package practice5;

public enum EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance() {
            return INSTANCE;
    }
}
