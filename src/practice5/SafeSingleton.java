package practice5;

public class SafeSingleton {
    private static volatile SafeSingleton instance;

    private SafeSingleton(){};

    public static SafeSingleton getInstance() {
        if (instance == null) {
            synchronized (SafeSingleton.class) {
                if (instance == null) {
                    instance = new SafeSingleton();
                }
            }
        }
        return instance;
    }
}
