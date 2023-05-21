package practice6.abctactFactory.mobileProject;

import practice6.abctactFactory.ProjectManager;

public class MobileProjectManager implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Менаджер проконтролировал создание мобильного приложения");
    }
}
