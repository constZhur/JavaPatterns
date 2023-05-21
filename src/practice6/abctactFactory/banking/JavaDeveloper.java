package practice6.abctactFactory.banking;

import practice6.abctactFactory.Developer;

public class JavaDeveloper implements Developer {

    @Override
    public void writeCode() {
        System.out.println("Джава разработчик написал банковский код");
    }
}
