package practice6.abctactFactory.mobileProject;

import practice6.abctactFactory.Developer;
import practice6.abctactFactory.ProjectManager;
import practice6.abctactFactory.ProjectTeamFactory;
import practice6.abctactFactory.Tester;

public class MobileTeamFactory implements ProjectTeamFactory {

    @Override
    public Developer getDeveloper() {
        return new KotlinDeveloper();
    }

    @Override
    public Tester getTester() {
        return new MobileTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new MobileProjectManager();
    }
}
