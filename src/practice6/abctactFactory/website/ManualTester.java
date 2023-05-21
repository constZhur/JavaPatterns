package practice6.abctactFactory.website;

import practice6.abctactFactory.Developer;
import practice6.abctactFactory.Tester;

public class ManualTester implements Tester {

    @Override
    public void testCode() {
        System.out.println("Ручной тестировщик протестировал код для вэбсайта");
    }
}
