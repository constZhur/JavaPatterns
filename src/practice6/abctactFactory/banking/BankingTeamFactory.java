package practice6.abctactFactory.banking;

import practice6.abctactFactory.Developer;
import practice6.abctactFactory.ProjectManager;
import practice6.abctactFactory.ProjectTeamFactory;
import practice6.abctactFactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingProjectManager();
    }
}
