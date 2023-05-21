package practice7.adapter;

public class Client {
    public static void main(String[] args) {
        AnaliticsLibrary library = new FileAdapter(new StockDataProvider());
        System.out.println("Аналитика json-файла " + library.getJsonFile());
        System.out.println("Аналитика завершена!");
    }
}
