package practice5;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lazy Singleton: ");
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println(lazySingleton1 == lazySingleton2);
        System.out.println(lazySingleton1.equals(lazySingleton2));

        System.out.println("Enum Singleton: ");
        EnumSingleton enumSingleton1 = EnumSingleton.getInstance();
        EnumSingleton enumSingleton2 = EnumSingleton.getInstance();
        System.out.println(enumSingleton1 == enumSingleton2);
        System.out.println(enumSingleton1.equals(enumSingleton2));

        System.out.println("Safe Singleton: ");
        SafeSingleton safeSingleton1 = SafeSingleton.getInstance();
        SafeSingleton safeSingleton2 = SafeSingleton.getInstance();
        System.out.println(safeSingleton1 == safeSingleton2);
        System.out.println(safeSingleton1.equals(safeSingleton2));

    }
}
