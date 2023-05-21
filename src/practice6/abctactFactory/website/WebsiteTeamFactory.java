package practice6.abctactFactory.website;

import practice6.abctactFactory.Developer;
import practice6.abctactFactory.ProjectManager;
import practice6.abctactFactory.ProjectTeamFactory;
import practice6.abctactFactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsiteProjectManager();
    }
}
