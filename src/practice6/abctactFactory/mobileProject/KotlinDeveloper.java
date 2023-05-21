package practice6.abctactFactory.mobileProject;

import practice6.abctactFactory.Developer;

public class KotlinDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Котлин разработчик написал код для мобильного приложения");
    }
}
