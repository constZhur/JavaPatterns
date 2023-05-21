package practice7.adapter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAdapter implements AnaliticsLibrary{

    private StockDataProvider stockDataProvider;
    private String file;


    public FileAdapter(StockDataProvider stockDataProvider) {
        this.stockDataProvider = stockDataProvider;
    }


    private void workWithJsonFile() {
        file = stockDataProvider.getXmlFile();
        System.out.println("Обработка файла " + file);
        file = file.substring(0, file.length() - 3) + "json";
    }

    @Override
    public String getJsonFile(){
        workWithJsonFile();
        Pattern pattern = Pattern.compile("\\w+\\.json$");
        Matcher matcher = pattern.matcher(file);
        if (matcher.find())
            return file;
        else throw new RuntimeException("Данный метод умеет работать только с json файлами");
    }
}
