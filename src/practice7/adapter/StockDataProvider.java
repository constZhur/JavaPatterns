package practice7.adapter;

//Исходный класс, возвращающий файл в формате xml
public class StockDataProvider {
    private String file;

    public StockDataProvider(){
         file = "default_file.xml";
    }

    public String getXmlFile(){
        System.out.println("Получение файла " + file);
        return file;
    }

}
