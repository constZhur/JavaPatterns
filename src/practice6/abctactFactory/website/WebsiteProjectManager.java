package practice6.abctactFactory.website;

import practice6.abctactFactory.ProjectManager;

public class WebsiteProjectManager implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Менаджер проконтролировал создание вэбсайта");
    }
}
