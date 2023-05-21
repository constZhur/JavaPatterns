package practice6.abctactFactory.website;

import practice6.abctactFactory.Developer;

public class PhpDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("Php разработчик написал код для вэбсайта");
    }
}
