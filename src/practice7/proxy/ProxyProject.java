package practice7.proxy;

public class ProxyProject implements IProject{
    private String url;
    private RealProject realProject;

    public ProxyProject(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        if (realProject == null)
            realProject = new RealProject(url);
        realProject.run();
    }
}
