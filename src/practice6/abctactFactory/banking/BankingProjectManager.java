package practice6.abctactFactory.banking;

import practice6.abctactFactory.ProjectManager;

public class BankingProjectManager implements ProjectManager {

    @Override
    public void manageProject() {
        System.out.println("Менаджер проконтролировал создание банковского проекта");
    }
}
